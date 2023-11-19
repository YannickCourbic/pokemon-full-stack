import {useParams} from "react-router";
import usePokemonById from "../hooks/usePokemonById.ts";
import Stat from "./Stat.tsx";
import Evolution from "./Evolution.tsx";
import Reproduction from "./Reproduction.tsx";
function ShowPokemon() {
    const params = useParams();
    const {pokemon, load, error} = usePokemonById(parseInt(params.id as string));
    console.log(pokemon , load , error)
    console.log(pokemon?.eggGroups)
    return (
        <div className={"container "} style={{ marginTop: "100px"}}>
            <h1 className="text-center">{pokemon?.name.fr} </h1>
            <div className={"row"}>
                <div className="col-md-6 col-sm-12 py-5">
                    <div className={"d-flex justify-content-center "}>
                        <img src={pokemon?.sprites.regular} alt="image de pokémon" className={"img-thumbnail w-75 shadow"} style={{background: "#f1f1f1"}} />
                    </div>
                </div>
                <div className="col-md-6 col-sm-12">
                    <div className={"w-100 rounded my-5 shadow p-3"} style={{background: "rgba(48,167,215,0.75)"}}>
                        <h3 className={"text-center text-light"}>Information du Pokémon</h3>
                        <h6 className={"text-light text-center"}>Pokedex n°{pokemon?.pokedexId}</h6>
                        <div className={"row"}>
                            <div className={"col-6 d-flex flex-column"}>
                                <h6 className={"text-light px-5 mt-5 text-center"} style={{letterSpacing:"2px"}}>
                                    Taille :
                                </h6>
                                <h4 className={"px-5 text-center "}>
                                    {pokemon?.height}
                                </h4>
                            </div>
                            <div className={"col-6 "}>
                                <h6 className={"text-light px-5 mt-5 text-center"} style={{letterSpacing:"2px"}}>
                                    Catégorie :
                                </h6>
                                <h4 className={"px-5 text-center"}>
                                    {pokemon?.category}
                                </h4>
                            </div>
                        </div>
                        <div className={"row"}>
                            <div className={"col-6 d-flex flex-column"}>
                                <h6 className={"text-light px-5 mt-5 text-center"} style={{letterSpacing:"2px"}}>
                                    Poids :
                                </h6>
                                <h4 className={"px-5 text-center"}>
                                    {pokemon?.weight}
                                </h4>
                            </div>
                            <div className={"col-6 text-center"}>
                                <h6 className={"text-light px-5 mt-5 pb-1 text-right"} style={{letterSpacing:"2px"}}>
                                    Talent :
                                </h6>
                                <div className={"px-5"}>
                                    {pokemon?.talents.map((talent,index) => {
                                        return <div key={index} style={{marginTop: "-13px" , color:"#262626"}}>
                                            <p className={""}> {talent.name}{talent.tc && <span className={"mx-2"} style={{fontSize: "10px" }}>(talent caché)</span>}</p>
                                        </div>
                                    })}
                                </div>
                            </div>
                        </div>
                            <div className="row">
                                <div className="col-6 d-flex flex-column">
                                    {pokemon?.sexe != null &&<>
                                    <h6 className={"text-light px-5 pb-1 text-center"} style={{letterSpacing:"2px"}}>
                                        Sexe
                                    </h6>
                                    <div className={"d-flex flex-row justify-content-center gap-2"}>
                                        <h5><i className="bi bi-gender-male text-primary fw-bolder"></i> {pokemon?.sexe.male}%</h5>
                                        <h5><i className="bi bi-gender-female text-danger fw-bold"></i> {pokemon?.sexe.female}%</h5>
                                    </div>
                                    </>
                                    }
                                </div>
                                    <div className="col-6 d-flex flex-column">
                                        <h6 className={"text-light px-5 pb-1 text-center"} style={{letterSpacing:"2px"}}>
                                            type :
                                        </h6>
                                        <div className={"d-flex flex-row justify-content-center gap-2"}>
                                            {pokemon?.types.map((type,index )=> {
                                                return <div key={index} className={"d-flex flex-column gap-1"}>
                                                    <img src={type.image} alt="image de type"/>
                                                    <p className={"text-center fw-bold"}>{type.name}</p>
                                                </div>

                                            })}
                                        </div>
                                    </div>
                            </div>
                    </div>
                </div>
                <div className={"col-md-6 col-sm-12"}>
                    <div className={"w-100 rounded my-5 shadow p-3"} style={{background: "#f1f1f1"}}>
                        <h3 className={"text-center"}>Statistiques du Pokémon</h3>
                        <div className="d-flex align-items-center justify-content-center ">
                            <Stat title ={"HP"} stat={pokemon?.stats.hp as number} maxStat = {255} color={"success"} height={"14"}/>
                            <h6 style={{marginTop:"25px"}}>{pokemon?.stats.hp}</h6>
                        </div>
                        <div className="d-flex align-items-center justify-content-center ">
                            <Stat title ={"ATK"} stat={pokemon?.stats.atk as number} maxStat = {190} color={"danger"} height={"14"}/>
                            <h6 style={{marginTop:"25px"}}>{pokemon?.stats.atk}</h6>
                        </div>
                        <div className="d-flex align-items-center justify-content-center ">
                            <Stat title ={"DEF"} stat={pokemon?.stats.def as number} maxStat = {255} color={"info"} height={"14"}/>
                            <h6 style={{marginTop:"25px"}}>{pokemon?.stats.def}</h6>
                        </div>
                        <div className="d-flex align-items-center justify-content-center ">
                            <Stat title ={"SPE_ATK"} stat={pokemon?.stats.spe_atk as number} maxStat = {255} color={"primary"} height={"14"}/>
                            <h6 style={{marginTop:"25px"}}>{pokemon?.stats.spe_atk}</h6>
                        </div>
                        <div className="d-flex align-items-center justify-content-center ">
                            <Stat title ={"SPE_DEF"} stat={pokemon?.stats.spe_def as number} maxStat = {255} color={"warning"} height={"14"}/>
                            <h6 style={{marginTop:"25px"}}>{pokemon?.stats.spe_def}</h6>
                        </div>
                        <div className="d-flex align-items-center justify-content-center ">
                            <Stat title ={"VIT"} stat={pokemon?.stats.vit as number} maxStat = {255} color={"secondary"} height={"14"}/>
                            <h6 style={{marginTop:"25px"}}>{pokemon?.stats.vit}</h6>
                        </div>
                    </div>
                </div>
                <div className="col-md-6 col-sm-12">
                    <div className="w-100 rounded my-5 shadow p-3" style={{backgroundColor: "rgba(146,38,255,0.45)"}}>
                        <h3 className={"text-center"}>Résistance du Pokémon</h3>
                        <div className="row">
                            {pokemon?.resistances.map((resistance,index) => {
                                return <div key={index} className={"col-md-3 col-sm-6"}>
                                        <div className="d-flex  align-items-center">
                                            <h6 className={""}>{ resistance.name + " x " +  resistance.multiplier}</h6>
                                        </div>
                                </div>
                            })}
                        </div>
                    </div>
                </div>
                <div className="col-12">
                    <div className="w-100 rounded my-5 shadow p-3" style={{backgroundColor:"#a9d7ff"}}>
                        <h3 className={"text-center"}>Les évolutions</h3>
                        {pokemon?.evolution.pre && pokemon.evolution.pre.map(pokemon => {
                            return <Evolution key={pokemon.pokedexId} id={pokemon.pokedexId} name={pokemon.name} condition={pokemon.condition}/>
                        })}
                        {pokemon?.evolution.next && pokemon.evolution.next.map(pokemon => {
                            return <Evolution key={pokemon.pokedexId} id={pokemon.pokedexId} name={pokemon.name} condition={pokemon.condition}/>
                        })}
                    </div>
                </div>
                <div className={"col-12"}>
                    <div className="w-100 rounded my-5 shadow p-3" style={{backgroundColor:"#ffbd93"}}>
                        <h3 className={"text-center"}>Reproductions</h3>

                        {
                            // @ts-ignore
                            pokemon?.eggGroups.map((egg , index) => {
                            console.log(egg ,index)
                            return <div key={index}>
                                <Reproduction egg={egg}/>
                            </div>
                        })}
                    </div>
                </div>

            </div>

            <a href={"/"} className={"btn btn-g btn-info p-2 text-light px-5 mb-5"} style={{position:"relative" , left:"50%" , marginLeft: "-50px"}}>Retour</a>
        </div>
    );
}

export default ShowPokemon;