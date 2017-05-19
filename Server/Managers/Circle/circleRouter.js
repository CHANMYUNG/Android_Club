
let router = require('express').Router();
let circleManager = require('./circleManager');

router.route('/circle/getInfoByName').post(function(req,res){
    let circleName = req.body.circleName;
    circleManager.getInfoByName(circleName, function(result){
        // DATABASE ERROR
        if(result == -1){
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("ERROR OCCURED");
            res.end();
        }
        // COULD NOT GET CIRCLE INFO 
        else if(result == null){
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("Doesn't exist");
            res.end();
        }
        // JSON OBJECT
        else{
            res.writeHead(200,{"Content-Type" : "application/json"});
            res.write(result);
            res.end();
        }
    });
});

router.route('/circle/getInfoByLeader').post(function(req,res){
    let leader = req.body.leader;
    circleManager.getInfoByLeader(leader, function(result){
        // DATABASE ERROR
        if(result == -1){
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("ERROR OCCURED");
            res.end();
        }
        // COULD NOT GET CIRCLE INFO 
        else if(result == null){
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("Doesn't exist");
            res.end();
        }
        // JSON OBJECT
        else{
            res.writeHead(200,{"Content-Type" : "application/json"});
            res.write(result);
            res.end();
        }
    });
});

/* TO DO :: 동아리가 이미 존재하는지 검사 */
router.route('/circle/isExist').post(function(req,res){
    let circleName = req.body.circleName;
    circleManager.isCircleExist()

});

router.route('/circle/create').post(function(req,res){
    circleManager.createCircle(req.body, function(err){
        if(err){
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("Failed");
            res.end();
        }

        else{
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("Succeed");
            res.end();
        }
    });

});

module.exports = router;