import java.util.Objects;

/**
 * This is the Student class and will contain all your working methods
 *
 * @author Asandile Buthelezi
 */
public class Student {


    //Fields used to store each user data entry
    public int id;
    public String name;
    public int age;
    public String email;
    public String course;


    public Student(int id, String name, int age, String email, String course) {
        //Constructor

        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId() && getAge() == student.getAge() && getName().equals(student.getName()) && getEmail().equals(student.getEmail()) && getCourse().equals(student.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getEmail(), getCourse());
    }

    @Override
    public String toString() {
        return "\nSTUDENT " + "\n----------------------------------------------------------------------" + "\nSTUDENT ID: " + id + "\nSTUDENT NAME: " + name + "\nSTUDENT AGE: " + age + "\nSTUDENT EMAIL: " + email + "\nSTUDENT COURSE: " + course + "\n-----------------------------------------------------------------------";

    }


}
