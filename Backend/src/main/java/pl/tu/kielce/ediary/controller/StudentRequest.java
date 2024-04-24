package pl.tu.kielce.ediary.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.tu.kielce.ediary.entity.Student;

@AllArgsConstructor
@Getter
@Setter
public class StudentRequest {
    private Student studentInfo;
    private String password;
}
