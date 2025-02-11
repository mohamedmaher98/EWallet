package main.project.service;

import main.project.model.*;

import java.util.Scanner;
import java.util.stream.Stream;

public class ApplicationServiceImpl implements ApplicationService {

    private int count = 0;
    Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome Sir");


        // 1.TODO please apply mulite choose for 4 times
        while (count < 4) {
            System.out.println("Please Enter your choose");
            System.out.println("a.login     b.signup   c.exit");
            char choose = scanner.next().charAt(0);
            switch (choose) {
            case 'a':
                login();
                break;
            case 'b':
                signup();
                break;
            case 'c':
                System.out.println("you are welcome.");
                break;
            default:
                System.out.println("Invalid Choose");
                count++;
            }

            if (count==3)
            {
                System.out.println("Try Again Later");
            }
        }

    }

    private void signup() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter User name");
        String name = scanner.nextLine();

        System.out.println("Please Enter password");
        String password = scanner.nextLine();

        ValidationService validationService = new ValidationServiceImpl();

        // 2.TODO Validation on UserName and Password
        if (!validationService.validateUserName(name)) { // "eslam"
            System.out.println("Invalid UserName");
            count++;
            return;
        }

        if (!validationService.validatePassword(password)) {
            System.out.println("Invalid Password");
            count++;
            return;
        }


        // 3.TODO SERVICE OF ACCOUNT TO CREATE ACCOUNT

        AccountService accountService = new AccountServiceImpl();
        Account account = new Account(name, password);
        // 4.TODO   impl createAccount
        boolean isAccountCreated = accountService.createAccount(account);
        if (isAccountCreated) {
            System.out.println("Account Created");
        } else {
            System.out.println("Account not Created Because There exist account with same user name");
            count++;
        }

    }

    private void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter User name");
        String name = scanner.nextLine();

        System.out.println("Please Enter password");
        String password = scanner.nextLine();

        ValidationService validationService = new ValidationServiceImpl();

        // TODO Validation on UserName and Password
        if (!validationService.validateUserName(name)) {
            System.out.println("Invalid UserName");
            return;
        }

        if (!validationService.validatePassword(password)) {
            System.out.println("Invalid Password");
            return;
        }

        AccountService accountService = new AccountServiceImpl();
        // 8.TODO SERVICE OF ACCOUNT TO LOGIN
        if (accountService.loginAccount(new Account(name, password))) {
            System.out.println("Login Success");
            services(name);
        } else {
            System.out.println("Account not Exist");
        }
    }

    private void services(String name)
    {

        System.out.println("1.Deposit   2.Withdraw    3.show details    4.Transfer    5. show balance   6.exit  7.logout");

        // TODO create switch case such as on run function
        // TODO every case on switch call function  don't forget (Invalid choose)

        Ewallet ewallet = Ewallet.getInstance();
        Account account = ewallet.getAccounts().stream().filter(l -> l.getUserName().equals(name)).findAny().orElse(new Account());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + name);

        // 1.TODO please apply mulite choose for 4 times
        int count1 = 0;
        while (count1 < 4)
        {
            char choose = scanner.next().charAt(0);
            switch (choose)
            {
            case '1':
                deposit(account);
                break;
            case '2':
                withdraw(account);
                break;
            case '3':
                showDetails(account);
                break;
            case '4':
                transfer(account);
            case '5':
                showBalance(account);
            default:
                System.out.println("Invalid Choose");
                count++;
            }

            if (count == 3)
            {
                System.out.println("Try Again Later");
            }
        }
    }

    // TODO create deposit function
    void deposit(Account a)
    {
        // input int money
        System.out.println("enter the amount of the money you want to deposit");
        Scanner scanner = new Scanner(System.in);
        double mo = scanner.nextDouble();
        // TODO pls validate money >= 100 and <= 20000
        if (mo < 100 || mo > 20000)
            System.out.println("not valid amount");
        else
        {
            System.out.println("money deposit successfully");
            a.setBalance(mo);
        }

    }

    // TODO create Withdraw function
    void withdraw(Account a)
    {
        // input int money
        // TODO pls validate money >= 100 and <= 8000
        System.out.println("enter the amount of the money you want to deposit");

        double mo = scanner.nextDouble();
        if (mo < 100 || mo > 20000)
            System.out.println("not valid amount");
        if (a.getBalance() < mo)
        {
            a.setBalance(a.getBalance() - mo);
            System.out.println("Money withdraw successfully");
        }

    }

    void showDetails(Account a)
    {
        System.out.println("Your User Name : "+ a.getBalance());
        System.out.println("Your password  : "+ a.getBalance());
        System.out.println("Your balance  : "+ a.getBalance());
        System.out.println("Your Active State : "+ a.getBalance());
    }


    void transfer(Account withdrawAccount)
    {
        // TODO USER MUST give me user name of account that will transfer
        // TODO input Account depositAccount
        // TODO input int money
        System.out.println("enter the name of the account you want to transfer to ");
        String withdrawName= scanner.next();
        ValidationServiceImpl service = new ValidationServiceImpl();
        boolean isExsit = service.validateAccountIsExsit(withdrawName);
        if(isExsit)
        {
            System.out.println("enter the amount of the money you want to transfer");
            double mo = scanner.nextDouble();
            // here
        }

    }

    void showBalance(Account a)
    {
        System.out.println("Your balance  : "+ a.getBalance());
    }
}

