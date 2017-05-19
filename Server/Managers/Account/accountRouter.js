
let router = require('express').Router();
let accountManager = require('./accountManager');

router.route('/account/login').post(function (req, res) {

    if (req.session.user) {
        res.end();
        return;
    }
    let id = req.body.id;
    let password = req.body.password;

    accountManager.login(id, password, function (err, result) {
        if (err) {
            // What status code can I send status code?
            res.end();
            return;
        }
        if (result) {
            req.session.user = {
                id: id,
                circle: result.circle,
                stuNum: result.stuNum,
                authorized: true
            };
            res.writeHead(200);
            res.write("Succeed");
            res.end();
        }
        else {
            res.writeHead(401);
            res.write("Failed");
            res.end();
        }
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
    res.write('Succeed');
    res.end();

});

router.route('/account/idCheck').post(function (req, res) {
    let id = req.body.id;

    accountManager.isIdExist(id, function (err, result) {
        if (err) {
            res.writeHead(200, { "Content-Type": "text/plain" });
            res.write("Could not find from DB");
            res.end();
            return;
        }

        // the id already exists
        if (result) {
            res.writeHead(200, { "Content-Type": "text/plain" });
            res.write("already exists");
            res.end();
            return;
        }

        // the id doesn't exist
        else {
            res.writeHead(200, { "Content-Type": "text/plain" });
            res.write("Doesn't exist");
            res.end();
            return;
        }
    });
});

router.route('/account/stuCheck').post(function (req, res) {
    
    let stuNum = req.body.stuNum;

    accountManager.isStuExist(stuNum, function (err, result) {
        if (err) {
            res.writeHead(200, { "Content-Type": "text/plain" });
            res.write("Error");
            res.end();
            return;
        }

        // the stuNum already exists
        if (result) {
            res.writeHead(200, { "Content-Type": "text/plain" });
            res.write("Can't");
            res.end();
            return;
        }

        // the stuNum doesn't exist
        else {
            res.writeHead(200, { "Content-Type": "text/plain" });
            res.write("Can");
            res.end();
            return;
        }
    });
});

router.route('/account/signUp').post(function (req, res) {
    let stuNum = parseInt(req.body.stuNum);
    req.body.stuNum = stuNum;

    if (!req.body.circle) {
        req.body.circle = null;
    }

    accountManager.signUp(req.body, function (err) {
        // if signing up failed
        if (err) {
            // What status code can I send?
            res.writeHead(200, { "Content-Type": "text/plain" });
            res.write("Failed");
            res.end();
        }

        // signing up succeed
        else {
            res.writeHead(200, { "Content-Type": "text/plain" });
            res.write("Succeed");
            res.end();
        }
    });
});

module.exports = router;