        //  JavaRegularExpression   //  --- Abbreviate to "Reg_Expn"
        //  This is java code it is called java regular expression A.K.A(REGEX) in javaScript   //



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg_Expn {
    String comment = "This is a java class";

    public static void main(String[] args) {
        // Corrected to use java.util.regex.Pattern and java.util.regex.Matcher
        Pattern pat = Pattern.compile("class", Pattern.CASE_INSENSITIVE);

        Reg_Expn instance = new Reg_Expn(); // Create an instance to access the non-static
                                                                      // variable
        Matcher mat = pat.matcher(instance.comment);
        boolean find = mat.find();

        if (find) {
            System.out.println("We have a match in the text");
        } else {
            System.out.println("No match found in the text");
 }
}
    Regular Expression Compile options
        // Pattern.CASE_INSENSITIVE;
        // Pattern.LITERA;
        // Pattern.UNICODE_CASE;

        // Regular Expression Patterns
        // [afx]
        // [^afx]
        // [0-9]

        
        // Regular Expression Metacharacters
        // | e.g [afx][abc]
        // .
        // ^    ^the
        // $    class$
        // \d
        // \s
        // \b
}