//Diamond Problem
//Java doesnot support multiple inheritance through classes but it supports multiple inheritance through interfaces.
//Q: A smart home system has device A and Device B. Both devices have same operation that is turnOn.
//soln: Smart device implements both interfaces/method.
interface DeviceA{
    default void turnOn(){
        System.out.println("Device A is turned on");
    }
}
interface DeviceB{
    default void turnOn(){
        System.out.println("Device B is turned on");
    }
}
class SmartDevice implements DeviceA, DeviceB{
    @Override
    public void turnOn(){
        DeviceA.super.turnOn();
        DeviceB.super.turnOn();
}
}
public class SIT_101{
    public static void main(String[] args) {
        SmartDevice op = new SmartDevice();
        op.turnOn();

    }
}