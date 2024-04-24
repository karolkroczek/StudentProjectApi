package pl.tu.kielce.ediary;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.tu.kielce.ediary.entity.*;
import pl.tu.kielce.ediary.service.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class EDiaryApplication {

	@Transactional
	@Bean
	public CommandLineRunner demo(StudentService studentService, TeacherService teacherService, SubjectService subjectService, GradeService gradeService, LessonService lessonService, SchoolClassService schoolClassService){
		return args -> {

			System.out.println("Serwer uruchomiono poprawnie!");



		};
	}

	public static void main(String[] args) {
		SpringApplication.run(EDiaryApplication.class, args);
	}

}
