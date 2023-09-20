package java.project_Uchilishte;

public class SchoolTest {
    public static void AddObjectsToSchool(School school){
        Teacher teacherGeorgiev = new Teacher("Dimitur", "Georgiev");
        Teacher teacherNikolova = new Teacher("Hristina", "Georgieva");
        
        school.addTeacher(teacherNikolova);
        school.addTeacher(teacherGeorgiev);

        Group groupEnglish = new Group("english");
        groupEnglish.addStudent(new Student("Ivan", "Petrov"));
        groupEnglish.addStudent(new Student("Vasil", null));
    }
}
