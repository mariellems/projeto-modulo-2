export default class ListController {

    constructor(ProdutoService) {
        this.cols = [{
            label: 'Descrição',
            value: 'descricao'
        },{
            label: 'Preço',
            value: 'preco'
        }];

        this.records = [];

        ProdutoService.getAll()
            .then(records => {
                this.records = records;
            }).catch(erro => {
                console.log(erro);
            });
    }
}

ListController.$inject = ['ProdutoService']