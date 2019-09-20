import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FresherInfo } from '../_models/fresher-info';

@Injectable({
  providedIn: 'root'
})
export class FresherInfoService {

  constructor(private http: HttpClient) { }

  submitFresherDetails(file: File, fresher: FresherInfo){
      const formData : FormData = new FormData();
      formData.append("file", file);
      formData.append("fresherDetails", new Blob([JSON.stringify(fresher)],{type: "application/json"}));

      return this.http.post('/career/fresher', formData, fresher);
    // return this.http.post('http://localhost:8081/career/fresher', formData, fresher);
  }
  getConfigurations(){
   // return this.http.get('http://localhost:8081/career/configurations');
   return this.http.get('/career/configurations');
  }
}
