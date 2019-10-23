DELIMITER &&
CREATE PROCEDURE cs5200_jdbc.`endorsedUsersForWeek` (IN start_date DATE, IN end_date DATE)
BEGIN
SELECT tmp.id, tmp.first_name, tmp.last_name, tmp.correct_num FROM 
(SELECT u.id, p.first_name, p.last_name, COUNT(a.id) AS correct_num FROM `question` q, `user` u, `answer` a, `person` p 
WHERE u.person = q.asked_by AND u.person = a.posted_by AND (q.posted_on BETWEEN start_date AND end_date) AND a.correct_answer = 1 
ORDER BY correct_num DESC LIMIT 5) AS tmp
ORDER BY tmp.first_name;
END;
&&