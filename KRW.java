public class KRW extends Cash {
    private int price = 1;
    private int count = 1000000;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getTotalValue() {
        return price * count;
    }

    public int buyStock(int n){
        int charge = getTotalValue()-80000*n;
        return charge;
    }

    @Override
    public void printInfo() {
        System.out
                .println(String.format("name = KRW, price = %d, count = %d, total = %d", price, count, price * count));
    }
}