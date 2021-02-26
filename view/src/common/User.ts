// test
interface User {
  id: string;
  password: string;
}

let user: User;

export function setUser(id: string, password: string) {
  user = { id, password };
}

export function getUser() : User {
  return user || {};
}

export function loggedIn(): boolean {
  const _user = getUser();
  return _user.id !== undefined && _user.password !== undefined;
}
