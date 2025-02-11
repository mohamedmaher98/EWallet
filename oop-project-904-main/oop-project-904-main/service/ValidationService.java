package main.project.service;

import main.project.model.*;

public interface ValidationService {

    Ewallet ewallet = Ewallet.getInstance();

    boolean validateUserName(String userName);
    boolean validatePassword(String password);
    boolean validateAccountIsExsit(String accName);
}
