CREATE TABLE `lectures` (
  `id` int NOT NULL AUTO_INCREMENT,
  `class_id` int,
  `lecture_name` varchar(255),
  `lecture_start_time` timestamp,
  `lecture_end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

CREATE TABLE `classes` (
  `id` varchar(100) PRIMARY KEY,
  `professor_id` int,
  `course_name` varchar(255),
  `student_count` int
);

CREATE TABLE `class_roster` (
  `class_id` varchar(100) PRIMARY KEY,
  `user_id` int
);

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `classification` int,
  `name` varchar(255),
  `email` varchar(255),
  `password` varchar(255),
  PRIMARY KEY (`id`)
);

CREATE TABLE `emotions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lecture_id` int,
  `user_id` int,
  `emotions` varchar(255),
  `percent` double,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

ALTER TABLE `lectures` ADD FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `class_roster` ADD FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`);

ALTER TABLE `class_roster` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `emotions` ADD FOREIGN KEY (`lecture_id`) REFERENCES `lectures` (`id`);

ALTER TABLE `emotions` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);



