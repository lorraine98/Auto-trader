public class Main {
    public static void main(String[] args) {
        Seller seller = new Seller();
        Buyer buyer = new Buyer();
        Thread thread = new Thread();
        Asset[] asset = new Asset[] { new Samsung(), new KRW() };

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
        
        seller.run();
        buyer.run();

        seller.sell(asset);

        try {
            thread.join();
        } catch (InterruptedException e) {
        }

        System.out.println("stockSum = " + stockSum);
        System.out.println("cashSum = " + cashSum);
        System.out.println("totalAsset = " + totalAsset);
    }
}