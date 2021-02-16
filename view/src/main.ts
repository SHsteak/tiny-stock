import { createApp } from 'vue'
import App from '@/App.vue'
import router from '@/router'

// TS2345 에러. vue가 만들어준대로 일단 사용하기 위해 ignore.
// @ts-ignore
createApp(App).use(router).mount('#app')
