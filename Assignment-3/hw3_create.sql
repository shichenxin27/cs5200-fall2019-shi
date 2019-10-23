CREATE TABLE cs5200_jdbc.`person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `usr_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE cs5200_jdbc.`phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(45) DEFAULT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phone_person_composition_idx` (`person`),
  CONSTRAINT `phone_person_composition` FOREIGN KEY (`person`) REFERENCES cs5200_jdbc.`person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE cs5200_jdbc.`address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street1` varchar(45) DEFAULT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `address_person_composition_idx` (`person`),
  CONSTRAINT `address_person_composition` FOREIGN KEY (`person`) REFERENCES cs5200_jdbc.`person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE cs5200_jdbc.`user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `approved_user` tinyint(4) DEFAULT 0,
  `user_agreement` tinyint(4) DEFAULT 0,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_person_generalization_idx` (`person`),
  CONSTRAINT `user_person_generalization` FOREIGN KEY (`person`) REFERENCES cs5200_jdbc.`person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE cs5200_jdbc.`developer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `developer_key` varchar(45) DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `developer_person_generalization_idx` (`person`),
  CONSTRAINT `developer_person_generalization` FOREIGN KEY (`person`) REFERENCES cs5200_jdbc.`person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE cs5200_jdbc.`website` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `visits` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
ALTER TABLE cs5200_jdbc.`website` MODIFY COLUMN `description` varchar(145);

CREATE TABLE cs5200_jdbc.`website_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `website` int(11) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `website_role_website_idx` (`website`),
  KEY `website_role_developer_idx` (`developer`),
  CONSTRAINT `website_role_developer` FOREIGN KEY (`developer`) REFERENCES cs5200_jdbc.`developer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `website_role_website` FOREIGN KEY (`website`) REFERENCES cs5200_jdbc.`website` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE cs5200_jdbc.`website_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilege` varchar(45) DEFAULT NULL,
  `website` int(11) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `website_privilege_website_idx` (`website`),
  KEY `website_privilege_developer_idx` (`developer`),
  CONSTRAINT `website_privilege_developer` FOREIGN KEY (`developer`) REFERENCES cs5200_jdbc.`developer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `website_privilege_website` FOREIGN KEY (`website`) REFERENCES cs5200_jdbc.`website` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE cs5200_jdbc.`page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `website` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_website_composition_idx` (`website`),
  CONSTRAINT `page_website_composition` FOREIGN KEY (`website`) REFERENCES cs5200_jdbc.`website` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);
ALTER TABLE cs5200_jdbc.`page` MODIFY COLUMN `description` varchar(145);

CREATE TABLE cs5200_jdbc.`page_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_role_page_idx` (`page`),
  KEY `page_role_developer_idx` (`developer`),
  CONSTRAINT `page_role_developer` FOREIGN KEY (`developer`) REFERENCES cs5200_jdbc.`developer` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `page_role_page` FOREIGN KEY (`page`) REFERENCES cs5200_jdbc.`page` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE cs5200_jdbc.`page_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilege` varchar(45) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_privilege_page_idx` (`page`),
  KEY `page_privilege_developer_idx` (`developer`),
  CONSTRAINT `page_privilege_developer` FOREIGN KEY (`developer`) REFERENCES cs5200_jdbc.`developer` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `page_privilege_page` FOREIGN KEY (`page`) REFERENCES cs5200_jdbc.`page` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
  );
  
  CREATE TABLE cs5200_jdbc.`widget` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `css_class` varchar(45) DEFAULT NULL,
  `css_style` varchar(45) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `shareble` tinyint(4) DEFAULT NULL,
  `expandable` tinyint(4) DEFAULT NULL,
  `src` varchar(45) DEFAULT NULL,
  `size` int(45) DEFAULT 2,
  `html` varchar(45) DEFAULT NULL,
  `dtype` varchar(45) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `widget_page_composition_idx` (`page`),
  CONSTRAINT `widget_page_composition` FOREIGN KEY (`page`) REFERENCES cs5200_jdbc.`page` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
  );

  CREATE TABLE cs5200_jdbc.`privilege` (
  `id` varchar(45) NOT NULL
  );
INSERT INTO cs5200_jdbc.`privilege` (`id`) VALUES ('create');
INSERT INTO cs5200_jdbc.`privilege` (`id`) VALUES ('read');
INSERT INTO cs5200_jdbc.`privilege` (`id`) VALUES ('update');
INSERT INTO cs5200_jdbc.`privilege` (`id`) VALUES ('delete');
  
  CREATE TABLE cs5200_jdbc.`role` (
  `id` varchar(45) NOT NULL
  );
INSERT INTO cs5200_jdbc.`role` (`id`) VALUES ('owner');
INSERT INTO cs5200_jdbc.`role` (`id`) VALUES ('admin');
INSERT INTO cs5200_jdbc.`role` (`id`) VALUES ('writer');
INSERT INTO cs5200_jdbc.`role` (`id`) VALUES ('editor');
INSERT INTO cs5200_jdbc.`role` (`id`) VALUES ('reviewer');

CREATE TABLE cs5200_jdbc.`module`(
  `id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO cs5200_jdbc.`module` (`id`) VALUES ('Project1');
INSERT INTO cs5200_jdbc.`module` (`id`) VALUES ('Project2');
INSERT INTO cs5200_jdbc.`module` (`id`) VALUES ('Assignment1');
INSERT INTO cs5200_jdbc.`module` (`id`) VALUES ('Assignment2');
INSERT INTO cs5200_jdbc.`module` (`id`) VALUES ('Quiz1');
INSERT INTO cs5200_jdbc.`module` (`id`) VALUES ('Exam');
INSERT INTO cs5200_jdbc.`module` (`id`) VALUES ('Logistics');

CREATE TABLE cs5200_jdbc.`question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(145) NOT NULL,
  `asked_by` int(11) NOT NULL,
  `posted_on` date DEFAULT NULL,
  `length` int DEFAULT 0,
  `views` int DEFAULT 0,
  `endorsed_by_instructor` tinyint(45) DEFAULT 0,
  `module` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `question_user_idx` (`asked_by`),
  KEY `module_idx` (`module`),
  CONSTRAINT `question_user` FOREIGN KEY (`asked_by`) REFERENCES cs5200_jdbc.`user` (`id`),
  CONSTRAINT `module_enum` FOREIGN KEY (`module`) REFERENCES cs5200_jdbc.`module`(`id`)
);

CREATE TABLE cs5200_jdbc.`answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(20) NOT NULL,
  `posted_by` int(11) NOT NULL,
  `posted_on` date DEFAULT NULL,
  `correct_answer` tinyint(1) DEFAULT 0,
  `up_votes` int DEFAULT 0,
  `down_votes` int DEFAULT 0,
  `question` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `answer_user_idx` (`posted_by`),
  KEY `answer_question_idx` (`question`),
  CONSTRAINT `answer_user` FOREIGN KEY (`posted_by`) REFERENCES cs5200_jdbc.`user`(`id`),
  CONSTRAINT `answer_question` FOREIGN KEY (`question`) REFERENCES cs5200_jdbc.`question`(`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);



