// Colleague Interface representing a bidder
public interface Colleague {
    void placeBid(int amount);               // Method to place a bid
    void receiveBidNotification(int bidAmount);  // Notify when a bid is placed
    String getName();                        // Get the name of the bidder
}