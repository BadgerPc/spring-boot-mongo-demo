package demo.service;

import com.google.common.base.Strings;
import demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by msanaulla on 12/22/2014.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(String name){
        return personRepository.findByName(name);
    }

    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> getPeople(String place){
        if(Strings.isNullOrEmpty(place)){
            return personRepository.findAll();
        }else{
            return personRepository.findByPlace(place);
        }
    }

}
