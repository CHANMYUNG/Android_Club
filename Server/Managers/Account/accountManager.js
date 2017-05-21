
let model = require('./accountModel');

let Manager = {};

Manager.login = function (id, password, callback) {
    model.find({ "id": id, "password": password }, function (err, results) {

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
};

Manager.isIdExist = function (id, callback) {
    model.find({ "id": id }, function (err, results) {

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
};

Manager.isStuExist = function (stuNum, callback) {
    model.find({ "stuNum": stuNum }, function (err, results) {

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
};

Manager.signUp = function (object, callback) {

    let data = new model(object);
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
};

Manager.findAccountByNum = function (stuNum, callback) {
    model.find({ "stuNum": stuNum }, function (err, results) {
        let response = {
            "error" : false,
            "account" : {}
        }

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
        callback(JSONResponse)
    });
};

Manager.findById = function (id) {
    let result = model.find({ "id": id }, function (result) {
        if (err) {
            callback(-1);
            return;
        }
        if (results.length > 0) {
            callback(JSON.stringify(results[0]));
        }
        else {
            callback(null);
        }
    });
};

module.exports = Manager;
