-- Retrieve developers 
SELECT * FROM `developer`;
SELECT * FROM `developer` WHERE `person` = '34';
SELECT * FROM `developer` WHERE (`id` IN (SELECT `developer` FROM `website_role` WHERE (`website` IN (SELECT `id` FROM `website` WHERE `name` = 'Twitter') AND `role` != 'owner')));
SELECT * FROM `developer` WHERE (`id` IN (SELECT `developer` FROM `page_role` WHERE (`page` IN (SELECT `id` FROM `page` WHERE (`views` < '300000')))));
SELECT * FROM `developer` WHERE (`id` IN (SELECT `developer` FROM `page_role` WHERE (`role` = 'writer' AND `page` IN (SELECT `id` FROM `page` WHERE (`title` = 'Home' AND (`id` IN (SELECT `page` FROM `widget` WHERE `dtype` = 'heading') AND (`website` IN (SELECT `id` FROM `website` WHERE (`name` = 'CNET')))))))));

-- Retrieve websites 
SELECT * FROM `website` WHERE (`visits` = (SELECT MIN(`visits`) FROM `website`));
SELECT `name` FROM `website` WHERE `id` = '678';
SELECT * FROM `website` WHERE (`id` IN (SELECT `website` FROM `page` WHERE (`id` IN (SELECT `page` FROM `widget` WHERE `dtype` = 'youtube') AND `id` IN (SELECT `page` FROM `page_role` WHERE (`role` = 'reviewer' AND `developer` = (SELECT `id` FROM `developer` WHERE `person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'bob')))))));
SELECT * FROM `website` WHERE (`id` IN (SELECT `website` FROM `website_role` WHERE(`role` = 'owner' AND `developer` = (SELECT `id` FROM `developer` WHERE `person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'alice')))));
SELECT * FROM `website` WHERE (`id` IN (SELECT `website` FROM `website_role` WHERE(`role` = 'admin' AND `developer` = (SELECT `id` FROM `developer` WHERE `person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'charlie')) AND (`visits` > 6000000))));

-- Retrieve pages
SELECT * FROM `page` WHERE (`views` = (SELECT MAX(`views`) FROM `page`));
SELECT `title` FROM `page` WHERE `id` = '234';
SELECT * FROM `page` WHERE (`id` IN (SELECT `page` FROM `page_role` WHERE(`role` = 'editor' AND `developer` = (SELECT `id` FROM `developer` WHERE `person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'alice')))));
SELECT SUM(`views`) FROM `page` WHERE (`website` = (SELECT `id` FROM `website` WHERE `name` = 'CNET'));
SELECT AVG(`views`) FROM `page` WHERE (`website` = (SELECT `id` FROM `website` WHERE `name` = 'Wikipedia'));

-- Retrieve widgets
SELECT * FROM `widget` WHERE (`page` = (SELECT `id` FROM `page` WHERE (`title` = 'Home' AND `website` = (SELECT `id` FROM `website` WHERE (`name` = 'CNET')))));
SELECT * FROM `widget` WHERE (`dtype` = 'youtube' AND `page` = (SELECT `id` FROM `page` WHERE (`website` = (SELECT `id` FROM `website` WHERE (`name` = 'CNN')))));
SELECT * FROM `widget` WHERE (`dtype` = 'image' AND `page` IN (SELECT `id` FROM `page` WHERE (`id` IN (SELECT `page` FROM `page_role` WHERE (`role` = 'reviewer' AND `developer` = (SELECT `id` FROM `developer` WHERE `person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'alice')))))));
SELECT COUNT(*) FROM `widget` WHERE (`page` = (SELECT `id` FROM `page` WHERE (`website` = (SELECT `id` FROM `website` WHERE (`name` = 'Wikipedia')))));

-- Verify triggers
SELECT `name` FROM `website` WHERE (`id` IN (SELECT `website` FROM `website_privilege` WHERE (`privilege` = 'delete' AND `developer` = (SELECT `id` FROM `developer` WHERE `person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'bob')))));
SELECT `title` FROM `page` WHERE (`id` IN (SELECT `page` FROM `page_privilege` WHERE (`privilege` = 'create' AND `developer` = (SELECT `id` FROM `developer` WHERE `person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'charlie')))));



