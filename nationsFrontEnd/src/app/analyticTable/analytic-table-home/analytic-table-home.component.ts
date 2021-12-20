import {Component, OnDestroy, OnInit} from '@angular/core';
import {AnalyticTableService} from "../services/analytic-table.service";
import {Subscription} from "rxjs";
import {AnalyticRecord} from "../../shared/models/analyticRecord";
import {map} from "rxjs/operators";
import {RegionService} from "../services/region.service";
import {Region} from "../../shared/models/Region";

@Component({
  selector: 'app-analytic-table-home',
  templateUrl: './analytic-table-home.component.html',
  styleUrls: ['./analytic-table-home.component.css']
})
export class AnalyticTableHomeComponent implements OnInit, OnDestroy {

  analyticRecords: AnalyticRecord[];
  filteredAnalyticRecords: AnalyticRecord[] = [];
  regions: Region[];
  analyticTableServiceSubscription: Subscription;
  regionServiceSubscription: Subscription;
  yearFrom = 1900;
  yearTo: number = new Date().getFullYear();
  regionFilter: Region = null;

  constructor(private analyticTableService: AnalyticTableService,
              private regionService: RegionService) {
    this.fetchRegions();
    this.fetchTableData();
  }

  fetchRegions = () => {
    this.regionServiceSubscription = this.regionService.getAll()
      .pipe(
        map(actions =>
          actions.map(action => {
              return action as Region;
            }
          )))
      .subscribe(regions => this.regions = regions);
  }

  fetchTableData = () => {
    this.analyticTableServiceSubscription = this.analyticTableService.getAnalyticRecords()
      .pipe(
        map(actions =>
          actions.map(action => {
              return action as AnalyticRecord;
            }
          )))
      .subscribe(analyticRecords => this.analyticRecords = this.filteredAnalyticRecords = analyticRecords);
  }

  filter = () => {
    console.log(this.regionFilter);
    console.log(this.yearFrom);
    console.log(this.yearTo);
    if (this.regionFilter){
      this.filteredAnalyticRecords = this.analyticRecords.filter( record =>
        (record.regionName === this.regionFilter.name &&
          record.year >= this.yearFrom &&
          record.year <= this.yearTo)
      );
    }else{
      this.filteredAnalyticRecords =
        this.analyticRecords.filter( record =>
          (record.year >= this.yearFrom &&
            record.year <= this.yearTo));
    }
  }

  // filterResultsByRegion = (regionId: number) => {
  //   if (regionId == -1){
  //     this.filteredAnalyticRecords = this.analyticRecords;
  //     this.regionFilter = null;
  //     this.filterResultsByDate();
  //   }else{
  //     this.regionFilter = this.regions.find(r => r.regionId == regionId);
  //     this.filteredAnalyticRecords = this.analyticRecords.filter( record => record.regionName === this.regionFilter.name);
  //     this.filterResultsByDate();
  //   }
  // }

  filterResultsByDate = () => {
    // if (this.regionFilter){
    //   this.filteredAnalyticRecords =
    //     this.filteredAnalyticRecords.filter( record =>
    //       (record.year >= this.yearFrom &&
    //         record.year <= this.yearTo));
    // } else {
    // this.filteredAnalyticRecords =
    //   this.analyticRecords.filter( record =>
    //     (record.year >= this.yearFrom &&
    //       record.year <= this.yearTo));
    // }
  }


  ngOnInit(): void {
    // this.yearFrom = 1900;
    // this.yearTo = new Date().getFullYear();
  }

  ngOnDestroy(): void {
    this.analyticTableServiceSubscription.unsubscribe();
    this.regionServiceSubscription.unsubscribe();
  }
}
