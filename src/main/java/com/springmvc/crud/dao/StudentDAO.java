package com.springmvc.crud.dao;

import com.springmvc.crud.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StudentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Student> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> students = session.createQuery("select s from Student s", Student.class).getResultList();
        System.out.println(students);
        return students;
    }
    @Transactional
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }
    @Transactional
    public void editStudent(int id, Student updatedStudent) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        student.setGpa(updatedStudent.getGpa());
        student.setName(updatedStudent.getName());
    }
    @Transactional
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        session.remove(student);
    }
    @Transactional
    public void save(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }
}
