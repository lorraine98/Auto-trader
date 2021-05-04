
public class Trader implements Runnable {
    private Stock stock;
    private Cash cash;
    private GoldmanSachs goldmanSachs;
    private boolean isBuyer;

    public Trader(Stock stock, Cash cash, GoldmanSachs goldmanSachs, boolean isBuyer) {
        this.stock = stock;
        this.cash = cash;
        this.goldmanSachs = goldmanSachs;
        this.isBuyer = isBuyer;
    }

    public void run() {
        if (isBuyer) {
            while (goldmanSachs.buy(stock, cash)) {
                try {
                    Thread.sleep(50);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        } else {
            while (goldmanSachs.sell(stock, cash)) {
                try {
                    Thread.sleep(50);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

}