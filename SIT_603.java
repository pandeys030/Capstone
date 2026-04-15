class Table_SIT {  
    synchronized void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
class five_sit extends Thread {
    Table_SIT t;

    five_sit(Table_SIT t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }
}
class seven_sit extends Thread {
    Table_SIT t;

    seven_sit(Table_SIT t) {
        this.t = t;
    }

    public void run() {
        t.printTable(7);
    }
}

public class SIT_603 {

    static class Printer {
        public synchronized void print(String message) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {

        Table_SIT obj = new Table_SIT();

        five_sit t1 = new five_sit(obj);
        seven_sit t2 = new seven_sit(obj);
        t1.start();
        t2.start();
        Printer printer = new Printer();

        Thread th1 = new Thread(() -> printer.print("Hello from Thread 1"));
        Thread th2 = new Thread(() -> printer.print("Hello from Thread 2"));

        th1.start();
        th2.start();
    }
}