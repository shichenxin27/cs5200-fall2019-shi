CREATE VIEW `deleveloper_roles_and_privileges` AS
SELECT  p.`first_name`, p.`last_name`, p.`usr_name`, p.`email`, w.`name` AS `website_name`, w.`visits`, w.`updated` as `website_updated_date`, w_r.`role` as `website_role`, w_p.`privilege` as `website_privilege`, pg.`title` AS `page_title`, pg.`views`, pg.`updated` as `page_updated_date`, p_r.`role` as `page_role`, p_p.`privilege` as `page_privilege`
FROM (`person` p INNER JOIN  `developer` d ON p.`id` = d.`person`
JOIN `website_role` w_r ON d.`id` = w_r.`developer`
LEFT JOIN `website_privilege` w_p ON d.`id` = w_p.`developer`
LEFT JOIN `website` w ON (w_r.`website` = w.`id` AND w_p.`website` = w.`id`)
JOIN `page` pg ON w.`id` = pg.`website`
LEFT JOIN `page_role` p_r ON (p_r.`page` = pg.`id` AND p_r.`developer` = d.`id`)
LEFT JOIN `page_privilege` p_p ON (p_p.`page` = pg.`id` AND p_p.`developer` = d.`id`));

-- DROP VIEW `deleveloper_roles_and_privileges`;
SELECT * FROM `deleveloper_roles_and_privileges`
