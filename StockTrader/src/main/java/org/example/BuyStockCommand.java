package org.example;

// BuyStockCommand class
class BuyStockCommand implements TradeCommand {
    private Stock stock;
    private int quantity;

    public BuyStockCommand(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }

    @Override
    public void execute(User user) {
        user.buyStock(stock, quantity);
    }
}
