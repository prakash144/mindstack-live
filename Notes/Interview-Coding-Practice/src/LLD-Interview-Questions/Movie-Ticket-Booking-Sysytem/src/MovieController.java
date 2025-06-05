import Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityVsMovies;
    List<Movie> allMovies;

    MovieController() {
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    // Add Movie to a particular city, make use of cityVsMovies map
    void addMovie(Movie movie, City city) {
        allMovies.add(movie);

        List<Movie> movies = cityVsMovies.getOrDefault(city, allMovies);
        movies.add(movie);
        cityVsMovies.put(city, movies);
    }

    Movie getMovie(String movieName) {
        for (Movie movie : allMovies) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    List<Movie> getMovieByCity(City city) {
        return cityVsMovies.getOrDefault(city, allMovies);
    }
    //REMOVE movie from a particular city, make use of cityVsMovies map

    //UPDATE movie of a particular city, make use of cityVsMovies map

    //CRUD operation based on Movie ID, make use of allMovies list
}

