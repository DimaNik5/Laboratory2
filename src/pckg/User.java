package pckg;

import java.util.Comparator;

public class User {
    private static int count = 0;
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String country;

    public User(int id, String firstName, String lastName, int age, String country) {
        this.id = id;
        if(id >= count) count += id + 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public User(String firstName, String lastName, int age, String country) {
        this.id = count++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public User(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

class UserComparator implements Comparator<User> {

    public static final int ON_LAST_NAME = 0, ON_AGE = 1;
    private final int why;
    UserComparator(int why){
        this.why = why;
    }
    public int compare(User a, User b){
        return switch (why) {
            case ON_LAST_NAME -> a.getLastName().compareTo(b.getLastName());
            case ON_AGE -> a.getAge() - b.getAge();
            default -> 0;
        };
    }
}
