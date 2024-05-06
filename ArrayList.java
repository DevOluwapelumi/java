    // JAVA ArrayList //
import java.util.ArrayList;

Public class ArrayList{
    public static void main(String[] args){
        ArrayList<String> name_of_students = new ArrayList<String>();
        name_of_students.add("Oluwapelumi");
        name_of_students.add("Micheal");
        name_of_students.add("Esther");
        name_of_students.add("Busola");

        System.out.println(name_of_students.get(3));
        name_of_students.set(2, "Titilayo");
        name_of_students.remove(1);
        name_of_students.clear();
        name_of_students.size();

        for(int i=0; i<name_of_students.size(); i++){
            System.out.println(name_of_students.get(i));
        }
    }

}