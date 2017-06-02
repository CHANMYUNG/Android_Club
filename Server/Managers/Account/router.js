
let router = require('express').Router();
// let accountManager = require('./accountManager');
let manager = require('./manager');

router.route('/account/login').post(function (req, res) {
    console.log("in");
    if (req.session.user) {
        res.end();
        return;
    }
    let id = req.body.id;
    let password = req.body.password;

    manager.login(id, password, function (JSONResponse) {
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

    manager.isIdExist(id, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/account/stuCheck').post(function (req, res) {

    let stuNum = req.body.stuNum;

    manager.isStuExist(stuNum, function (JSONResponse) {
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
    console.log(object);
    console.log(JSON.stringify(object));
    manager.signUp(object, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/account/findAccount').post(function (req, res) {
    let stuNum = req.body.stuNum;

    manager.findAccountByNum(stuNum, function (JSONResponse) {
        res.writeHead(200, { "Content-Type": "application/json" });
        res.write(JSONResponse);
        res.end();
    });
});

module.exports = router;