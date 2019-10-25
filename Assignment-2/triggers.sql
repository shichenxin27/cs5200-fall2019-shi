DELIMITER &&
CREATE TRIGGER website_privilege_insert_trigger AFTER INSERT ON website_role FOR EACH ROW
BEGIN
IF NEW.role = 'owner' OR NEW.role = 'admin' THEN
INSERT INTO website_privilege (privilege, website, developer)
VALUES('create', NEW.website, NEW.developer), 
	  ('read', NEW.website, NEW.developer), 
      ('update', NEW.website, NEW.developer), 
      ('delete', NEW.website, NEW.developer);
END IF;
IF NEW.role = 'writer' THEN
INSERT INTO website_privilege (privilege, website, developer)
VALUES('create', NEW.website, NEW.developer), 
	  ('read', NEW.website, NEW.developer), 
      ('update', NEW.website, NEW.developer);
END IF;
IF NEW.role = 'editor' THEN
INSERT INTO website_privilege (privilege, website, developer)
VALUES('read', NEW.website, NEW.developer), 
      ('update', NEW.website, NEW.developer);
END IF;
IF NEW.role = 'reviewer' THEN
INSERT INTO website_privilege (privilege, website, developer)
VALUES('read', NEW.website, NEW.developer);
END IF;
END;
&&

DELIMITER &&
CREATE TRIGGER website_privilege_update_trigger AFTER UPDATE ON website_role FOR EACH ROW
BEGIN
DELETE FROM website_privilege WHERE website = OLD.website AND developer = OLD.developer;
IF NEW.role = 'owner' OR NEW.role = 'admin' THEN
INSERT INTO website_privilege (privilege, website, developer)
VALUES('create', NEW.website, NEW.developer), 
	  ('read', NEW.website, NEW.developer), 
      ('update', NEW.website, NEW.developer), 
      ('delete', NEW.website, NEW.developer);
END IF;
IF NEW.role = 'writer' THEN
INSERT INTO website_privilege (privilege, website, developer)
VALUES('create', NEW.website, NEW.developer), 
	  ('read', NEW.website, NEW.developer), 
      ('update', NEW.website, NEW.developer);
END IF;
IF NEW.role = 'editor' THEN
INSERT INTO website_privilege (privilege, website, developer)
VALUES('read', NEW.website, NEW.developer), 
      ('update', NEW.website, NEW.developer);
END IF;
IF NEW.role = 'reviewer' THEN
INSERT INTO website_privilege (privilege, website, developer)
VALUES('read', NEW.website, NEW.developer);
END IF;
END;
&&

DELIMITER &&
CREATE TRIGGER website_privilege_delete_trigger AFTER DELETE ON website_role FOR EACH ROW
BEGIN
DELETE FROM website_privilege WHERE website = OLD.website AND developer = OLD.developer;
END;
&&


DELIMITER &&
CREATE TRIGGER page_privilege_insert_trigger AFTER INSERT ON page_role FOR EACH ROW
BEGIN
IF NEW.role = 'owner' OR NEW.role = 'admin' THEN
INSERT INTO page_privilege (privilege, page, developer)
VALUES('create', NEW.page, NEW.developer), 
	  ('read', NEW.page, NEW.developer), 
      ('update', NEW.page, NEW.developer), 
      ('delete', NEW.page, NEW.developer);
END IF;
IF NEW.role = 'writer' THEN
INSERT INTO page_privilege (privilege, page, developer)
VALUES('create', NEW.page, NEW.developer), 
	  ('read', NEW.page, NEW.developer), 
      ('update', NEW.page, NEW.developer);
END IF;
IF NEW.role = 'editor' THEN
INSERT INTO page_privilege (privilege, page, developer)
VALUES('read', NEW.page, NEW.developer), 
      ('update', NEW.page, NEW.developer);
END IF;
IF NEW.role = 'reviewer' THEN
INSERT INTO page_privilege (privilege, page, developer)
VALUES('read', NEW.page, NEW.developer);
END IF;
END;
&&

DELIMITER &&
CREATE TRIGGER page_privilege_update_trigger AFTER UPDATE ON page_role FOR EACH ROW
BEGIN
DELETE FROM page_privilege WHERE page = OLD.page AND developer = OLD.developer;
IF NEW.role = 'owner' OR NEW.role = 'admin' THEN
INSERT INTO page_privilege (privilege, page, developer)
VALUES('create', NEW.page, NEW.developer), 
	  ('read', NEW.page, NEW.developer), 
      ('update', NEW.page, NEW.developer), 
      ('delete', NEW.page, NEW.developer);
END IF;
IF NEW.role = 'writer' THEN
INSERT INTO website_privilege (privilege, page, developer)
VALUES('create', NEW.page, NEW.developer), 
	  ('read', NEW.page, NEW.developer), 
      ('update', NEW.page, NEW.developer);
END IF;
IF NEW.role = 'editor' THEN
INSERT INTO page_privilege (privilege, page, developer)
VALUES('read', NEW.page, NEW.developer), 
      ('update', NEW.page, NEW.developer);
END IF;
IF NEW.role = 'reviewer' THEN
INSERT INTO page_privilege (privilege, page, developer)
VALUES('read', NEW.page, NEW.developer);
END IF;
END;
&&

DELIMITER &&
CREATE TRIGGER page_privilege_delete_trigger AFTER DELETE ON page_role FOR EACH ROW
BEGIN
DELETE FROM page_privilege WHERE page = OLD.page AND developer = OLD.developer;
END
&&