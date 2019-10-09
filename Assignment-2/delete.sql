-- Delete developer
DELETE FROM `address` WHERE (`person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'alice') AND `primary` = '1');

-- Delete widget
DELETE FROM `widget` WHERE (`page` = (SELECT `id` FROM `page` WHERE (`title` = 'Contact')) AND `order` = (SELECT x.`o` FROM (SELECT MAX(`order`) AS `o` FROM `widget`) x ));

-- Delete page
DELETE FROM `page` WHERE (`updated` = (SELECT p.`updated` FROM (SELECT MAX(`updated`) AS `updated` FROM `page`) p) AND `website` = (SELECT `id` FROM `website` WHERE `name` = 'Wikipedia'));

-- Delete website
DELETE FROM `website_role` WHERE (`website` = (SELECT `id` FROM `website` WHERE `name` = 'CNET'));
DELETE FROM `website` WHERE(`name` = 'CNET');