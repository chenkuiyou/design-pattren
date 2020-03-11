package FactoryMethon;

/**
 * @author cky
 * @create 2020 03 11 19:08
 */
public class DogFactory implements PetFactory{
    @Override
    public Pet createPet() {
        return  new Dog();
    }
}
