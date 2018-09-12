package ms;

public class ReverseInteger {

    private int reverseInteger(int num) {
        int result = 0;
        while(num != 0){
            result = (result * 10) + (num % 10);
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverseInteger(-1234));
        System.out.println(ri.reverseInteger(12000));
        System.out.println(ri.reverseInteger(2));
    }

}
