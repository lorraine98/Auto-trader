import java.util.Random;

public class Buyer implements Runnable {
    @Override
    public void run() {
        while (asset[1].getTotalValue() <= 80000) {
            Random randomNum = new Random();
            asset[1].buyStock(randomNum.nextInt(10) + 1);
        }
    }

}
