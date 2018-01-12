package netcracker.project.petshop.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import netcracker.project.petshop.other.RandomFieldValue;

@JsonTypeName("cat")
public class Cat extends HomeAnimal {

    public Cat() {
        super();
        breed = RandomFieldValue.getRandomBreedForCat();
    }

    private static class Danger {
        private static final Integer DEGREE_OF_DANGER = 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", breed='" + breed + '\'' +
                ", degreeOfPollution=" + degreeOfPollution +
                '}';
    }
}

