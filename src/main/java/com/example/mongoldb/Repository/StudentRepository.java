package com.example.mongoldb.Repository;

import com.example.mongoldb.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    Student findByNameAndMailId(String name, String email);

    List<Student> findByDepartmentDepartmentName(String depName);

    List<Student> findBySubjectsSubjectName(String subName);

    List<Student> findByMailIdIsLike(String email);

    List<Student> findByNameStartsWith(String name);

    List<Student> findByDepartmentId(String id);

    @Query("{\"name\":\"?0\"}")
    List<Student> getByName(String name);
}
