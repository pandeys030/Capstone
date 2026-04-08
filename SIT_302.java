public class SIT_302 {
    public static void main(String[] args){
        int number = 40;
        boolean[] isPrime = new boolean[number];

        for(int i = 2; i < number; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i * i < number; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j < number; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 2; i < number; i++) {
            if(isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}