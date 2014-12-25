package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

/**
 * Created by msanaulla on 12/22/2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @Id
    private String id;

    private String name;
    private String place;

    public Person(){}
    public Person(String name, String place){
        this.name = name;
        this.place = place;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
