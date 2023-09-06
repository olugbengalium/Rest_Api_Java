package com.myapp.marginni.controller;

import com.myapp.marginni.beans.Mymodel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApplicationController {
    //    Mymodel student = new Mymodel(2, "yemi", "debo");
    @GetMapping("/hello")
    public int returnNum() {
        return 5;
    }

    @GetMapping("/student")
    public Mymodel getStudent() {
        return new Mymodel(2, "yemi", "debo");
//        return student;
    }

    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mymodel createStudents(@RequestBody Mymodel student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @PutMapping("/students/{id}/update")
    public Mymodel updateStudent(@PathVariable("id") int studentid, @RequestBody Mymodel student){
        return student;
    }

    @GetMapping("")
    public ResponseEntity<Mymodel> getNewStudent(){
        Mymodel student = new Mymodel(3, "John", "Happy");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("response")
    public ResponseEntity<Mymodel> getTheStudents(){
        Mymodel student = new Mymodel(3, "John", "Happy");
        return ResponseEntity.ok()
                .header("student","John")
                .body(student);
    }

}
