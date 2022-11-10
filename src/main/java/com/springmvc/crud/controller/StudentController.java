package com.springmvc.crud.controller;

import com.springmvc.crud.dao.StudentDAO;
import com.springmvc.crud.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentDAO studentDAO;
    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("students", studentDAO.getAll());
        return "students/all";
    }

    @GetMapping("/{id}")
    public String showStudent(@PathVariable int id, Model model) {
        model.addAttribute("student", studentDAO.getStudent(id));
        return "students/student";
    }

    @GetMapping("/new")
    public String addStudent(@ModelAttribute("student") Student student) {
        return "students/new";
    }

    @PostMapping()
    public String postStudent(@ModelAttribute("student") @Valid Student student,
                              BindingResult result) {
        if (result.hasErrors())
            return "students/new";
        studentDAO.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String editStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentDAO.getStudent(id));
        return "students/edit";
    }

    @PatchMapping("/{id}")
    public String updateStudent(@PathVariable("id") int id,
                                @ModelAttribute("student") @Valid Student student,
                                BindingResult result) {
        if (result.hasErrors())
            return "students/edit";
        studentDAO.editStudent(id, student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentDAO.deleteStudent(id);
        return "redirect:/students";
    }
}
