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
}
