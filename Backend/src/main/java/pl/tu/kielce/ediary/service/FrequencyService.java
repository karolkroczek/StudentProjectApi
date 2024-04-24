package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Frequency;
import pl.tu.kielce.ediary.repository.FrequencyRepository;

import java.util.List;

@Service
public class FrequencyService {

    private final FrequencyRepository frequencyRepository;

    @Autowired
    FrequencyService(FrequencyRepository frequencyRepository){
        this.frequencyRepository = frequencyRepository;
    }

    public List<Frequency> getAll(){
        return frequencyRepository.findAll();
    }
}
