package netcracker.project.petshop.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Cat.class, name = "cat"),
        @JsonSubTypes.Type(value = Dog.class, name = "dog"),
        @JsonSubTypes.Type(value = Wolf.class, name = "wolf"),
        @JsonSubTypes.Type(value = Crocodile.class, name = "crocodile")
})
public interface Animal {

    String getName();

    Integer getCost();

    String getCharacter();

    String getBreed();

    Integer getDegreeOfPollution();

    void setName(String name);

    void setCost(Integer cost);

    void setCharacter(String character);

    void setBreed(String breed);

    void setDegreeOfPollution(Integer degreeOfPollution);
}
