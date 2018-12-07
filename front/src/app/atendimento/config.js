import ListController from './list.controller'
import FormController from './form.controller'
import AtendimentoService from './service';


export const atendimentoConfig = (modulo) => {

  modulo
    .service('AtendimentoService', AtendimentoService);

    atendimentoConfig.$inject = ['$stateProvider', '$urlRouterProvider'];

    function atendimentoConfig ($stateProvider) {
      $stateProvider
        .state('app.atendimento', {
          template: require('@views/default.html'),
          url: 'atendimento',
          redirectTo:'app.atendimento.list'
        })
        .state('app.atendimento.list', {
          template: require('@views/atendimento/list.html'),
          url: '/list',
          controller: ListController,
          controllerAs: 'vm'
        })
        .state('app.atendimento.new', {
          template: require('@views/atendimento/form.html'),
          url: '/new',
          controller: FormController,
          controllerAs: 'vm'
        })
        .state('app.atendimento.edit', {
          template: require('@views/atendimento/form.html'),
          url: '/{id}',
          controller: FormController,
          controllerAs: 'vm'
        });
    };
    return atendimentoConfig;

  };