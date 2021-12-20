import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {CountryStats} from "../../shared/models/CountryStats";
import {catchError} from "rxjs/operators";
import {BadInput} from "../../shared/errors/bad-input";
import {NotFoundError} from "../../shared/errors/not-found-error";
import {AppError} from "../../shared/errors/app-error";

@Injectable({
  providedIn: 'root'
})
export class CountryStatsService {

  private readonly url = "http://localhost:8080/api/v1/countryStats/";

  constructor(private http: HttpClient) { }

  getCountryStats(): Observable<CountryStats[]>{
    return this.http.get<CountryStats[]>(this.url).pipe(
      catchError(this.handleError)
    );
  }

  private handleError = (error: Response) => {
    if (error.status === 400) {
      return throwError(new BadInput(error));
    }
    if (error.status === 404) {
      return throwError(new NotFoundError());
    }

    return throwError(new AppError(error));
  }
}
