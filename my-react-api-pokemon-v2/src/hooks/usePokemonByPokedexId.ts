import {useEffect, useState} from "react";
import Pokemon from "../models/Pokemon.ts";
import ApiCallPokemon from "./ApiCallPokemon.ts";

const usePokemonByPokedexId = (id:number|null) => {
    const [pokemon,setPokemon] = useState<Pokemon>();
    const [error , setError] = useState<{res : boolean , message:string , data:string , status:number  }>({res:false , message: "" , data: "" , status:200});
    const [load, setLoad] = useState<boolean>(true);
    useEffect(() => {
            ApiCallPokemon.getPokemnByPokedexId(id)
                .then(res => res.data)
                .then(pokemon => {
                    // @ts-ignore
                    const p = new Pokemon();
                    p.id = pokemon.data[0].id;
                    p.pokedexId = pokemon.data[0].pokedexId;
                    p.generation = pokemon.data[0].generation;
                    p.category = pokemon.data[0].category;
                    p.name = pokemon.data[0].name;
                    p.sprites = pokemon.data[0].sprites;
                    p.types = pokemon.data[0].types;
                    p.stats = pokemon.data[0].stats;
                    p.resistances = pokemon.data[0].resistances;
                    p.evolution = pokemon.data[0].evolution;
                    p.height= pokemon.data[0].height;
                    p.weight = pokemon.data[0].weight;
                    p.eggGroups = pokemon.data[0]['egg_groups'];
                    p.sexe = pokemon.data[0].sexe;
                    p.catchRate = pokemon.data[0].catchRate;
                    p.level100 = pokemon.data[0].level100;
                    p.talents = pokemon.data[0].talents
                    setPokemon(p);
                    setLoad(false);
                })
                .catch(error => {
                    console.log(error)
                    setError({res:true , data: error.response.data ,message: error.response.data.message , status: error.response.status})
                    setLoad(false);
                })
    }, [id]);
    return {pokemon , load , error}
}

export default usePokemonByPokedexId;
