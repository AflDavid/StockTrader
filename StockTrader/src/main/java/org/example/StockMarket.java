package org.example;
import java.util.HashMap;
import java.util.Map;

// StockMarket class
class StockMarket {
    private StockManager stockManager = new StockManager();
    private UserManager userManager = new UserManager();
    private TradingStrategy tradingStrategy;

    public void setTradingStrategy(String strategyName) {
        switch (strategyName) {
            case "DayTrading":
                this.tradingStrategy = new DayTradingStrategy();
                break;
            case "LongTermInvesting":
                this.tradingStrategy = new LongTermInvestingStrategy();
                break;
            default:
                throw new IllegalArgumentException("Invalid trading strategy name.");
        }
    }

    public void executeTrade(TradeCommand command, User user) {
        if (tradingStrategy != null) {
            command.execute(user);
            tradingStrategy.executeTrade(command, user);
        } else {
            throw new IllegalArgumentException("Trading strategy not set.");
        }
    }

    @Override
    public String toString() {
        return "StockMarket{" +
                "stockManager=" + stockManager +
                ", userManager=" + userManager +
                ", tradingStrategy=" + tradingStrategy +
                '}';
    }

    // Example Usage
    public static void main(String[] args) {
        // Initialize StockMarket
        StockMarket market = new StockMarket();

        // Create stocks
        Stock appleStock = new Stock("AAPL", 1500.0);
        Stock googleStock = new Stock("GOOGL", 2500.0);

        // Add stocks to StockManager
        market.stockManager.addStock(appleStock);
        market.stockManager.addStock(googleStock);

        // Create users
        User john = market.userManager.registerUser("JohnDoe");
        User alice = market.userManager.registerUser("AliceSmith");

        // Set trading strategy
        market.setTradingStrategy("DayTrading");

        // John buys stocks
        TradeCommand buyAppleCommand = new BuyStockCommand(appleStock, 1);
        market.executeTrade(buyAppleCommand, john);

        // Alice sells stocks
        TradeCommand sellGoogleCommand = new SellStockCommand(googleStock, 1);
        market.executeTrade(sellGoogleCommand, alice);

        // Update stock prices
        appleStock.setPrice(15.0);
        googleStock.setPrice(10.0);

        // Display user portfolios and transaction history
        System.out.println(john);
        System.out.println(alice);
        System.out.println(john.getTransactionHistory().getUserTransactions(john));
        System.out.println(alice.getTransactionHistory().getUserTransactions(alice));

        // Display current trading strategy
        System.out.println("Current Trading Strategy: " + market.tradingStrategy.getStrategyName());
    }
}
