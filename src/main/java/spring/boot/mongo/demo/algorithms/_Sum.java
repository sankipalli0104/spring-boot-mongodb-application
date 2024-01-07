package spring.boot.mongo.demo.algorithms;

public class _Sum {
    public static void main(String args[])
    {
        addUp(10);
    }

    private static void addUp(int n) {
        int sum = n * (n+1)/2;
        System.out.println(sum);
    }
}
