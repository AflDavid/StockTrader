package org.example;
import java.util.ArrayList;
import java.util.List;

// TradingStrategy interface
interface TradingStrategy {
    void executeTrade(TradeCommand command, User user);

    double calculateTransactionFee(double amount);

    String getStrategyName();
}
