package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Person> people = new ArrayList<>();
    private final List<GradeBook> gradeBooks = new ArrayList<>();
    private long nextId = 1;

    public Student enroll(String name) {
        long id = nextId++;
        GradeBook book = new GradeBook(id);
        Student student = new Student(id, name, book);
        people.add(student);
        gradeBooks.add(book);
        return student;
    }

    public void hire(String name, String subject) {
        long id = nextId++;
        Teacher teacher = new Teacher(id, name, subject);
        people.add(teacher);
    }

    public Person findById(long id) {
        for (Person p : people) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new IllegalArgumentException("человек с номером " + id + " не найден");
    }

    public Person findByName(String name) {
        for (Person p : people) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new IllegalArgumentException("человек с именем " + name + " не найден");
    }

    public List<Person> all() {
        return new ArrayList<>(people);
    }

    public void grade(long id, int grade) {
        Person p = findById(id);
        if (p.getClass() == Student.class) {
            for (GradeBook book : gradeBooks) {
                if (book.getStudentId() == id) {
                    book.addGrade(grade);
                    return;
                }
            }
            throw new IllegalArgumentException("зачётка не найдена");
        } else {
            throw new IllegalArgumentException("этому человеку нельзя поставить оценку (он не студент)");
        }
    }

    public double average(long id) {
        for (GradeBook book : gradeBooks) {
            if (book.getStudentId() == id) {
                return book.average();
            }
        }
        throw new IllegalArgumentException("зачётка не найдена");
    }
}
