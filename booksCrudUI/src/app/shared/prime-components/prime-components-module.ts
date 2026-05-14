import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { SkeletonModule } from 'primeng/skeleton';
import { AvatarModule } from 'primeng/avatar';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
@NgModule({
  declarations: [],
  exports: [
    CommonModule,
    TableModule,
    SkeletonModule,
    AvatarModule,
    ButtonModule,
    CardModule
  ]
})
export class PrimeComponentsModule { }
