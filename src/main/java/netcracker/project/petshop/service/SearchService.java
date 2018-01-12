package netcracker.project.petshop.service;

import netcracker.project.petshop.dao.PetShopStorage;
import netcracker.project.petshop.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    @Autowired
    private PetShopStorage storage;

    public SearchService(PetShopStorage storage) {
        this.storage = storage;
    }

    /**
     * Makes search of animals in petshop by name.
     *
     * @param name animal's name.
     * @return the list of animals with specified name.
     */
    public List<Animal> findByName(String name) {
        List<Animal> listAnimal = storage.getAnimals().stream()
                .filter(a -> a.getName().equals(name))
                .collect(Collectors.toList());
        if (listAnimal.isEmpty()) {
            System.out.println("There is no animal with such name");
        }
        return listAnimal;
    }

    /**
     * Makes search of animals in petshop by cost.
     *
     * @param cost animal's cost.
     * @return the list of animals with specified cost.
     */
    public List<Animal> findByCost(Integer cost) {
        List<Animal> listAnimal = storage.getAnimals().stream()
                .filter(a -> a.getCost().equals(cost))
                .collect(Collectors.toList());
        if (listAnimal.isEmpty()) {
            System.out.println("There is no animal with such cost");
        }
        return listAnimal;
    }

    /**
     * Makes search of animals in petshop by character.
     *
     * @param character animal's character.
     * @return the list of animals with specified character.
     */
    public List<Animal> findByCharacter(String character) {
        List<Animal> listAnimal = storage.getAnimals().stream()
                .filter(a -> a.getCharacter().equals(character))
                .collect(Collectors.toList());
        if (listAnimal.isEmpty()) {
            System.out.println("There is no animal with such character");
        }
        return listAnimal;
    }

    /**
     * Makes search of animals in petshop by breed.
     *
     * @param breed animal's breed.
     * @return the list of animals with specified breed.
     */
    public List<Animal> findByBreed(String breed) {
        List<Animal> listAnimal = storage.getAnimals().stream()
                .filter(a -> a.getBreed().equals(breed))
                .collect(Collectors.toList());
        if (listAnimal.isEmpty()) {
            System.out.println("There is no animal with such breed");
        }
        return listAnimal;
    }
}
