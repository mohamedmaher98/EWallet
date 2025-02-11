package main.project.service;

import main.project.model.Account;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean validateUserName(String userName) {

        // TODO return true if userName start with upper case and length must be greater than or equal 3 --> Done
        if (userName.length() > 3) {
            return Character.isUpperCase(userName.charAt(0));
        }
        return false;
    }

    @Override
    public  boolean validatePassword(String password) {
        boolean checkUpper = false;
        boolean checkLower = false;
        boolean checkDigit = false;
        boolean checkSpecial = false;
        // TODO return true if password contain number , uppercaseChar, lowerCase char, size greater than or equal 6 and special char --> Done
        if (password.length() >= 6) {
            for (int i = 0; i < password.length(); i++) {
                if (checkSpecial && checkLower && checkDigit && checkUpper) {
                    return true;
                }
                if (Character.isLetter(password.charAt(i))) {
                    if (Character.isUpperCase(password.charAt(i))) {
                        checkUpper = true;
                    } else if (Character.isLowerCase(password.charAt(i)))
                        checkLower = true;
                } else if (Character.isDigit(password.charAt(i))) {
                    checkDigit = true;
                } else if (!Character.isLetterOrDigit(password.charAt(i))) checkSpecial = true;
            }
        }
        return (checkSpecial && checkLower && checkDigit && checkUpper);
    }

    @Override
    public boolean validateAccountIsExsit(String accName)
    {
        for (Account a : ewallet.getAccounts())
        {
            if (a.getUserName().equals(accName))
                return true;
        }
        return false;
    }
}
