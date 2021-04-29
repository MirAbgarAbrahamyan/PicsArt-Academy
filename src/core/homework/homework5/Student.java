package core.homework.homework5;

public class Student {
    private String name;
    private String surname;
    private int year;
    private char sex;
    private float mark;

    public Student(String name, String surname, int year, char sex, float mark) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.sex = sex;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYear() {
        return year;
    }

    public char getSex() {
        return sex;
    }

    public float getMark() {
        return mark;
    }
}
