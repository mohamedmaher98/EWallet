package main.project.model;

import java.util.ArrayList;
import java.util.List;


// pls apply singleton
public class Ewallet {


    private String name = "EraaSoft Cash";

    private static Ewallet instance;

    private List<Account> accounts = new ArrayList<>();

    private Ewallet() {

    }

    public static Ewallet getInstance() {
        if (instance == null)
            return instance = new Ewallet();
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
