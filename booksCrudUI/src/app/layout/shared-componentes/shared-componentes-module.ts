import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';


@NgModule({
  exports: [
    CommonModule,ButtonModule
  ]
})
export class SharedComponentesModule { }
