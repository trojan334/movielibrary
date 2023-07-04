package pl.trojanowicz.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


//Zawiera endpointy do aplikacji
@RestController
public class MovieController {

    //Wstrzykujemy reopo do pobrania metod
    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/movies")
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    @GetMapping("movies/{id}")
    public Movie getById(@PathVariable int id){
        return movieRepository.getById(id);
    }
}
