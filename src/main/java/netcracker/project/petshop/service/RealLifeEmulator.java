package netcracker.project.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;
import static netcracker.project.petshop.service.PetshopService.createRandomAnimal;

@Service
public class RealLifeEmulator {
    @Autowired
    private PetshopService petshop;
    @Autowired
    private BuySellService buySellService;

    public RealLifeEmulator(PetshopService petshop, BuySellService buySellService) {
        this.petshop = petshop;
        this.buySellService = buySellService;
    }

    /**
     * Makes work of petshop.
     */
    public void work() {
        int number = 0;
        try {
            for (int i = 0; i < 10; i++) {
                number = new Random().nextInt(3);
                switch (number) {
                    case 0:
                        petshop.runAway(petshop.getRandomAnimal());
                        break;
                    case 1:
                        buySellService.sell(petshop.getRandomAnimal());
                        break;
                    case 2:
                        buySellService.buy(createRandomAnimal());
                        break;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("MainThread is interrupted");
        }
    }
}
