export class Language{

  constructor(private _languageId?: number,
              private _language?: string) {
  }

  get languageId(): number {
    return this._languageId;
  }

  set languageId(value: number) {
    this._languageId = value;
  }

  get language(): string {
    return this._language;
  }

  set language(value: string) {
    this._language = value;
  }
}
