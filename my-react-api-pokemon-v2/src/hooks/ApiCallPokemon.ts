import axios from "axios";


export default class ApiCallPokemon {
    static async getPaginated(page: number | null, limit: string) {
        return axios.get(`http://localhost:8080/api/v1/rest/pokemon/paginated?page=${page}&limit=${limit}`,
            {
                method: "GET",
                headers: {'Content-Type': 'application/json'}
            });
    }

}