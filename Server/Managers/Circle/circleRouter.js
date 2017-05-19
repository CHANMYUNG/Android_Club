
let router = require('express').Router();
let circleManager = require('./circleManager');

router.route('/circle/getInfoByName').post(function (req, res) {
    let circleName = req.body.circleName;
    circleManager.getInfoByName(circleName, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/circle/getInfoByLeader').post(function (req, res) {
    let leader = req.body.leader;
    circleManager.getInfoByLeader(leader, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/circle/isNameExist').post(function (req, res) {
    let circleName = req.body.circleName;
    circleManager.isNameExist(circleName, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/circle/create').post(function (req, res) {
    circleManager.createCircle(req.body, function (err) {
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

module.exports = router;