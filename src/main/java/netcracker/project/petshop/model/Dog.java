package netcracker.project.petshop.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import netcracker.project.petshop.other.RandomFieldValue;

@JsonTypeName("dog")
public class Dog extends HomeAnimal {

    public Dog() {
        super();
        breed = RandomFieldValue.getRandomBreedForDog();
    }

    private static class Danger {
        private static final Integer DEGREE_OF_DANGER = 4;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", breed='" + breed + '\'' +
                ", degreeOfPollution=" + degreeOfPollution +
                '}';
    }
}
