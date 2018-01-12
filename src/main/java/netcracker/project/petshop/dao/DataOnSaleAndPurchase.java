package netcracker.project.petshop.dao;

import netcracker.project.petshop.model.Animal;
import netcracker.project.petshop.service.BuySellService;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DataOnSaleAndPurchase {
    private List<Animal> boughtAnimals;
    private List<Animal> soldAnimals;

    public DataOnSaleAndPurchase() {
        boughtAnimals = new ArrayList<>();
        soldAnimals = new ArrayList<>();
    }

    /**
     * Returns list of animals purchased in the process of work of petshop.
     *
     * @return list of bought animals.
     * @see BuySellService#buy(Animal)
     */
    public List<Animal> getBoughtAnimals() {
        return boughtAnimals;
    }

    /**
     * Returns list of animals sold in the process of work of petshop.
     *
     * @return list of sold animals.
     * @see BuySellService#sell(Animal)
     */
    public List<Animal> getSoldAnimals() {
        return soldAnimals;
    }
}
