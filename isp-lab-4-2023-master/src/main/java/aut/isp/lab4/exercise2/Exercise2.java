package aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("ACME", "F500");

        fishFeeder.fillUp();
        System.out.println(fishFeeder);

        fishFeeder.feed();
        System.out.println(fishFeeder);
    }
}
