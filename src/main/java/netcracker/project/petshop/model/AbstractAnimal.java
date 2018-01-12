package netcracker.project.petshop.model;

import netcracker.project.petshop.other.RandomFieldValue;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.PROPERTY)
public abstract class AbstractAnimal implements Animal {
    protected String name;
    protected Integer cost;
    protected String character;
    protected String breed;
    protected Integer degreeOfPollution;

    protected AbstractAnimal() {
        name = RandomFieldValue.getRandomName();
        cost = RandomFieldValue.getRandomCost();
        character = RandomFieldValue.getRandomCharacter();
        degreeOfPollution = RandomFieldValue.getRandomDegreeOfPollution();
    }

    @XmlAttribute
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public Integer getDegreeOfPollution() {
        return degreeOfPollution;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public void setCharacter(String character) {
        this.character = character;
    }

    @Override
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void setDegreeOfPollution(Integer degreeOfPollution) {
        this.degreeOfPollution = degreeOfPollution;
    }
}
