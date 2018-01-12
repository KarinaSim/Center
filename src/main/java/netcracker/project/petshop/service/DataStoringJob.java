package netcracker.project.petshop.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import netcracker.project.petshop.dao.PetShopStorage;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataStoringJob {
    private static final Logger LOGGER = LogManager.getLogger(DataStoringJob.class);
    private static final String FILENAME = "src/main/resources/storage.json";
    @Autowired
    private PetShopStorage storage;

    public DataStoringJob(PetShopStorage storage) {
        this.storage = storage;
    }

    /**
     * Saves state of animals in file and outputs information about it.
     *
     * @see PetShopStorage
     */
    public void save() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILENAME);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, storage);
            LOGGER.info("The state of petshop is kept");
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
