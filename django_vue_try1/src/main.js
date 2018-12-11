import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router';
import App1 from './App1.vue';
import graph1 from './generate_graphs.vue';
import gr from './NewGraph'
import JsonViewer from './lib'
import jview from './JsonViewer';
import {store} from './store';


import Simple from './simple.vue'
import * as axios from '../node_modules/axios'

//import V from 'vue'

Vue.use(VueRouter);
Vue.use(JsonViewer);


const routes =[
  { path: '/selectfiles' ,component: App1},
  //{ path: '/' ,component: App}
  {path: '/gen_graph', component:gr},
  {path:'/jsonViewer',component:jview},




];

const routes1 =[
  // { path: '/selectfiles' ,component: App1},
  //{ path: '/' ,component: App}
  {path: '/gen_graph', component:graph1},






];

const route1 = new VueRouter(
  {
    routes1
  }
)


const router = new VueRouter({
  routes
});

new Vue({
  el: '#app',
  store,
  router,
  render: h => h(App)
})


new Vue({
  el: '#getfiles-app',
  store,
  route1,
  render: h => h(App1)
})

new Vue({
  el: '#jsonviewer-app',
  store,
  route1,
  render: h => h(jview)
})


 // new V({
 //   e2: '#app1',
 //   render: h => h(App1)
 // })
