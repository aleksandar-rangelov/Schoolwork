package java.project_Uchilishte;

public class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }
}
