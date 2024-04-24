package pl.tu.kielce.ediary.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.tu.kielce.ediary.entity.Student;

@AllArgsConstructor
@Getter
@Setter
public class StudentResponse {
    private Student userInfo;
    private String role;
}
