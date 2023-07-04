package pl.trojanowicz.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//Zawiera metody operujące na bazie danych
@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //metoda zwracająca wszystie filmy
    public List<Movie> getAll(){
        return jdbcTemplate.query("SELECT id, name, rating FROM movie",
                BeanPropertyRowMapper.newInstance(Movie.class));
    }


    //metoda zwraca film po id, queryForObject(zapytanie, mapper, argumentu które podstawiaa się pod ?)
    public Movie getById(int id){
        return jdbcTemplate.queryForObject("SELECT id, name, rating FROM movie WHERE id = ?", BeanPropertyRowMapper.newInstance(Movie.class),id);
    }

    public int save(List<Movie> movies) {
        movies.forEach(movie -> jdbcTemplate
                .update("INSERT INTO movie(name, rating) VALUES(?, ?)",
                movie.getName(), movie.getRating()));
        return 1;
    }
}
