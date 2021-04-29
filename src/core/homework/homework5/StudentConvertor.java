package core.homework.homework5;

public class StudentConvertor {
    public static Student convert(String info) {
        String[] studentInfo = info.split(",");
        return new Student(studentInfo[0], studentInfo[1], Integer.parseInt(studentInfo[2]),
                studentInfo[3].charAt(0), Float.parseFloat(studentInfo[4]));
    }
}
