import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { SkeletonModule } from 'primeng/skeleton';
import { AvatarModule } from 'primeng/avatar';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { BadgeModule } from 'primeng/badge';
import { OverlayBadgeModule } from 'primeng/overlaybadge';
@NgModule({
  declarations: [],
  exports: [
    CommonModule,
    TableModule,
    SkeletonModule,
    AvatarModule,
    ButtonModule,
    CardModule,
    BadgeModule,
    OverlayBadgeModule
  ]
})
export class PrimeComponentsModule { }
