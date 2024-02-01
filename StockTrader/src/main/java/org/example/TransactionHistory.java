package org.example;
import java.util.*;

// TransactionHistory class
class TransactionHistory {
    private List<Map<String, Object>> transactions = new ArrayList<>();

    public void addTransaction(String symbol, int quantity, double price, double totalAmount, String transactionType, Date timestamp) {
        Map<String, Object> transaction = new HashMap<>();
        transaction.put("symbol", symbol);
        transaction.put("quantity", quantity);
        transaction.put("price", price);
        transaction.put("totalAmount", totalAmount);
        transaction.put("transactionType", transactionType);
        transaction.put("timestamp", timestamp);
        transactions.add(transaction);
    }

    public List<Map<String, Object>> getUserTransactions(User user) {
        List<Map<String, Object>> userTransactions = new ArrayList<>();
        for (Map<String, Object> transaction : transactions) {
            String symbol = (String) transaction.get("symbol");
            if (user.getPortfolio().containsKey(symbol)) {
                userTransactions.add(transaction);
            }
        }
        return userTransactions;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "transactions=" + transactions +
                '}';
    }
}
