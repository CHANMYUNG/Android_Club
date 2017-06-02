let mongoose = require('mongoose');
let schema = require('./schema');

schema.static('login', function (id, password, callback) {
    this.find({ "id": id, "password": password }, function (err, results) {

        let response = {
            "error": false,
            "success": false
        };
        let JSONResponse;

        if (err) {
            response.error = true;
        }

        else if (results.length > 0) {
            response.success = true;
        }
        else {
            response.success = false;
        }

        JSONResponse = JSON.stringify(response);
        console.log(JSONResponse)
        callback(JSONResponse);
    });
});

schema.static('isIdExist', function (id, callback) {
    this.find({ "id": id }, function (err, results) {

        let response = {
            "error": false,
            "exist": false
        };
        let JSONResponse;

        if (err) {
            response.error = true;
        }

        else if (results.length > 0) {
            response.exist = true;
        }
        else {
            response.exist = false;
        }

        JSONResponse = JSON.stringify(response);
        callback(JSONResponse);
    });
});

schema.static('isStuExist', function (stuNum, callback) {
    this.find({ "stuNum": stuNum }, function (err, results) {

        let response = {
            "error": false,
            "exist": false
        };
        let JSONResponse;

        if (err) {
            response.error = true;
        }

        else if (results.length > 0) {
            response.exist = true;
        }
        else {
            response.exist = false;
        }

        JSONResponse = JSON.stringify(response);
        callback(JSONResponse);
    });
});

schema.static('signUp', function (object, callback) {
    let model = mongoose.model("accounts",schema);
    let data = new model(object);
    console.log(data);
    let response = {
        "error": false,
        "success": false
    };
    let JSONResponse;

    data.save(function (err) {
        if (err) {
            response.error = true;
        }
        else {
            response.success = true;
        }
    });

    JSONResponse = JSON.stringify(response);
    callback(JSONResponse);
});

schema.static('findByNum', function (stuNum, callback) {
    this.find({ "stuNum": stuNum }, function (err, results) {
        let response = {
            "error": false,
            "account": {}
        };

        let JSONResponse;

        if (err) {
            response.error = true;
        }
        if (results.length > 0) {
            response.account = results[0];
        }
        else {
            response.account = null;
        }

        JSONResponse = JSON.stringify(response);
        callback(JSONResponse);
    });
});

schema.static('findById', function (id, callback) {
    this.find({ "id": id }, function (err, results) {
        let response = {
            "error": false,
            "account": {}
        };

        let JSONResponse;

        if (err) {
            response.error = true;
        }
        if (results.length > 0) {
            response.account = results[0];
        }
        else {
            response.account = null;
        }

        JSONResponse = JSON.stringify(response);
        callback(JSONResponse);
    });
});

schema.static('findByName', function(name, callback){
    this.find({"name" : name }, function(err, results){
        let response = {
            "error": false,
            "accounts": []
        };

        let JSONResponse;

        if (err) {
            response.error = true;
        }
        if (results.length > 0) {
            for(var i = 0 ; i < results.length; i++){
                response.accounts.push(results[i]);
            }
        }
        else {
            response.account = null;
        }

        JSONResponse = JSON.stringify(response);
        callback(JSONResponse);
    });
});

let manager = mongoose.model("accounts", schema);

module.exports = manager;