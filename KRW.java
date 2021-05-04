public class KRW extends Cash {
    private int price = 1;
    private int count;

    public KRW(int userCount) {
        count = userCount;
    }

    @Override
    public int buy(int n) {
        return count += n;
    }

    @Override
    public int sell(int n) {
        return count -= n;
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
                .println(String.format("name = KRW, price = %d, count = %d, total = %d", price, count, price * count));
    }
}