package org.example;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class User implements Observer {
    private String username;
    private Map<String, Map<String, Object>> portfolio = new HashMap<>();
    private TransactionHistory transactionHistory = new TransactionHistory();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void buyStock(Stock stock, int quantity) {
        if (!portfolio.containsKey(stock.getSymbol())) {
            portfolio.put(stock.getSymbol(), new HashMap<>());
            portfolio.get(stock.getSymbol()).put("quantity", 0);
            portfolio.get(stock.getSymbol()).put("averagePrice", 0.0);
        }

        double totalCost = stock.getPrice() * quantity;
        transactionHistory.addTransaction(stock.getSymbol(), quantity, stock.getPrice(), totalCost, "BUY", new Date());

        int currentQuantity = (int) portfolio.get(stock.getSymbol()).get("quantity");
        double currentAveragePrice = (double) portfolio.get(stock.getSymbol()).get("averagePrice");

        int newQuantity = currentQuantity + quantity;
        double newAveragePrice = ((currentAveragePrice * currentQuantity) + (stock.getPrice() * quantity)) / newQuantity;

        portfolio.get(stock.getSymbol()).put("quantity", newQuantity);
        portfolio.get(stock.getSymbol()).put("averagePrice", newAveragePrice);
    }

    public void sellStock(Stock stock, int quantity) {
        if (!portfolio.containsKey(stock.getSymbol()) || (int) portfolio.get(stock.getSymbol()).get("quantity") < quantity) {
            throw new IllegalArgumentException("Not enough stocks to sell.");
        }

        double totalSale = stock.getPrice() * quantity;
        transactionHistory.addTransaction(stock.getSymbol(), quantity, stock.getPrice(), totalSale, "SELL", new Date());

        int currentQuantity = (int) portfolio.get(stock.getSymbol()).get("quantity");
        int newQuantity = currentQuantity - quantity;

        portfolio.get(stock.getSymbol()).put("quantity", newQuantity);
    }

    public Map<String, Map<String, Object>> getPortfolio() {
        return portfolio;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof Stock) {
            Stock stock = (Stock) subject;
            System.out.println("User " + username + ": Stock price updated - " + stock.getSymbol() + ": " + stock.getPrice());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", portfolio=" + portfolio +
                ", transactionHistory=" + transactionHistory +
                '}';
    }
}
