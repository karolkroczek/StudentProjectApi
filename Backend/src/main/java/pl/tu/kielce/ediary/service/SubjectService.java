package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Subject;
import pl.tu.kielce.ediary.repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public void addSubject(Subject subject){
        subjectRepository.save(subject);
    }

    public void deleteSubjectById(long id){
        subjectRepository.deleteById(id);
    }

    public void updateSubjectById(long id, String name, String desc){
        subjectRepository.findById(id).ifPresent(subject -> {
            subject.setName(name);
            subject.setDescription(desc);
        });
    }








}
