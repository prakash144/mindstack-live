// Mediator Interface
public interface AuctionMediator {
    void addBidder(Colleague bidder);      // Adds bidder to the auction
    void placeBid(Colleague bidder, int bidAmount);  // Places a bid and notifies other bidders
}