package pl.trojanowicz.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


//Zawiera endpointy do aplikacji
@RestController
public class MovieController {

    //Wstrzykujemy reopo do pobrania metod
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/test")
    public int test() {
        return 1;
    }

    @GetMapping("/movies")
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }
}
