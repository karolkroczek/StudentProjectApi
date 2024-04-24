package pl.tu.kielce.ediary.controller;

import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.Frequency;
import pl.tu.kielce.ediary.service.FrequencyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/frequency")
public class FrequencyController {
    FrequencyService frequencyService;

    @GetMapping()
    public List<Frequency> getAll(){
        return frequencyService.getAll();
    }

    @GetMapping("/{id}")
    public void getFrequencyById(@PathVariable int id){

    }
    @PostMapping
    public void addNewFrequency(){

    }
    @DeleteMapping("/{id}")
    public void deleteFrequency(@PathVariable int id){

    }
}
