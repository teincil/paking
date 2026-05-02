-- =============================================
-- 智能停车系统 - 设备模块数据库脚本
-- 数据库名称: parking_device
-- 创建日期: 2026-04-30
-- =============================================

CREATE DATABASE IF NOT EXISTS `parking` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `parking`;

-- ----------------------------
-- 1. 停车场表
-- ----------------------------
DROP TABLE IF EXISTS `dev_parking_lot`;
CREATE TABLE `dev_parking_lot` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `lot_code` varchar(32) NOT NULL COMMENT '停车场编码（唯一）',
    `lot_name` varchar(64) NOT NULL COMMENT '停车场名称',
    `lot_type` tinyint NOT NULL DEFAULT 1 COMMENT '类型：1地上 2地下 3地上地下混合',
    `province` varchar(32) DEFAULT NULL COMMENT '省份',
    `city` varchar(32) DEFAULT NULL COMMENT '城市',
    `district` varchar(32) DEFAULT NULL COMMENT '区县',
    `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
    `latitude` decimal(10,6) DEFAULT NULL COMMENT '纬度',
    `longitude` decimal(10,6) DEFAULT NULL COMMENT '经度',
    `total_space` int NOT NULL DEFAULT 0 COMMENT '总车位数量',
    `free_space` int NOT NULL DEFAULT 0 COMMENT '剩余车位数量',
    `hourly_rate` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '每小时费率',
    `max_daily_rate` decimal(10,2) NOT NULL DEFAULT 0.00 COMMENT '每日最高费率（0表示不封顶）',
    `free_duration` int NOT NULL DEFAULT 0 COMMENT '免费时长（分钟），0表示不免费',
    `opening_hours` varchar(64) DEFAULT NULL COMMENT '营业时间，格式：09:00-22:00',
    `is_24h` tinyint NOT NULL DEFAULT 1 COMMENT '是否24小时营业：0否 1是',
    `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态：0营业中 1暂停营业 2装修中 3已关闭',
    `logo` varchar(255) DEFAULT NULL COMMENT '停车场图标',
    `contact_phone` varchar(16) DEFAULT NULL COMMENT '联系电话',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_lot_code` (`lot_code`),
    KEY `idx_lot_type` (`lot_type`),
    KEY `idx_status` (`status`),
    KEY `idx_city` (`city`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='停车场表';

-- ----------------------------
-- 2. 通道表
-- ----------------------------
DROP TABLE IF EXISTS `dev_channel`;
CREATE TABLE `dev_channel` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `channel_code` varchar(32) NOT NULL COMMENT '通道编码（唯一）',
    `channel_name` varchar(64) NOT NULL COMMENT '通道名称，如：入口1',
    `channel_type` tinyint NOT NULL COMMENT '类型：1入口 2出口 3混合',
    `gate_id` bigint DEFAULT NULL COMMENT '关联闸机ID',
    `camera_id` bigint DEFAULT NULL COMMENT '关联主摄像头ID',
    `aux_camera_id` bigint DEFAULT NULL COMMENT '关联辅助摄像头ID',
    `sensor_id` bigint DEFAULT NULL COMMENT '关联地感线圈ID',
    `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
    `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态：0正常 1维护中 2已停用',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_channel_code` (`channel_code`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_channel_type` (`channel_type`),
    KEY `idx_status` (`status`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='通道表';

-- ----------------------------
-- 3. 闸机表
-- ----------------------------
DROP TABLE IF EXISTS `dev_gate`;
CREATE TABLE `dev_gate` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `gate_code` varchar(32) NOT NULL COMMENT '闸机编码（唯一）',
    `gate_name` varchar(64) NOT NULL COMMENT '闸机名称',
    `gate_type` varchar(16) NOT NULL COMMENT '闸机类型：barrier栅栏机/truss牌坊机/toll收费亭',
    `brand` varchar(32) DEFAULT NULL COMMENT '品牌',
    `model` varchar(32) DEFAULT NULL COMMENT '型号',
    `ip_address` varchar(32) DEFAULT NULL COMMENT 'IP地址',
    `port` int DEFAULT NULL COMMENT '端口',
    `baud_rate` int DEFAULT NULL COMMENT '波特率',
    `protocol` varchar(32) DEFAULT NULL COMMENT '通信协议',
    `gate_status` tinyint NOT NULL DEFAULT 0 COMMENT '闸杆状态：0落下 1抬起 2异常 3维护中',
    `online_status` tinyint NOT NULL DEFAULT 0 COMMENT '在线状态：0离线 1在线',
    `last_heartbeat` datetime DEFAULT NULL COMMENT '最后心跳时间',
    `is_enabled` tinyint NOT NULL DEFAULT 1 COMMENT '是否启用：0禁用 1启用',
    `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_gate_code` (`gate_code`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_gate_status` (`gate_status`),
    KEY `idx_online_status` (`online_status`),
    KEY `idx_last_heartbeat` (`last_heartbeat`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='闸机表';

-- ----------------------------
-- 4. 摄像头表
-- ----------------------------
DROP TABLE IF EXISTS `dev_camera`;
CREATE TABLE `dev_camera` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `channel_id` bigint DEFAULT NULL COMMENT '所属通道ID',
    `camera_code` varchar(32) NOT NULL COMMENT '摄像头编码（唯一）',
    `camera_name` varchar(64) NOT NULL COMMENT '摄像头名称',
    `camera_type` tinyint NOT NULL COMMENT '类型：1入口主摄像头 2出口主摄像头 3入口辅助摄像头 4出口辅助摄像头 5监控摄像头',
    `brand` varchar(32) DEFAULT NULL COMMENT '品牌',
    `model` varchar(32) DEFAULT NULL COMMENT '型号',
    `ip_address` varchar(32) DEFAULT NULL COMMENT 'IP地址',
    `port` int DEFAULT NULL COMMENT '端口',
    `username` varchar(32) DEFAULT NULL COMMENT '用户名',
    `password` varchar(128) DEFAULT NULL COMMENT '密码（加密存储）',
    `rtsp_url` varchar(255) DEFAULT NULL COMMENT 'RTSP地址',
    `snapshot_url` varchar(255) DEFAULT NULL COMMENT '抓拍地址',
    `ai_enabled` tinyint NOT NULL DEFAULT 1 COMMENT '是否启用AI识别：0否 1是',
    `ai_model` varchar(32) DEFAULT NULL COMMENT 'AI识别模型',
    `recognize_accuracy` decimal(5,2) DEFAULT NULL COMMENT '识别准确率',
    `online_status` tinyint NOT NULL DEFAULT 0 COMMENT '在线状态：0离线 1在线',
    `last_heartbeat` datetime DEFAULT NULL COMMENT '最后心跳时间',
    `is_enabled` tinyint NOT NULL DEFAULT 1 COMMENT '是否启用：0禁用 1启用',
    `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_camera_code` (`camera_code`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_channel_id` (`channel_id`),
    KEY `idx_camera_type` (`camera_type`),
    KEY `idx_online_status` (`online_status`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='摄像头表';

-- ----------------------------
-- 5. 地感线圈表
-- ----------------------------
DROP TABLE IF EXISTS `dev_ground_sensor`;
CREATE TABLE `dev_ground_sensor` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `channel_id` bigint DEFAULT NULL COMMENT '所属通道ID',
    `sensor_code` varchar(32) NOT NULL COMMENT '地感编码（唯一）',
    `sensor_name` varchar(64) NOT NULL COMMENT '地感名称',
    `sensor_type` tinyint NOT NULL DEFAULT 1 COMMENT '类型：1单线圈 2双线圈',
    `brand` varchar(32) DEFAULT NULL COMMENT '品牌',
    `model` varchar(32) DEFAULT NULL COMMENT '型号',
    `ip_address` varchar(32) DEFAULT NULL COMMENT 'IP地址',
    `port` int DEFAULT NULL COMMENT '端口',
    `sensitivity` tinyint DEFAULT NULL COMMENT '灵敏度（1-10）',
    `detect_distance` int DEFAULT NULL COMMENT '检测距离（厘米）',
    `vehicle_detect_status` tinyint NOT NULL DEFAULT 0 COMMENT '车辆检测状态：0无车 1有车 2异常',
    `online_status` tinyint NOT NULL DEFAULT 0 COMMENT '在线状态：0离线 1在线',
    `last_heartbeat` datetime DEFAULT NULL COMMENT '最后心跳时间',
    `is_enabled` tinyint NOT NULL DEFAULT 1 COMMENT '是否启用：0禁用 1启用',
    `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_sensor_code` (`sensor_code`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_channel_id` (`channel_id`),
    KEY `idx_vehicle_detect_status` (`vehicle_detect_status`),
    KEY `idx_online_status` (`online_status`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='地感线圈表';

-- ----------------------------
-- 6. 通行记录表
-- ----------------------------
DROP TABLE IF EXISTS `dev_pass_record`;
CREATE TABLE `dev_pass_record` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `record_no` varchar(32) NOT NULL COMMENT '通行记录编号（唯一）',
    `plate_number` varchar(16) NOT NULL COMMENT '车牌号',
    `plate_color` varchar(8) DEFAULT NULL COMMENT '车牌颜色：蓝、黄、绿、白、黑',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `parking_lot_name` varchar(64) NOT NULL COMMENT '停车场名称',
    `channel_id` bigint NOT NULL COMMENT '通道ID',
    `channel_name` varchar(64) NOT NULL COMMENT '通道名称',
    `channel_type` tinyint NOT NULL COMMENT '通道类型：1入口 2出口',
    `camera_id` bigint DEFAULT NULL COMMENT '触发摄像头ID',
    `gate_id` bigint DEFAULT NULL COMMENT '关联闸机ID',
    `sensor_id` bigint DEFAULT NULL COMMENT '触发地感ID',
    `pass_time` datetime NOT NULL COMMENT '通行时间',
    `pass_type` tinyint NOT NULL COMMENT '通行类型：1自动抬杆 2扫码通行 3人工放行 4异常通行',
    `plate_number_orig` varchar(16) DEFAULT NULL COMMENT '原始识别车牌（识别错误时记录）',
    `is_ai_recognize` tinyint NOT NULL DEFAULT 1 COMMENT '是否AI识别：0否 1是',
    `recognize_confidence` decimal(5,2) DEFAULT NULL COMMENT '识别置信度',
    `capture_image` varchar(255) DEFAULT NULL COMMENT '抓拍图片地址',
    `capture_image2` varchar(255) DEFAULT NULL COMMENT '抓拍图片地址2（双摄像头）',
    `is_matched` tinyint NOT NULL DEFAULT 1 COMMENT '车牌是否匹配：0否 1是',
    `match_order_no` varchar(32) DEFAULT NULL COMMENT '匹配订单号（入场记录关联）',
    `order_id` bigint DEFAULT NULL COMMENT '关联订单ID',
    `user_id` bigint DEFAULT NULL COMMENT '关联用户ID',
    `vehicle_id` bigint DEFAULT NULL COMMENT '关联车辆ID',
    `monthly_card_id` bigint DEFAULT NULL COMMENT '关联月卡ID',
    `gate_action` tinyint DEFAULT NULL COMMENT '闸机动作：0落杆 1抬杆 2无动作',
    `gate_action_time` datetime DEFAULT NULL COMMENT '闸机动作时间',
    `exception_type` tinyint DEFAULT NULL COMMENT '异常类型：1识别失败 2无入场记录 3黑名单 4月卡过期 5其他',
    `exception_desc` varchar(255) DEFAULT NULL COMMENT '异常描述',
    `operator_id` bigint DEFAULT NULL COMMENT '操作人ID（人工放行时）',
    `operator_name` varchar(64) DEFAULT NULL COMMENT '操作人姓名',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_record_no` (`record_no`),
    KEY `idx_plate_number` (`plate_number`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_channel_id` (`channel_id`),
    KEY `idx_channel_type` (`channel_type`),
    KEY `idx_pass_time` (`pass_time`),
    KEY `idx_pass_type` (`pass_type`),
    KEY `idx_order_id` (`order_id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_exception_type` (`exception_type`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='通行记录表';

-- ----------------------------
-- 7. 设备指令日志表
-- ----------------------------
DROP TABLE IF EXISTS `dev_command_log`;
CREATE TABLE `dev_command_log` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `command_no` varchar(32) NOT NULL COMMENT '指令编号（唯一）',
    `device_type` tinyint NOT NULL COMMENT '设备类型：1闸机 2摄像头 3地感',
    `device_id` bigint NOT NULL COMMENT '设备ID',
    `device_code` varchar(32) NOT NULL COMMENT '设备编码',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `command_type` tinyint NOT NULL COMMENT '指令类型：1抬杆 2落杆 3抓拍 4重启 5校时 6布防 7撤防',
    `command_params` varchar(512) DEFAULT NULL COMMENT '指令参数（JSON）',
    `command_status` tinyint NOT NULL DEFAULT 0 COMMENT '指令状态：0待发送 1已发送 2执行成功 3执行失败 4超时 5取消',
    `send_time` datetime DEFAULT NULL COMMENT '发送时间',
    `execute_time` datetime DEFAULT NULL COMMENT '执行时间',
    `execute_result` varchar(255) DEFAULT NULL COMMENT '执行结果',
    `response_data` text DEFAULT NULL COMMENT '响应数据（JSON）',
    `retry_count` tinyint NOT NULL DEFAULT 0 COMMENT '重试次数',
    `max_retry` tinyint NOT NULL DEFAULT 3 COMMENT '最大重试次数',
    `order_id` bigint DEFAULT NULL COMMENT '关联订单ID（通行相关指令）',
    `pass_record_id` bigint DEFAULT NULL COMMENT '关联通行记录ID',
    `operator_id` bigint DEFAULT NULL COMMENT '操作人ID（系统为0）',
    `operator_name` varchar(64) DEFAULT NULL COMMENT '操作人姓名',
    `operator_type` tinyint NOT NULL DEFAULT 0 COMMENT '操作者类型：0系统 1用户 2管理员',
    `remark` varchar(255) DEFAULT NULL COMMENT '备注',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_command_no` (`command_no`),
    KEY `idx_device_type` (`device_type`),
    KEY `idx_device_id` (`device_id`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_command_type` (`command_type`),
    KEY `idx_command_status` (`command_status`),
    KEY `idx_send_time` (`send_time`),
    KEY `idx_execute_time` (`execute_time`),
    KEY `idx_order_id` (`order_id`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='设备指令日志表';

-- ----------------------------
-- 8. 设备状态变更记录表
-- ----------------------------
DROP TABLE IF EXISTS `dev_status_log`;
CREATE TABLE `dev_status_log` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `device_type` tinyint NOT NULL COMMENT '设备类型：1闸机 2摄像头 3地感',
    `device_id` bigint NOT NULL COMMENT '设备ID',
    `device_code` varchar(32) NOT NULL COMMENT '设备编码',
    `parking_lot_id` bigint NOT NULL COMMENT '停车场ID',
    `before_status` varchar(32) DEFAULT NULL COMMENT '变更前状态',
    `after_status` varchar(32) DEFAULT NULL COMMENT '变更后状态',
    `change_type` tinyint NOT NULL COMMENT '变更类型：1上线 2离线 3故障 4恢复 5参数变更',
    `alarm_level` tinyint DEFAULT NULL COMMENT '告警级别：1提示 2警告 3严重',
    `alarm_message` varchar(255) DEFAULT NULL COMMENT '告警消息',
    `alarm_data` text DEFAULT NULL COMMENT '告警数据（JSON）',
    `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除：0未删除 1已删除',
    PRIMARY KEY (`id`),
    KEY `idx_device_type` (`device_type`),
    KEY `idx_device_id` (`device_id`),
    KEY `idx_parking_lot_id` (`parking_lot_id`),
    KEY `idx_change_type` (`change_type`),
    KEY `idx_alarm_level` (`alarm_level`),
    KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='设备状态变更记录表';
