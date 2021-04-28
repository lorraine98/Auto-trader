public class Samsung extends Stock {
    private int price = 80000;
    private int count = 15;

    public int sell(int n){
        count = count-n;
        return count;
    }

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

    @Override
    public void printInfo() {
        System.out
                .println(String.format("name = Samsung, price = %d, count = %d, total = %d", price, count, price * count));
    }
}