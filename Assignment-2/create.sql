CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `usr_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(45) DEFAULT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `phone_person_composition_idx` (`person`),
  CONSTRAINT `phone_person_composition` FOREIGN KEY (`person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street1` varchar(45) DEFAULT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `address_person_composition_idx` (`person`),
  CONSTRAINT `address_person_composition` FOREIGN KEY (`person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_agreement` tinyint(4) DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_person_generalization_idx` (`person`),
  CONSTRAINT `user_person_generalization` FOREIGN KEY (`person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE `developer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `developer_key` varchar(45) DEFAULT NULL,
  `person` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `developer_person_generalization_idx` (`person`),
  CONSTRAINT `developer_person_generalization` FOREIGN KEY (`person`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE `website` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `visits` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
ALTER TABLE `website` MODIFY COLUMN `description` varchar(145);

CREATE TABLE `website_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `website` int(11) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `website_role_website_idx` (`website`),
  KEY `website_role_developer_idx` (`developer`),
  CONSTRAINT `website_role_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `website_role_website` FOREIGN KEY (`website`) REFERENCES `website` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `website_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilege` varchar(45) DEFAULT NULL,
  `website` int(11) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `website_privilege_website_idx` (`website`),
  KEY `website_privilege_developer_idx` (`developer`),
  CONSTRAINT `website_privilege_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `website_privilege_website` FOREIGN KEY (`website`) REFERENCES `website` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE `page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `website` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_website_composition_idx` (`website`),
  CONSTRAINT `page_website_composition` FOREIGN KEY (`website`) REFERENCES `website` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);
ALTER TABLE `page` MODIFY COLUMN `description` varchar(145);

CREATE TABLE `page_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_role_page_idx` (`page`),
  KEY `page_role_developer_idx` (`developer`),
  CONSTRAINT `page_role_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `page_role_page` FOREIGN KEY (`page`) REFERENCES `page` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE `page_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilege` varchar(45) DEFAULT NULL,
  `page` int(11) DEFAULT NULL,
  `developer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_privilege_page_idx` (`page`),
  KEY `page_privilege_developer_idx` (`developer`),
  CONSTRAINT `page_privilege_developer` FOREIGN KEY (`developer`) REFERENCES `developer` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `page_privilege_page` FOREIGN KEY (`page`) REFERENCES `page` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
  );
  
  CREATE TABLE `widget` (
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
  CONSTRAINT `widget_page_composition` FOREIGN KEY (`page`) REFERENCES `page` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
  );
ALTER TABLE `widget` MODIFY COLUMN `width` varchar(45); 
ALTER TABLE `widget` MODIFY COLUMN `height` varchar(45); 

  CREATE TABLE `privilege` (
  `id` varchar(45) NOT NULL
  );
  
  CREATE TABLE `role` (
  `id` varchar(45) NOT NULL
  );