package demo.service;

import demo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by msanaulla on 12/24/2014.
 */
public interface PersonRepository extends MongoRepository<Person, String> {
    public Person findByName(String name);
    public List<Person> findByPlace(String place);
}
