package core.homework.homework5;

public class StudentService {
    private static void printInfo(Student student) {
        System.out.println("Name: " + student.getName() + "\n" +
                "Surname: " + student.getSurname() + "\n" +
                "Year: " + student.getYear() + "\n" +
                "Sex: " + student.getSex() + "\n" +
                "Mark: " + student.getMark() + "\n\n");
    }

    public static void printFullName(Student[] students) {
        System.out.println("Task 1: Print Full Names of Students\n");
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getSurname());
        }
        System.out.println("\n");
    }

    public static void printAllMaleStudents(Student[] students) {
        System.out.println("Task 2: Print All Male Students\n");
        for (Student student : students) {
            if (student.getSex() == 'm')
                printInfo(student);
        }
    }

    public static void printAllFemaleStudentsMoreThan50_4(Student[] students) {
        System.out.println("Task 3: Print All Female Students Who's Marks Are More Than 50.4\n");
        for (Student student : students) {
            if (student.getSex() == 'f' && student.getMark() > 50.4)
                printInfo(student);
        }
    }

    public static void printMinMarkStudent(Student[] students) {
        System.out.println("Task 4: Print Student Who Has The Minimum Mark\n");
        float min = Float.MAX_VALUE;
        Student minStudent = null;
        for (Student student : students) {
            if (student.getMark() < min) {
                minStudent = student;
                min = student.getMark();
            }
        }
        if (minStudent != null)
            printInfo(minStudent);
    }

    public static void printElderStudent(Student[] students) {
        System.out.println("Task 5: Print The Elder Student\n");
        int min = Integer.MAX_VALUE;
        Student elder = null;
        for (Student student : students) {
            if (student.getYear() < min) {
                elder = student;
                min = student.getYear();
            }
        }
        if (elder != null)
            printInfo(elder);
    }

    public static void printStudentsSortedByMark(Student[] students) {
        System.out.println("Task 6: Print Students Sorted By Mark\n");
        for (int i = 0; i < students.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].getMark() > students[j + 1].getMark()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped)
                break;
        }
        for (Student student : students) {
            printInfo(student);
        }
    }

    public static void printFemaleStudentsSortedByYear(Student[] students) {
        System.out.println("Task 7: Print Female Students Sorted By Year\n");
        for (int i = 0; i < students.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].getYear() > students[j + 1].getYear()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped)
                break;
        }
        for (Student student : students) {
            if (student.getSex() == 'f')
                printInfo(student);
        }
    }
}
