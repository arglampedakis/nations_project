import {Component, OnDestroy, OnInit} from '@angular/core';
import {Country} from "../../shared/models/country";
import {Subscription} from "rxjs";
import {CountryService} from "../services/country.service";
import {map} from "rxjs/operators";
import {Router} from "@angular/router";

@Component({
  selector: 'app-country-home',
  templateUrl: './country-home.component.html',
  styleUrls: ['./country-home.component.css']
})
export class CountryHomeComponent implements OnInit, OnDestroy {

  countries: Country[] = [];
  subscription: Subscription;

  constructor(private countryService: CountryService,
              private router: Router) {
    this.fetchTableData();
  }

  fetchTableData = () => {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }

    this.subscription = this.countryService.getAll()
      .pipe(
        map(actions =>
          actions.map(action => {
            return action as Country;
            }
          )))
      .subscribe(countries => this.countries = countries);
  }

  onRowClick = (countryId: number) => {
    this.router.navigate(['./language/' + countryId]);
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
