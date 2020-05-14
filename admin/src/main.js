import Vue from 'vue'
import App from './app.vue'
import route from './router'

Vue.config.productionTip = false;

new Vue({
  route,
  render: h => h(App),
}).$mount('#app')
