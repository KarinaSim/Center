package netcracker.project.petshop.dao;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import netcracker.project.petshop.model.*;
import org.springframework.stereotype.Repository;

@Repository
@XmlRootElement(name = "animals")
@XmlAccessorType(XmlAccessType.NONE)
public class PetShopStorage {
    private static final String FILENAME = "src/main/resources/storage.json";
    private List<Animal> animals;

    public PetShopStorage() {
        animals = new CopyOnWriteArrayList<Animal>();
    }

    /**
     * Loads animals from file.
     */

    public void loadAnimals() {
        File file = new File(FILENAME);
        ObjectMapper mapper = new ObjectMapper();
        try {
            animals = mapper.readValue(file, PetShopStorage.class).getAnimals();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the list of animals if they are already loaded from file otherwise
     * loads the list of animals in storage at first and then returns it.
     *
     * @return the list of animals.
     */
    @XmlElements({
            @XmlElement(name = "cat", type = Cat.class),
            @XmlElement(name = "dog", type = Dog.class),
            @XmlElement(name = "wolf", type = Wolf.class),
            @XmlElement(name = "crocodile", type = Crocodile.class)
    })
    public List<Animal> getAnimals() {
        if (!animals.isEmpty()) {
            return animals;
        } else {
            loadAnimals();
            return animals;
        }
    }
}
