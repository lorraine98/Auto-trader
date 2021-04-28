import java.util.Random;

public class Seller implements Runnable{

    @Override
    public void run() {
        }

    public void sell (Asset stock){
        while(stock.getCount()<=0){
            Random randomNum = new Random();
            stock.sellStock(randomNum.nextInt(10)+1);
    }
    
    }
}
