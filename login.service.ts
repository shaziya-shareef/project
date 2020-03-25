import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
private baseUrl='http://localhost:8080/Customer';
private baseUrl1= 'http://localhost:8080/product';

  constructor(private http: HttpClient, private _httpService: LoginService) { }

  getCustomer(username:string):Observable<any>{
  	return this.http.get(`${this.baseUrl}/${username}`);
  }

  createCustomer(customer: Object): Observable<Object>{
  	return this.http.post('http://localhost:8080/post/customer', customer);
  }

  updateCustomer(id:number, value:any):Observable<Object>{
  	return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deletecustomer(id:number):Observable<any>{
  	return this.http.delete(`${this.baseUrl}/${id}`,{responseType:'text'});
  }

  loginValidation(username:string, password:string, value:any):Observable<any>{
  	return this.http.post(`${this.baseUrl}/${username}/${password}`,value);
  }

  getDetails(email:string, password:string){
  	return this.http.get('http://localhost:8080/Customer/'+email+'/'+password);
  }

  getProduct():Observable<any>{
    return this.http.get('http://localhost:8080/product');
  }

  getProductUpdate(id:number):Observable<any>{
    return this.http.get('http://localhost:8080/product/${id}');
  }

   updateProduct(id:number, value:any):Observable<Object>{
    return this.http.put(`${this.baseUrl1}/${id}`,value);
  }

  deleteProduct(id:number):Observable<any>{
    return this.http.delete(`${this.baseUrl1}/${id}`,{responseType:'text'});
  }

  createProduct(product: Object): Observable<Object>{
    return this.http.post('http://localhost:8080/productadd', product);
  }
  productDetails(id:number):Observable<any>{
    return this.http.get('http://localhost:8080/details/${id}');
  }
} 
