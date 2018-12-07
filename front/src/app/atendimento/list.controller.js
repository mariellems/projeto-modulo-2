export default class ListController {

    constructor(AtendimentoService) {
        this.cols = [{
            label: 'Nome',
            value: 'nome'
        },{
            label: 'Telefone',
            value: 'telefone'
        },{
            label: 'Data',
            value: 'data'
        },{
            label: 'Serviço',
            value: 'servico'
        },{
            label: 'Produto',
            value: 'produto'
        },{
            label: 'Valor Total',
            value: 'valorTotal'
        },{
            label: 'Cliente pagou',
            value: 'opcao'
        }];

        this.records = [];

        AtendimentoService.getAll()
            .then(records => {
                this.records = records;
            }).catch(erro => {
                console.log(erro);
            });
    }
}

ListController.$inject = ['AtendimentoService']