public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("This is my first commit");
        double sum = 0;
        for (int i = 1; i < 100; i++){
            double a = 1000 * Math.pow(1.09,i);
            sum += a;
        }
        System.out.println(sum);
    }
}
