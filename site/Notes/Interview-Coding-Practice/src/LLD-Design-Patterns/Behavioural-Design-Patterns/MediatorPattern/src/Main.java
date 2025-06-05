/*
        +-----------------------+
        |       Main (Client)    |
        +-----------------------+
                |
                v
        +-----------------------+         +-----------------------+
        |  Auction (Mediator)   | <------ |      Bidder A         |
        +-----------------------+         +-----------------------+
                |                               ^ placeBid(4000)
                | placeBid(3000)                |
                |                               |
        +-----------------------+               |
        |      Bidder B         |<--------------+ placeBid(2000)
        +-----------------------+

    1. Client (Main) creates a mediator (Auction) and bidders.
    2. Bidders place bids through the mediator.
    3. The mediator notifies other bidders when a new bid is placed.

 */
public class Main {
    public static void main(String[] args) {
        // Create Auction mediator
        AuctionMediator auctionMediatorObj = new Auction();

        // Create bidders and add them to the mediator
        Colleague bidder1 = new Bidder("A", auctionMediatorObj);
        Colleague bidder2 = new Bidder("B", auctionMediatorObj);

        // Bidders place bids
        bidder1.placeBid(2000);
        bidder2.placeBid(3000);
        bidder1.placeBid(4000);
    }
}