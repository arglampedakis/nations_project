import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {LanguageService} from "../services/language.service";
import {Language} from "../../shared/models/Language";
import {Subscription} from "rxjs";
import {map} from "rxjs/operators";
import {CountryService} from "../../country/services/country.service";
import {Country} from "../../shared/models/country";

@Component({
  selector: 'app-language-home',
  templateUrl: './language-home.component.html',
  styleUrls: ['./language-home.component.css']
})
export class LanguageHomeComponent implements OnInit, OnDestroy {

  countryId: number;
  country: Country = new Country();
  languages: Language[];
  subscription: Subscription;
  subscription2: Subscription;

  constructor(private languageService: LanguageService,
              private countryService: CountryService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.countryId = +this.route.snapshot.paramMap.get('id');
    if (this.countryId){
      this.fetchTableData(this.countryId);
      this.fetchCountry(this.countryId);
    }
  }

  fetchCountry = (countryId: number) => {
    if (this.subscription2) {
      this.subscription2.unsubscribe();
    }
    this.subscription2 = this.countryService.getByCountryId(countryId)
      .pipe(
        map(action => {
            return action as Country;
            }
          ))
      .subscribe(country => this.country = country);
  }

  fetchTableData = (countryId: number) => {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }

    this.subscription = this.languageService.getByCountryId(countryId)
      .pipe(
        map(actions =>
          actions.map(action => {
            return action as Language;
            }
          )))
      .subscribe(languages => this.languages = languages);
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
    this.subscription2.unsubscribe();
  }

}
