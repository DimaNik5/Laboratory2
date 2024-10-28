package pckg;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static void sortOnLastName(List<User> users){
        users.stream().sorted(new UserComparator(UserComparator.ON_LAST_NAME)).forEach(System.out::println);
    }

    private static void sortOnAge(List<User> users){
        users.stream().sorted(new UserComparator(UserComparator.ON_AGE)).forEach(System.out::println);
    }

    private static Boolean checkAllOlderSevenAge(List<User> users){
        return users.stream().allMatch(user -> user.getAge() > 7);
    }

    private static int middleAge(List<User> users){
        return users.stream().reduce((acc, user) -> new User(acc.getAge() + user.getAge())).get().getAge() / users.size();
    }

    private static int countDifferentCountry(List<User> users){
        return users.stream().map(User::getCountry).collect(Collectors.toSet()).size();
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("First", "Name7", 8, "Russia"));
        users.add(new User("Second", "Name2", 78, "UK"));
        users.add(new User("Third", "Name3", 23, "Chine"));
        users.add(new User("Four", "Name4", 9, "Russia"));
        users.add(new User("Five", "Name5", 18, "UK"));

        System.out.println("\tSorted by LastName:");
        sortOnLastName(users);
        System.out.println("\tSorted by Age:");
        sortOnAge(users);
        System.out.println(checkAllOlderSevenAge(users) ? "Everybody is older 7 age" : "Everybody isn't older 7 age");
        System.out.println("Middle age: " + middleAge(users));
        System.out.println("Count different country: " + countDifferentCountry(users));
    }
}
