//Q: Employee management system (Diamond problem)
//this is the classic structure: A-->B, C-->D structure
//Q: Create a real time employee notification system.
// A: employee
// B: email notification
// C: sms notification
//D: Manager
// Both B and C inherit from A. 
interface Employee{
    default void notifyEmployee(){
        System.out.println("Notifying employee...");
    }
}
interface EmailNotification {
    default void notifyEmployee(){
        System.out.println("Notifying employee via Email...");
    }
}
interface SMSNotification {
    default void notifyEmployee(){
        System.out.println("Notifying employee via SMS...");
    }
}
class Manager implements Employee, EmailNotification, SMSNotification{
    @Override
    public void notifyEmployee(){
        Employee.super.notifyEmployee();
        EmailNotification.super.notifyEmployee();
        SMSNotification.super.notifyEmployee();
    }
}
public class SIT_103 {
    public static void main(String[] args) {
        Manager op = new Manager();
        op.notifyEmployee();

    }
}