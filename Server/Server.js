let http = require('http');
let express = require('express');
let path = require('path');
let bodyParser = require('body-parser');
let cookieParser = require('cookie-parser');
let static = require('serve-static');
let errorHandler = require('errorhandler');
let expressSession = require('express-session');
let app = express();

let mongoose = require('mongoose');
let mysql = require('mysql');


let accountRouter = require('./Account/router');
let circleRouter = require('./Circle/router');


// on Mac :: 8080,
// on Ubuntu :: 80
app.set('port', 80);

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.use(cookieParser());

app.use(expressSession({
    secret: 'my key',
    resave: true,
    saveUninitialized: true
}));

app.use('/', accountRouter);
app.use('/', circleRouter);

http.createServer(app).listen(app.get('port'), function () {
    console.log('Server started on ' + app.get('port') + 'port');
});
