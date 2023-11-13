const fetchPokemon =  (url , method= "GET" , headers = {'Content-Type': 'application/json'}) => {
    fetch(url , {
        method: method,
        headers : headers,
    })
        .then(res => {
            return res.json();
        })
        .then(pokemons => {

            console.log(pokemons)
            pokemons.forEach(pokemon => {
                const name = JSON.stringify(pokemon.name);
                const sprites = JSON.stringify(pokemon.sprites);
                const types = JSON.stringify(pokemon.types);
                const talents = JSON.stringify(pokemon.talents);
                const stats = JSON.stringify(pokemon.stats);
                const resistances = JSON.stringify(pokemon.resistances);
                const evolution = JSON.stringify({
                    pre: (pokemon.evolution && pokemon.evolution.pre !== null) ? pokemon.evolution.pre : null,
                    next: (pokemon.evolution && pokemon.evolution.next !== null) ? pokemon.evolution.next : null,
                    mega: (pokemon.evolution && pokemon.evolution.mega !== null )? pokemon.evolution.mega : null
                });                const eggGroups = JSON.stringify(pokemon["egg_groups"])
                const sexe = JSON.stringify(pokemon.sexe);

                const postData = {
                    generation : {
                        id : 1
                    },
                    pokedexId : pokemon.pokedexId,
                    category: pokemon.category,
                    name: name,
                    sprites : sprites,
                    types : types,
                    talents : talents,
                    stats : stats,
                    resistances : resistances,
                    evolution : evolution,
                    height : pokemon.height,
                    weight : pokemon.weight,
                    egg_groups: eggGroups,
                    sexe : sexe,
                    catchRate: pokemon["catch_rate"],
                    level100: pokemon["level_100"]
                }
                fetch( "http://localhost:8080/api/v1/rest/pokemon/create" ,  {
                    method : "POST",
                    headers : {
                        'Content-Type': 'application/json'
                    },
                    body : JSON.stringify(postData)
                })
                    .then(response => {
                    if (!response.ok) {
                        throw new Error(`HTTP error! Status: ${response.status}`);
                    }
                    return response.json(); // Assuming the response is in JSON format
                })

            })

        })
}

// fetchPokemon("https://api-pokemon-fr.vercel.app/api/v1/gen/1")



const getPokemon = () => {
    fetch("http://localhost:8080/api/v1/rest/pokemon/identify/1000" , {
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
                console.log(response)
            }
            return response.json(); // Assuming the response is in JSON format
        })
        .then(data => {
            console.log(data)
        })
        .catch(err => console.error(err))

}

getPokemon();