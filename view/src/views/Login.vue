<template>
  <div class="tn-login-app">
    로그인 페이지
<!--    <BForm @submit.prevent="onSubmit">-->
<!--      <BFormGroup-->
<!--        label="ID: "-->
<!--        label-for="id"-->
<!--      >-->
<!--        <BFormInput-->
<!--          id="id"-->
<!--          v-model="formInput.id"-->
<!--          required-->
<!--          autocomplete="username"-->
<!--          autofocus-->
<!--        />-->
<!--      </BFormGroup>-->
<!--      <BFormGroup-->
<!--        label="비밀번호: "-->
<!--        label-for="password"-->
<!--      >-->
<!--        <BFormInput-->
<!--          id="password"-->
<!--          v-model="formInput.password"-->
<!--          required-->
<!--          autocomplete="current-password"-->
<!--        />-->
<!--      </BFormGroup>-->
<!--      <BButton type="submit">로그인</BButton>-->
<!--    </BForm>-->
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import PageUrls from "@/common/PageUrls.ts";
import * as User from "@/common/User";

interface LoginForm {
  id: string;
  password: string;
}

export default defineComponent({
  name: "LoginApp",
  data() {
    return {
      formInput: {
        id: "" as string,
        password: "" as string
      } as LoginForm
    };
  },
  methods: {
    onSubmit(): void {
      const { id, password } = this.formInput;
      User.setUser(id, password);
      if (User.loggedIn())
        window.location.href = PageUrls.HOME;

    }
  }
});

</script>

<style>

</style>
