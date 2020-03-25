import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router,ActivatedRoute } from '@angular/router';
import { ProductInfo } from "./../product-info";
import { LoginService } from "./../login.service";
import { ProductInfoComponent } from './../product-info/product-info.component';

@Component({
  selector: 'app-product-list-admin',
  templateUrl: './product-list-admin.component.html',
  styleUrls: ['./product-list-admin.component.css']
})
export class ProductListAdminComponent implements OnInit {

 
  id:number;

	product: Observable<ProductInfo[]>;

  constructor(private route:ActivatedRoute,private loginService: LoginService,
  	private router: Router) { }

  ngOnInit(){
    this.reloadData();
  }
     reloadData(){
    this.product=this.loginService.getProduct();
  } 

  updateProduct(id:number, product:Object){
    this.router.navigate(['update',id]);
  }
  productDetails(id:number){
    this.router.navigate(['details',id]);
  }

  addProduct(){
    this.router.navigate(['add']);
  }
}


    
  
