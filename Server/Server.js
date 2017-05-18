
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
let accountManager = require('./Managers/Account/accountManager');


app.set('port', 8080);

app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

app.use(cookieParser());

app.use(expressSession({
    secret : 'my key',
    resave : true,
    saveUninitialized : true
}));

router.route('/process/login').post(function(req,res){
    console.log("/process/login");

    if(req.session.user){
        res.end();
        return;
    }
    let id = req.body.id;
    let password = req.body.password;
    
    if(database){
       accountManager.login(database,id,password,function(err, result){
            if(err){ 
                // What status code can I send status code?
                res.end();
                return;
            }
            if(result){
                req.session.user = {
                    id : id,
                    authorized : true 
                };

                res.writeHead(200);
                res.write("Succeed");
                res.end();
            }
            else{
                res.writeHead(401);
                res.write("Failed");
                res.end();
            }
        });
    }
});

router.route('/process/logout').post(function(req,res){
    // Session destroy
    req.session.destroy(function(err){
        console.log('Session destroyed');
    });

    res.writeHead(200,{"Content-Type" : "text/plain"});
    res.write('Succeed');
    res.end();

});

router.route('/process/idCheck').post(function(req,res){
    let id = req.body.id;

    accountManager.isIdExist(database, id, function(err, result){
        if(err){
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("Could not find from DB");
            res.end();
            return;
        }

        // the id already exists
        if(result){
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("already exists");
            res.end();
            return;
        }

        // the id doesn't exist
        else{
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("Doesn't exist");
            res.end();
            return;
        }
    });
});

router.route('/process/stuCheck').post(function(req,res){
    let stuNum = req.body.stuNum;

    accountManager.isStuExist(database, stuNum, function(err, result){
        if(err){
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("Error");
            res.end();
            return;
        }

        // the stuNum already exists
        if(result){
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("Can't");
            res.end();
            return;
        }

        // the stuNum doesn't exist
        else{
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("Can");
            res.end();
            return;
        }
    });
});

router.route('/process/regist').post(function(req,res){
    let stuNum = req.body.stuNum;
    let id = req.body.id;
    let password = req.body.password;
    let name = req.body.name;
    let gender = req.body.gender;
    let major = req.body.major;

    accountManager.regist(database, stuNum,id, password, name, gender, major, function(err){
        // if registing failed
        if(err){
            // What status code can I send?
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("Failed");
            res.end();
            return;
        }

        // registing succeed
        else{
            res.writeHead(200,{"Content-Type" : "text/plain"});
            res.write("Succeed");
            res.end();
        }
    });
});



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
