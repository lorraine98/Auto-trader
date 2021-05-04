public class Main {
    public static void main(String[] args) {
        Asset[] asset = new Asset[] { new Samsung(80), new KRW(6400000) };

        int totalAsset = 0;
        int stockSum = 0;
        int cashSum = 0;
        for (int i = 0; i < asset.length; i++) {
            totalAsset += asset[i].getTotalValue();
            if (asset[i] instanceof Stock) {
                stockSum += asset[i].getTotalValue();
            } else if (asset[i] instanceof Cash) {
                cashSum += asset[i].getTotalValue();
            }
            asset[i].printInfo();
        }

        System.out.println("stockSum = " + stockSum);
        System.out.println("cashSum = " + cashSum);
        System.out.println("totalAsset = " + totalAsset);
        GoldmanSachs goldmanSachs = new GoldmanSachs();
        Thread buyerThread = new Thread(new Trader((Stock) asset[0], (Cash) asset[1], goldmanSachs, true));
        Thread sellerThread = new Thread(new Trader((Stock) asset[0], (Cash) asset[1], goldmanSachs, false));

        buyerThread.start();
        sellerThread.start();

    }
}