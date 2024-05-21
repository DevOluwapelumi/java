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
        // \b   \bcopy  paste\b

        // Pattern.CASE_INSENSITIVE;
    // Pattern.LITERAL;
    // Pattern.UNICODE_CASE;

    // Some other REGEX pattern
    // [afx] This will check if any of the character or all the character exist in
    // the comment.
    // [^afx] This means that any of the characters doesn't exist in the comment
    // [0-9]

    // REGREX Metcharacters......
    // ---> | e.g [afx] | [abc] This is if any of the group exist.
    // ---> . it will check if at least one instance exist.
    // ---> ^ If (e.g ^the starts the word.).
    // ---> $ It check if it is (e.g $the) word that ends the statement.
    // ---> \d It check if everything a digit or can it find a digit.
    // ---> \s It check if there is space between.
    // ---> \b it check if copy ends the statement (\bcopy). and if (paste\b) paste
    // ends the statement.

    // REGEX QUANTIFIER.....
    // ---> + e.g age+, it check if it is only once that age appears.
    // ---> * e.g man*, it check if it doesn't exist or it's more than 1.
    // ---> ? e.g beat?, it check if it 0 or 1 occurrence.
    // ---> n{X} 3{man} if man appears up to 3 times.
    // ---> n{X, Y} 3{me, two} if me and two appears more than 3 times.
}
