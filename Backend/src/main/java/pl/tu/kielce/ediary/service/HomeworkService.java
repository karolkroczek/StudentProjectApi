package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Homework;
import pl.tu.kielce.ediary.repository.HomeworkRepository;

import java.util.List;

@Service
public class HomeworkService {

    private final HomeworkRepository homeworkRepository;

    @Autowired
    public HomeworkService(HomeworkRepository homeworkRepository){
        this.homeworkRepository = homeworkRepository;
    }

    public List<Homework> getAllHomework(){
        return homeworkRepository.findAll();
    }
    public List<Homework> getAllHomeworkByClassId(long id){
        return homeworkRepository.findAllByIdClass(id);
    }


    public void addHomework(Homework homework){
        homeworkRepository.save(homework);
    }

    public void removeHomeworkById(int id){
        homeworkRepository.deleteById(id);
    }







}
