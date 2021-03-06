export default class FormController {

    constructor(ServicoService, $stateParams, $state) {
        this.service = ServicoService;
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
                this.$state.go('app.servicos.list')
            }).catch(console.error);
    }
}

FormController.$inject = [
    'ServicoService', 
    '$stateParams',
    '$state'
];
