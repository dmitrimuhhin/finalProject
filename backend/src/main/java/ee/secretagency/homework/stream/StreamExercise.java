package ee.secretagency.homework.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercise {

    public static void main(String[] args) {

        var persons = List.of(
                new Person("Dmitri", "M", 35,187),
                new Person("Sass", "I", 34,179),
                new Person("Aleksei", "H", 33,182),
                new Person("Jaanus", "T", 32,175)
        );

        // make a collection with just names - loops approach
        List<String> justNames = new ArrayList<>();
        for (var person : persons) {
            justNames.add(person.name());
        }
        System.out.println("just names: " + justNames);

        // make a collection with names of people who are older than 33 years
        List<String> justNamesOfOlderPersons = new ArrayList<>();
        for (var person : persons) {
            if (person.age() > 33) {
                justNamesOfOlderPersons.add(person.name());
            }
        }
        System.out.println("loops - just names of older persons:" + justNamesOfOlderPersons);

        System.out.println("now streams");

        var namesWithStream = persons.stream()
                .map(person -> person.name())
//                .toList() // since Java 16th
                .collect(Collectors.toList());
        System.out.println("streams - just names: " + namesWithStream);

        var olderPersonsFilteredWithStream = persons.stream()
                .filter(person -> person.age() > 33)
                .map(person -> person.name())
                .toList();
        System.out.println("stream - older persons: " + olderPersonsFilteredWithStream);

        persons.stream()
                .filter(person -> person.age() < 34)
                .map(person -> person.height())
                .forEach(height -> System.out.println("person height: " + height));

        persons.stream()
                .filter(person -> {
                    System.out.println("checking person: " + person);
                    return person.age() < 34;
                })
                .map(person -> {
                    System.out.println("mapping to names %s -> %s".formatted(person, person.name()));
                    return person.name();
                })
                .toList();
    }
}
