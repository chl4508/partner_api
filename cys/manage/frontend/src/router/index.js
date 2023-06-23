import { createRouter, createWebHistory } from 'vue-router'
import Test from '@/views/Test.vue'
//import BoardList from '@/views/board/BoardList.vue'

const routes = [
  {
    path: '/test',
    name: 'test',
    component: Test
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router