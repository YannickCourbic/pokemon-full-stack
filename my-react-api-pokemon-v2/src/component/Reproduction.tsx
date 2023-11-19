import usePokemonByEggGroups from "../hooks/usePokemonByEggGroups.ts";

interface reproductionProps{
    egg:string|null
}
function Reproduction({egg}:reproductionProps) {

    const {pokemon , load ,error} = usePokemonByEggGroups(egg)
    console.log(pokemon , load ,error)

    return (
        <div className={"row"}>
            {load && <div className="spinner"></div>}
            {error.res && <h1>error</h1>}
            <h4 className={"text-center mt-5"}>{egg}</h4>
            {pokemon?.map(({sprites,id}) => {
                return <div key={id} className={"col-1 d-flex flex-columns align-items-center justify-content-center"}>
                    <img src={sprites.regular} alt="image de pokemon" style={{width: "50px"}}/>
                </div>
            })}
        </div>
    );
}

export default Reproduction;