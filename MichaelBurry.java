import java.util.Random;

public class MichaelBurry implements Runnable {
    Random random = new Random();
    private Stock stock;
    private Cash cash;

    public MichaelBurry(Stock s, Cash c) {
        stock = s;
        cash = c;
    }

    public synchronized boolean sell() {
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

    public synchronized void reportTrading() {
        System.out.println("---------MichaelBurry Trading Report---------");
        cash.printInfo();
        stock.printInfo();

    }

    public void run() {
        while (sell()) {
            reportTrading();
        }
    }
}
