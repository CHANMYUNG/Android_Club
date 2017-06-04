let mysql = require('mysql');


let conn = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "xogns1228",
    database: "Arirang"
});

module.exports = conn;