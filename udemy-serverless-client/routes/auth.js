var debug = require('debug')('auth');
var AWSCognito = require('amazon-cognito-identity-js');
var jwt = require('jsonwebtoken');

var poolData = {
    UserPoolId : 'us-east-2_EfNWqFewp',
    ClientId : '7odphuik49cmobja50256ujl9n'
};
var userPool = new AWSCognito.CognitoUserPool(poolData);

var cognitoUser;
var cognitoToken;

function signout(req, res) {
    if(cognitoUser) {
        cognitoUser.globalSignOut();
    }
    res.redirect('/auth/signin');
}

function confirmForm(req, res) {
    res.render('auth/confirm', {
        title : "Confirm With Code"
    });
}
function confirm(req, res) {
    debug(req.body);

    var userData = {
        Username : req.body.username,
        Pool : userPool
    };

    var user = new AWSCognito.CognitoUser(userData);
    user.confirmRegistration(req.body.code, true, function(err, result) {
        if (err) {
            debug("confirm failed : " + err);
            res.render('compareYourself/error', {
                title : 'Confirm Error',
                message : err
            });
        } else {
            debug("user confirmation successful : " + result);
            res.redirect('/auth/signin');
        }
    });
}

function signinForm(req, res) {
    res.render('auth/signin', {
        title : "Sign In"
    });
}
function signin(req, res) {
    debug(req.body);

    var authenticationData = {
        Username : req.body.username,
        Password : req.body.password
    };
    var authenticationDetails = new AWSCognito.AuthenticationDetails(authenticationData);

    var userData = {
        Username : req.body.username,
        Pool : userPool
    };

    cognitoUser = new AWSCognito.CognitoUser(userData);

    cognitoUser.authenticateUser(authenticationDetails, {
        onSuccess: function (result) {
            debug('Auth Token :');
            console.dir(result.getAccessToken());

            debug('Auth JWT token :');
            console.dir(jwt.decode(result.getAccessToken().getJwtToken()));

            cognitoToken = result.getAccessToken();

            res.redirect('/compare');
        },

        onFailure: function(err) {
            debug("authentication failed : " + err);
            res.render('compareYourself/error', {
                title : 'Authentication Error',
                message : err
            });
        }
    });
}

function signupForm(req, res) {
    res.render('auth/signup', {
        title : "Sign Up"
    });
}
function signup(req, res) {
    debug(req.body);

    var dataEmail = {
        Name : 'email',
        Value : req.body.email
    };

    var dataName = {
        Name : 'name',
        Value : req.body.name
    };

    var attributeList = [];
    attributeList.push(new AWSCognito.CognitoUserAttribute(dataEmail));
    attributeList.push(new AWSCognito.CognitoUserAttribute(dataName));

    userPool.signUp(req.body.username, req.body.password, attributeList, null, function(err, result){
        if (err) {
            debug('signup failed : ' + err);
            res.render('compareYourself/error', {
                title : 'SignUp Error',
                message : err
            });
        } else {
            debug('signup successful');
            res.redirect('/compare')
        }
    });
}

module.exports = {
    route : function(router) {
        router.get('/auth/signup', signupForm);
        router.post('/auth/signup', signup);

        router.get('/auth/signin', signinForm);
        router.post('/auth/signin', signin);

        router.get('/auth/confirm', confirmForm);
        router.post('/auth/confirm', confirm);

        router.get('/auth/signout', signout);
    },

    executeWithToken : function(callback) {
        if(cognitoUser) {
            cognitoUser.getSession(function(err, session) {
                var idToken = session.getIdToken();
                debug('ID Token :');
                console.dir(idToken);


                var jwtToken = idToken.getJwtToken();
                debug('ID JWT Token : ');
                console.dir(jwt.decode(jwtToken));
                callback(jwtToken);
            });
        } else {
            debug('no user');
        }
    }
};