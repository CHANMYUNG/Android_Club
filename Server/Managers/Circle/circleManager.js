
let model = require('./circleModel');

let manager = {};

// path : /circle/getInfoByName.
// find a circle by circle name.
// response the circle as a JSON foramt.
manager.getInfoByName = function (name, callback) {
    model.find({ "name": name }, function (err, results) {
        let info = {
            "error": false,
            "info": {}
        };
        let JSONResponse;
        if (err) {
            info.error = true;
        }
        if (results.length > 0) {
            info.info = results[0];
        }
        else {
            info.info = null;
        }
        JSONResponse = JSON.stringify(info);
        callback(JSONResponse);
    });
};

// path : /circle/getInfoByLeader
// find a circle by leader's stuNum.
// response the circle as a JSON format.
manager.getInfoByLeader = function (leader, callback) {
    model.find({ "leader": leader }, function (err, results) {
        let info = {
            "error": false,
            "info": {}
        };
        let JSONResponse;
        if (err) {
            info.error = true;
        }
        if (results.length > 0) {
            info.info = results[0];
        }
        else {
            info.info = null;
        }
        JSONResponse = JSON.stringify(info);
        callback(JSONResponse);
    });
};

// path : /process/getMembersByName
// find a circle members by circle name.
// and response them as JSON ARRAY
manager.getMembersByName = function (circleName, callback) {
    model.find({ "name": circleName }, function (err, results) {
        if (err) {
            callback(-1);
            return;
        }
        if (results.length > 0) {
            let Members = [];
            for (let i = 0; i < results.length; i++) {
                Members.push(JSON.stringify(results[i]));
            }
            callback(Members);
        }
        else {
            callback(null);
        }
    });
};

manager.isNameExist = function (circleName, callback) {
    model.find({ "name": circleName }, function (err, results) {
        let response = {
            "error": false,
            "exist": false
        };
        let JSONResponse;
        if (err) {
            response.error = true;
        }
        if (results.length > 0) {
            response.exist = true;
        }
        else {
            response.exist = false;
        }
        JSONResponse = JSON.stringify(response);
        callback(JSONResponse);
    });
};

manager.getMembersByLeader = function () { };

manager.createCircle = function (object, callback) {
    let data = new model(object);

    data.save(function (err) {
        if (err) {
            callback(true);
        }
        else {
            callback(false);
        }
    });
};
manager.getCircles = function(callback){
    model.find({},function(err, results){
        let response = {
            "error" : false,
            "circles" : []
        };
        let JSONResponse;

        if(err){
            response.error = true;
        }
        
        if(results.length > 0){
            for(var i = 0 ; i < results.length ; i++){
                response.clubs.push(results[i]);
            }
        }
        JSONResponse = JSON.stringify(response);

        callback(JSONResponse);
    });
}
module.exports = manager;