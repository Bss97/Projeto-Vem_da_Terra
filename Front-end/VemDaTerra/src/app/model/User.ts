import {Produto} from "./Produto"
export class User{
    public id: number
    public nome: string
    public email: string
    public senha: string
    public tipo: string
    public produto: Produto[] 
}