export default class ServicoService {

    constructor($http, BASE_URL) {
        this.$http = $http;
        this.baseUrl = `${BASE_URL}/servicos`;
    }

    getAll() {
        return this.$http.get(this.baseUrl)
            .then(response => response.data);
    }

    getOne(id) {
        return this.$http.get(`${this.baseUrl}/${id}`)
            .then(response => response.data);
    }

    save(data) {
        if (data.id) {
            return this.$http.put(`${this.baseUrl}/${data.id}`, data)
                .then(response => response.data);
        } else {
            return this.$http.post(this.baseUrl, data)
                .then(response => response.data);
        }
    }

    remove(id) {
        return this.$http.delete(`${this.baseUrl}/${id}`);
    }

}

ServicoService.$inject = ['$http', 'BASE_URL'];
