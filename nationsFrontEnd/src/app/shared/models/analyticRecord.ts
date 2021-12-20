export class AnalyticRecord {

  constructor(private _continentName?: string,
              private _regionName?: string,
              private _countryName?: string,
              private _year?: number,
              private _gdp?: number,
              private _population?: number) {
  }


  get continentName(): string {
    return this._continentName;
  }

  set continentName(value: string) {
    this._continentName = value;
  }

  get regionName(): string {
    return this._regionName;
  }

  set regionName(value: string) {
    this._regionName = value;
  }

  get countryName(): string {
    return this._countryName;
  }

  set countryName(value: string) {
    this._countryName = value;
  }

  get year(): number {
    return this._year;
  }

  set year(value: number) {
    this._year = value;
  }

  get gdp(): number {
    return this._gdp;
  }

  set gdp(value: number) {
    this._gdp = value;
  }

  get population(): number {
    return this._population;
  }

  set population(value: number) {
    this._population = value;
  }
}
