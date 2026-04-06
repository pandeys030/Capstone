import java.util.*;

interface UPI{
    default void processPayment(){
        System.out.println("Payment Done using UPI");
    }
}

interface Card{
    default void processPayment(){
        System.out.println("Payment Done using Card");
    }
}

class HybridPaymentSystem implements UPI, Card{
    Scanner sc = new Scanner(System.in);

    @Override
    public void processPayment(){
        System.out.println("Choose the payment method: 1. UPI 2. Card");
        int ch = sc.nextInt();

        if(ch == 1){
            UPI.super.processPayment();
        }
        else if(ch == 2){
            Card.super.processPayment();
        }
        else{
            System.out.println("Invalid choice");
        }
    }
}

public class SIT_102 {
    public static void main(String[] args) {
        HybridPaymentSystem op = new HybridPaymentSystem();
        while(true){
            System.out.println("Do you want to make a payment? (yes/no)");
            String choice = op.sc.next();

            if(choice.equalsIgnoreCase("no")){
                System.out.println("Exiting the payment system.");
                break;
            }
             op.processPayment();

        }
       


    }
}