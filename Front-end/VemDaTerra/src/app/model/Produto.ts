import {Categoria} from "./Categoria"

export class Produto{
    public id: number
    public nome: string
    public descricao: string
    public preco: number
    public codigo: number
    public categoria: Categoria[]

}