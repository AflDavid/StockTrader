package org.example;
import java.util.ArrayList;
import java.util.List;

// LongTermInvestingStrategy class
class LongTermInvestingStrategy implements TradingStrategy {
    @Override
    public void executeTrade(TradeCommand command, User user) {
        // Implement long-term investing strategy
    }

    @Override
    public double calculateTransactionFee(double amount) {
        // Calculate long-term investing fee
        return 0.005 * amount; // Placeholder calculation
    }

    @Override
    public String getStrategyName() {
        return "Long-Term Investing";
    }
}
