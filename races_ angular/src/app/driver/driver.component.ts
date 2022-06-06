import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppService } from '../app.service';
import { Driver } from '../driver';

@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html',
  styleUrls: ['./driver.component.css'],
})
export class DriverComponent implements OnInit {
  drivers: any[] = [];
  constructor(private appService: AppService) {}

  ngOnInit(): void {
    //Driver by Id
  }
  getDriverById(id: string): void {
    this.appService.getDriverById(id).subscribe({
      next: (data: any) => {
        this.drivers = data;
        console.log(data);
      },
      error: (e) => console.error(e),
    });
  }
}
