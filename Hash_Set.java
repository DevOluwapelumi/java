import java.util.HashSet;

public class Hash_Set {
    public static void main(String[] args) {
        HashSet<String> classNames = new HashSet<String>();
        classNames.add("Micheal");
        classNames.add("Sunday");
        classNames.add("John");
        classNames.add("Israel");
        classNames.add("Pelumi"); // This won't be displayed because it doesn't allow repetition.

        // System.out.println(classNames);

        // course_instructor.contain("Joy"); //To get the value be the get method.
        // course_instructor.get("Sunday"); //To get the value be the get method.
        // course_instructor.remove("Isreal"); //To remove the value be the remove
        // method.
        // course_instructor.clear(); //To clear
        // course_instructor.size(); //To get the size.

        for (String names : classNames) {
            System.out.println(names);
        }

        HashSet<Integer> score = new HashSet<Integer>();
        HashSet<Double> balance = new HashSet<Double>();
        HashSet<Boolean> status = new HashSet<Boolean>();
}
}