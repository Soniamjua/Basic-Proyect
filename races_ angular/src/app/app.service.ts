import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Driver } from './driver';

const API_BASE = 'http://localhost:8080';

@Injectable({
  providedIn: 'root',
})
export class AppService {
  constructor(private http: HttpClient) {}

  getGlobalRanking() {
    return this.http.get(`${API_BASE}/ranking`);
  }

  getDriverById(id: string): Observable<any> {
    return this.http.get(` ${API_BASE}/driver/${id} `);
  }
}
