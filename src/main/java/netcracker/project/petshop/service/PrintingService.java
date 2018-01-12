package netcracker.project.petshop.service;

import netcracker.project.petshop.dao.DataOnSaleAndPurchase;
import netcracker.project.petshop.model.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrintingService {
    private static final Logger LOGGER = LogManager.getLogger(PrintingService.class);
    @Autowired
    private DataOnSaleAndPurchase saleAndPurchase;

    public PrintingService(DataOnSaleAndPurchase saleAndPurchase) {
        this.saleAndPurchase = saleAndPurchase;
    }

    /**
     * Outputs information about sold animals.
     *
     * @see DataOnSaleAndPurchase#getSoldAnimals()
     */
    public void printSales() {
        List<Animal> soldAnimals = saleAndPurchase.getSoldAnimals();

        if (soldAnimals.isEmpty()) {
            LOGGER.info("Animals are not sold");
        } else {
            System.out.println("The list of the sold animals:");
            for (Animal animal: soldAnimals) {
                System.out.println(animal.toString());
            }
        }
    }

    /**
     * Outputs information about bought animals.
     *
     * @see DataOnSaleAndPurchase#getBoughtAnimals()
     */
    public void printPurchases() {
        List<Animal> boughtAnimals = saleAndPurchase.getBoughtAnimals();

        if (boughtAnimals.isEmpty()) {
            LOGGER.info("Animals are not bought");
        } else {
            System.out.println("The list of the bought animals:");
            for (Animal animal: boughtAnimals) {
                System.out.println(animal.toString());
            }
        }
    }
}