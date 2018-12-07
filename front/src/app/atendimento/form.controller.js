export default class FormController {

    constructor(AtendimentoService, $stateParams, $state) {
        this.service = AtendimentoService;
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
                this.$state.go('app.atendimento.list')
            }).catch(console.error);
    }
}

FormController.$inject = [
    'AtendimentoService', 
    '$stateParams',
    '$state'
];
