package spring.boot.mongo.demo.map;

import java.io.Serializable;
import java.util.*;

public class _TreeMap {

    public static void main(String... args) {
        Set<Movie> list = new TreeSet<>((Movie m1, Movie m2) ->  (m1.getName()).compareTo(m2.getName()));
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));


        System.out.println("Movies after sorting With Movie Years: ");
        for (Movie movie : list) {
            System.out.println(
                    movie.getYear() + "-> " +
                            movie.getName() + "-> " +
                            movie.getRating());
        }
//        Collections.sort(list, new MovieNameComparator());
//        System.out.println("Movies after sorting With Movie Name : ");
//        for (Movie movie : list) {
//            System.out.println(
//                    movie.getName() + "-> " +
//                            movie.getRating() + "-> " +
//                            movie.getYear());
//        }
//        Collections.sort(list, new MovieRatingComparator());
//        System.out.println("Movies after sorting With Movie Rating : ");
//        for (Movie movie : list) {
//            System.out.println(
//                    movie.getRating() + "-> " +
//                            movie.getName() + "-> " +
//                            movie.getYear());
//        }
    }
}
