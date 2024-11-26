package DemergingUsingQueue;

public class Person {
    String name;
    String gender;
    String dayOfBirth;

    public Person(String name, String gender, String dayOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name + " - " + gender + " - " + dayOfBirth;
    }
}
