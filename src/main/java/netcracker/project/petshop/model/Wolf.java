package netcracker.project.petshop.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import netcracker.project.petshop.other.RandomFieldValue;

@JsonTypeName("wolf")
public class Wolf extends WildAnimal {

    public Wolf() {
        super();
        breed = RandomFieldValue.getRandomBreedForWolf();
    }

    private static class Danger {
        private static final Integer DEGREE_OF_DANGER = 9;
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", breed='" + breed + '\'' +
                ", degreeOfPollution=" + degreeOfPollution +
                '}';
    }
}
