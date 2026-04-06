//Jack is always excited about sunday. It is favourite day, when he gets to play all day. And goes to cycling with his friends.
//So every time when the months starts he counts the number of sundays he will get to enjoy. Considering the month can start with any day, be it Sunday, Monday…. Or so on.
//Count the number of Sunday jack will get within n number of days. 

import java.util.Scanner;

public class SIT_106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String startDay = sc.next();  
        int n = sc.nextInt();
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        int startIndex = 0;
        for (int i = 0; i < 7; i++) {
            if (days[i].equalsIgnoreCase(startDay)) {
                startIndex = i;
                break;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((startIndex + i) % 7 == 0) { 
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}