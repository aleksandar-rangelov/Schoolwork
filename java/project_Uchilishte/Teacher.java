package java.project_Uchilishte;

import java.util.ArrayList;
import java.io.PrintStream;

class Teacher{

    private String firstName;
    private String lastName;
    private ArrayList<Group> groups;

    public Teacher(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.groups = new ArrayList<Group>();
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public void printGroups(PrintStream output){
        output.printf("Teacher name: %s%s%n", this.firstName, this.lastName);
        output.printf("Group names: %n");
        for (Group group : this.groups){
            group.printStudents(output);
        }   
    }
}