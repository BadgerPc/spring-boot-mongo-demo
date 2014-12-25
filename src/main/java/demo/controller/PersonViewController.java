package demo.controller;

import demo.model.Person;
import demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by msanaulla on 12/25/2014.
 */
@Controller
public class PersonViewController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/newPerson", method = RequestMethod.GET)
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "person_form";
    }

    @RequestMapping(value = "/savePerson", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute Person person, Model model){
        personService.savePerson(person);
        model.addAttribute("person",person);
        return "person_details";
    }

    @RequestMapping(value = "/personDetails", method = RequestMethod.GET)
    public String showPersonDetails(@RequestParam(value = "name", required = true) String name, Model model){
        Person person = personService.getPerson(name);
        model.addAttribute("person",person);
        return "person_details";
    }
}
