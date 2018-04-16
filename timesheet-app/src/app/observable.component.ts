import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';
import {Book} from './book'

@Component({
   selector: 'app-observable',
   templateUrl: './observable.component.html'
})
export class ObservableComponent implements OnInit { 

    constructor(private http: Http) {}

    books: Book[];

    ngOnInit(){
        // this.http.get
        console.log('Observable component initialized')

        this.http.get('http://localhost:8080/timesheet-tracker/api/books')
		        .map((this.extractData))
                .catch(this.handleErrorObservable)
                .subscribe(data => {
                    console.log(data);
                    this.books = data
                });
    }


    private extractData(res: Response) {
        let body = res.json();
        console.log(body)
        return body;
    }
    private handleErrorObservable (error: Response | any) {
		console.error(error.message || error);
		return Observable.throw(error.message || error);
    }
  
}
    

