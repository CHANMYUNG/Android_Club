let mysql = require('mysql');


let conn = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "",
    database: "Arirang"
});

module.exports = conn;  