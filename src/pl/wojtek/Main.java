package pl.wojtek;

import java.util.*;

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

        List<String> firstNames = new ArrayList<>();
        firstNames.add("John");
        firstNames.add("Mark");
        firstNames.add("Susie");
        firstNames.add("Kate");
        firstNames.add("Bob");

        List<String> lastNames = new ArrayList<>();
        lastNames.add("Kowalski");
        lastNames.add("Smith");
        lastNames.add("Thatcher");
        lastNames.add("Columbus");
        lastNames.add("Ford");

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            int age = (int) ((Math.random() * 99) + 1);
            String firstName = firstNames.get(new Random().nextInt(firstNames.size()));
            String lastName = lastNames.get(new Random().nextInt(lastNames.size()));
            Sex sex = Sex.randomSex();
            people.add(new Person(firstName, lastName, sex, age));
        }
        Iterator iterator = people.iterator();

        // 2. Zliczenie średniej wieku wszystkich osób........................................

        int x = 0;
        for (int i = 0; i < people.size(); i++) {
            x = x + people.get(i).getAge();
        }
        double averagePersonsAge = (double) x / (double) people.size();
        System.out.println("The average age of a person in the list is: " + averagePersonsAge + ".\n");

        //3. Zliczenie ile jest unikalnych osób.

        Set<Person> uniquePeople = new HashSet<>();
        while (iterator.hasNext()) {
            uniquePeople.add((Person) iterator.next());
        }
        System.out.println("The number of people that are unique is: " + uniquePeople.size() + ".\n");

        //4. Ile jest osób z każdą płcią..............................................

        List<Person> men = new ArrayList<>();
        List<Person> women = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getSex().equals(Sex.MALE)) {
                men.add(people.get(i));
            } else women.add(people.get(i));
        }
        System.out.println("The number of men on the list is: " + men.size() + ".\n" + "The number of women on the list is: " + women.size() + ".\n");

        //5. Ile jest osób w wieku powyżej 50 lat.
        long numberOfPeopleOver50 = people.stream().filter(person -> person.getAge() > 50).count();
        System.out.println("The number of people over 50 is: " + numberOfPeopleOver50 + ".\n");

        //6. Mapa z przyporządkowanymi liczbami powtórzeń do inicjałów

        Set<String> initialsSet = new HashSet<>();
        Map<String, Integer> initialsAndTheirQuantity = new HashMap<>();
        char[] initialsChar = new char[2];
        String initialsString;

        for (int i = 0; i < people.size(); i++) {
            initialsChar[0] = people.get(i).getFirstName().charAt(0);
            initialsChar[1] = people.get(i).getLastName().charAt(0);
            initialsString = new String(initialsChar);
            initialsSet.add(initialsString);
        }
        List<String> initialsList = new ArrayList<>(initialsSet);
        for(int j = 0; j < initialsList.size(); j++) {

            int initialCount = 0;
            for (int i = 0; i < people.size(); i++) {
                initialsChar[0] = people.get(i).getFirstName().charAt(0);
                initialsChar[1] = people.get(i).getLastName().charAt(0);
                String initial = new String(initialsChar);
                if (initial.equals(initialsList.get(j))) {
                    initialCount++;
                }
                initialsAndTheirQuantity.put(initialsList.get(j), initialCount);
            }
        }
        System.out.println("This is a table with initials of people on the with the number of times they are used: " + initialsAndTheirQuantity);


        //7. Porównanie dwóch list, oraz usunięcie powtarzających się w drugiej liście identycznych osób.

        List<Person> secondListOfPeople = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            int age = (int) ((Math.random() * 99) + 1);
            String firstName = firstNames.get(new Random().nextInt(firstNames.size()));
            String lastName = lastNames.get(new Random().nextInt(lastNames.size()));
            Sex sex = Sex.randomSex();
            secondListOfPeople.add(new Person(firstName, lastName, sex, age));
        }
        secondListOfPeople.removeIf(people::contains); //zrobiłem tak: Person -> people.contains(Person) ale IntelliJ podpowiedział tak jak zostawiłem
        System.out.println("Number of people on the first list is: " + people.size() + ".\n" + "People who were also on the second list were removed from second list. Now second list contains " + secondListOfPeople.size() + " people.");
    }
}

