let mongoose = require('mongoose');

let schema = mongoose.Schema({
    uid : {type : String, required : true, unique : true},
    id : { type : String, unique : true},
    stuNum : {type : Number, required : true, unique : true},
    name : {type : String, required : true},
    password : {type : String},
    gender : {type : String, required : true},
    major : {type : String},
    club : {type : String}
});

module.exports = schema;