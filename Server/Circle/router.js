let router = require('express').Router();
let manager = require('./manager');

router.route('/circle/getCircleInfos').post(function (req, res) {
    manager.getCircleInfos(function (JSONResponse) {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.write(JSONResponse);
        res.end();
    })
});

router.route('/circle/canFound').post(function (req, res) {
    let response = {
        session: false,
        able: false
    };
    if (req.session.user) {
        response.session = true;
        if (!req.session.user.circle_id) {
            response.able = true;
        }
    }
    res.writeHead(200, { 'Content-Type': 'application/json' });
    res.write(JSON.stringify(response));
    res.end();
});

router.route('/circle/found').post(function (req, res) {
    if (!req.session.user) {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.write(JSOㅌN.stringify({
            session: false
        }));
        res.end();
        return;
    }
    let name = req.body.name;
    let uid = req.session.user.uid;
    let intro = req.body.intro;
    console.log(uid);
    manager.found(name, uid, intro, function (JSONResponse) {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.write(JSONResponse);
        res.end();
    });
});

module.exports = router;