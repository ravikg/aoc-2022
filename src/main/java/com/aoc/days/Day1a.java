import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class Day1a {
    public static void main(String args[]) throws IOException{
            Stream<String> lines = Files.lines(Path.of("day1.txt"));
            //lines.forEach(System.out::println); // to print input.
            int sum =0;
            List<Long> calories = new ArrayList<>(); // so that not need to define size in list
            AtomicLong tempCalories = new AtomicLong();
            tempCalories.set(0);
            lines.forEach(line -> {
                if(line.isBlank()) {
                    calories.add(tempCalories.get());
                    tempCalories.set(0);
                }
                else {
                    int n = Integer.parseInt(line);
                    tempCalories.set(n+tempCalories.get());
                }
            });
            System.out.println(calories.stream().max(Long::compare));
            Collections.sort(calories);
            System.out.println(calories);
            System.out.println(calories.size());
            for(int i=calories.size();i<238;i--) {
                //calories = new List<Long>();
                sum += calories.get(i);
            }
            System.out.println(sum);
            
        }
}
