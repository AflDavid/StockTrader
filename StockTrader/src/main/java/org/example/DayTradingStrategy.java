package org.example;
import java.util.ArrayList;
import java.util.List;

// DayTradingStrategy class
class DayTradingStrategy implements TradingStrategy {
    @Override
    public void executeTrade(TradeCommand command, User user) {
        // Implement day trading strategy
    }

    @Override
    public double calculateTransactionFee(double amount) {
        // Calculate day trading fee
        return 0.02 * amount; // Placeholder calculation
    }

    @Override
    public String getStrategyName() {
        return "Day Trading";
    }
}
