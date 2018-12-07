export default class LoginController {

    constructor($state, $http, BASE_URL) {
        this.$state = $state;
        this.$http = $http;
        this.baseUrl = `${BASE_URL}/auth`;
    }

    login() {
        this.$http.post(`${this.baseUrl}/login`, {
            email: this.email,
            senha: this.senha
        })
        .then((response) => response.data)
        .then((data) => {
            sessionStorage.setItem('token', data.token);
            this.$state.go('app')
        })
        .catch((error) => {
            console.log(error);
        });
    }

}

LoginController.$inject = ['$state', '$http', 'BASE_URL']
