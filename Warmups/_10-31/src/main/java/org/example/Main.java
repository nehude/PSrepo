package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> movieRatings = new HashMap<>();

        movieRatings.put("Inception", 9);
        movieRatings.put("The Shawshank Redemption", 10);
        movieRatings.put("Pulp Fiction", 8);
        movieRatings.put("The Matrix", 7);
        movieRatings.put("Titanic", 6);
        movieRatings.put("Fight Club", 9);
        movieRatings.put("The Godfather", 10);
        movieRatings.put("Forrest Gump", 8);
        movieRatings.put("The Dark Knight", 9);
        movieRatings.put("Avatar", 7);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a movie title to get its rating: ");
        String movieTitle = scanner.nextLine();
        if (movieRatings.containsKey(movieTitle)) {
            int rating = movieRatings.get(movieTitle);
            System.out.println("Rating of " + movieTitle + ": " + rating);
        } else {
            System.out.println("Sorry, movie not available.");
        }

        System.out.print("Enter a movie title to check if it's in the hashmap: ");
        String searchMovie = scanner.nextLine();
        if (movieRatings.containsKey(searchMovie)) {
            int rating = movieRatings.get(searchMovie);
            System.out.println(searchMovie + " is available. The rating is " + rating + ".");
        } else {
            System.out.println("Sorry, movie not available.");
        }

        System.out.println("Movies with a rating above 5:");
        for (String movie : movieRatings.keySet()) {
            if (movieRatings.get(movie) > 5) {
                System.out.println(movie);
            }
        }
    }
}