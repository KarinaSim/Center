package netcracker.project.petshop.service;

import netcracker.project.petshop.dao.PetShopStorage;
import netcracker.project.petshop.model.Animal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class CleaningJob {
    private static final Logger LOGGER = Logger.getLogger(CleaningJob.class);
    @Autowired
    private PetShopStorage storage;

    public CleaningJob(PetShopStorage storage) {
        this.storage = storage;
    }

    /**
     * Cleans of animals on casual quantity of units in the range
     from 20 to 30% and outputs information about it.
     */
    public void clean() {
        int degreeOfPollution = 0;
        int percentOfCleaning = 20 + new Random().nextInt(31 - 20);

        for (Animal animal: storage.getAnimals()) {
            degreeOfPollution = animal.getDegreeOfPollution();
            degreeOfPollution -= percentOfCleaning;
            if (degreeOfPollution < 0) {
                animal.setDegreeOfPollution(0);
            } else {
                animal.setDegreeOfPollution(degreeOfPollution);
            }
        }
        LOGGER.info("Animals are cleaned");
    }
}
