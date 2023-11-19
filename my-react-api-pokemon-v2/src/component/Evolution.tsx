
import usePokemonByPokedexId from "../hooks/usePokemonByPokedexId.ts";

interface evolutionProps{
    id:number,
    name:string,
    condition:string
}
function Evolution({id , name , condition}:evolutionProps) {
    const {pokemon , load , error} = usePokemonByPokedexId(id);
    console.log(pokemon ,load , error)
    console.log(id)
    return (
        <div className={"d-flex flex-column align-items-center py-2"}>
            <img src={pokemon?.sprites.regular} alt="image de pokémon" width={"200px"} className={"rounded-circle bg-white"}/>
            <h3 className={"text-center"}>{name}</h3>
            <h6 className={"text-center fw-bold"}>{condition}</h6>
        </div>
    );
}

export default Evolution;