import org.apache.logging.log4j.*;

import java.util.Scanner;


public class PasswordLogging {
    private static final byte Password_Length = 8;
    private static final Logger logger = LogManager.getLogger(PasswordLogging.class);

    public void passwordIsValid(String password) throws  Exception {

        boolean uppercase = false;
        boolean lowercase = false;
        boolean isdigit = false;
        boolean isSpecialChar = false;

        String SpecialChars = "{<>,.!@#$%^&*()_+| \\/~`}";
        char[] convertSpecialChars = SpecialChars.toCharArray();

        if (password.length() < Password_Length) {
            throw new Exception("Password should be longer than than 8 characters");
        } else if (password.isEmpty()) {
            throw new Exception("Password should exists!");
        } else {

            char[] characters = password.toCharArray();

            for (int i = 0; i < characters.length; i++) {

                if (Character.isUpperCase(characters[i])) {
                    uppercase = true;

                }
                if (Character.isDigit(characters[i])) {
                    isdigit = true;

                }
                if (Character.isLowerCase(characters[i])) {
                    lowercase = true;

                }
                for (int j = 0; j < convertSpecialChars.length; j++) {

                    if (characters[i] == convertSpecialChars[j]) {
                        isSpecialChar = true;
                    }
                }
            }

            if (!uppercase) {
                throw new Exception("password should have at least one uppercase letter");
            }
            if (!lowercase) {
                throw new Exception("password should have at least one lowercase letter");
            }
            if (!isdigit) {
                throw new Exception("password should have at least one digit");
            }
            if (!isSpecialChar) {
                throw new Exception("password should have at least one special character");
            }


        }
    }
    public  boolean passwordIsOk(String password)throws Exception{
        String SpecialChars = "{<>,.!@#$%^&*()_+| \\/~`}";
        char[] convertSpecialChars = SpecialChars.toCharArray();

        int passwordLength = 1;
        if(password.isEmpty()){

          throw new Exception("Password is never OK!");
        }

        if(password.length() < Password_Length){
            passwordLength = 0;
        }

        char[] characters = password.toCharArray();
        // int[] counter = new int[4];
        int sum =0;
        int isUpper=0, isLower=0, isDigit=0, isChar=0;
        // for(int i : counter){ i=0;}


        for(int i=0; i< characters.length; i++){

            if((Character.isUpperCase(characters[i]))){
                //  counter[0] = 1;
                isUpper = 1;
            }if(Character.isDigit(characters[i])){
                //  counter[1] = 1;
                isDigit = 1;
            }if(Character.isLowerCase(characters[i])) {
                // counter[2] = 1;
                isLower = 1;
            }
            for (int j=0; j< convertSpecialChars.length; j++) {

                if (characters[i] == convertSpecialChars[j]) {
                    //counter[3] = 1;
                    isChar = 1;
                }
            }
        }
        // for(int x : counter){sum += x;}
        sum = (isChar + isDigit + isLower + isUpper + passwordLength);
        return sum >= 3;
    }

    public  static void main(String[] Args) throws Exception {
//
//        logger.debug("This is debug message");
//
//        logger.info("This is info message");
//
//        logger.warn("This is warn message");
//
//        logger.fatal("This is fatal message");
//
//        logger.error("This is error message");

        System.out.println("Please enter your password below !");
        PasswordLogging pw = new PasswordLogging();
        Scanner scanner = new Scanner(System.in);

        String passW = scanner.next();
       try {
           if (pw.passwordIsOk(passW)) {
               logger.debug("User: password is ok!");
           } else {
               logger.debug("User: password is not ok !");
           }
               pw.passwordIsValid(passW);

       }catch(Exception e)
       {

           logger.debug(e.getMessage());

           if((passW.length() >=  Password_Length)){
                logger.error(e.getMessage());
           }


       }


    }
}
