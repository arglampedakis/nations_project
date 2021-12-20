export class Region {

  constructor(private _regionId?: number,
              private _name?: string) {
  }


  get regionId(): number {
    return this._regionId;
  }

  set regionId(value: number) {
    this._regionId = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }
}
