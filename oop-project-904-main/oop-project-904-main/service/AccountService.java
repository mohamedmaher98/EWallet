package main.project.service;

import main.project.model.Account;

import java.util.Stack;

public interface AccountService {

    boolean createAccount(Account account);
    boolean loginAccount(Account account);
    boolean deposite(Account account);
}
