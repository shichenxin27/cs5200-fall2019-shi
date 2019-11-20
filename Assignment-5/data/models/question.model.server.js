const mongoose = require('mongoose');
questionSchema = require('./question.schema.server');
const questionModel = mongoose.model('QuestionModel', questionSchema);
module.exports = questionModel;