
let router = require('express').Router();
let manager = require('./manager');

router.route('/circle/getInfoByName').post(function (req, res) {
    let circleName = req.body.circleName;
    manager.getInfoByName(circleName, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/circle/getInfoByLeader').post(function (req, res) {
    let leader = req.body.leader;
    manager.getInfoByLeader(leader, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/circle/isNameExist').post(function (req, res) {
    let circleName = req.body.circleName;
    manager.isNameExist(circleName, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/circle/create').post(function (req, res) {
    manager.createCircle(req.body, function (err) {
        if (err) {
            res.writeHead(200, { "Content-Type": "text/plain" });
            res.write("Failed");
            res.end();
        }

        else {
            res.writeHead(200, { "Content-Type": "text/plain" });
            res.write("Succeed");
            res.end();
        }
    });

});

router.route('/circle/getCircles').post(function(req,res){
    console.log('/circle/getCircles');
    manager.getCircles(function(JSONResponse){
        res.write(JSONResponse);
        res.end();
    });
});
module.exports = router;
