package netcracker.project.petshop.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import netcracker.project.petshop.other.RandomFieldValue;

@JsonTypeName("crocodile")
public class Crocodile extends WildAnimal {

    public Crocodile() {
        super();
        breed = RandomFieldValue.getRandomBreedForCrocodile();
    }

    private static class Danger {
        private static final Integer DEGREE_OF_DANGER = 8;
    }

    @Override
    public String toString() {
        return "Crocodile{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", breed='" + breed + '\'' +
                ", degreeOfPollution=" + degreeOfPollution +
                '}';
    }
}
