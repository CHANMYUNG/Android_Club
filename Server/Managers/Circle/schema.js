
let mongoose = require('mongoose');

let schema = mongoose.Schema({
    name : {type : String, required : true, unique : true},
    leader : {type : Number, required : true},
    size : {type : Number, required : true}
});

module.exports = schema;