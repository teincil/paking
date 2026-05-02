-- =============================================
-- 智能停车系统 - 用户模块数据库脚本
-- 数据库名称: parking_user
-- 创建日期: 2026-04-30
-- =============================================

CREATE DATABASE IF NOT EXISTS `parking` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `parking`;

-- ----------------------------
-- 1. 用户表
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `nickname` varchar(64) DEFAULT NULL COMMENT '用户昵称',
    `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
    `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
    `wechat_openid` varchar(64) DEFAULT NULL COMMENT '微信OpenID',
    `alipay_openid` varchar(64) DEFAULT NULL COMMENT '支付宝OpenID',
    `balance` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '可用余额',
    `gift_balance` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '赠送金额（永久有效，不可提现）',
    `total_recharge` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '累计充值金额',
    `total_consume` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '累计消费金额',
    `vip_level` tinyint NOT NULL DEFAULT 0 COMMENT '会员等级：0普通 1铜牌 2银牌 3金牌 4钻石',
    `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态：0正常 1黑名单 2禁用',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_mobile` (`mobile`),
    UNIQUE KEY `uk_wechat_openid` (`wechat_openid`),
    UNIQUE KEY `uk_alipay_openid` (`alipay_openid`),
    KEY `idx_status` (`status`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';

-- ----------------------------
-- 2. 车辆表
-- ----------------------------
DROP TABLE IF EXISTS `sys_vehicle`;
CREATE TABLE `sys_vehicle` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_id` bigint NOT NULL COMMENT '用户ID',
    `plate_number` varchar(16) NOT NULL COMMENT '车牌号',
    `plate_color` varchar(8) DEFAULT NULL COMMENT '车牌颜色：蓝、黄、绿、白、黑',
    `vehicle_color` varchar(16) DEFAULT NULL COMMENT '车身颜色',
    `brand` varchar(32) DEFAULT NULL COMMENT '车辆品牌',
    `model` varchar(32) DEFAULT NULL COMMENT '车辆型号',
    `is_new_energy` tinyint NOT NULL DEFAULT 0 COMMENT '是否新能源车：0否 1是',
    `is_default` tinyint NOT NULL DEFAULT 0 COMMENT '是否默认车辆：0否 1是',
    `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态：0正常 1禁用',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_plate_number` (`plate_number`),
    KEY `idx_status` (`status`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='车辆表';

-- ----------------------------
-- 3. 月卡表
-- ----------------------------
DROP TABLE IF EXISTS `sys_monthly_card`;
CREATE TABLE `sys_monthly_card` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_id` bigint NOT NULL COMMENT '用户ID',
    `vehicle_id` bigint NOT NULL COMMENT '车辆ID',
    `card_no` varchar(32) NOT NULL COMMENT '月卡编号',
    `type` tinyint NOT NULL DEFAULT 1 COMMENT '类型：1月卡 2季卡 3年卡',
    `parking_lot_id` bigint DEFAULT NULL COMMENT '停车场ID（null表示全部停车场）',
    `start_time` datetime NOT NULL COMMENT '有效期开始时间',
    `end_time` datetime NOT NULL COMMENT '有效期结束时间',
    `price` decimal(10,2) NOT NULL COMMENT '购买价格',
    `free_duration` int NOT NULL DEFAULT 0 COMMENT '每日免费时长（分钟），0表示不限',
    `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态：0待生效 1生效中 2已过期 3已退款',
    `refund_time` datetime DEFAULT NULL COMMENT '退款时间',
    `refund_amount` decimal(10,2) DEFAULT NULL COMMENT '退款金额',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_card_no` (`card_no`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_vehicle_id` (`vehicle_id`),
    KEY `idx_status` (`status`),
    KEY `idx_end_time` (`end_time`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='月卡表';

-- ----------------------------
-- 4. 余额变动流水表
-- ----------------------------
DROP TABLE IF EXISTS `sys_balance_log`;
CREATE TABLE `sys_balance_log` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_id` bigint NOT NULL COMMENT '用户ID',
    `order_no` varchar(32) DEFAULT NULL COMMENT '关联订单号',
    `type` tinyint NOT NULL COMMENT '变动类型：1充值 2消费 3退款 4赠送 5提现',
    `change_type` tinyint NOT NULL DEFAULT 1 COMMENT '余额类型：1可用余额 2赠送余额',
    `before_balance` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '变动前余额',
    `change_balance` decimal(12,2) NOT NULL COMMENT '变动金额（正数增加，负数减少）',
    `after_balance` decimal(12,2) NOT NULL COMMENT '变动后余额',
    `before_gift_balance` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '变动前赠送金额',
    `change_gift_balance` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '变动赠送金额',
    `after_gift_balance` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '变动后赠送金额',
    `payment_channel` varchar(16) DEFAULT NULL COMMENT '支付渠道：wechat/alipay/balance',
    `activity_id` bigint DEFAULT NULL COMMENT '充值活动ID（充值时关联）',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_order_no` (`order_no`),
    KEY `idx_type` (`type`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='余额变动流水表';

-- ----------------------------
-- 5. 充值活动表
-- ----------------------------
DROP TABLE IF EXISTS `sys_recharge_activity`;
CREATE TABLE `sys_recharge_activity` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name` varchar(64) NOT NULL COMMENT '活动名称',
    `description` varchar(255) DEFAULT NULL COMMENT '活动描述',
    `recharge_amount` decimal(10,2) NOT NULL COMMENT '充值金额',
    `gift_amount` decimal(10,2) NOT NULL COMMENT '赠送金额',
    `min_recharge` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '最低充值金额',
    `total_limit` int NOT NULL DEFAULT 0 COMMENT '总名额限制，0表示不限制',
    `daily_limit` int NOT NULL DEFAULT 0 COMMENT '每日名额限制，0表示不限制',
    `sold_count` int NOT NULL DEFAULT 0 COMMENT '已使用次数',
    `start_time` datetime NOT NULL COMMENT '活动开始时间',
    `end_time` datetime NOT NULL COMMENT '活动结束时间',
    `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态：0未开始 1进行中 2已结束 3已下架',
    `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    KEY `idx_status` (`status`),
    KEY `idx_start_time` (`start_time`),
    KEY `idx_end_time` (`end_time`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='充值活动表';

-- ----------------------------
-- 6. 黑名单表
-- ----------------------------
DROP TABLE IF EXISTS `sys_blacklist`;
CREATE TABLE `sys_blacklist` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_id` bigint DEFAULT NULL COMMENT '用户ID（可为空）',
    `plate_number` varchar(16) NOT NULL COMMENT '车牌号',
    `reason` varchar(255) NOT NULL COMMENT '加入黑名单原因',
    `evidence` varchar(512) DEFAULT NULL COMMENT '证据图片地址（多张逗号分隔）',
    `source` tinyint NOT NULL DEFAULT 1 COMMENT '来源：1系统 2人工',
    `order_id` bigint DEFAULT NULL COMMENT '关联订单ID（逃费时关联）',
    `operate_id` bigint DEFAULT NULL COMMENT '操作人ID',
    `operate_name` varchar(64) DEFAULT NULL COMMENT '操作人姓名',
    `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态：0生效中 1已解除',
    `unblock_reason` varchar(255) DEFAULT NULL COMMENT '解除原因',
    `unblock_time` datetime DEFAULT NULL COMMENT '解除时间',
    `unblock_operate_id` bigint DEFAULT NULL COMMENT '解除操作人ID',
    `unblock_operate_name` varchar(64) DEFAULT NULL COMMENT '解除操作人姓名',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_plate_number` (`plate_number`),
    KEY `idx_status` (`status`),
    KEY `idx_source` (`source`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='黑名单表';

-- =============================================
-- 初始化数据
-- =============================================

-- 插入默认充值活动
INSERT INTO `sys_recharge_activity` (`name`, `description`, `recharge_amount`, `gift_amount`, `min_recharge`, `start_time`, `end_time`, `status`) VALUES
('充100送10', '充值100元赠送10元', 100.00, 10.00, 100.00, '2026-01-01 00:00:00', '2027-12-31 23:59:59', 1),
('充500送80', '充值500元赠送80元', 500.00, 80.00, 500.00, '2026-01-01 00:00:00', '2027-12-31 23:59:59', 1),
('充1000送200', '充值1000元赠送200元', 1000.00, 200.00, 1000.00, '2026-01-01 00:00:00', '2027-12-31 23:59:59', 1);
