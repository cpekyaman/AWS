/**
 * Created by raistlin on 9/21/2017.
 */
function signinForm(req, res) {
    res.render('auth/signin', {
        title : "Sign In"
    });
}

function signin(req, res) {

}

function signupForm(req, res) {
    res.render('auth/signup', {
        title : "Sign Up"
    });
}
function signup(req, res) {

}

module.exports = function(router) {
    router.get('/auth/signup', signupForm);
    router.post('/auth/signup', signup);

    router.get('/auth/signin', signinForm);
    router.post('/auth/signin', signin);
};