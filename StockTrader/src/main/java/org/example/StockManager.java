package org.example;
import java.util.HashMap;
import java.util.Map;


// StockManager class
class StockManager {
    private Map<String, Stock> stocks = new HashMap<>();

    public void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    @Override
    public String toString() {
        return "StockManager{" +
                "stocks=" + stocks +
                '}';
    }
}
