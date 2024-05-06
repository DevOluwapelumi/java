//     // JAVA ArrayList //
// import java.util.LinkedList;
// import java.util.Collections;

// public class ArrayList{
//     public static void main(String[] args){
//         LinkedList<String> name_of_students = new LinkedList<String>();
//         name_of_students.add("Oluwapelumi");
//         name_of_students.add("Micheal");
//         name_of_students.add("Esther");
//         name_of_students.add("Busola");

//         System.out.println(name_of_students.get(3)); 
//         name_of_students.set(2, "Titilayo");
//         name_of_students.remove(1);
//         name_of_students.clear();
//         name_of_students.size();
//         System.out.println(nameOfStudents.size());

//         for(int i=0; i<name_of_students.size(); i++){
//             System.out.println(name_of_students.get(i));
//         }

//         for (String name : name_of_students) {
//             System.out.println(name);
//         }

//         LinkedList<Integer> age = new LinkedList<Integer>();
//         LinkedList<Boolean> age = new LinkedList<Integer>();
//         LinkedList<character> age = new LinkedList<character>();
//         LinkedList<Double> age = new LinkedList<Double>();
//         age.add(20);
//         age.add(25);
//         age.add(30);
//         age.add(35);
//         age.add(40);

//         Collections.sort(age);
//         for(int i : age) {
//             System.out.println(i);
//         }
//         Collections.sort(name_of_students);
//         for(String name : name_of_students) {
//             System.out.println(name);
//         }

//         age.addFirst(45);
//         age.addLast(45);
//         age.removeFirst(45);
//         age.removeLast(45);
//         age.getFirst(45);
//         age.getLast(45);
//     }

// }






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

        LinkedList<Integer> ages = new LinkedList<>();
        LinkedList<Boolean> ages = new LinkedList<Integer>();
        LinkedList<character> ages = new LinkedList<character>();
        LinkedList<Double> ages = new LinkedList<Double>();
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
        ages.addFirst(10);
        ages.addLast(20);
        ages.removeFirst(30);
        ages.removeLast(40);
        age.getFirst(50);
        age.getLast(60);
        System.out.println(ages.addFirst());
        System.out.println(ages.addLast());
        System.out.println(ages.removeFirst());
        System.out.println(ages.removeLast());
        System.out.println(ages.getFirst());
        System.out.println(ages.getLast());
    }
}
