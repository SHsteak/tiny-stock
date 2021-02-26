import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import PageUrls from "@/common/PageUrls.ts";
import * as User from "@/common/User";

const routes: Array<RouteRecordRaw> = [
  {
    path: PageUrls.HOME,
    name: "Home",
    component: () => import("@/views/Home.vue")
  },
  {
    path: PageUrls.LOGIN,
    name: "Login",
    component: () => import("@/views/Login.vue"),
    meta: { beforeAuth: true }
  },
  {
    path: PageUrls.ABOUT,
    name: "About",
    component: () => import("@/views/About.vue")
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

router.beforeEach((to, from, next) => {
  console.log(to);
  console.log(from);
  if (! User.loggedIn() && ! to.meta.beforeAuth)
    next({ path: PageUrls.LOGIN });
  // else if (User.loggedIn() && 로그인으로 가려고 하면)
  //     next({ path: "/" });
  else
    next();
});

export default router;
