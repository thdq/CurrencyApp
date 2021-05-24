import { createApp } from 'vue'
import App from './App.vue'
import PrimveVue from 'primevue/config'
import './index.css'

const app = createApp(App)
app.use(PrimveVue)

app.mount('#app')


