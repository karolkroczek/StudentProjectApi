package pl.tu.kielce.ediary.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.tu.kielce.ediary.entity.Student;
import pl.tu.kielce.ediary.entity.Teacher;

@AllArgsConstructor
@Getter
@Setter
public class TeacherResponse {
    private Teacher userInfo;
    private String role;
}