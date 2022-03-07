import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      redirect: 'login'
    },
    {
      path: '/index',
      name: 'Index',
      component: () => import('./views/Index.vue'),
      meta: { title: '首页' },
      redirect: '/home',
      children: [
        {
          path: '/home',
          name: 'home',
          component: () => import('./views/Home/Home'),
          meta: { title: '首页' }
        },
        {
          path: '/staff',
          name: 'staff',
          component: () => import('./views/Staff'),
          meta: { title: '后台用户信息列表' }
        },
        {
          path: '/userList',
          name: 'userList',
          component: () => import('./views/userList'),
          meta: { title: 'C端用户管理' }
        },
        {
          path: '/Infoshow',
          name: 'Infoshow',
          component: () => import('./views/InfoShow'),
          meta: { title: '个人信息' }
        },
          {
          path: '/slideshow',
          name: 'slideshow',
          component: () => import('./views/slideshow'),
          meta: { title: '广告管理' }
        },
        {
          path: '/newsList',
          name: 'newsList',
          component: () => import('./views/news/list'),
          meta: { title: '文章列表' }
        },
          {
          path: '/qrCodeList',
          name: 'qrCodeList',
          component: () => import('./views/qrcode/list'),
          meta: { title: '二维码列表' }
        },
          {
          path: '/noticeList',
          name: 'noticeList',
          component: () => import('./views/notice/list'),
          meta: { title: '二维码列表' }
        }
      ]
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('./views/register/Register')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('./views/logo/Login')
    },
    {
      path: '/lock',
      name: 'lock',
      component: () => import('./views/Lock.vue')
    },
    {
      path: '*',
      name: 'Nofind',
      component: () => import('./views/404')
    }
  ]
  // mode: "history"
})

// 路由守卫
router.beforeEach((to, from, next) => {
  const isLogin = !!localStorage.eleToken

  if (to.path === '/login' || to.path === '/register') {
    next()
  } else {
    isLogin ? next() : next('/login')
  }
})

export default router
