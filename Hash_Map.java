import java.util.HashMap;

public class Hash_Map {
    public static void main(String[] args) {
        HashMap<String, String> courseInstructor = new HashMap<>();
        courseInstructor.put("Java", "Oluwapelumi");
        courseInstructor.put("Project Management", "Pelumi");
        courseInstructor.put("HTML", "Busola");
        courseInstructor.put("Python", "Esther");
        courseInstructor.put("Product Design", "Titilayo");
        System.out.println(courseInstructor);

        // Uncomment the following lines if you want to use these methods
        // System.out.println(courseInstructor.get("Java"));
        // courseInstructor.remove("HTML");
        // courseInstructor.clear();
        // System.out.println(courseInstructor.size());

        for (String course : courseInstructor.keySet()) {
            System.out.println(course);
        }
        for (String instructor : courseInstructor.values()) {
            System.out.println(instructor);
        }
        for (String course : courseInstructor.keySet()) {
            System.out.println("Course: " + course + " Instructor: " + courseInstructor.get(course));
        }
        // System.out.println(course_instructor);

        HashMap<String, Integer> inst_age = new HashMap<String, Integer>();
        inst_age.put("Yemi", 28);
        inst_age.put("Blessing", 34);
        inst_age.put("Titilayo", 35);


        HashMap<String, Boolean> inst_status = new HashMap<String, Boolean>();
        inst_status.put("Yemi", true);
        inst_status.put("Blessing", false);

    }
}
