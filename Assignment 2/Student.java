/*Part 2*/
public class Student {
    private String firstName;
    private String surname;
    private String gender;
    private String id;
    private int age;

    public Student(String firstName, String surname, String gender, String id, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.gender = gender;
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + surname;
    }

    public String getGender() {
        return gender.equalsIgnoreCase("M") ? "male" : "female";
    }

    public int getAge() {
        return age;
    }
}
