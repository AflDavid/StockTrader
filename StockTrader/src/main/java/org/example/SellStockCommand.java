package org.example;

// SellStockCommand class
class SellStockCommand implements TradeCommand {
    private Stock stock;
    private int quantity;

    public SellStockCommand(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }

    @Override
    public void execute(User user) {
        user.sellStock(stock, quantity);
    }
}
