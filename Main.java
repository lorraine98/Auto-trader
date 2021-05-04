public class Main {
    public static void main(String[] args) {
        Asset[] asset = new Asset[] { new Samsung(20), new KRW(1600000) };

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

        Thread cathieWoodThread = new Thread(new CathieWood((Stock) asset[0], (Cash) asset[1]));
        Thread michealBurryThread = new Thread(new MichaelBurry((Stock) asset[0], (Cash) asset[1]));

        cathieWoodThread.start();
        michealBurryThread.start();

    }
}