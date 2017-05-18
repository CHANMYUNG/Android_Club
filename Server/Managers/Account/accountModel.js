
let mongoose = require('mongoose');

let schema = mongoose.Schema({
    stuNum : {type : Number, require : true, unique : true},
    id : { type : String, require: true, unique : true},
    password : {type : String, require : true},
    name : {type : String, require : true},
    gender : {type : String, require : true},
    major : {type : String, require : true}
});

let model = mongoose.model("accounts", schema);
module.exports = model;