-- =============================================
-- 智能停车系统 - 计费模块数据库脚本
-- 数据库名称: parking_caculate
-- 创建日期: 2026-04-30
-- =============================================

CREATE DATABASE IF NOT EXISTS `parking` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `parking`;

-- ----------------------------
-- 1. 停车场计费规则表
-- ----------------------------
DROP TABLE IF EXISTS `cac_lot_rate`;
CREATE TABLE `cac_lot_rate` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `parking_lot_name` varchar(64) NOT NULL COMMENT '停车场名称',
    `rate_name` varchar(64) NOT NULL COMMENT '规则名称，如：标准计费',
    `rate_type` tinyint NOT NULL DEFAULT 1 COMMENT '计费类型：1标准临停 2月卡 3混合',
    `first_hour_price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '首小时价格',
    `hourly_price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '每小时价格（超出部分）',
    `daily_max_price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '每日最高价格（0表示不封顶）',
    `half_hour_price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '半小时价格（不足一小时按半小时计）',
    `charge_interval` int NOT NULL DEFAULT 60 COMMENT '计费间隔（分钟），默认60分钟',
    `free_duration` int NOT NULL DEFAULT 0 COMMENT '免费时长（分钟），入场后在此时间内离场免费',
    `max_free_times` int NOT NULL DEFAULT 0 COMMENT '每日最大免费次数，0表示不限制',
    `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态：0未启用 1启用中 2已禁用',
    `is_default` tinyint NOT NULL DEFAULT 0 COMMENT '是否默认规则：0否 1是',
    `effective_start` datetime DEFAULT NULL COMMENT '生效开始时间',
    `effective_end` datetime DEFAULT NULL COMMENT '生效结束时间，null表示永久生效',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_rate_type` (`rate_type`),
    KEY `idx_status` (`status`),
    KEY `idx_is_default` (`is_default`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='停车场计费规则表';

-- ----------------------------
-- 2. 计费规则明细表
-- ----------------------------
DROP TABLE IF EXISTS `cac_rate_rule`;
CREATE TABLE `cac_rate_rule` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `lot_rate_id` bigint NOT NULL COMMENT '所属计费规则ID',
    `rule_type` tinyint NOT NULL COMMENT '规则类型：1按时长 2按次数 3分时段 4阶梯计费',
    `rule_name` varchar(64) NOT NULL COMMENT '规则名称',
    `start_duration` int NOT NULL DEFAULT 0 COMMENT '开始时长（分钟），0表示从0开始',
    `end_duration` int NOT NULL DEFAULT 0 COMMENT '结束时长（分钟），0表示不限制',
    `price` decimal(10,2) NOT NULL COMMENT '价格',
    `price_type` tinyint NOT NULL DEFAULT 1 COMMENT '价格类型：1固定价格 2每小时 3每半小时',
    `step_index` int NOT NULL DEFAULT 1 COMMENT '阶梯索引（阶梯计费时使用）',
    `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
    `status` tinyint NOT NULL DEFAULT 1 COMMENT '状态：0禁用 1启用',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    KEY `idx_lot_rate_id` (`lot_rate_id`),
    KEY `idx_rule_type` (`rule_type`),
    KEY `idx_status` (`status`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='计费规则明细表';

-- ----------------------------
-- 3. 特殊日期计费规则表
-- ----------------------------
DROP TABLE IF EXISTS `cac_special_rule`;
CREATE TABLE `cac_special_rule` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `rule_name` varchar(64) NOT NULL COMMENT '规则名称',
    `special_type` tinyint NOT NULL COMMENT '特殊类型：1节假日 2工作日 3指定日期 4周末',
    `date_pattern` varchar(64) DEFAULT NULL COMMENT '日期模式，如：2026-01-01 或 01-01',
    `day_of_week` varchar(32) DEFAULT NULL COMMENT '星期几生效，如：1,2,3,4,5表示周一到周五',
    `first_hour_price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '首小时价格',
    `hourly_price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '每小时价格',
    `daily_max_price` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '每日最高价格（0表示不封顶）',
    `free_duration` int NOT NULL DEFAULT 0 COMMENT '免费时长（分钟）',
    `status` tinyint NOT NULL DEFAULT 1 COMMENT '状态：0禁用 1启用',
    `effective_start` datetime DEFAULT NULL COMMENT '生效开始时间',
    `effective_end` datetime DEFAULT NULL COMMENT '生效结束时间',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_special_type` (`special_type`),
    KEY `idx_status` (`status`),
    KEY `idx_effective_start` (`effective_start`),
    KEY `idx_effective_end` (`effective_end`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='特殊日期计费规则表';

-- ----------------------------
-- 4. 会员折扣规则表
-- ----------------------------
DROP TABLE IF EXISTS `cac_discount_rule`;
CREATE TABLE `cac_discount_rule` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `parking_lot_id` bigint DEFAULT NULL COMMENT '停车场ID，null表示全局规则',
    `rule_name` varchar(64) NOT NULL COMMENT '规则名称',
    `discount_type` tinyint NOT NULL COMMENT '优惠类型：1会员折扣 2时段优惠 3充值优惠 4免费时长',
    `vip_level` tinyint DEFAULT NULL COMMENT '会员等级，null表示全部等级',
    `discount_value` decimal(5,2) NOT NULL COMMENT '优惠值（折扣：如0.8表示8折；金额：如5.00表示减5元）',
    `discount_mode` tinyint NOT NULL DEFAULT 1 COMMENT '优惠模式：1折扣 2减免 3赠送时长',
    `start_time` varchar(8) DEFAULT NULL COMMENT '优惠开始时间，格式：HH:mm',
    `end_time` varchar(8) DEFAULT NULL COMMENT '优惠结束时间，格式：HH:mm',
    `day_of_week` varchar(32) DEFAULT NULL COMMENT '星期几可用，如：1,2,3,4,5,6,7表示每天',
    `min_parking_duration` int NOT NULL DEFAULT 0 COMMENT '最小停车时长（分钟）才可享受优惠',
    `max_discount_amount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '最大优惠金额（0表示不限制）',
    `status` tinyint NOT NULL DEFAULT 1 COMMENT '状态：0禁用 1启用',
    `effective_start` datetime DEFAULT NULL COMMENT '生效开始时间',
    `effective_end` datetime DEFAULT NULL COMMENT '生效结束时间',
    `sort` int NOT NULL DEFAULT 0 COMMENT '排序（优先级）',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_discount_type` (`discount_type`),
    KEY `idx_vip_level` (`vip_level`),
    KEY `idx_status` (`status`),
    KEY `idx_effective_start` (`effective_start`),
    KEY `idx_effective_end` (`effective_end`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='会员折扣规则表';

-- ----------------------------
-- 5. 计费流水记录表
-- ----------------------------
DROP TABLE IF EXISTS `cac_charge_log`;
CREATE TABLE `cac_charge_log` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `log_no` varchar(32) NOT NULL COMMENT '计费记录编号（唯一）',
    `order_no` varchar(32) DEFAULT NULL COMMENT '关联订单编号（可为空，本地先计费后有订单）',
    `plate_number` varchar(16) NOT NULL COMMENT '车牌号',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `parking_lot_name` varchar(64) NOT NULL COMMENT '停车场名称',
    `enter_time` datetime NOT NULL COMMENT '入场时间',
    `exit_time` datetime NOT NULL COMMENT '出场时间',
    `duration` int NOT NULL DEFAULT 0 COMMENT '停车时长（分钟）',
    `fee_source` tinyint NOT NULL DEFAULT 1 COMMENT '费用来源：1云端 2本地离线',
    `original_amount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '原始费用',
    `discount_amount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '优惠金额',
    `final_amount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '最终费用',
    `monthly_card_id` bigint DEFAULT NULL COMMENT '月卡ID（如使用月卡）',
    `monthly_card_discount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '月卡抵扣金额',
    `coupon_id` bigint DEFAULT NULL COMMENT '优惠券ID',
    `coupon_discount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '优惠券抵扣金额',
    `discount_details` varchar(512) DEFAULT NULL COMMENT '优惠明细（JSON）',
    `rate_rule_id` bigint DEFAULT NULL COMMENT '使用的计费规则ID',
    `special_rule_id` bigint DEFAULT NULL COMMENT '使用的特殊规则ID',
    `is_synced` tinyint NOT NULL DEFAULT 0 COMMENT '是否已同步云端：0否 1是',
    `sync_time` datetime DEFAULT NULL COMMENT '同步云端时间',
    `sync_status` tinyint NOT NULL DEFAULT 0 COMMENT '同步状态：0待同步 1同步中 2已同步 3同步失败',
    `sync_retry_count` tinyint NOT NULL DEFAULT 0 COMMENT '同步重试次数',
    `cloud_verify_status` tinyint DEFAULT NULL COMMENT '云端核对状态：0待核对 1核对通过 2有差异',
    `cloud_verify_amount` decimal(10,2) DEFAULT NULL COMMENT '云端核对金额',
    `amount_diff` decimal(10,2) DEFAULT NULL COMMENT '金额差异（本地-云端）',
    `verify_time` datetime DEFAULT NULL COMMENT '核对时间',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_log_no` (`log_no`),
    KEY `idx_order_no` (`order_no`),
    KEY `idx_plate_number` (`plate_number`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_fee_source` (`fee_source`),
    KEY `idx_enter_time` (`enter_time`),
    KEY `idx_exit_time` (`exit_time`),
    KEY `idx_is_synced` (`is_synced`),
    KEY `idx_sync_status` (`sync_status`),
    KEY `idx_cloud_verify_status` (`cloud_verify_status`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='计费流水记录表';

-- ----------------------------
-- 6. 优惠券表（计费模块管理）
-- ----------------------------
DROP TABLE IF EXISTS `cac_coupon`;
CREATE TABLE `cac_coupon` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `coupon_no` varchar(32) NOT NULL COMMENT '优惠券编号（唯一）',
    `coupon_name` varchar(64) NOT NULL COMMENT '优惠券名称',
    `coupon_type` tinyint NOT NULL COMMENT '类型：1满减券 2折扣券 3固定金额券 4免费时长券',
    `threshold_amount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '使用门槛（满X元），0表示无门槛',
    `discount_value` decimal(10,2) NOT NULL COMMENT '优惠值',
    `discount_mode` tinyint NOT NULL DEFAULT 1 COMMENT '优惠模式：1折扣 2减免 3赠送时长',
    `free_duration` int NOT NULL DEFAULT 0 COMMENT '免费时长（分钟，类型为4时使用）',
    `total_count` int NOT NULL DEFAULT 0 COMMENT '总发行数量，0表示不限制',
    `used_count` int NOT NULL DEFAULT 0 COMMENT '已使用数量',
    `per_user_limit` int NOT NULL DEFAULT 1 COMMENT '每人限领数量',
    `valid_days` int NOT NULL DEFAULT 0 COMMENT '领取后有效天数（0表示按时间范围）',
    `effective_start` datetime DEFAULT NULL COMMENT '生效开始时间',
    `effective_end` datetime DEFAULT NULL COMMENT '生效结束时间',
    `parking_lot_ids` varchar(255) DEFAULT NULL COMMENT '可用停车场ID列表，null表示全部',
    `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态：0未发布 1已发布 2已下架 3已过期',
    `issue_type` tinyint NOT NULL DEFAULT 1 COMMENT '发放方式：1主动领取 2系统发放 3活动发放',
    `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_coupon_no` (`coupon_no`),
    KEY `idx_coupon_type` (`coupon_type`),
    KEY `idx_status` (`status`),
    KEY `idx_issue_type` (`issue_type`),
    KEY `idx_effective_start` (`effective_start`),
    KEY `idx_effective_end` (`effective_end`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='优惠券表';

-- ----------------------------
-- 7. 用户优惠券表
-- ----------------------------
DROP TABLE IF EXISTS `cac_user_coupon`;
CREATE TABLE `cac_user_coupon` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_coupon_no` varchar(32) NOT NULL COMMENT '用户优惠券编号（唯一）',
    `user_id` bigint NOT NULL COMMENT '用户ID',
    `coupon_id` bigint NOT NULL COMMENT '优惠券ID',
    `coupon_no` varchar(32) NOT NULL COMMENT '优惠券编号',
    `source` tinyint NOT NULL DEFAULT 1 COMMENT '来源：1主动领取 2系统发放 3活动奖励 4购买',
    `receive_time` datetime NOT NULL COMMENT '领取时间',
    `effective_start` datetime DEFAULT NULL COMMENT '生效开始时间',
    `effective_end` datetime NOT NULL COMMENT '生效结束时间',
    `use_time` datetime DEFAULT NULL COMMENT '使用时间',
    `order_no` varchar(32) DEFAULT NULL COMMENT '使用的订单编号',
    `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态：0待使用 1已使用 2已过期 3已退款',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_coupon_no` (`user_coupon_no`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_coupon_id` (`coupon_id`),
    KEY `idx_status` (`status`),
    KEY `idx_receive_time` (`receive_time`),
    KEY `idx_effective_end` (`effective_end`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户优惠券表';

-- ----------------------------
-- 8. 计费规则版本表（用于本地缓存同步）
-- ----------------------------
DROP TABLE IF EXISTS `cac_rate_version`;
CREATE TABLE `cac_rate_version` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `data_type` tinyint NOT NULL COMMENT '数据类型：1计费规则 2折扣规则 3特殊规则 4优惠券',
    `version` bigint NOT NULL DEFAULT 1 COMMENT '版本号',
    `hash_code` varchar(64) NOT NULL COMMENT '数据哈希值（用于校验）',
    `data_snapshot` text DEFAULT NULL COMMENT '数据快照（JSON）',
    `effective_time` datetime NOT NULL COMMENT '生效时间',
    `sync_status` tinyint NOT NULL DEFAULT 0 COMMENT '同步状态：0待同步 1已同步',
    `sync_time` datetime DEFAULT NULL COMMENT '同步时间',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_data_type` (`data_type`),
    KEY `idx_version` (`version`),
    KEY `idx_sync_status` (`sync_status`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='计费规则版本表';

-- =============================================
-- 初始化数据
-- =============================================

-- 插入默认计费规则
INSERT INTO `cac_lot_rate` (`parking_lot_id`, `parking_lot_name`, `rate_name`, `rate_type`, `first_hour_price`, `hourly_price`, `daily_max_price`, `half_hour_price`, `charge_interval`, `free_duration`, `status`, `is_default`) VALUES
(1, '默认停车场', '标准临停计费', 1, 5.00, 3.00, 30.00, 2.00, 60, 15, 1, 1);

-- 插入计费规则明细
INSERT INTO `cac_rate_rule` (`lot_rate_id`, `rule_type`, `rule_name`, `start_duration`, `end_duration`, `price`, `price_type`, `step_index`, `sort`, `status`) VALUES
(1, 1, '首小时', 0, 60, 5.00, 1, 1, 1, 1),
(1, 1, '超出部分（每小时）', 60, 0, 3.00, 2, 2, 2, 1);

-- 插入折扣规则
INSERT INTO `cac_discount_rule` (`parking_lot_id`, `rule_name`, `discount_type`, `vip_level`, `discount_value`, `discount_mode`, `day_of_week`, `min_parking_duration`, `max_discount_amount`, `status`, `sort`) VALUES
(NULL, '普通会员95折', 1, 1, 0.95, 1, '1,2,3,4,5,6,7', 0, 0.00, 1, 1),
(NULL, '银牌会员9折', 1, 2, 0.90, 1, '1,2,3,4,5,6,7', 0, 0.00, 1, 2),
(NULL, '金牌会员85折', 1, 3, 0.85, 1, '1,2,3,4,5,6,7', 0, 0.00, 1, 3),
(NULL, '钻石会员8折', 1, 4, 0.80, 1, '1,2,3,4,5,6,7', 0, 0.00, 1, 4),
(NULL, '会员首小时免费', 4, NULL, 60.00, 3, '1,2,3,4,5,6,7', 0, 0.00, 1, 5);
