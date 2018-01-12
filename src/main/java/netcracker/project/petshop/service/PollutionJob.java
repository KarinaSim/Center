package netcracker.project.petshop.service;

import netcracker.project.petshop.dao.PetShopStorage;
import netcracker.project.petshop.model.Animal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class PollutionJob {
    private static final Logger LOGGER = Logger.getLogger(PollutionJob.class);
    @Autowired
    private PetShopStorage storage;

    public PollutionJob(PetShopStorage storage) {
        this.storage = storage;
    }

    /**
     * Pollutes of animals on casual quantity of units in the range
     from 20 to 30% and outputs information about it.
     */
    public void pollute() {
        int degreeOfPollution = 0;
        int percentOfPollution = 20 + new Random().nextInt(31 - 20);

        for (Animal animal: storage.getAnimals()) {
            degreeOfPollution = animal.getDegreeOfPollution();
            if (degreeOfPollution > 100) {
                storage.getAnimals().remove(animal);
                LOGGER.warn("The " + animal.getClass().getSimpleName() + " is dead");
            } else {
                degreeOfPollution += percentOfPollution;
                animal.setDegreeOfPollution(degreeOfPollution);
            }
        }
        LOGGER.info("Animals are polluted");
    }
}
