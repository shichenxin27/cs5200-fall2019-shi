CREATE TABLE cs5200.sample (
  id INT NOT NULL AUTO_INCREMENT,
  message VARCHAR(45) NULL,
  PRIMARY KEY (id));

INSERT INTO cs5200.sample (id, message) VALUES ('1', 'Hello Chenxin Shi');
INSERT INTO cs5200.sample (id, message) VALUES ('2', 'SQL is great');
INSERT INTO cs5200.sample (id, message) VALUES ('3', 'Java is awesome');

SELECT * FROM cs5200.hello;
DELETE FROM cs5200.sample WHERE id = '1';
