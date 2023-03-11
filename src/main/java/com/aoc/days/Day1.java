package com.aoc.days;

import java.io.IOException;
//import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class Day1 {

    public static void main(String[] args) throws IOException { //}, URISyntaxException {
        Stream<String> lines = Files.lines(Path.of("src/main/resources/day1.txt"));
//        Stream<String> lines = Files.lines(Path.of(Day1.class.getClassLoader().getResource("day1.txt").toURI()));
//        lines.forEach(System.out::println);

        List<Long> calories = new ArrayList<>();
        AtomicLong tempCalorie = new AtomicLong();
        tempCalorie.set(0);
        lines.forEach(line -> {
            if(line.isBlank()) {
                calories.add(tempCalorie.get());
                tempCalorie.set(0);
            } else {
                int n = Integer.parseInt(line);
                tempCalorie.set(n+tempCalorie.get());// += n;
            }

        });
        System.out.println(calories.stream().max(Long::compare));

    }
}
