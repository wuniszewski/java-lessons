package pl.wojtek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 1.Dodać random enum (najlepiej metode)
 2.Policzyć średnią wieku wszystkich osób
 3.Policz ile jest unikalnych osób
 4.Policz ile jest osób z każdą płcią
 5.Policz jest osób w wieku większym od 50 lat
 6 i 7 wymyśl coś z wykorzystaniem kolekcji

 Poczytaj o kolekcjach która do czego służy i na czym polega equals i hashcode (co to jest kontrakt equals i hashcode)
 !!!!!!! Uzyj do tego kolekcji !!!!!!!!!!
 */
public class Main {

    public static void main(String[] args) {

        List<String> firstNames = new ArrayList<String>();
        firstNames.add("John");
        firstNames.add("Mark");
        firstNames.add("Susie");
        firstNames.add("Kate");
        firstNames.add("Bob");

        List<String> lastNames = new ArrayList<>();
        lastNames.add("Kowalski");
        lastNames.add("Smith");
        lastNames.add("Thutcher");
        lastNames.add("Columbus");
        lastNames.add("Ford");

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 5000 ; i++ ){
            int age = (int) ((Math.random() * 99) + 1);
            String firstName = firstNames.get(new Random().nextInt(firstNames.size()));
            String lastName = lastNames.get(new Random().nextInt(lastNames.size()));
            Sex sex = Sex.FEMALE;
        }

    }
}
