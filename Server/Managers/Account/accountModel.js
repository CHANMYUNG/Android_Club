
let mongoose = require('mongoose');

let schema = mongoose.Schema({
    uid : {type : String, required : true, unique : true},
    id : { type : String, required: true, unique : true},
    stuNum : {type : Number, required : true, unique : true},
    name : {type : String, required : true},
    password : {type : String, required : true},
    gender : {type : String, required : true},
    major : {type : String, required : true},
    club : {type : String}
});

let model = mongoose.model("accounts", schema);
module.exports = model;