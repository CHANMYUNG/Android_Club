let conn = require('../DBConnection');

let manager = {};

manager.getCircleInfos = function (callback) {
    let response = {
        session: true,
        error: false,
        infos: []
    };
    let JSONResponse;
    conn.query("select c.name, count(c.name) as size, (select name from account where account.num=c.leaderNum) as leader " +
        "from account as a inner join circle as c on a.circle_id = c.id group by a.circle_id;", function (err, rows) {
            if (err) response.error = true;
            else if (rows.length > 0) {
                for (var i = 0; i < rows.length; i++) {
                    response.infos.push({
                        name: rows[i].name,
                        leader: rows[i].leader,
                        size: rows[i].size
                    });
                }
            }
            JSONResponse = JSON.stringify(response);
            callback(JSONResponse);
        });
};

manager.canFound = function (uid, callback) {
    let response = {
        session: true,
        error: false,
        enable: false
    };
    let JSONResponse;
    console.log(uid);
    conn.query("select * from account where uid=? and circle_id is null", uid, function (err, rows) {
        if (err) response.error = true;
        else if (rows.length == 1) response.enable = true;
        JSONResponse = JSON.stringify(response);
        callback(JSONResponse);
    });
};

manager.found = function (name, uid, intro, callback) {
    let response = {
        session: true,
        error: false,
        success: false
    };
    let JSONResponse;
    conn.query("insert into circle values((select count(c.name)+1 from circle as c),?,?,?)", [name, uid, intro], function (err, result) {
        if (err) response.error = true;
        else if (result.affectedRows == 1) {
            conn.query("update account set circle_id = (select count(circle.name) from circle) where uid = ?", uid, function (error, updateResult) {
                if (error) response.error = true;

                else if (updateResult.affectedRows == 1) response.success = true;

                JSONResponse = JSON.stringify(response);
                callback(JSONResponse);
            });
        }
    });
}

manager.getCircle = function (circle_id, callback) {
    let response = {
        session: true,
        error: false,
        leader: null,
        name: []
    };
    let JSONResponse;
    let leaderNum;
    conn.query("select name,num from account where num = (select leaderNum from circle where id=?)", circle_id, function (err, rows) {
        if (err) response.error = true;
        else if (rows.length == 1) {
            leaderNum = rows[0].num;
            response.leader = rows[0].name;
            conn.query("select name from account where circle_id=? and num != ? order by name", [circle_id, leaderNum], function (err, rows) {
                if (err) response.error = true;
                else if (rows.length > 0) {
                    for (var i = 0; i < rows.length; i++) {
                        response.name.push(rows[i].name);
                    }
                }
                JSONResponse = JSON.stringify(response);
                callback(JSONResponse);
            });
        }
    });
}

module.exports = manager;