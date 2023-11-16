import Pokemon from "../models/Pokemon.ts";
import Stat from "./Stat.tsx";

interface typeProps {
    pokemon:Pokemon
}
function Card({pokemon}:typeProps) {
    return (
        <div className={"card py-2 my-2"} style={{background: "#fafafa"}}>
            <div className={"row"}>
                <div className="col-5 d-flex flex-column justify-content-center align-items-center">
                    <img src={pokemon.sprites.regular} alt="image de pokémon" width={"150px"}/>
                   <div className="d-flex flex-row justify-content-center align-items-center gap-2">
                       {pokemon.types.map((type , index) => {
                           return <><img key={index} src={type.image} alt={`image de ${type.name}`} width={"30px"}/></>
                       } )}
                   </div>
                </div>
                <div className="col-7">
                    <div className="d-flex flex-column align-items-center">
                        <h4 className={"text-center"}>{pokemon.name.fr}</h4>
                        <p className={"text-primary text-center"} style={{marginTop: "-10px"}}>{pokemon.name.en}</p>
                        <p className={"text-danger text-center"} style={{marginTop:"-17px"}}>{pokemon.name.jp}</p>
                    </div>
                    <Stat title ={"HP"} stat = {pokemon.stats.hp} maxStat = {255} color={"success"} />
                    <Stat title ={"ATK"} stat = {pokemon.stats.atk} maxStat = {190} color={"danger"}/>
                    <Stat title ={"DEF"} stat = {pokemon.stats.def} maxStat = {250} color={"info"}/>
                    <Stat title ={"SPE_ATK"} stat = {pokemon.stats.spe_atk} maxStat = {194} color={"primary"} />
                    <Stat title ={"SPE_DEF"} stat = {pokemon.stats.spe_def} maxStat = {230} color={"warning"} />
                    <Stat title ={"VIT"} stat = {pokemon.stats.vit} maxStat = {200} color={"secondary"} />
                </div>
            </div>
        </div>
    );
}

export default Card;