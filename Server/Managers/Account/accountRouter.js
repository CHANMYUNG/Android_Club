
let router = require('express').Router();
let accountManager = require('./accountManager');

router.route('/account/login').post(function (req, res) {

    if (req.session.user) {
        res.end();
        return;
    }
    let id = req.body.id;
    let password = req.body.password;

    accountManager.login(id, password, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });

});

router.route('/account/logout').post(function (req, res) {
    // Session destroy
    if (req.session.user) {
        req.session.destroy(function (err) {
            console.log('Session destroyed');
        });
    }
    res.writeHead(200, { "Content-Type": "text/plain" });
    res.end();

});

router.route('/account/idCheck').post(function (req, res) {
    let id = req.body.id;

    accountManager.isIdExist(id, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/account/stuCheck').post(function (req, res) {

    let stuNum = req.body.stuNum;

    accountManager.isStuExist(stuNum, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/account/signUp').post(function (req, res) {
    let stuNum = parseInt(req.body.stuNum);
    req.body.stuNum = stuNum;

    if (!req.body.circle) {
        req.body.circle = null;
    }

    let object = req.body;
    accountManager.signUp(object, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/account/findAccount').post(function(req, res){
    let stuNum = req.body.stuNum;
    accountManager.findAccountByNum(stuNum, function(JSONResponse){
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

module.exports = router;