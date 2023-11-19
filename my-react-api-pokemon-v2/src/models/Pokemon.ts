import Generation from "./Generation.ts";


export  default class Pokemon {
    //1. typage des propriété d'un pokémon
    private _id:number;
    private _pokedexId:number;
    private _generation:Generation;
    private _category:string;
    private _name: {en:string , fr:string , jp:string};
    private _sprites:{gmax: {shiny:string , regular:string} , shiny:string, regular:string};
    private _types:[{name:string,image:string}];
    private _stats: { hp:number,atk:number,def:number,vit:number ,spe_atk:number,spe_def:number };
    private _resistances:[{name:string , multiplier:number}];
    private _evolution:{pre:[{name:string , condition:string , pokedexId:number}] , mega : [{orbre:string , sprites: {shiny:string , regular:string}}] , next:[{name:string , condition:string, pokedexId:number}]};
    private _height:string;
    private _weight:string;
    private _eggGroups:object;
    private _sexe:{male:number, female:number};
    private _catchRate:number;
    private _level100:number;
    private _talents : [{tc:boolean , name:string}];
    //2.définition des valeurs par défault des pokémons


    constructor(
        id:number,
        pokedexId:number,
        generation:Generation,
        category:string,
        name: {en:string , fr:string , jp:string},
        sprites:{gmax: {shiny:string , regular:string} , shiny:string, regular:string},
        types:[{name:string,image:string}],
        stats: { hp:number,atk:number,def:number,vit:number ,spe_atk:number,spe_def:number },
        resistances:[{name:string , multiplier:number}],
        evolution:{pre:[{name:string , condition:string , pokedexId:number}] , mega : [{orbre:string , sprites: {shiny:string , regular:string}}] , next:[{name:string , condition:string, pokedexId:number}]},
        height:string,
        weight:string,
        eggGroups:object,
        sexe:{male:number, female:number},
        catchRate:number,
        level100:number,
        talents:[{tc:boolean, name:string}],
    ) {
        this._id = id;
        this._pokedexId = pokedexId;
        this._generation = generation;
        this._category = category;
        this._name = name;
        this._sprites = sprites;
        this._types = types;
        this._stats = stats;
        this._resistances = resistances;
        this._evolution = evolution;
        this._height = height;
        this._weight = weight;
        this._eggGroups = eggGroups;
        this._sexe = sexe;
        this._catchRate = catchRate;
        this._level100 = level100;
        this._talents = talents;
    }

    get id(): number {
        return this._id;
    }

    public set id(value: number) {
        this._id = value;
    }

    get pokedexId(): number {
        return this._pokedexId;
    }

    set pokedexId(value: number) {
        this._pokedexId = value;
    }

    get generation(): Generation {
        return this._generation;
    }

    set generation(value: Generation) {
        this._generation = value;
    }

    get category(): string {
        return this._category;
    }

    set category(value: string) {
        this._category = value;
    }

    get name(): {en:string , fr:string , jp:string}  {
        return this._name;
    }

    set name(value: string) {
        this._name = JSON.parse(value);
    }

    get sprites(): {gmax: {shiny:string , regular:string} , shiny:string, regular:string} {
        return this._sprites;
    }

    set sprites(value: string) {
        this._sprites = JSON.parse(value);
    }

    get types(): [{name:string,image:string}] {
        return this._types;
    }

    set types(value: string) {
        this._types = JSON.parse(value);
    }

    get stats(): { hp:number,atk:number,def:number,vit:number ,spe_atk:number,spe_def:number } {
        return this._stats;
    }

    set stats(value: string) {
        this._stats = JSON.parse(value);
    }

    get resistances(): [{name:string , multiplier:number}] {
        return this._resistances;
    }

    set resistances(value: string) {
        this._resistances = JSON.parse(value);
    }

    get evolution(): {pre:[{name:string , condition:string , pokedexId:number}] , mega : [{orbre:string , sprites: {shiny:string , regular:string}}] , next:[{name:string , condition:string, pokedexId:number}]} {
        return this._evolution;
    }

    set evolution(value: string) {
        this._evolution = JSON.parse(value);
    }

    get height(): string {
        return this._height;
    }

    set height(value: string) {
        this._height = value;
    }

    get weight(): string {
        return this._weight;
    }

    set weight(value: string) {
        this._weight = value;
    }

    get eggGroups(): object {
        return this._eggGroups;
    }

    set eggGroups(value: string) {
        this._eggGroups = JSON.parse(value);
    }

    get sexe(): {male:number, female:number} {
        return this._sexe;
    }

    set sexe(value: string) {
        this._sexe = JSON.parse(value);
    }

    get catchRate(): number {
        return this._catchRate;
    }

    set catchRate(value: number) {
        this._catchRate = value;
    }

    get level100(): number {
        return this._level100;
    }

    set level100(value: number) {
        this._level100 = value;
    }

    get talents(): [{ tc: boolean; name: string }] {
        return this._talents;
    }

    set talents(value: string) {
        this._talents = JSON.parse(value);
    }

}

