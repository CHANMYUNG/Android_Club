
let mongoose = require('mongoose');

let schema = mongoose.Schema({
    stuNum : {type : Number, required :true, unique : true},
    serial : {tyoe : String, required :true, unique : true},
    isExist : {type : Boolean, required : true}    
});

let model = mongoose.model("serials", schema);
module.exports = model;