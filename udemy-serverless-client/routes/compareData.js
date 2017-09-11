var request = require('request');

var api = {
    fetchUrl : 'https://stu4e8uoh2.execute-api.us-east-2.amazonaws.com/dev/compare-yourself'
};

function fetchCompareData(req, res) {
    request(api.fetchUrl, function(error, response, body) {
        res.render('compare', JSON.parse(body));
    });
}

module.exports = function(router) {
    router.get('/compare', fetchCompareData);
};