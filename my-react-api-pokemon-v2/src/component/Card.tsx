import Pokemon from "../models/Pokemon.ts";
import Stat from "./Stat.tsx";
import {useState} from "react";
import {useNavigate} from "react-router-dom";
interface typeProps {
    pokemon:Pokemon,
    borderColor?:string
}
function Card({pokemon , borderColor = "#009688"}:typeProps) {
    const [color , setColor] = useState<string>();
    const history = useNavigate();
    const goToPokemon = (id:number) => {
        history(`/pokemon/${id}`);
    }
    const showBorder = () => {
        setColor(borderColor)
    }
    const hideBorder = () => {
        setColor("#f5f5f5");
    }
    return (
        <a
         className={"nav-link"}
         href={""}
        >
        <div
            onClick={() => goToPokemon(pokemon.id)}
            className={"card py-2 my-2 shadow-sm"}
            style={{background: "#fafafa" ,
                border: `5px ${color} solid`}}
            onMouseEnter={showBorder}
            onMouseLeave={hideBorder}
        >
            <div className={"row"}>
                <div className={`col-5 d-flex flex-column justify-content-center align-items-center card-${pokemon.types[0].name}`}>
                    <img src={pokemon.sprites.regular} alt="image de pokémon" width={"150px"} className={``} />
                   <div className="d-flex flex-row justify-content-center align-items-center gap-2">
                       {pokemon.types.map((type , index) => {
                           return <div key={index}><img key={index} src={type.image} alt={`image de ${type.name}`} width={"30px"}/></div>
                       } )}
                   </div>
                </div>
                <div className="col-7">
                    <div className="d-flex flex-column align-items-center">
                        <h4 className={"text-center"}>{pokemon.name.fr}</h4>
                        <p className={"text-primary text-center"} style={{marginTop: "-10px"}}>{pokemon.name.en}</p>
                        <p className={"text-danger text-center"} style={{marginTop:"-17px"}}>{pokemon.name.jp}</p>
                    </div>
                    <Stat title ={"HP"} stat = {pokemon.stats.hp} maxStat = {255} color={"success"} height={"7"}/>
                    <Stat title ={"ATK"} stat = {pokemon.stats.atk} maxStat = {190} color={"danger"} height={"7"}/>
                    <Stat title ={"DEF"} stat = {pokemon.stats.def} maxStat = {250} color={"info"} height={"7"}/>
                    <Stat title ={"SPE_ATK"} stat = {pokemon.stats.spe_atk} maxStat = {194} color={"primary"} height={"7"}/>
                    <Stat title ={"SPE_DEF"} stat = {pokemon.stats.spe_def} maxStat = {230} color={"warning"} height={"7"}/>
                    <Stat title ={"VIT"} stat = {pokemon.stats.vit} maxStat = {200} color={"secondary"} height={"7"}/>
                </div>
            </div>
        </div>
        </a>
    );
}

export default Card;