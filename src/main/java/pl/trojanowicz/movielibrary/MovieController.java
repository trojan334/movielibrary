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
    public Movie getById(@PathVariable("id") int id) {
        return movieRepository.getById(id);
    }

    //Requestbody - spring musi wiedziec ze dostanie jsona?
    @PostMapping("/")
    public int add(@RequestBody List<Movie> movies) {
        return movieRepository.save(movies);
    }


    //w zapytaniu typu put trzeba zupdatować wszystkie pola
    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.getById(id);
        if (movie != null) {
            movie.setName(updatedMovie.getName());
            movie.setRating(updatedMovie.getRating());
            movieRepository.update(movie);
            return 1;
        } else {
            return -1;
        }
    }


    //metoda typu patch aktualizuje tylko wskazane wartości
    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.getById(id);
        if (movie != null) {
            if (updatedMovie.getName() != null) movie.setName(updatedMovie.getName());
            if (updatedMovie.getRating() > 0) movie.setRating(updatedMovie.getRating());

            movieRepository.update(movie);
            return 1;
        } else {
            return -1;
        }
    }
}
