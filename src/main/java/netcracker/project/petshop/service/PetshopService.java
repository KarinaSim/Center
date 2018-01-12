package netcracker.project.petshop.service;

import netcracker.project.petshop.dao.PetShopStorage;
import netcracker.project.petshop.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.List;
import java.util.Random;

@Service
public class PetshopService {
    private static final Logger LOGGER = LogManager.getLogger(PetShopStorage.class);
    @Autowired
    private PetShopStorage storage;

    public PetshopService(PetShopStorage storage) {
        this.storage = storage;
    }

    public List<Animal> getAnimalList() {
        return storage.getAnimals();
    }

    /**
     * Makes escape of the animal from petshop.
     * @param animal escaped animal.
     */
    public void runAway(Animal animal) {
        try {
            storage.getAnimals().remove(animal);
            LOGGER.warn("The " + animal.getClass().getSimpleName() + " has run away");
        } catch (NullPointerException e) {
            LOGGER.error("Petshop has gone bankrupt");
        }
    }

    /**
     * Outputs information about animals on the console in xml format.
     */
    public void printAnimalsOnXmlFormat() {
        try {
            JAXBContext context = JAXBContext.newInstance(PetShopStorage.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(storage, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates 1 of 4 species of animals: {@link Cat}, {@link Dog}, {@link Wolf} or {@link Crocodile}.
     *
     * @return random animal.
     */
    public static Animal createRandomAnimal() {
        Animal animal = null;
        Integer number = new Random().nextInt(4);
        switch (number) {
            case 0:
                animal = new Wolf();
                break;
            case 1:
                animal = new Crocodile();
                break;
            case 2:
                animal = new Dog();
                break;
            case 3:
                animal = new Cat();
                break;
        }
        return animal;
    }

    /**
     * Returns random animal from petshop.
     *
     * @return random animal.
     */
    public Animal getRandomAnimal() {
        Animal animal = null;
        int number = 0;
        try {
            number = new Random().nextInt(storage.getAnimals().size());
            animal = storage.getAnimals().get(number);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Storage is empty");
        }
        return animal;
    }
}
