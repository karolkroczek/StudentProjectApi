package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Student;
import pl.tu.kielce.ediary.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(Long id){
        return studentRepository.findStudentById(id);
    }
    public Student getStudentByEmailAddress(String emailAddress){
        return studentRepository.findStudentByEmailAddress(emailAddress);
    }
    public void updateStudentById(long studentId, Student updateStudent){
        studentRepository.findById(studentId).ifPresent(student -> {
            student.setName(updateStudent.getName());
            student.setSurname(updateStudent.getSurname());
            student.setAddress(updateStudent.getAddress());
            student.setBirthDate(updateStudent.getBirthDate());
            student.setEmailAddress(updateStudent.getEmailAddress());
            student.setPhoneNumber(updateStudent.getPhoneNumber());
            student.setParentPhoneNumber(updateStudent.getParentPhoneNumber());
            student.setParetEmailAddress(updateStudent.getParetEmailAddress());
            student.setParentName(updateStudent.getParentName());
            student.setParentSurname(updateStudent.getParentSurname());

        });
    }

    public void deleteStudentById(long studentId){
        studentRepository.deleteById(studentId);
        System.out.println("Student " + " has been successfully deleted");
    }


    public void addStudent(Student student){
        List<Student> existingStudents = getAllStudents();

        // Sprawdź, czy student o danym PESEL już istnieje
        boolean studentExists = existingStudents.stream()
                .anyMatch(existingStudent -> existingStudent.getPesel().equals(student.getPesel()));

        if (studentExists) {
            System.out.println("A student with this PESEL number already exists");
        } else {
            // Jeśli nie istnieje, dodaj studenta do bazy danych
            studentRepository.save(student);
            System.out.println("A new student has been successfully added");
        }

    }




}
