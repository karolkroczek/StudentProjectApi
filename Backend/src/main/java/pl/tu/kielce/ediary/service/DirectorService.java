package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Director;
import pl.tu.kielce.ediary.repository.DirectorRepository;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;
    @Autowired
    DirectorService(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    public Boolean addDirector(Director director){
        if(directorRepository.findAll().toArray().length>=1){
            return false;
        }
        directorRepository.save(director);
        return true;
    }
    public Director getDirectorByEmailAddress(String emailAddress){
        return directorRepository.findDirectorByEmailAddress(emailAddress);
    }
}
