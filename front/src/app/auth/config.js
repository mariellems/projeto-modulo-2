export const authConfig = ($httpProvider) => {
    $httpProvider.interceptors.push(['$q', '$state', function($q, $state) {
        return {
            request(config) {
                let token = sessionStorage.getItem('token');
                if (token)
                    config.headers['Authorization'] = `Bearer ${token}`;
                return config;
            }, 
            responseError(error) {
                if (error.status === 401 || error.status === 403) {
                    $state.go('login');
                }
                return $q.reject(error);
            }
        }
    }]);
};

authConfig.$inject = ['$httpProvider'];
