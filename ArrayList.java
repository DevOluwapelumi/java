import java.util.LinkedList;
import java.util.Collections;

public class ArrayList {
    public static void main(String[] args) {
        LinkedList<String> nameOfStudents = new LinkedList<>();
        nameOfStudents.add("Oluwapelumi");
        nameOfStudents.add("Micheal");
        nameOfStudents.add("Esther");
        nameOfStudents.add("Busola");

        System.out.println(nameOfStudents.get(3)); 
        nameOfStudents.set(2, "Titilayo");
        nameOfStudents.remove(1);
        nameOfStudents.clear();
        System.out.println(nameOfStudents.size());

        for (int i = 0; i < nameOfStudents.size(); i++) {
            System.out.println(nameOfStudents.get(i));
        }

        for (String name : nameOfStudents) {
            System.out.println(name);
        }

        LinkedList<Integer> ages = new LinkedList<Integer>();
        // LinkedList<Boolean> ages = new LinkedList<Boolean>();
        // LinkedList<character> ages = new LinkedList<character>();
        // LinkedList<Double> ages = new LinkedList<Double>();
        ages.add(20);
        ages.add(25);
        ages.add(30);
        ages.add(35);
        ages.add(40);

        Collections.sort(ages);
        for (int age : ages) {
            System.out.println(age);
        }

        Collections.sort(nameOfStudents);
         for(String name : nameOfStudents) {
             System.out.println(name);
        }

        // The following methods don't take any arguments
        // ages.addFirst();
        // ages.addLast();
        ages.removeFirst();
        ages.removeLast();
        ages.getFirst();
        ages.getLast();
        // System.out.println(ages.addFirst());
        // System.out.println(ages.addLast());
        System.out.println(ages.removeFirst());
        System.out.println(ages.removeLast());
        System.out.println(ages.getFirst());
        System.out.println(ages.getLast());
    }
}
