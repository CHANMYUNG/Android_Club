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

let database;

let UserSchema;
UserSchema = mongoose.Schema({
    id : { type : String, unique : true},
    password : String
});

// collection :: accounts
let UserModel = mongoose.model("accounts",UserSchema);

app.set('port', process.env.PORT || 8080);

app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

app.use(cookieParser());

app.use(expressSession({
    secret : 'my key',
    resave : true,
    saveUninitialized : true
}));

router.route('/process/login').post(function(req,res){
    console.log('/process/login');
    let id = req.body.id;
    let password = req.body.password;
    
    if(database){
        Login(database,id,password,function(err, results){
            if(err){
                res.writeHead('200',{"Content-Type" : "text/plain"});
                res.end("Database Connection Error");
                return;
            }
            if(results){
                res.writeHead('200',{"Content-Type" : "text/plain"});
                res.end("Succeed");
                console.log("Succeed");
            }
            else{
                res.writeHead('200',{"Content-Type" : "text/plain"});
                res.end("Failed");
                console.log("Failed");
            }
        });
    }
});

function Login(database, id, password, callback){
    UserModel.find({"id":id,"password":password}, function(err,results){
        if(err){
            callback(err,null);
            return;
        }

        if(results.length>0){
            callback(null,results);
        }
        else{
            callback(null,null);
        }
    });
}

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

app.use('/',router);

http.createServer(app).listen(app.get('port'), function(){
    console.log('Server started on '+app.get('port')+'port');
    connectDB();
});
