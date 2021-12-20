import { Injectable } from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {Country} from "../../shared/models/country";
import {catchError} from "rxjs/operators";
import {BadInput} from "../../shared/errors/bad-input";
import {NotFoundError} from "../../shared/errors/not-found-error";
import {AppError} from "../../shared/errors/app-error";
import {CountryStats} from "../../shared/models/CountryStats";

@Injectable({
  providedIn: "root"
})
export class CountryService {

  private readonly url = "http://localhost:8080/api/v1/country/";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Country[]>{
    return this.http.get<Country[]>(this.url).pipe(
      catchError(this.handleError)
    );
  }


  getByCountryId(countryId: number): Observable<Country>{
  return this.http.get<Country>(this.url + countryId).pipe(
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
