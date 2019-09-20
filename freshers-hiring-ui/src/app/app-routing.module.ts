import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './_components/home/home.component';
import { FreshersInfoComponent } from './_components/freshers-info/freshers-info.component';

const routes: Routes = [
  //{path: '', component: HomeComponent},
  {path: '', component: FreshersInfoComponent},
  {path: 'freshers-hiring', component: FreshersInfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
