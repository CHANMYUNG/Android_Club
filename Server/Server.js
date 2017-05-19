
let http = require('http');
let express = require('express');
let path = require('path');
let bodyParser = require('body-parser');
let cookieParser = require('cookie-parser');
let static = require('serve-static');
let errorHandler = require('errorhandler');
let expressSession = require('express-session');
let app = express()
let router = express.Router();
let mongoose = require('mongoose');

// database instance 
let database;

// Managers
let accountRouter = require('./Managers/Account/accountRouter');
let circleRouter = require('./Managers/Circle/circleRouter');


// on Mac :: 8080,
// on Ubuntu :: 80
app.set('port', 80);

app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

app.use(cookieParser());

app.use(expressSession({
    secret : 'my key',
    resave : true,
    saveUninitialized : true
}));

function connectDB(){
    let databaseUrl = "mongodb://localhost:27017/Arirang";

    console.log('trying to connect DB');

    mongoose.Promise = global.Promise;
    mongoose.connect(databaseUrl);
    database = mongoose.connection;

    database.on('error', console.error.bind(console, 'database connection error'));

    database.on('open', function(){
        console.log('Database Connection Succeed');
    });

    database.on('disconnect', function(){
        console.log("Database connection lost. Server will retry in 5 secs");
        setInterval(connectDB, 5000);
    })

}

app.use('/',accountRouter);
app.use('/',circleRouter);
http.createServer(app).listen(app.get('port'), function(){
    console.log('Server started on '+app.get('port')+'port');
    connectDB();
});
