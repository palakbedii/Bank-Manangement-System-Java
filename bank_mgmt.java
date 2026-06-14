import java.util.* ;
class bank {
    Scanner sc = new Scanner (System.in) ;
    int age, acc_no, id_no, new_acc, initial_fixed = 10000, initial_money, withdraw_money, deposit_money, total_money ;
    String name, acc_type ;                                      //data members

    void details() {                                             //member function to get data
        System.out.print("Enter your name : ") ;
        name = sc.next() ;
        System.out.print("Enter your age : ") ;
        age = sc.nextInt() ;
        System.out.print("Enter your id card no. : ") ;
        id_no = sc.nextInt() ;
        System.out.print("Which acc type you want (personal/ family): ") ;
        acc_type = sc.next() ;
    }

    void acc_open() {
        System.out.print("Enter the amount you want to add in your new acc [should be >10000] : ") ;
        initial_money = sc.nextInt() ;
        if (initial_money > 10000) {
            new_acc += initial_money ;                              //adding initial money when the acc is created
            System.out.print("ACCOUNT CREATED SUCCESSFULLY !!") ;

            total_money += initial_money ;                           //adding this amt in total money 
            System.out.print("\nTOTAL MONEY in acc : " + total_money) ;
        }
        else
        System.out.print("Amount < 10000 !! \nACCOUNT NOT CREATED !!") ;
    }

    void deposit() {
        System.out.print("Enter the amount you want to deposit : ") ;
        deposit_money = sc.nextInt() ;
        total_money += deposit_money ;
        System.out.print("MONEY DEPOSITED : " + deposit_money + "\nTOTAL MONEY in acc : " + total_money) ;
    }

    void withdraw() {                                            //Check with the previous amount in the bank acc
        System.out.print("Enter the amount you want to WITHDRAW : ") ;
        withdraw_money = sc.nextInt() ;
        if (withdraw_money <= total_money - initial_fixed) {       //OR, withdraw_money <= total_money-10000    //---> IMPORTANT
            total_money = total_money - withdraw_money ;
            System.out.print("MONEY WITHDRAWN : " + withdraw_money + "\nTOTAL BALANCE in acc left : " + total_money) ;
        }
        else {
            System.out.print("LOW BALANCE in acc") ;
        }
    }

    void acc_close() {                // can be done using file handling

    }
}

public class bank_mgmt {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in) ;
        int choice ;

        bank ob = new bank() ;                                   //object of class

        System.out.println("ENTER YOUR PERSONAL DETAILS BELOW : ") ;
        ob.details() ;                                           //calling 'details function'

        System.out.println("-------MENU------- \n 1. ACCOUNT OPEN \n 2. MONEY DEPOSIT \n 3. MONEY WITHDRAW \n 4. ACCOUNT CLOSE \n 5. EXIT MENU") ;
        
        while (true) {
            System.out.println("\nEnter your choice [1 to 5]: ") ;
            choice = sc.nextInt() ;
        
            switch(choice) {
                case 1 :
                ob.acc_open() ;
                break ;

                case 2 :
                ob.deposit() ;
                break ;

                case 3 :
                ob.withdraw() ;
                break ;

                case 4 :
                ob.acc_close() ;
                break ;
            }

            if (choice == 5)
            break ;
        }
    }
}
