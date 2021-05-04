import java.util.Random;

public class CathieWood implements Runnable {
    Random random = new Random();
    private Stock stock;
    private Cash cash;

    public CathieWood(Stock s, Cash c) {
        stock = s;
        cash = c;
    }

    public synchronized boolean buy() {
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

    public synchronized void reportTrading() {
        System.out.println("---------CathieWood Trading Report---------");
        cash.printInfo();
        stock.printInfo();

    }

    public void run() {
        while (buy()) {
            reportTrading();
        }
    }
}
