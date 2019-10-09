INSERT INTO `person` (`id`, `first_name`,`last_name`,`usr_name`, `password`, `email`) VALUE ('12', 'Alice', 'Wonder', 'alice', 'alice', 'alice@wonder.com');
INSERT INTO `developer` (`developer_key`, `person`) VALUE('4321rewq', '12');

INSERT INTO `person` (`id`, `first_name`,`last_name`,`usr_name`, `password`, `email`) VALUE ('23', 'Bob', 'Marley', 'bob', 'bob', 'bob@marley.com');
INSERT INTO `developer` (`developer_key`, `person`) VALUE('5432trew', '23');

INSERT INTO `person` (`id`, `first_name`,`last_name`,`usr_name`, `password`, `email`) VALUE ('34', 'Charlies', 'Garcia', 'charlie', 'charlie', 'chuch@garcia.com');
INSERT INTO `developer` (`developer_key`, `person`) VALUE('6543ytre', '34');

INSERT INTO `person` (`id`, `first_name`,`last_name`,`usr_name`, `password`, `email`) VALUE ('45', 'Dan', 'Martin', 'dan', 'dan', 'dan@martin.com');
INSERT INTO `user` (`person`) VALUE ('45');

INSERT INTO `person` (`id`, `first_name`,`last_name`,`usr_name`, `password`, `email`) VALUE ('56', 'Ed', 'Karaz', 'ed', 'ed', 'ed@kar.com');
INSERT INTO `user` (`person`) VALUE ('56');



INSERT INTO `website` (`id`, `name`, `description`, `created`, `updated`, `visits`) VALUE ('123', 'Facebook', 'an online social media and social networking service', CURRENT_DATE(), CURRENT_DATE(), '1234234');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='123'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='alice')), 'owner');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='123'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='bob')), 'editor');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='123'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='charlie')), 'admin');

INSERT INTO `website` (`id`, `name`, `description`, `created`, `updated`, `visits`) VALUE ('234', 'Twitter', 'an online news and social networking service', CURRENT_DATE(), CURRENT_DATE(), '4321543');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='234'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='bob')), 'owner');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='234'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='charlie')), 'editor');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='234'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='alice')), 'admin');

INSERT INTO `website` (`id`, `name`, `description`, `created`, `updated`, `visits`) VALUE ('345', 'Wikipedia', 'a free online encyclopedia', CURRENT_DATE(), CURRENT_DATE(), '3456654');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='345'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='charlie')), 'owner');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='345'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='alice')), 'editor');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='345'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='bob')), 'admin');

INSERT INTO `website` (`id`, `name`, `description`, `created`, `updated`, `visits`) VALUE ('456', 'CNN', 'an American basic cable and satellite television news channel', CURRENT_DATE(), CURRENT_DATE(), '6543345');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='456'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='alice')), 'owner');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='456'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='bob')), 'editor');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='456'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='charlie')), 'admin');

INSERT INTO `website` (`id`, `name`, `description`, `created`, `updated`, `visits`) VALUE ('567', 'CNET', 'an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics', CURRENT_DATE(), CURRENT_DATE(), '5433455');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='567'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='bob')), 'owner');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='567'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='charlie')), 'editor');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='567'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='alice')), 'admin');

INSERT INTO `website` (`id`, `name`, `description`, `created`, `updated`, `visits`) VALUE ('678', 'Gizmodo', 'a design, technology, science and science fiction website tat also writes articles on politics', CURRENT_DATE(), CURRENT_DATE(), '4322345');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='678'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='charlie')), 'owner');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='678'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='alice')), 'editor');
INSERT INTO `website_role` (`website`, `developer`, `role`) VALUE ((SELECT `id` FROM `website` WHERE `id`='678'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='bob')), 'admin');



INSERT INTO `page` (`id`, `title`, `description`, `website`, `created`, `updated`, `views`) VALUE ('123', 'Home', 'Landing page', (SELECT `id` FROM `website` WHERE `name`='CNET'), '2019-09-04', '2019-10-09', '123434');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='123'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='alice')), 'editor');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='123'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='bob')), 'reviewer');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='123'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='charlie')), 'writer');

INSERT INTO `page` (`id`, `title`, `description`, `website`, `created`, `updated`, `views`) VALUE ('234', 'About', 'Website description', (SELECT `id` FROM `website` WHERE `name`='Gizmodo'), '2019-09-04', '2019-10-09', '234545');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='234'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='bob')), 'editor');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='234'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='charlie')), 'reviewer');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='234'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='alice')), 'writer');

INSERT INTO `page` (`id`, `title`, `description`, `website`, `created`, `updated`, `views`) VALUE ('345', 'Contact', 'Addresses, phones, and contact info', (SELECT `id` FROM `website` WHERE `name`='Wikipedia'), '2019-09-04', '2019-10-09', '345656');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='345'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='charlie')), 'editor');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='345'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='alice')), 'reviewer');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='345'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='bob')), 'writer');

INSERT INTO `page` (`id`, `title`, `description`, `website`, `created`, `updated`, `views`) VALUE ('456', 'Preferences', 'Where users can configure their preferences', (SELECT `id` FROM `website` WHERE `name`='CNN'), '2019-09-04', '2019-10-09', '456776');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='456'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='alice')), 'editor');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='456'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='bob')), 'reviewer');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='456'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='charlie')), 'writer');

INSERT INTO `page` (`id`, `title`, `description`, `website`, `created`, `updated`, `views`) VALUE ('567', 'Profile', 'Users can configure their personal information', (SELECT `id` FROM `website` WHERE `name`='CNET'), '2019-09-04', '2019-10-09', '567878');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='567'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='bob')), 'editor');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='567'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='charlie')), 'reviewer');
INSERT INTO `page_role` (`page`, `developer`, `role`) VALUE ((SELECT `id` FROM `page` WHERE `id`='567'), (SELECT `id` FROM `developer` WHERE `person`=(SELECT `id` FROM `person` WHERE `usr_name`='alice')), 'writer');



INSERT INTO `widget` (`id`, `name`, `dtype`, `text`, `order`, `width`, `height`, `url`, `page`) VALUE ('123', 'head123', 'heading', 'Welcome', '0', null, null, null, (SELECT `id` FROM `page` WHERE `title`='Home'));
INSERT INTO `widget` (`id`, `name`, `dtype`, `text`, `order`, `width`, `height`, `url`, `page`) VALUE ('234', 'post234', 'html', '<p>Lorem</p>', '0', null, null, null, (SELECT `id` FROM `page` WHERE `title`='About'));
INSERT INTO `widget` (`id`, `name`, `dtype`, `text`, `order`, `width`, `height`, `url`, `page`) VALUE ('345', 'head345', 'heading', 'Hi', '1', null, null, null, (SELECT `id` FROM `page` WHERE `title`='Contact'));
INSERT INTO `widget` (`id`, `name`, `dtype`, `text`, `order`, `width`, `height`, `url`, `page`) VALUE ('456', 'intro456', 'html', '<h1>Hi</h1>', '2', null, null, null, (SELECT `id` FROM `page` WHERE `title`='Contact'));
INSERT INTO `widget` (`id`, `name`, `dtype`, `text`, `order`, `width`, `height`, `url`, `page`) VALUE ('567', 'image345', 'image', null, '3', '50*100', '50*100', '/img/567.png', (SELECT `id` FROM `page` WHERE `title`='Contact'));
INSERT INTO `widget` (`id`, `name`, `dtype`, `text`, `order`, `width`, `height`, `url`, `page`) VALUE ('678', 'video456', 'youtube', null, '0', '400*300', '400*300', 'https://youtu.be/h67VX51QXiQ', (SELECT `id` FROM `page` WHERE `title`='Preferences'));



INSERT INTO `phone` (`person`, `phone`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='alice'), '123-234-3456', '1');
INSERT INTO `phone` (`person`, `phone`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='alice'), '234-345-4567', '0');
INSERT INTO `address` (`person`, `street1`, `city`, `zip`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='alice'), '123 Adam St.', 'Alton', '01234', '1');
INSERT INTO `address` (`person`, `street1`, `city`, `zip`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='alice'), '234 Birch St.', 'Boston', '02345', '0');

INSERT INTO `phone` (`person`, `phone`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='bob'), '345-456-5677', '1');
INSERT INTO `address` (`person`, `street1`, `city`, `zip`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='bob'), '345 Charles St.', 'Chelms', '03455', '1');
INSERT INTO `address` (`person`, `street1`, `city`, `zip`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='bob'), '456 Down St.', 'Dalton', '04566', '0');
INSERT INTO `address` (`person`, `street1`, `city`, `zip`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='bob'), '543 East St.', 'Everett', '01112', '0');

INSERT INTO `phone` (`person`, `phone`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='charlie'), '321-432-5435', '1');
INSERT INTO `phone` (`person`, `phone`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='charlie'), '432-432-5433', '0');
INSERT INTO `phone` (`person`, `phone`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='charlie'), '543-543-6544', '0');
INSERT INTO `address` (`person`, `street1`, `city`, `zip`, `primary`) VALUE ((SELECT `id` FROM `person` WHERE `usr_name`='charlie'), '654 Frank St.', 'Foulton', '04322', '1');


-- alter table website_role AUTO_INCREMENT=1;
-- select * from phone

