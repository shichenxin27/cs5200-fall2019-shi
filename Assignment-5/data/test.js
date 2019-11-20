require('./db')();
const uniDao = require('./daos/university.dao.server');
const assert = require('assert');


testStudentsInitialCount = () => {
    return uniDao.findAllStudents()
        .then(students =>
        {
            assert.equal(students.length, 2, "testStudentsInitialCount failed...");
            console.log("Success, student initial count is", students.length)
        })
};

testQuestionsInitialCount = () => {
    return uniDao.findAllQuestions()
        .then(questions =>
        {
            assert.equal(questions.length, 4, "testQuestionsInitialCount failed...");
            console.log("Success, question initial count is", questions.length)
        })
};

testAnswersInitialCount = () => {
    return uniDao.findAllAnswers()
        .then(answers =>
            {
                assert.equal(answers.length, 8,"testAnswersInitialCount failed...");
                console.log("Success, answer initial count is", answers.length)
            })
};

testDeleteAnswer = () => {
    return uniDao.deleteAnswer(890)
        .then(() => {
        uniDao.findAllAnswers()
            .then(allAnswers =>
            {
                assert.equal(allAnswers.length, 7, "testAllAnswerCount after deletion failed...");
                console.log("Success, total answer count after deletion is", allAnswers.length)
            });
        uniDao.findAnswersByStudent(234)
            .then(studentAnswers =>
            {
                assert.equal(studentAnswers.length, 3, "testBobAnswerCount after deletion failed...");
                console.log("Success, Bob's answer count after deletion is", studentAnswers.length)
            });
    });
};

testDeleteQuestion = () => {
    return uniDao.deleteQuestion(321)
        .then(() => {
        uniDao.findAllQuestions()
            .then(questions =>
            {
                assert.equal(questions.length, 3, "testQuestionsCount after deletion failed...");
                console.log("Success, question count after deletion is", questions.length)
            });
    });
};

testDeleteStudent = () => {
    return uniDao.deleteStudent(234)
        .then(() =>
        uniDao.findAllStudents()
            .then(student =>
            {
                assert.equal(student.length, 1, "testStudentCount after deletion failed...");
                console.log("Success, student count after deletion is", student.length)
            }))
};


uniDao.truncateDatabase()
    .then(() => uniDao.populateDatabase())
    .then(() => testStudentsInitialCount())
    .then(() => testQuestionsInitialCount())
    .then(() => testAnswersInitialCount())
    .then(() => testDeleteAnswer())
    .then(() => testDeleteQuestion())
    .then(() => testDeleteStudent());

