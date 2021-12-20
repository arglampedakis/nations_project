import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {CountryStats} from "../../shared/models/CountryStats";
import {map} from "rxjs/operators";
import {CountryStatsService} from "../services/country-stats.service";

@Component({
  selector: 'app-country-stats',
  templateUrl: './country-stats.component.html',
  styleUrls: ['./country-stats.component.css']
})
export class CountryStatsComponent implements OnInit, OnDestroy {

  countryStatsList: CountryStats[] = [];
  subscription: Subscription;

  constructor(private countryStatsService: CountryStatsService) {
    this.fetchTableData();
  }

  ngOnInit(): void {
  }

  fetchTableData = () => {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }

    this.subscription = this.countryStatsService.getCountryStats()
      .pipe(
        map(actions =>
          actions.map(action => {
            return action as CountryStats;
            }
          )))
      .subscribe(countryStatsList => this.countryStatsList = countryStatsList);
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
