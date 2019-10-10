-- Update developer
UPDATE `phone` SET `phone` = '333-444-5555' WHERE (`person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'charlie') AND `primary` = '1');

-- Update widget
UPDATE `widget` SET `order` = (`order` - 1) WHERE (`order` > 0) LIMIT 6;
UPDATE `widget` SET `order` = '3' WHERE (`name` = 'head345') LIMIT 6;

-- Update page
UPDATE `page` SET `title` = concat('CNET-', `title`) WHERE (`website` = (SELECT `id` FROM `website` WHERE `name` = 'CNET'));

-- Update roles
-- Notice that after the previous update, the title of 'Home' has been changed to 'CNET-Home' 
UPDATE `page_role` a
INNER JOIN `page_role` b ON a.`role` <> b.`role`
SET a.`developer` = b.`developer`
WHERE 
(
(a.`page` = (SELECT `id` FROM `page` WHERE (`title` = 'CNET-Home' AND `website` = (SELECT `id` FROM `website` WHERE `name` = 'CNET'))) 
AND (b.`page` = (SELECT `id` FROM `page` WHERE (`title` = 'CNET-Home' AND `website` = (SELECT `id` FROM `website` WHERE `name` = 'CNET')))) 
AND (a.`developer` = (SELECT `id` FROM `developer` WHERE (`person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'bob'))))
AND (b.`developer` = (SELECT `id` FROM `developer` WHERE (`person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'charlie')))))
OR
(a.`page` = (SELECT `id` FROM `page` WHERE (`title` = 'CNET-Home' AND `website` = (SELECT `id` FROM `website` WHERE `name` = 'CNET'))) 
AND (b.`page` = (SELECT `id` FROM `page` WHERE (`title` = 'CNET-Home' AND `website` = (SELECT `id` FROM `website` WHERE `name` = 'CNET')))) 
AND (b.`developer` = (SELECT `id` FROM `developer` WHERE (`person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'bob'))))
AND (a.`developer` = (SELECT `id` FROM `developer` WHERE (`person` = (SELECT `id` FROM `person` WHERE `usr_name` = 'charlie')))))
);
