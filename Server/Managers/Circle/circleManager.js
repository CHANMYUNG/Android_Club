
let model = require('./circleModel');

let manager ={};

// path : /process/getCircleInfoByName.
// find a circle by circle name.
// and response the circle as a JSON file.
manager.getInfoByName = function(name, callback){
    model.find({"name" : name}, function(err, results){
        if(err){
            callback(-1);
            return;
        }
        if(results.length > 0){
            callback(JSON.stringify(results[0]));
        }
        else{
            callback(null);
        }
    });
};

// path : /process/getCircleInfoByLeader
// find a circle by Leader Number.
// and response the circle as a JSON file.
manager.getInfoByLeader = function(leader, callback){
    model.find({"leader" : leader}, function(err, results){
        if(err){
            callback(-1);
            return;
        }
        if(results.length > 0){
            callback(JSON.stringify(results[0]));
        }
        else{
            callback(null);
        }
    });
};

// path : /process/getMembersByName
// find a circle members by circle name.
// and response them as JSON ARRAY
manager.getMembersByName = function(circleName, callback){
    model.find({"name" : circleName}, function(err, results){
        if(err){
            callback(-1);
            return;
        }
        if(results.length>0){
            let Members = [];
            for(let i=0;i<results.length;i++){
                Members.push(JSON.stringify(results[i]));
            }
            callback(Members);
        }
        else{
            callback(null);
        }
    });
};

manager.isCircleExist = function(circleName,callback){
    model.find({"name" : circleName}, function(err, results){
        if(err){
            callback(-1);
            return;
        }
        if(results.length > 0){
            callback(true);
        }
        else{
            callback(false);
        }
    })
};

manager.getMembersByLeader = function(){};

manager.createCircle = function(object, callback){
    let data = new model(object);

    data.save(function(err){
        if(err){
            callback(true);
        }
        else{
            callback(false);
        }
    });
};
module.exports = manager;