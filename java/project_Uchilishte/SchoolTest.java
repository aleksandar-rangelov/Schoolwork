package java.project_Uchilishte;


public class SchoolTest {
    public static void AddObjectsToSchool(School school){
        Teacher teacherGeorgiev = new Teacher("Dimitur", "Georgiev");
        Teacher teacherNikolova = new Teacher("Hristina", "Georgieva");
        
        school.addTeacher(teacherNikolova);
        school.addTeacher(teacherGeorgiev);

        Group groupEnglish = new Group("english");
        groupEnglish.addStudent(new Student("Ivan", "Petrov"));
        groupEnglish.addStudent(new Student("Vasil", "Todorov"));
        groupEnglish.addStudent(new Student("Elena", "Mihailova"));
        groupEnglish.addStudent(new Student("Radoslav", "Georgiev"));
        groupEnglish.addStudent(new Student("Milena", "Stefanova"));
        groupEnglish.addStudent(new Student("Ivan", "Petrov"));
        
        school.addGroup(groupEnglish);
        teacherNikolova.addGroup(groupEnglish);

        // Add the French group
        Group groupFrench = new Group("French");
        groupFrench.addStudent(new Student("Petar", "Petrov"));
        groupFrench.addStudent(new Student("Vasil", "Vasilev"));

        school.addGroup(groupFrench);
        teacherNikolova.addGroup(groupFrench);

        Group groupInformatics = new Group("Informatics");
        groupInformatics.addStudent(new Student("Milka", "Koleva"));
        groupInformatics.addStudent(new Student("Pencho", "Toshev"));
        groupInformatics.addStudent(new Student("Iva", "Borisova"));
        groupInformatics.addStudent(new Student("Milena", "Ivanova"));
        groupInformatics.addStudent(new Student("Hristo", "Todorov"));

        school.addGroup(groupInformatics);
        teacherGeorgiev.addGroup(groupInformatics);
    }

    public static void main(String[] args){
        School school = new School("Svoboda");

        AddObjectsToSchool(school);
        for (Teacher teacher : school.getTeachers()) {
            teacher.printGroups(System.out);
            System.out.println();
        }
    }
}
