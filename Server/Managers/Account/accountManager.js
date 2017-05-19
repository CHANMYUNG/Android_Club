
let model = require('./accountModel');

let Manager = {};

Manager.login = function( id, password, callback){
    model.find({"id":id,"password":password}, function(err,results){
        if(err){
            callback(err,null);
            return;
        }

        if(results.length>0){
            callback(null,results[0]);
        }
        else{
            callback(null,null);
        }
    });
};

Manager.isIdExist = function(id, callback){
    model.find({"id":id}, function(err,results){
        if(err){
            callback(err, null);
            return;
        }
        
        if(results.length > 0 ){
            callback(null, true);
        }

        else{ 
            callback(null, false);
        }
    })
};

Manager.isStuExist = function(stuNum, callback){
    model.find({"stuNum" : stuNum}, function(err, results){
        if(err){
            callback(err, null);
            return;
        }
        if(results.length > 0 ){
            callback(null, true);
        }
        else{ 
            callback(null, false);
        }
    });
};

Manager.signUp = function(object, callback){

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

Manager.findByNum = function(stuNum, callback){
    let result = model.find({"stuNum" : stuNum}, function(result){
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

Manager.findById = function(id){
    let result = model.find({"id" : id}, function(result){
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

module.exports = Manager;
