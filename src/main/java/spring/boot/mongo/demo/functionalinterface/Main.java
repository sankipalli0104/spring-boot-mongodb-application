package spring.boot.mongo.demo.functionalinterface;

import java.util.List;
import java.util.function.Predicate;

import static spring.boot.mongo.demo.functionalinterface.Main.Gender.FEMALE;
import static spring.boot.mongo.demo.functionalinterface.Main.Gender.MALE;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Siva", MALE),
                new Person("Saru", FEMALE),
                new Person("Siddu", MALE),
                new Person("Sam", MALE),
                new Person("Geethu", FEMALE)
        );

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        personList.stream()
                .filter(personPredicate).count();
                //.forEach(System.out::println);
    }

    static class Person{
        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        private final String name;
        private  final Gender gender;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        FEMALE, MALE
    }
}
