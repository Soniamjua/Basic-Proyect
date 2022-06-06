export interface Driver {
  id?: String;
  picture?: String;
  age?: Number;
  name?: String;
  team?: String;
  races?: [
    {
      name?: String;
      time?: String;
    }
  ];
  position?: Number;
}
