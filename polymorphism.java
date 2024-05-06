    //  //polymorphism //

 class chicken{
    public void animalSound(){
        System.out.println("The animal makes a sound");
    }
}

class pig extends Animal{
    public void animalSound(){
        System.out.println("The pig says: wee wee");
}
}

class Goat extends Animal{
    public void animalSound(){
        System.out.println("The goat says: moooo");
    }
}

public class Animal{
    public static void main(String [] args){
        chicken an = new chicken();
        pig pg = new pig();
        Goat gt = new Goat();
        an.animalSound();
        pg.animalSound();
        gt.animalSound();
}
}
