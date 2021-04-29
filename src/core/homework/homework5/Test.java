package core.homework.homework5;

public class Test {
    public static void main(String[] args) {
        //String[] studentsList = FileService.readLines("C:\\Users\\Hayk_Avdalyan\\Desktop\\students.txt")
        String[] studentsList = FileService.readLines(
                "C:\\Users\\User\\PicsArt Academy\\src\\core\\homework\\homework5\\students_info.txt");
        Student[] students = new Student[studentsList.length];

        for (int i = 0; i < studentsList.length; i++) {
            students[i] = StudentConvertor.convert(studentsList[i]);
        }

        StudentService.printFullName(students);
        StudentService.printAllMaleStudents(students);
        StudentService.printAllFemaleStudentsMoreThan50_4(students);
        StudentService.printMinMarkStudent(students);
        StudentService.printElderStudent(students);
        StudentService.printStudentsSortedByMark(students);
        StudentService.printFemaleStudentsSortedByYear(students);
    }
}
