import Pokemon from "./Pokemon";

export  default  class Generation {
    private _id:number;
    private _region:string;
    private _pokemonList:Pokemon[];
    constructor(
        id:number,
        region:string,
        pokemonList:Pokemon[],
    ) {
        this._id = id;
        this._region = region;
        this._pokemonList = pokemonList;
    }


    get id(): number {
        return this._id;
    }

    set id(value: number) {
        this._id = value;
    }

    get region(): string {
        return this._region;
    }

    set region(value: string) {
        this._region = value;
    }

    get pokemonList(): Pokemon[] {
        return this._pokemonList;
    }

    set pokemonList(value: Pokemon[]) {
        this._pokemonList = value;
    }
}