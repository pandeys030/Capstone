//block level synchronization
class BlockSynch_703{
        int available = 10;
        void booking(int seat){
            System.out.println("Hello "+Thread.currentThread().getName());
            System.out.println("Hello "+Thread.currentThread().getName());
            System.out.println("Hello "+Thread.currentThread().getName());
            synchronized (this) {
                 String name = Thread.currentThread().getName();
            if (available > seat) {
                System.out.println("Seat Booked for "+Thread.currentThread().getName());
                available = available - seat;
            }
            else{
                System.out.println("Sorry "+Thread.currentThread().getName()+" No seat available");
                System.out.println("Available seats: "+available);

            }
            System.out.println("BYE "+Thread.currentThread().getName());
            System.out.println("BYE "+Thread.currentThread().getName());
            }
        }
}
public class SIT_703 extends Thread {
    static BlockSynch_703 op;
    int seat;
    public void run(){  

        op.booking(seat);
        
    }
    public static void main(String[] args) {
        op = new BlockSynch_703();
        BlockSynch_703 b = new BlockSynch_703();
        SIT_703 t1 = new SIT_703();
        SIT_703 t2 = new SIT_703();
        t1.seat = 5;
        t2.seat = 3;
        t1.setName("Onkar");
        t2.setName("Alankar");
        t1.start();
        t2.start();
    }
    
}
