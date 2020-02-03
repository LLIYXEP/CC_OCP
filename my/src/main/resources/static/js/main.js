import Vue from 'vue'
import VueResource from 'vue-resource'
import App from '../pages/App.vue'
import { connect } from './util/ws'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import VueMaterial from 'vue-material'
import 'vue-material/dist/vue-material.css'


if (frontendData.profile) {
	connect()
}


Vue.use(VueResource)
Vue.use(Vuetify)
Vue.use(VueMaterial)


new Vue ({
	el: '#app',
	vuetify: new Vuetify(),
	render: a => a(App)
})
