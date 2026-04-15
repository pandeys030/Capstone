//multithreading
// step 1: import java.lang pkg
//step 2: a) by extending the thread class b) by implementing the runnable interface
//step 3: initialize the run menthod
//stept 4: 
//step 5: implement the run method 
//step 6: create the number of threads
// step 7: start all the threads
class singleT601 extends Thread{
    public void run(){
        try {
            for (int i = 1; i<=3; i++)
            {
                System.out.println("Thread: " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class SIT_601{
    public static void main(String[] args) {
        try
        {
            for (int i = 0; i<=3;i++)
                {

                    System.out.println("Hello SIT");
                    Thread.sleep(2000);

                }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}