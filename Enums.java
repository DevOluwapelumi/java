            // JAVA Enumeration //

    // enum Info{
    //     NAME,
    //     CLASS,
    //     SCORE,
    //     SUBJECT
    // }

    // Info class = Info.CLASS;




    // public class Enums{
    //     enum Info{
    //         PELUMI,
    //         LEVEL5,
    //         SCORE100,
    //         JAVA
    //     }

    //     public static void main(String[] args){
    //         Info myName = Info.LEVEL5;
    //         System.out.println(myName);
    //     }
    // }




    enum Period{
        MORNING,
        AFTERNOON,
        EVENING,
        NIGHT,
        MIDNIGHT
    }

    // public class Enums{
    //     public static void main(String[] args){
    //         Period per = Period.MORNING;
    //         switch ((per)) {
    //             case MORNING:
    //                 System.out.println("Wake up and prepared for School");
    //                  break;
    //             case AFTERNOON:
    //                 System.out.println("I wanna take you for Launch");
    //                  break;
    //             case EVENING:
    //                 System.out.println("Return home before its get dark");
    //                  break;
    //             default:
    //                  break;
    //         }
    //     }
    // }

    
    public class Enums{
        public static void main(String[] args){
        for(Period per : Period.values()){
            System.out.println(per);
        }
        }
    }