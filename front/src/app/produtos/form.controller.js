export default class FormController {

    constructor(ProdutoService, $stateParams, $state) {
        this.service = ProdutoService;
        this.$state = $state;
        if ($stateParams.id) {
            this.service.getOne($stateParams.id)
                .then(registro => {
                    this.record = registro;
                }).catch(console.error);
        }
    }

    save() {
        this.service.save(this.record)
            .then(() => {
                this.$state.go('app.produtos.list')
            }).catch(console.error);
    }
}

FormController.$inject = [
    'ProdutoService', 
    '$stateParams',
    '$state'
];
