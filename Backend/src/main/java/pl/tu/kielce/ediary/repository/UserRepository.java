package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Marks;
import pl.tu.kielce.ediary.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByEmailAddressAndPassword(String emailAddress, String password);}
