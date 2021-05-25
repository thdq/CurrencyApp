import { createApp } from 'vue'
import App from './App.vue'
import PrimveVue from 'primevue/config'
import './index.css'
import 'primevue/resources/themes/saga-blue/theme.css'
import 'primevue/resources/primevue.min.css'
import 'primeicons/primeicons.css'

const app = createApp(App)

app.use(PrimveVue)

app.mount('#app')


