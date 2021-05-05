import java.util.Random;

public class GoldmanSachs {

    Random random = new Random();

    public synchronized boolean buy(Stock stock, Cash cash) {
        int n = random.nextInt(20);
        if (cash.getTotalValue() >= n * stock.getPrice() && stock.getCount() >= n) {
            cash.substract(n * stock.getPrice());
            stock.add(n);
            System.out.println("매수 주문이 체결되었습니다.");
            printTradingInfo(stock, cash);
            return true;
        } else {
            System.out.println("주식을 매수할 수 없습니다.");
            return false;
        }

    }

    public synchronized boolean sell(Stock stock, Cash cash) {
        int n = random.nextInt(20);
        if (stock.getCount() >= n && cash.getTotalValue() >= stock.getPrice() * n) {
            cash.add(n * stock.getPrice());
            stock.substract(n);
            System.out.println("매도 주문이 체결되었습니다.");
            printTradingInfo(stock, cash);
            return true;
        } else {
            System.out.println("주식을 매도할 수 없습니다.");
            return false;
        }
    }

    public synchronized void printTradingInfo(Stock stock, Cash cash) {
        cash.printInfo();
        stock.printInfo();
    }

}