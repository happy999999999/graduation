//学生表
CREATE TABLE `student` (
  `student_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `student_name` varchar(255) NOT NULL COMMENT '学生姓名',
  `student_age` tinyint(3) NOT NULL COMMENT '学生年龄',
  `qq_number` varchar(255) DEFAULT NULL COMMENT 'qq号码',
  `phone_number` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `dormitory` varchar(255) DEFAULT NULL COMMENT '宿舍位置',
  `admission_time` timestamp NULL DEFAULT NULL COMMENT '入学时间',
  `graduation_time` timestamp NULL DEFAULT NULL COMMENT '毕业时间',
  `college_id` int(10) NOT NULL COMMENT '学院id',
  `professional_id` int(10) NOT NULL COMMENT '专业id',
  `counselor_id` int(10) NOT NULL COMMENT '辅导员id',
  `tutor_id` int(10) DEFAULT NULL COMMENT '导师id',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态：0存在，1删除',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//学院表
CREATE TABLE `college` (
  `college_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '学院id',
  `college_name` varchar(255) NOT NULL COMMENT '学院name',
  `college_slogan` varchar(255) DEFAULT NULL COMMENT '学院口号',
  `counselor_ids` varchar(255) NOT NULL COMMENT '辅导员们',
  `teacher_ids` varchar(255) NOT NULL COMMENT '老师们',
  `tutor_ids` varchar(255) NOT NULL COMMENT '导师们',
  `professional_ids` int(10) NOT NULL COMMENT '包括的专业',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态：0存在1删除',
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//课程表
CREATE TABLE `course` (
  `course_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `course_name` varchar(255) NOT NULL COMMENT '课程名字',
  `teacher_id` int(10) NOT NULL COMMENT '上课教师id',
  `student_num` int(10) NOT NULL COMMENT '学生人数',
  `course_time` tinyint(3) DEFAULT NULL COMMENT '上课课时',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态：0存在1删除',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//专业表
CREATE TABLE `professional` (
  `professional_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `professional_name` varchar(255) DEFAULT NULL COMMENT '专业名字',
  `duration` tinyint(2) DEFAULT NULL COMMENT '专业时长',
  `course_ids` varchar(255) DEFAULT NULL COMMENT '包含的课程',
  `college_id` int(10) DEFAULT NULL COMMENT '所属学院',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(2) NOT NULL COMMENT '状态：0存在1删除',
  PRIMARY KEY (`professional_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//教师表
CREATE TABLE `teacher` (
  `teacher_id` int(10) NOT NULL COMMENT '教师id',
  `teacher_name` varchar(255) NOT NULL COMMENT '教师名字',
  `teacher_age` tinyint(2) DEFAULT NULL COMMENT '教师年龄',
  `qq_number` varchar(255) DEFAULT NULL COMMENT 'qq号码',
  `phone_number` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `identity` tinyint(3) DEFAULT NULL COMMENT '身份0教师1辅导员',
  `entry_time` timestamp NULL DEFAULT NULL COMMENT '入职时间',
  `retirement_time` timestamp NULL DEFAULT NULL COMMENT '退休时间',
  `course_ids` varchar(255) DEFAULT NULL COMMENT '教授课程id',
  `college_id` int(10) DEFAULT NULL COMMENT '学院id',
  `office_location` varchar(255) DEFAULT NULL COMMENT '办公室',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(3) DEFAULT NULL COMMENT '状态0存在1删除',
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//课程详情表
CREATE TABLE `course_detail` (
  `course_detail_id` int(10) NOT NULL COMMENT '课程详情id',
  `course_detail_name` varchar(255) DEFAULT NULL COMMENT '课程详情名称',
  `course_id` int(10) DEFAULT NULL COMMENT '课程id',
  `semester` varchar(255) DEFAULT NULL COMMENT '学期',
  `course_detail_teacher_id` int(10) DEFAULT NULL COMMENT '任课教师id',
  `course_detail_student_num` int(3) DEFAULT NULL COMMENT '课程总学生人数',
  `course_time_start` timestamp NULL DEFAULT NULL COMMENT '课程开始时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态0存在1删除',
  PRIMARY KEY (`course_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





