package com.kodilla.good.patterns.challenges.taskfirst;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieStore {
    private Map<String, List<String>> getMovies() {
        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);

        return booksTitlesWithTranslations;
    }


    public void printMovies(){

        String mStr = getMovies().values().stream()
                .map(l -> String.join(">", l))
                .collect(Collectors.joining("|"));

        System.out.println(mStr);

    }

}
