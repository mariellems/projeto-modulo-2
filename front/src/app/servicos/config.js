import ListController from './list.controller'
import FormController from './form.controller'
import ServicoService from './service';


export const servicoConfig = (modulo) => {

  modulo
    .service('ServicoService', ServicoService);

    servicoConfig.$inject = ['$stateProvider', '$urlRouterProvider'];

    function servicoConfig ($stateProvider) {
      $stateProvider
        .state('app.servicos', {
          template: require('@views/default.html'),
          url: 'servicos',
          redirectTo:'app.servicos.list'
        })
        .state('app.servicos.list', {
          template: require('@views/servicos/list.html'),
          url: '/list',
          controller: ListController,
          controllerAs: 'vm'
        })
        .state('app.servicos.new', {
          template: require('@views/servicos/form.html'),
          url: '/new',
          controller: FormController,
          controllerAs: 'vm'
        })
        .state('app.servicos.edit', {
          template: require('@views/servicos/form.html'),
          url: '/{id}',
          controller: FormController,
          controllerAs: 'vm'
        });
    };
    return servicoConfig;

  };