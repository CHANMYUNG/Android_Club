
let model = require('./accountModel');

let Manager = {};

Manager.login = function(database, id, password, callback){
    model.find({"id":id,"password":password}, function(err,results){
        if(err){
            callback(err,null);
            return;
        }

        if(results.length>0){
            callback(null,true);
        }
        else{
            callback(null,false);
        }
    });
};

Manager.isIdExist = function(database, id, callback){
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

Manager.isStuExist = function(database, stuId, callback){
    model.find({"stuId" : stuId}, function(err, results){
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

Manager.regist = function(database, stuId,id, password, name, gender, major, callback){
    let data = new model({"stuId" : stuId, "id" : id, "password" : password
                            , "name" : name, "gender" : gender, "major" : major});
    data.save(function(err){
        if(err)
            callback(true);
	else{        
	    callback(false);
    	}
    });
};

module.exports = Manager;
