package main.project.service;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean validateUserName(String userName) {
        // TODO return true if userName start with upper case and length must be greater than or equal 3
        // else false
        if (!Character.isUpperCase(userName.charAt(0))) {
            System.out.println("User Name Should Start With Upper Case");
            return false;
        }
        if (userName.length() < 3) {
            System.out.println("User Name Should Be At Least 3 Character");
            return false;
        }
        return true;
    }

    @Override
    public boolean validatePassword(String password) {
        // TODO return true if password contain number , uppercaseChar, lowerCase char, size greater than or equal 6 and special char
        // else false
        boolean checkNumber = false;
        boolean checkUpperCase = false;
        boolean checkLowerCase = false;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetter(password.charAt(i))) {
                checkNumber = true;
            }
            if (Character.isUpperCase(password.charAt(i)))
            {
                checkUpperCase = true;
            }
            if (Character.isLowerCase(password.charAt(i))){
                checkLowerCase = true;
            }
        }
        if (!(password.length() >= 6 && checkNumber && checkUpperCase && checkLowerCase)) {
            return true;
        }

        return false;
    }
}
