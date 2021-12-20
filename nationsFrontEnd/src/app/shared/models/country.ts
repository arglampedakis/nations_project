export class Country{

  constructor(private _countryId?: number,
              private _name?: string,
              private _area?: number,
              private _nationalDay?: Date,
              private _countryCode2?: string,
              private _countryCode3?: string,
              private _regionId?: number) {
  }


  get countryId(): number {
    return this._countryId;
  }

  set countryId(value: number) {
    this._countryId = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get area(): number {
    return this._area;
  }

  set area(value: number) {
    this._area = value;
  }

  get nationalDay(): Date {
    return this._nationalDay;
  }

  set nationalDay(value: Date) {
    this._nationalDay = value;
  }

  get countryCode2(): string {
    return this._countryCode2;
  }

  set countryCode2(value: string) {
    this._countryCode2 = value;
  }

  get countryCode3(): string {
    return this._countryCode3;
  }

  set countryCode3(value: string) {
    this._countryCode3 = value;
  }

  get regionId(): number {
    return this._regionId;
  }

  set regionId(value: number) {
    this._regionId = value;
  }
}
