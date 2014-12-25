package demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.config.DatabaseConfig;
import demo.model.Person;
import demo.service.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import demo.service.PersonService;
import java.io.IOException;
import java.util.List;

/**
 * Created by msanaulla on 12/3/2014.
 */
@Controller
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonService personService;

    static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    DatabaseConfig databaseConfig;

    @RequestMapping("/index")
    String index(){
        return "index";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ResponseBody String addNewPerson(@RequestBody String requestBody ) throws IOException {
        Person person = personService.savePerson(objectMapper.readValue(requestBody, Person.class));
        return objectMapper.writeValueAsString(person);
    }

    @RequestMapping(value = "/person/{name}", method = RequestMethod.GET)
    @ResponseBody String getPerson(@PathVariable String name ) throws IOException {
        Person person = personService.getPerson(name);
        return objectMapper.writeValueAsString(person);
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    @ResponseBody String getPeople(@RequestParam(value = "place", required = false)String place) throws JsonProcessingException {
        List<Person> people = personService.getPeople(place);
        return objectMapper.writeValueAsString(people);
    }

}
