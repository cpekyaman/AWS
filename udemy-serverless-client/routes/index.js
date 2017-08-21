var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

var request = require('request');
router.get('/compare', function(req, res, next) {
    request('https://stu4e8uoh2.execute-api.us-east-2.amazonaws.com/dev/compare-yourself', function(error, response, body) {
        res.render('compare', JSON.parse(body));
    });
});

router.get('/assignment', function(req, res, next) {
    request('https://hjb1ovxamh.execute-api.us-east-2.amazonaws.com/dev/fetch-data', function(error, response, body) {
        res.render('assignmentFetch', JSON.parse(body));
    });
});
router.post('/assignment', function(req, res, next) {
    request.post({
        headers : {'Content-Type' : 'application/json'},
        url : 'https://hjb1ovxamh.execute-api.us-east-2.amazonaws.com/dev/store-data',
        form : {  },
        json : true
    }, function(error,response,body) {
        console.log(body);
        res.render('assignmentPost', body);
    })
});

module.exports = router;
