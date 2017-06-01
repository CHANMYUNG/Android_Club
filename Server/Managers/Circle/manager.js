let mongoose = require('mongoose');
let schema = require('./schema');

// path : /circle/getInfoByName.
// find a circle by circle name.
// response the circle as a JSON foramt.

schema.static('getInfoByName', function (name, callback) {
    this.find({ "name": name }, function (err, results) {
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
});

// path : /circle/getInfoByLeader
// find a circle by leader's stuNum.
// response the circle as a JSON format.

schema.static('getInfoByLeader', function (leader, callback) {
    this.find({ "leader": leader }, function (err, results) {
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
});


// path : /process/getMembersByName
// find a circle members by circle name.
// and response them as JSON ARRAY

schema.static('getMembersByName', function (circleName, callback) {
    this.find({ "name": circleName }, function (err, results) {
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
});


schema.static('getMembersByLeader', function (leader, callback) {
    this.find({ "leader": leader }, function (err, results) {
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
});

schema.static('isNameExist', function (circleName, callback) {
    this.find({ "name": circleName }, function (err, results) {
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
});

schema.static('createCircle', function (object, callback) {
    let data = new model(object);

    data.save(function (err) {
        if (err) {
            callback(true);
        }
        else {
            callback(false);
        }
    });
});

schema.static('getCircles', function (callback) {
    this.find({}, function (err, results) {
        let response = {
            "error": false,
            "circles": []
        };
        let JSONResponse;

        if (err) {
            response.error = true;
        }

        if (results.length > 0) {
            for (var i = 0; i < results.length; i++) {
                response.circles.push(results[i]);
            }
        }
        JSONResponse = JSON.stringify(response);
        console.dir(JSONResponse);
        callback(JSONResponse);
    });
});

let manager = mongoose.model("circles", schema);

module.exports = manager;
