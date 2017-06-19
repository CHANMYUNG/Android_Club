let conn = require('../DBConnection')

let manager = {};

manager.serialCheck = function (serial, callback) {
    let response = {
        error: false,
        available: false
    };

    conn.query("select * from account where uid=? and id is null and password is null", serial, function (err, rows) {
        if (err) {
            response.error = true;
        }
        else if (rows.length > 0) response.available = true;

        callback(JSON.stringify(response));
    });
};

manager.idCheck = function (id, callback) {
    let response = {
        error: false,
        available: false
    };

    conn.query("select * from account where id=?", id, function (err, rows) {
        if (err) {
            response.error = true;
        }
        else if (rows.length == 0) response.available = true;

        callback(JSON.stringify(response));
    });
};

manager.emailCheck = function (email, callback) {
    let response = {
        error: false,
        available: false
    };

    conn.query("select * from account where email=?", email, function (err, rows) {
        if (err) {
            response.error = true;
        }
        else if (rows.length == 0) response.available = true;

        callback(JSON.stringify(response));
    });
};

manager.signUp = function (serial, id, password, email, callback) {
    let response = {
        error: false,
        success: false
    };
    conn.query("update account set id=?, password=?, email=? where uid = ?", [id, password, email, serial], function (err, result) {
        if (err) {
            response.error = true;
        }
        else if (result.affectedRows) response.success = true;

        callback(JSON.stringify(response));
    });
};

manager.login = function (id, password, callback) {
    let response = {
        error: false,
        success: false
    };
    conn.query("select * from account where id=? and password=?", [id, password], function (err, rows) {
        if (err) response.error = true;
        else if (rows.length == 1) {
            response.success = true;
            response.uid = rows[0].uid;
            response.circle_id = rows[0].circle_id;
        }
        callback(response);
    });
};

manager.findAll = function (callback) {
    let response = {
        error: false,
        accounts: []
    };
    conn.query("select * from account", function (err, rows) {
        if (err) {
            response.error = true;
        }
        else {
            for (var i = 0; i < rows.length; i++) {
                response.accounts.push(rows[i]);
            }
        }
        callback(JSON.stringify(response));
    });
};

manager.getUserInfo = function (uid, callback) {
    let response = {
        session: true,
        error: false,
        user: null,
        circle: null
    };

    conn.query("select a.name, c.name as circle from account as a inner join  circle as c on a.circle_id = c.id where a.uid = ?", uid, function (err, rows) {
        if (err) {
            response.error = true;
        } else if (rows.length == 1) {
            response.user = rows[0].name;
            response.circle = rows[0].circle;
        }
        callback(JSON.stringify(response));
    });
};

module.exports = manager;