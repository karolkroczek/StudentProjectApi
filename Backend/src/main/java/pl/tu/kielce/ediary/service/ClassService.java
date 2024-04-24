package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.tu.kielce.ediary.entity.SchoolClass;
import pl.tu.kielce.ediary.repository.ClassRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    private final ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository){
        this.classRepository = classRepository;
    }


    public List<SchoolClass> getAllClass(){
        return classRepository.findAll();
    }

    public Optional<SchoolClass> findById(int id){
        return  classRepository.findById(id);
    }

    public void addClass(SchoolClass class_){
        classRepository.save(class_);
    }

    public void deleteClass(int id){
        classRepository.deleteById(id);
    }





}
