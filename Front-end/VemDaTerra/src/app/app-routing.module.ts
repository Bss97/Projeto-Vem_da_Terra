import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroCategoriaComponent } from './cadastro-categoria/cadastro-categoria.component';
import { CadastroProdutoComponent } from './cadastro-produto/cadastro-produto.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { CardProdutoComponent } from './card-produto/card-produto.component';
import { ContatoComponent } from './contato/contato.component';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './login/login.component';
import { SobreNosComponent } from './sobre-nos/sobre-nos.component';


const routes: Routes = [

  {path: '', redirectTo: 'inicio', pathMatch: 'full'},

  {path:'inicio', component: InicioComponent},
  {path:'sobre', component: SobreNosComponent},
  {path:'contato', component: ContatoComponent},
  {path:'login', component: LoginComponent},
  {path: 'cadastro', component: CadastroComponent},
  {path: 'cadastro/categoria', component: CadastroCategoriaComponent},
  {path: 'cadastro/produto', component: CadastroProdutoComponent},
  {path: 'produto', component: CardProdutoComponent}




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
