import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {AnalyticRecord} from "../../shared/models/analyticRecord";
import {catchError} from "rxjs/operators";
import {BadInput} from "../../shared/errors/bad-input";
import {NotFoundError} from "../../shared/errors/not-found-error";
import {AppError} from "../../shared/errors/app-error";
import {Region} from "../../shared/models/Region";

@Injectable({
  providedIn: 'root'
})
export class RegionService {

  private readonly baseUrl = "http://localhost:8080/api/v1/region/";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Region[]>{
    return this.http.get<Region[]>(this.baseUrl).pipe(
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
