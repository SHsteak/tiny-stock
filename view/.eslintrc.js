module.exports = {
  "env": {
    "browser": true,
    "es6": true,
    "node": true
  },
  "extends": [
    "eslint:recommended",
    "plugin:vue/essential",
    "plugin:@typescript-eslint/eslint-recommended"
  ],
  "globals": {
    "Atomics": "readonly",
    "SharedArrayBuffer": "readonly"
  },
  "parserOptions": {
    "ecmaVersion": 2018,
    "parser": "@typescript-eslint/parser",
    "sourceType": "module"
  },
  "plugins": [
     "vue",
     "@typescript-eslint"
  ],
  "rules": {
    "arrow-spacing": "warn",
    "indent": ["error", 2],
    "keyword-spacing": "warn",
    "linebreak-style": ["error", "windows"],
    // type definition 목적으로 사용하는 타입 변수를 error로 잡아서 off 처리.
    // 참고: https://github.com/typescript-eslint/typescript-eslint/blob/master/packages/eslint-plugin/docs/rules/no-unused-vars.md
    "no-unused-vars": "off",
    "@typescript-eslint/no-unused-vars": "error",
    "object-curly-spacing": ["warn", "always"],
    "quotes": ["warn", "double"],
    "semi": ["warn", "always"],
    "space-before-function-paren": ["warn", "never"]
  }
};
