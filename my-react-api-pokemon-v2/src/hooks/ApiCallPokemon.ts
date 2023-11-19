import axios from "axios";


export default class ApiCallPokemon {
    static async getPaginated(page: number | null, limit: string) {
        return axios.get(`http://localhost:8080/api/v1/rest/pokemon/paginated?page=${page}&limit=${limit}`,
            {
                method: "GET",
                headers: {'Content-Type': 'application/json'}
            });
    }

    static async getPokemonById(id:number | null){
        return await axios.get(`http://localhost:8080/api/v1/rest/pokemon/identify/${id}` ,
            {
                method: 'GET',
                headers: {"Content-Type": "application/json"}
            }
        )
    }
    static async getPokemnByPokedexId(id:number|null){
        return await axios.get(`http://localhost:8080/api/v1/rest/pokemon/pokedex/${id}`, {method:'GET' , headers: {"Content-Type": "application/json"}})
    }

    static async getPokemonByEggGroups(egg:string|null){
        return await axios.get(`http://localhost:8080/api/v1/rest/pokemon/eggGroups/${egg}`, {method:'GET' , headers:{"Content-Type": "application/json"}})
    }

}