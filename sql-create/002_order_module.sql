-- =============================================
-- 智能停车系统 - 订单模块数据库脚本
-- 数据库名称: parking_order
-- 创建日期: 2026-04-30
-- =============================================

CREATE DATABASE IF NOT EXISTS `parking` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `parking`;

-- ----------------------------
-- 1. 订单主表
-- ----------------------------
DROP TABLE IF EXISTS `order_main`;
CREATE TABLE `order_main` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `order_no` varchar(32) NOT NULL COMMENT '订单编号（唯一，格式：ORD+yyyyMMdd+12位数字）',
    `plate_number` varchar(16) NOT NULL COMMENT '车牌号',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `parking_lot_name` varchar(64) NOT NULL COMMENT '停车场名称',
    `enter_time` datetime NOT NULL COMMENT '入场时间',
    `exit_time` datetime DEFAULT NULL COMMENT '出场时间',
    `original_amount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '原始费用',
    `discount_amount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '优惠金额',
    `coupon_id` bigint DEFAULT NULL COMMENT '使用的优惠券ID',
    `coupon_amount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '优惠券抵扣金额',
    `final_amount` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '最终支付金额',
    `payment_method` varchar(16) DEFAULT NULL COMMENT '支付方式：wechat/alipay/balance/gift',
    `payment_status` tinyint NOT NULL DEFAULT 0 COMMENT '支付状态：0待支付 1支付中 2已支付 3支付失败 4已退款',
    `order_status` tinyint NOT NULL DEFAULT 0 COMMENT '订单状态：0待支付 1已支付 2已取消 3已完成 4已退款',
    `user_id` bigint DEFAULT NULL COMMENT '用户ID（可为空，临时用户）',
    `vehicle_id` bigint DEFAULT NULL COMMENT '车辆ID（可为空）',
    `monthly_card_id` bigint DEFAULT NULL COMMENT '使用的月卡ID（月卡用户）',
    `is_monthly_card` tinyint NOT NULL DEFAULT 0 COMMENT '是否月卡支付：0否 1是',
    `enter_channel` varchar(32) DEFAULT NULL COMMENT '入场渠道：camera/scan/manual',
    `exit_channel` varchar(32) DEFAULT NULL COMMENT '出场渠道：camera/scan/manual',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_order_no` (`order_no`),
    KEY `idx_plate_number` (`plate_number`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_order_status` (`order_status`),
    KEY `idx_payment_status` (`payment_status`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_enter_time` (`enter_time`),
    KEY `idx_exit_time` (`exit_time`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单统计月报表';

-- ----------------------------
-- 5. 订单状态流水表
-- ----------------------------
DROP TABLE IF EXISTS `order_status_log`;
CREATE TABLE `order_status_log` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `order_no` varchar(32) NOT NULL COMMENT '关联订单编号',
    `order_id` bigint NOT NULL COMMENT '订单ID',
    `operation_type` tinyint NOT NULL COMMENT '操作类型：1创建 2修改金额 3状态变更 4优惠券使用 5退款 6备注修改',
    `before_status` tinyint DEFAULT NULL COMMENT '操作前订单状态',
    `after_status` tinyint DEFAULT NULL COMMENT '操作后订单状态',
    `before_payment_status` tinyint DEFAULT NULL COMMENT '操作前支付状态',
    `after_payment_status` tinyint DEFAULT NULL COMMENT '操作后支付状态',
    `before_amount` decimal(10,2) DEFAULT NULL COMMENT '操作前金额',
    `after_amount` decimal(10,2) DEFAULT NULL COMMENT '操作后金额',
    `change_amount` decimal(10,2) DEFAULT NULL COMMENT '金额变动（正数增加，负数减少）',
    `coupon_id` bigint DEFAULT NULL COMMENT '优惠券ID（使用优惠券时记录）',
    `coupon_name` varchar(64) DEFAULT NULL COMMENT '优惠券名称',
    `remark` varchar(255) DEFAULT NULL COMMENT '操作备注',
    `operator_id` bigint DEFAULT NULL COMMENT '操作人ID（系统为0）',
    `operator_name` varchar(64) DEFAULT NULL COMMENT '操作人姓名',
    `operator_type` tinyint NOT NULL DEFAULT 0 COMMENT '操作者类型：0系统 1用户 2管理员',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    KEY `idx_order_no` (`order_no`),
    KEY `idx_order_id` (`order_id`),
    KEY `idx_operation_type` (`operation_type`),
    KEY `idx_operator_id` (`operator_id`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='订单状态流水表';


-- ----------------------------


-- ----------------------------
