package java.project_Uchilishte;

import java.util.ArrayList;

public class School {
    private String name;
    private ArrayList<Teacher> teachers;
    private ArrayList<Group> groups;
    private ArrayList<Student> students;
    
    public String getName(){
        return this.name;
    }

    public ArrayList<Teacher> getTeachers(){
        return this.teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public void addGroup(Group group){
        groups.add(group);
        for (Student student: students){
            if (!this.students.contains(student))
                students.add(student);
        }
    }
}
