import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DriverComponent } from './driver/driver.component';
import { TableComponent } from './table/table.component';

const routes: Routes = [
  { path: 'table', component: TableComponent },
  { path: 'driver/:id', component: DriverComponent },
  { path: '', pathMatch: 'full', redirectTo: 'table' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
