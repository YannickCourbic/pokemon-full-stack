package com.pokemonapi.restpokemon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemonapi.restpokemon.Entity.Generation;
import com.pokemonapi.restpokemon.Entity.Pokemon;
import com.pokemonapi.restpokemon.Repository.GenerationRepository;
import com.pokemonapi.restpokemon.Service.GenerationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootTest
class RestPokemonApplicationTests {
    @Autowired
    private GenerationRepository generationRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GenerationService generationService;
    @Test
    void TestCreateGeneation() {
        ArrayList<String> gens = new ArrayList<>();
        gens.add("Kanto");
        gens.add("Johto");
        gens.add("Hoenn");
        gens.add("Sinnoh");
        gens.add("Unys");
        gens.add("Kalos");
        gens.add("Alola");
        gens.add("Galar");
        gens.add("Paldea");

        gens.stream().forEach(gen -> {
            Generation g = new Generation();
            g.setRegion(gen);
            this.generationRepository.save(g);
        });
    }

    @Test
    void TestCallApiPokemon(){

        for (int i = 1; i <=151; i++) {
            System.out.println(i);
            String url = "https://api-pokemon-fr.vercel.app/api/v1/pokemon/" + i;
            String response = this.restTemplate.getForObject(url , String.class);
            ObjectMapper objectMapper= new ObjectMapper();
            try{
                PokemonJson pokemon = objectMapper.readValue(response , PokemonJson.class);

                System.out.println(pokemon.toString());

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Test
    void TestGetGeneration(){
        Generation generation = new Generation();
        generation.setId(10L);
        this.generationService.getGeneration(generation);
   this.generationService.getGeneration(generation);
        System.out.println(this.generationService.getGeneration(generation));
    }

}
