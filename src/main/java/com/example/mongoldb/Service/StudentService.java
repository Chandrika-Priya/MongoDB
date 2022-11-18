package com.example.mongoldb.Service;

import com.example.mongoldb.Model.Student;
import com.example.mongoldb.Repository.DepartmentRepository;
import com.example.mongoldb.Repository.StudentRepository;
import com.example.mongoldb.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    SubjectRepository subjectRepository;
    public Student createStudent(Student student){
        if(student.getDepartment() != null){
            departmentRepository.save(student.getDepartment());
        }
        if(student.getSubjects() != null && student.getSubjects().size()>0){
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }

    public Student getStudentByNameandEmail(String name, String email) {
        return studentRepository.findByNameAndMailId(name,email);
    }

    public List<Student> getAllByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllBySorting() {
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        return studentRepository.findAll(sort);
    }

    public List<Student> getByDepartmentName(String depName) {
        return studentRepository.findByDepartmentDepartmentName(depName);
    }

    public List<Student> getBySubjectName(String subName) {
        return studentRepository.findBySubjectsSubjectName(subName);
    }

    public List<Student> getByEmailId(String email) {
        return studentRepository.findByMailIdIsLike(email);
    }


    public List<Student> getByNameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> getByDepartmentId(String id) {
        return studentRepository.findByDepartmentId(id);
    }

    public List<Student> getByStudentName(String name) {
        return studentRepository.getByName(name);
    }
}
