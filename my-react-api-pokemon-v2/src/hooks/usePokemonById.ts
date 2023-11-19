import {useEffect, useState} from "react";
import ApiCallPokemon from "./ApiCallPokemon.ts";
import Pokemon from "../models/Pokemon.ts";

const usePokemonById = (id:number | null) => {
    const [pokemon , setPokemon] = useState<Pokemon>();
    const [error , setError] = useState<{res : boolean , message:string , data:string , status:number  }>({res:false , message: "" , data: "" , status:200});
    const [load , setLoad] = useState<boolean>(true);
    useEffect(() => {
        ApiCallPokemon.getPokemonById(id)
            .then(res => res.data)
            .then(pokemon => {
                // @ts-ignore
                const p = new Pokemon()
                p.id = pokemon?.data.id;
                p.pokedexId = pokemon?.data.pokedexId;
                p.generation = pokemon?.data.generation;
                p.category = pokemon?.data.category;
                p.name = pokemon?.data.name;
                p.sprites = pokemon?.data.sprites;
                p.types = pokemon?.data.types;
                p.stats = pokemon?.data.stats;
                p.resistances = pokemon?.data.resistances;
                p.evolution = pokemon?.data.evolution;
                p.height= pokemon?.data.height;
                p.weight = pokemon?.data.weight;
                p.eggGroups = pokemon?.data['egg_groups'];
                p.sexe = pokemon?.data.sexe;
                p.catchRate = pokemon?.data.catchRate;
                p.level100 = pokemon?.data.level100;
                p.talents = pokemon?.data.talents
                setPokemon(p);
                setLoad(false);

            })
            .catch(error => {
                setError({res:true , data: error.response.data ,message: error.response.data.message , status: error.response.status})
                setLoad(false);
            })
    }, [id]);
    return {pokemon , load , error};
}

export default usePokemonById;