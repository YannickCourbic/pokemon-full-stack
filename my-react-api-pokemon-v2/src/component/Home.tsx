import {useEffect, useState} from "react";
import Pokemon from "../models/Pokemon.ts";
import ApiCallPokemon from "../hooks/ApiCallPokemon.ts";
import Generation from "../models/Generation.ts";
import Card from "./Card.tsx";
import Pagination from "./Pagination.tsx";

function Home() {
    const [data , setData] = useState<Pokemon[] | null>(null);
    const [page , setPage] = useState<number>(1);
    const [error , setError] = useState<{res : boolean , message:string , data:string , status:number  }>({res:false , message: "" , data: "" , status:200});
    const [load , setLoad] = useState<boolean>(true);
    useEffect( () => {
        const pokemonArr:Pokemon[] = [];
        ApiCallPokemon.getPaginated(page , "6")
            .then(res =>res.data)
            .then(pokemons => {
                pokemons?.data.forEach((pokemon: { id: number; pokedexId: number; generation: Generation; category: string; name: string; sprites: string; types: string; stats: string; resistances: string; evolution: string; height: string; weight: string; egg_groups: string; sexe: string; catchRate: number; level100: number; }) => {
                    // @ts-ignore
                    const p:Pokemon = new Pokemon()
                    p.id = pokemon.id;
                    p.pokedexId = pokemon.pokedexId;
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
                    p.eggGroups = pokemon.egg_groups;
                    p.sexe = pokemon.sexe;
                    p.catchRate = pokemon.catchRate;
                    p.level100 = pokemon.level100;
                    pokemonArr.push(p);
                });
                setData(pokemonArr);
                setLoad(false);

            })
            .catch(error => {
                    setError({res:true , data: error.response.data ,message: error.response.data.message , status: error.response.status})
                    setLoad(false);
                }
            )
    }, [page]);
    const handleClickNext = () => {
        setPage(page => page + 1);
    }
    const  handleClickPre = () => {
        setPage(page => page -1);
    }
    return (
        <div>
            {load && <div className="spinner position-absolute top-50" style={{left:"50%"}}></div>}
            {error.res && <h1>error</h1>}
            <div className="container">
                <h1 className="text-center">Pokédex</h1>
                <div className="row">
                    {data?.map((pokemon:Pokemon) => {
                        console.log(pokemon)

                        return <div key={pokemon.id} className={"col-sm-12 col-md-4"}>
                            <Card key={pokemon.id} pokemon = {pokemon}  />
                        </div>
                    })}
                </div>
                <Pagination handleClickNext = {handleClickNext} handleClickPre = {handleClickPre} page={page}/>
            </div>
        </div>
    );
}

export default Home;