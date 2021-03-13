import axios from "axios";
import { StringKeyObject } from "@/common/TypeDefs.ts";

// read
export async function get(url: string, param?: StringKeyObject) {
  try {
    return (await axios.get(url, param ? { params: param } : {})).data;
  } catch (e) {
    return new Error(e.status);
  }
}

// create
export async function post(url: string, param: StringKeyObject) {
  try {
    return (await axios.post(url, param)).data;
  } catch (e) {
    return new Error(e.status);
  }
}

// update
export async function put(
  url: string,
  key: number | string,
  param: StringKeyObject
) {
  try {
    return (await axios.put(`${url}/${key}`, param)).data;
  } catch (e) {
    return new Error(e.status);
  }
}

// delete
export async function del(url: string, key: number | string) {
  try {
    return (await axios.delete(`${url}/${key}`)).data;
  } catch (e) {
    return new Error(e.status);
  }
}
