package Challenge.WISSEN;

import java.util.*;
import java.util.concurrent.*;

public class Stats {
    public static class StatisticsAggregatorImpl implements StatisticsAggregator {

        Map<String, List<Double>> statistics = new ConcurrentHashMap<>();

        @Override
        public void putNewPrice(String symbol, double price) {
            List<Double> stockPrices;
            if (!statistics.containsKey(symbol)) {
                stockPrices = new ArrayList<>();
                statistics.put(symbol, stockPrices);
            }else
                stockPrices=statistics.get(symbol);
            stockPrices.add(price);
        }

        @Override
        public double getAveragePrice(String symbol) {
            List<Double> stockPrices = statistics.get(symbol);
            if (stockPrices!=null || stockPrices.size()==0)
                return stockPrices.stream().mapToDouble(val->val).average().orElse(0.0);
            else
                return 0.0;
        }

        @Override
        public int getTickCount(String symbol) {
            if (statistics.containsKey(symbol))
                return statistics.get(symbol).size();
            else
                return 0;
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface StatisticsAggregator {
        // This is an input. Make note of this price.
        public void putNewPrice(String symbol, double price);

        // Get the average price
        public double getAveragePrice(String symbol);

        // Get the total number of prices recorded
        public int getTickCount(String symbol);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final StatisticsAggregator stats = new StatisticsAggregatorImpl();
            final Set<String> symbols = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            int threads = Integer.parseInt(inputs[0]);
            ExecutorService pool = Executors.newFixedThreadPool(threads);
            for (int i = 1; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                symbols.add(symbol);
                final double price = Double.parseDouble(tokens[1]);
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        stats.putNewPrice(symbol, price);
                    }
                });

            }
            pool.shutdown();
            try {
                pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (String symbol : symbols) {
                System.out.println(String.format("%s %.4f %d", symbol,
                        stats.getAveragePrice(symbol),
                        stats.getTickCount(symbol)));
            }
        }
        scanner.close();

    }
}