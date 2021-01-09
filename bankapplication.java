import java.util.*;
public class bankapplication {
    public static void main(final String[] args) {
        final Scanner sc=new Scanner(System.in);
        System.out.println("********************************");
        System.out.println("WELCOME TO VISHAL BANK SERVICES");
        System.out.println("********************************");
        System.out.println("ENTER CUSTOMER NAME:");
        System.out.println("********************************");
        final String customer_name = sc.nextLine();
        System.out.println("********************************");
        System.out.println("ENTER CUSTOMER ID:");
        System.out.println("********************************");
        
        final String c_id = sc.nextLine();
        System.out.println("********************************");
        final Banking obj = new Banking(customer_name, c_id);
        obj.show();
    }
}

class Banking {
    int account_balance=0;
    int last_transcation=0;
    String Customer_name;
    String Customer_id;

    Banking(final String cname, final String cid) {
        Customer_name = cname;
        Customer_id = cid;
    }

    void deposit(final int a_mount) {
        account_balance = account_balance + a_mount;
        last_transcation = a_mount;
        System.out.println("###----Transaction Successful----####");
        System.out.println("Deposited Amount:Rs" + a_mount);
        System.out.println("Account Balance:Rs" + account_balance);
        System.out.println("********************************");

    }

    void withdraw(final int a_mount) {
        if (a_mount <= account_balance) {
            account_balance = account_balance - a_mount;
            last_transcation = -a_mount;
            System.out.println("###----Transaction Successful----####");
            System.out.println("Withdrawn Amount:Rs" + a_mount);
            System.out.println("Account Balance:Rs" + account_balance);
            System.out.println("********************************");

        } else {
            System.out.println("####----You do not have Sufficient balance----####");
            System.out.println("********************************");

        }
    }

    void balaceenquiry() {
        System.out.println("Account Balance:Rs" + account_balance);
        System.out.println("********************************");
    }

    void lasttrans() {
        if (last_transcation > 0) {
            System.out.println("Deposited:Rs" + last_transcation);
            System.out.println("********************************");
        } else if (last_transcation == 0) {
            System.out.println("###----You do not have done any transcations----####");
            System.out.println("********************************");
        } else {
            System.out.println("WithDrawn:Rs" + Math.abs(last_transcation));
            System.out.println("********************************");
        }

    }

    void show() {
        char option = '\0';
        do {
            System.out.println(Customer_name + " choose any options mentioned below:");
            System.out.println("---------------------------------------------------------");
            System.out.println("-----------A-> Withdrawal---------------");
            System.out.println("-----------B-> Deposition---------------");
            System.out.println("-----------C-> Balance Enquiry----------");
            System.out.println("-----------D-> Mini Statement-----------");
            System.out.println("-----------E-> Exit---------------------");
            System.out.println("---------------------------------------------------------");
            final Scanner sc = new Scanner(System.in);
            option = sc.next().charAt(0);
            switch (option) {
                case 'A':
                    System.out.println("********************************");
                    System.out.println("ENTER AMOUNT FOR WITHDRAWAL:");
                    System.out.println("********************************");
                    final int amt = sc.nextInt();
                    withdraw(amt);
                    break;
                case 'B':
                    System.out.println("********************************");
                    System.out.println("ENTER AMOUNT FOR DEPOSITION:");
                    System.out.println("********************************");
                    final int amnt = sc.nextInt();
                         deposit(amnt);
                break;
                case 'C':System.out.println("********************************");
                         balaceenquiry();
                break;
                case 'D':System.out.println("********************************");
                         lasttrans();
                break;
                case 'E':System.out.println("********************************");
                         System.out.println("------Thank You-------");
                         System.out.println("----------------------");
                         System.out.println("--------     ---------");
                break;
                default:System.out.println("********************************");
                        System.out.println("###### CHOOSE OPTIONS CORRECTLY###### ");
                        System.out.println("********************************");
                break;        
                         
            }

        }while(option!='E');
        
    }

};