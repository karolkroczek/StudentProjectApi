package pl.tu.kielce.ediary.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.tu.kielce.ediary.entity.Director;

@AllArgsConstructor
@Getter
@Setter
public class DirectorResponse {
    private Director userInfo;
    private String role;

}
