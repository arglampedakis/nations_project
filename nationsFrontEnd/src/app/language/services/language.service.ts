import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {catchError} from "rxjs/operators";
import {BadInput} from "../../shared/errors/bad-input";
import {NotFoundError} from "../../shared/errors/not-found-error";
import {AppError} from "../../shared/errors/app-error";
import {Language} from "../../shared/models/Language";

@Injectable({
  providedIn: 'root'
})
export class LanguageService {

  private readonly baseUrl = "http://localhost:8080/api/v1/language/";

  constructor(private http: HttpClient) { }

  getByCountryId(countryId: number): Observable<Language[]>{
    return this.http.get<Language[]>(this.baseUrl + countryId).pipe(
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
