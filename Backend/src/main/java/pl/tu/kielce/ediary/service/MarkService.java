package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Marks;
import pl.tu.kielce.ediary.repository.MarksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MarkService {
    private final MarksRepository marksRepository;

    @Autowired
    MarkService(MarksRepository marksRepository){
            this.marksRepository = marksRepository;
    }

    public void addNewMark(Marks mark){
        marksRepository.save(mark);
    }

    public Optional<Marks> getMarksById(int id){
       return marksRepository.findById(id);
    }
    public List<Marks> getMarksByStudentId(long id){
        return marksRepository.findAllByIdStudent(id);
    }


    public void deleteMark(int id){
        marksRepository.deleteById(id);
    }


}
