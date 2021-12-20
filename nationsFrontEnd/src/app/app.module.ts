import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import {RouterModule} from "@angular/router";
import {DataTablesModule} from 'angular-datatables';
import {HttpClientModule} from "@angular/common/http";
import { AppComponent } from './app.component';
import { CountryHomeComponent } from './country/country-home/country-home.component';
import {CountryService} from "./country/services/country.service";
import {AppErrorHandler} from "./shared/errors/app-error-handler";
import { NavbarComponent } from './core/navbar/navbar.component';
import { FooterComponent } from './core/footer/footer.component';
import { HomeComponent } from './core/home/home.component';
import { LanguageHomeComponent } from './language/language-home/language-home.component';
import { CountryStatsComponent } from './country/country-stats/country-stats.component';
import { AnalyticTableHomeComponent } from './analyticTable/analytic-table-home/analytic-table-home.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    CountryHomeComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    LanguageHomeComponent,
    CountryStatsComponent,
    AnalyticTableHomeComponent
  ],
    imports: [
        BrowserModule,
        DataTablesModule,
        HttpClientModule,
        RouterModule.forRoot([
            {path: '', component: HomeComponent},
            {path: 'country', component: CountryHomeComponent},
            {path: 'country/stats', component: CountryStatsComponent},
            {path: 'language/:id', component: LanguageHomeComponent},
            {path: 'analyticTable', component: AnalyticTableHomeComponent}
        ]),
        FormsModule
    ],
  providers: [
    CountryService,
    {provide: ErrorHandler, useClass: AppErrorHandler}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
