import ListController from './list.controller'
import FormController from './form.controller'
import ProdutoService from './service';


export const produtoConfig = (modulo) => {

  modulo
    .service('ProdutoService', ProdutoService);

    produtoConfig.$inject = ['$stateProvider', '$urlRouterProvider'];

    function produtoConfig ($stateProvider) {
      $stateProvider
        .state('app.produtos', {
          template: require('@views/default.html'),
          url: 'produtos',
          redirectTo:'app.produtos.list'
        })
        .state('app.produtos.list', {
          template: require('@views/produtos/list.html'),
          url: '/list',
          controller: ListController,
          controllerAs: 'vm'
        })
        .state('app.produtos.new', {
          template: require('@views/produtos/form.html'),
          url: '/new',
          controller: FormController,
          controllerAs: 'vm'
        })
        .state('app.produtos.edit', {
          template: require('@views/produtos/form.html'),
          url: '/{id}',
          controller: FormController,
          controllerAs: 'vm'
        });
    };
    return produtoConfig;

  };