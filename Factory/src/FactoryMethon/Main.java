package FactoryMethon;

/**
 * @author cky
 * @create 2020 03 11 19:03
 */
public class Main {
    public static void main(String[] args) {
        PetFactory petFactory=new DogFactory();
        Pet dog=petFactory.createPet();
    }
}
