DELIMITER &&
CREATE PROCEDURE cs5200_jdbc.`getUnansweredQuestions` ()
BEGIN
SELECT q.`text` AS question_text, COUNT(a.`id`) AS answer_num FROM `question` q, `user` u, `answer` a 
WHERE u.person = q.asked_by AND u.person = a.posted_by AND a.correct_answer = 0 
GROUP BY q.module 
HAVING MAX(answer_num);
END;
&&