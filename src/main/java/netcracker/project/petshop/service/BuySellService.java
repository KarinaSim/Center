package netcracker.project.petshop.service;

import netcracker.project.petshop.dao.DataOnSaleAndPurchase;
import netcracker.project.petshop.dao.PetShopStorage;
import netcracker.project.petshop.model.Animal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuySellService {
    private static final Logger LOGGER = Logger.getLogger(BuySellService.class);
    @Autowired
    private PetShopStorage storage;
    @Autowired
    private DataOnSaleAndPurchase saleAndPurchase;

    public BuySellService(PetShopStorage storage, DataOnSaleAndPurchase saleAndPurchase) {
        this.storage = storage;
        this.saleAndPurchase = saleAndPurchase;
    }

    /**
     * Makes purchase of the animal and outputs information about it.
     *
     * @param animal the animal who is necessary to buy.
     * @see PetShopStorage
     */
    public void buy(Animal animal) {
        storage.getAnimals().add(animal);
        saleAndPurchase.getBoughtAnimals().add(animal);
        LOGGER.info("The " + animal.getClass().getSimpleName() + " is bought for " + animal.getCost() + "$");
    }

    /**
     * Makes sale of the animal and outputs information about it.
     *
     * @param animal the animal who is necessary to sell.
     * @see PetShopStorage
     */
    public void sell(Animal animal) {
        try {
            if (storage.getAnimals().contains(animal)) {
                storage.getAnimals().remove(animal);
                saleAndPurchase.getSoldAnimals().add(animal);
                LOGGER.info("The " + animal.getClass().getSimpleName() + " is sold for " + animal.getCost() + "$");
            }
        } catch (NullPointerException e) {
            LOGGER.error("Petshop has gone bankrupt");
        }
    }
}

