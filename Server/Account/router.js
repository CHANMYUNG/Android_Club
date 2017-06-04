
let router = require('express').Router();
let manager = require('./manager');

router.route('/account/findAll').post(function (req, res) {
    manager.findAll(function (JSONResponse) {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/account/serialCheck').post(function (req, res) {
    let serial = req.body.serial;
    manager.serialCheck(serial, function (JSONResponse) {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/account/idCheck').post(function (req, res) {
    let id = req.body.id;
    manager.idCheck(id, function (JSONResponse) {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/account/emailCheck').post(function (req, res) {
    let email = req.body.email;
    manager.emailCheck(email, function (JSONResponse) {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/account/signUp').post(function (req, res) {
    let serial = req.body.serial;
    let id = req.body.id;
    let password = req.body.password;
    let email = req.body.email;
    manager.signUp(serial, id, password, email, function (JSONResponse) {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.write(JSONResponse);
        res.end();
    });
});

router.route('/account/login').post(function (req, res) {
    let id = req.body.id;
    let password = req.body.password;
    manager.login(id, password, function (response) {
        if (response.success) {
            req.session.user = {
                uid: response.uid,
                circle_id : response.circle_id,
                authorized: true
            };
        }
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.write(JSON.stringify(response));
        res.end();
    });
});

router.route('/account/logout').post(function (req, res) {
    let response = {
        error: false,
        success: false
    };
    if (req.session.user) {
        req.session.destroy(function (err) {
            if (err) response.error = true;
            else response.success = true;
            res.writeHead(200, { 'Content-Type': 'application/json' });
            res.write(JSON.stringify(response));
            res.end();
        });

    }
    else {
        response.success = true;
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.write(JSON.stringify(response));
        res.end();
    }

});
module.exports = router;