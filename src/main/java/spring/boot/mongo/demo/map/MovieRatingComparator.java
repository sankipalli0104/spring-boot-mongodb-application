package spring.boot.mongo.demo.map;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {
        {
            if (movie1.getRating() < movie2.getRating())
                return -1;
            if (movie1.getRating() > movie2.getRating())
                return 1;
            else
                return 0;
        }
    }
}
