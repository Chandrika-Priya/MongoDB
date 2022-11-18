package com.example.mongoldb.Controller;

import com.example.mongoldb.Model.Department;
import com.example.mongoldb.Model.Student;
import com.example.mongoldb.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("getById/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        studentService.deleteById(id);
        return "deleted";
    }

    @GetMapping("/getByNameandEmail")
    public Student getStudentByNameandEmail(@RequestParam String name,@RequestParam String email){
        return studentService.getStudentByNameandEmail(name,email);
    }

    @GetMapping("/allWithpagination")
    public List<Student> getAllWithPagination(@RequestParam int pageNo,@RequestParam int pageSize){
        return studentService.getAllByPagination(pageNo,pageSize);
    }

    @GetMapping("/allWithSorting")
    public List<Student> getAllBySorting(){
        return studentService.getAllBySorting();
    }

    @GetMapping("/byDepartmentName")
    public List<Student> getByDepartmentName(@RequestParam String depName){
        return studentService.getByDepartmentName(depName);
    }

    @GetMapping("/bySubjectName")
    public List<Student> getBySubjectName(@RequestParam String subName){
        return studentService.getBySubjectName(subName);
    }

    @GetMapping("byEmailId")
    public List<Student> getByEmailId(@RequestParam String email){
        return studentService.getByEmailId(email);
    }

    @GetMapping("/nameStartsWith")
    public List<Student> getByNameStartsWith(@RequestParam String name){
        return studentService.getByNameStartsWith(name);
    }

    @GetMapping("/byDepartmentId")
    public List<Student> getByDepartmentId(@RequestParam String id){
        return studentService.getByDepartmentId(id);
    }

    @GetMapping("/byStudentName")
    public List<Student> getByStudentName(@RequestParam String name){
        return studentService.getByStudentName(name);
    }
}
