export class CountryStats{

  constructor(private _countryId?: number,
              private _year?: number,
              private _name?: string,
              private _countryCode3?: string,
              private _gdp?: number,
              private _population?: number) {
  }


  get countryId(): number {
    return this._countryId;
  }

  set countryId(value: number) {
    this._countryId = value;
  }

  get year(): number {
    return this._year;
  }

  set year(value: number) {
    this._year = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get countryCode3(): string {
    return this._countryCode3;
  }

  set countryCode3(value: string) {
    this._countryCode3 = value;
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
