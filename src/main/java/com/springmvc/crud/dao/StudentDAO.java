package com.springmvc.crud.dao;

import com.springmvc.crud.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAO {

    private static int STUDENT_ID = 1;
    private List<Student> students;
    {
        students = new ArrayList<>();
        students.add(new Student(STUDENT_ID++, "Asulan", 3.8));
        students.add(new Student(STUDENT_ID++, "Togzhan", 2.4));
        students.add(new Student(STUDENT_ID++, "Arman", 2.7));
        students.add(new Student(STUDENT_ID++, "Rinat", 3.8));
    }

    /*
    1. showAll
    2. showStudent
    3. editStudent
    4. deleteStudent
    5. save
     */

    public List<Student> getAll() {
        return students;
    }
    public Student getStudent(int id) {
        for (Student s : students)
            if (s.getId() == id)
                return s;
        return null;
    }
    public void editStudent(int id, Student updatedStudent) {
        Student student = getStudent(id);
        student.setName(updatedStudent.getName());
        student.setGpa(updatedStudent.getGpa());
    }
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }
    public void save(Student student) {
        student.setId(STUDENT_ID++);
        students.add(student);
    }
}
