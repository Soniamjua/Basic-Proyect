import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit {
  races: any[] = [];
  constructor(private appService: AppService) {}

  ngOnInit(): void {
    // GlobalRanking
    this.appService
      .getGlobalRanking()
      .subscribe((data: any) => (this.races = data));
  }
}
