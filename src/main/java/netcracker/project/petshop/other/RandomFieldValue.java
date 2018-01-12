package netcracker.project.petshop.other;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomFieldValue {
    private static List<String> listName = Arrays.asList("Vaska", "Mashka", "Timka", "Belka", "Tom");
    private static List<Integer> listCost = Arrays.asList(23411, 15298, 10536, 7981, 34647);
    private static List<String> listCharacter = Arrays.asList("angry", "kind", "funny", "cheerful", "serious");
    private static List<String> listBreedForCat = Arrays.asList("Korat", "Manx", "Nebelung", "Peterbald", "Ragdoll");
    private static List<String> listBreedForDog = Arrays.asList("Bulldog", "Doberman", "Husky", "Collie", "Bobtail");
    private static List<String> listBreedForWolf = Arrays.asList("Steppe", "Tundra", "Mexican", "Arabian", "Polar");
    private static List<String> listBreedForCrocodile = Arrays.asList("Nile", "Siamese", "Australian");
    private static Random random = new Random();

    public static String getRandomName() {
        int index = random.nextInt(listName.size());
        String name = listName.get(index);
        return name;
    }

    public static Integer getRandomCost() {
        int index = random.nextInt(listCost.size());
        Integer cost = listCost.get(index);
        return cost;
    }

    public static String getRandomCharacter() {
        int index = random.nextInt(listCharacter.size());
        String character = listCharacter.get(index);
        return character;
    }

    public static String getRandomBreedForCat() {
        int index = random.nextInt(listBreedForCat.size());
        String breedCat = listBreedForCat.get(index);
        return breedCat;
    }

    public static String getRandomBreedForDog() {
        int index = random.nextInt(listBreedForDog.size());
        String breedDog = listBreedForDog.get(index);
        return breedDog;
    }

    public static String getRandomBreedForWolf() {
        int index = random.nextInt(listBreedForWolf.size());
        String breedWolf = listBreedForWolf.get(index);
        return breedWolf;
    }

    public static String getRandomBreedForCrocodile() {
        int index = random.nextInt(listBreedForCrocodile.size());
        String breedCrocodile = listBreedForCrocodile.get(index);
        return breedCrocodile;
    }

    public static Integer getRandomDegreeOfPollution() {
        int degree = new Random().nextInt(101);
        return degree;
    }
}
