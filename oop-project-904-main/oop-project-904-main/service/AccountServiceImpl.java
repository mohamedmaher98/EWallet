package main.project.service;

import main.project.model.Account;
import main.project.model.Ewallet;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private Ewallet ewallet = Ewallet.getInstance();

    @Override
    public boolean createAccount(Account account) {
        // 5.TODO get List of Account on Ewallet and make sure that not any account with same user name
        // 6.TODO if not exist any account not has same username add account and return true
        // 7.TODO else return false

        List<Account> newAcs = new ArrayList<>();
        if (ewallet.getAccounts().isEmpty()) {
            newAcs.add(account);
            ewallet.setAccounts(newAcs);
            return true;
        }
        for (Account acc : ewallet.getAccounts()) {
            if (acc.getUserName().equals(account.getUserName()))
                return false;
        }

        newAcs.add(account);
        ewallet.setAccounts(newAcs);
        return false;
    }

    @Override
    public boolean loginAccount(Account account) {
        // TODO get List of Account on Ewallet and make sure that exist account with same user name and password
        // TODO if exist any account  has same username and password return true
        // TODO else return false
        for (Account a : ewallet.getAccounts()) {
            if (a.getUserName().equals(account.getUserName()) && a.getPassword().equals(account.getPassword()))
                return true;
        }
        return false;
    }

    @Override
    public boolean deposite(Account account) {

        // TODO create function with name deposit that return
        // TODO true if deposit success
        // TODO false if deposit fail
        // TODO check if account exist on wallet or not if not print account not exist
        // TODO check if account is active or not  if not print account not active
        // TODO make deposit
        if (!loginAccount(account)) {
            System.out.println("account not exist");
            return false;
        }
        if (!account.getActive()) {
            System.out.println("account not active");
            return false;
        }
        return true;

    }

    // TODO without duplication
    // TODO make withdraw
    // TODO create function with name withdraw that return
    // TODO true if withdraw success
    // TODO false if withdraw fail
    // TODO check if account exist on wallet or not if not print account not exist
    // TODO check if account is active or not  if not print account not active
    // TODO check if account balance is greater than  money if not print can't deposit because ....
    // TODO make without


    // Transfer Account depositAccount, Account withdrawAccount, int money
    // TODO without duplication
    // TODO make Transfer
    // TODO create function with name transfer that return
    // TODO true if transfer success
    // TODO false if transfer fail
    // TODO check if depositAccount and withdrawAccount exist on wallet or not if not print account not exist
    // TODO check if depositAccount and withdrawAccount is active or not  if not print account not active
    // TODO check if withdrawAccount balance is greater than money if not print can't deposit because ....

    // TODO SHOW Account Details


    // TODO SHOW show Balance
}
