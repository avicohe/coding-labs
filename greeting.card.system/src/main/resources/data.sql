DROP TABLE IF EXISTS template;
 
CREATE TABLE template (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  content VARCHAR(3000) NOT NULL
);
 
INSERT INTO template (content) VALUES
  ('Happy birthday, %s! from %s.'),
  ('Happy holiday to the %s family, from %s and %s.'),
  ('Good luck on your %s examine, from %s');