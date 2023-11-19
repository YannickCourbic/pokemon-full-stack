import {useEffect, useState} from "react";
import ApiCallPokemon from "./ApiCallPokemon.ts";
import Pokemon from "../models/Pokemon.ts";
import Generation from "../models/Generation.ts";

const usePokemonByEggGroups = (egg: string | null) => {
    const [pokemon, setPokemon] = useState<Pokemon[]>();
    const [error, setError] = useState<{ res: boolean, message: string, data: string, status: number }>({res: false, message: "", data: "", status: 200});
    const [load, setLoad] = useState<boolean>(true);

    useEffect(() => {
        const pokemonArr: never[] = [];
        ApiCallPokemon.getPokemonByEggGroups(egg)
            .then(res => res.data)
            .then(pokemons => {
                pokemons.pokemon.forEach((pokemon:{ id: number; pokedexId: number; generation: Generation; category: string; name: string; sprites: string; types: string; stats: string; resistances: string; evolution: string; height: string; weight: string; egg_groups: string; sexe: string; catchRate: number; level100: number;talents:string }) => {

                        // @ts-ignore
                        const p = new Pokemon();
                        p.id = pokemon?.id;
                        p.pokedexId = pokemon?.pokedexId;
                        p.generation = pokemon.generation;
                        p.category = pokemon.category;
                        p.name = pokemon.name;
                        p.sprites = pokemon.sprites;
                        p.types = pokemon.types;
                        p.stats = pokemon.stats;
                        p.resistances = pokemon.resistances;
                        p.evolution = pokemon.evolution;
                        p.height= pokemon.height;
                        p.weight = pokemon.weight;
                        p.eggGroups = pokemon['egg_groups'];
                        p.sexe = pokemon.sexe;
                        p.catchRate = pokemon.catchRate;
                        p.level100 = pokemon.level100;
                        p.talents = pokemon.talents
                    // @ts-ignore
                    pokemonArr.push(p);
                })
                setPokemon(pokemonArr)
                setLoad(false)
            })
            .catch(error => {
                setError({res:true , data: error.response.data ,message: error.response.data.message , status: error.response.status})
                setLoad(false);
            })
    }, [egg]);
    return {pokemon , load , error}
}

export default usePokemonByEggGroups;