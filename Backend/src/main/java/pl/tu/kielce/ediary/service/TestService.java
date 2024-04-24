package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Test;
import pl.tu.kielce.ediary.repository.TestRepository;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private final TestRepository testRepository;

    @Autowired
    TestService(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    public List<Test> getAllClassTests(Long classId){
        return testRepository.findAllByClassId_Id(classId);
    }

    public void addTestToList(Test homeworksList){
        this.testRepository.save(homeworksList);
    }

    public void deleteTestById(long id){
        this.testRepository.deleteById(id);
    }

}
