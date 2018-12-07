import angular from 'angular';

import { default as uiRouter } from '@uirouter/angularjs';
import diretivas from './diretivas';

import { mainConfig } from './main/config';
import { authConfig } from './auth/config';
import { atendimentoConfig } from './atendimento/config';
import { produtoConfig } from './produtos/config';
import { servicoConfig } from './servicos/config';

const modulo = angular
   .module('app', [uiRouter, diretivas]);

export default modulo
  .config(mainConfig)
  .config(authConfig)
  .config(atendimentoConfig(modulo))
  .config(produtoConfig(modulo))
  .config(servicoConfig(modulo))
  .constant('BASE_URL', 'http://localhost:8080/api')
  .name;
