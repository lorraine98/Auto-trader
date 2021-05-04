import java.util.Random;

public class Trader implements Runnable {
    Random random = new Random();

    private Stock stock;
    private Cash cash;

    public cathieWood(Stock s, Cash c) {
        stock = s;
        cash = c;
    }

    public michaelBurry(Stock s, Cash c) {
        stock = s;
        cash = c;
    }

    public void run() {
        while (buy()) {
            cathieWoodReporter();
        }
        while (sell()) {
            michaelBurryReporter();
        }
    }

    public boolean buy() {
        int n = random.nextInt(10);
        if (cash.getTotalValue() >= stock.getPrice()) {
            cash.sell(n * stock.getPrice());
            stock.buy(n);
            return true;
        } else {
            System.out.println("no money to buy");
            return false;
        }
    }

    public synchronized void cathieWoodReporter() {
        System.out.println("---------CathieWood Trading Report---------");
        cash.printInfo();
        stock.printInfo();
    }

    public boolean sell() {
        int n = random.nextInt(10);
        if (stock.getCount() > 0) {
            cash.buy(n * stock.getPrice());
            stock.sell(n);
            return true;

        } else {
            System.out.println("no stock to sell");
            return false;
        }
    }

    public synchronized void michaelBurryReporter() {
        System.out.println("---------MichaelBurry Trading Report---------");
        cash.printInfo();
        stock.printInfo();

    }
}