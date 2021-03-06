package uz.teda.appOnlineShop.controller;

import org.springframework.web.bind.annotation.*;
import uz.teda.appOnlineShop.entity.Student;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagerController {


    private static final List<Student> students = Arrays.asList(
            new Student(1, "Jumaniyozov Nizomjon "),

            new Student(2, "Odamboy Egamberdiyev"),
            new Student(3, "Azizbek Jumaboyev "),
            new Student(4, "Sardor Bobojonov ")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("getAllStudents");
        return students;
    }

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("getStudent");
        return students.stream().filter(student -> studentId.equals(student.getStudentId()))
                .findAny()
                .orElseThrow(()->new IllegalStateException("Student "+studentId+"doesn't exist"));
        //    return students.stream().filter(student -> studentId.equals(student.getStudentId()))
        //            .findAny()
        //            .orElseThrow(()->new IllegalStateException("Student "+ studentId+" doesn't exist" ));
    }

    @PostMapping
    public void registrNewStudent(@RequestBody Student student) {
        System.out.println("registrNewStudent");
        System.out.println(student);

    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {

        System.out.println("updateStudent");
        System.out.println(String.format("%s  %s%n", student, studentId));
    }
}
