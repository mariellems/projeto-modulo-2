export default class ListController {

    constructor(ServicoService) {
        this.cols = [{
            label: 'Descrição',
            value: 'descricao'
        },{
            label: 'Preço',
            value: 'preco'
        }];

        this.records = [];

        ServicoService.getAll()
            .then(records => {
                this.records = records;
            }).catch(erro => {
                console.log(erro);
            });
    }
}

ListController.$inject = ['ServicoService']