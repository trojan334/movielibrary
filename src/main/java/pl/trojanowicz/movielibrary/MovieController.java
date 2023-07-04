package pl.trojanowicz.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Zawiera endpointy do aplikacji
//Request mapping - endpoint dla klasu
@RestController
@RequestMapping("/movies")
public class MovieController {

    //Wstrzykujemy reopo do pobrania metod
    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/")
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable int id){
        return movieRepository.getById(id);
    }

    @PostMapping("/")
    public int add(@RequestBody List<Movie> movies){
        return movieRepository.save(movies);
    }
}
