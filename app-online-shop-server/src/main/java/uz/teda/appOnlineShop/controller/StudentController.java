package uz.teda.appOnlineShop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.teda.appOnlineShop.entity.Student;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

private static final List<Student>students= Arrays.asList(
        new Student(4,"Sardor Bobojonov "),
        new Student(2,"Odamboy Egamberdiyev"),
        new Student(3,"Azizbek Jumaboyev "),
        new Student(1,"Jumaniyozov Nizomjon ")

);


    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable Integer studentId){

return students.stream().filter(student -> studentId.equals(student.getStudentId()))
        .findAny()
        .orElseThrow(()->new IllegalStateException("Student "+ studentId+" doesn't exist" ));

    }

}
