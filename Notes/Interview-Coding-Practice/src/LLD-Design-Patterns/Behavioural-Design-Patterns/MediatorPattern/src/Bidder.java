public class Bidder implements Colleague {

    String name;
    AuctionMediator auctionMediator;

    Bidder(String name, AuctionMediator auctionManager) {
        this.name = name;
        this.auctionMediator = auctionManager;
        auctionManager.addBidder(this); // Automatically register bidder with the mediator
    }

    @Override
    public void placeBid(int amount) {
        auctionMediator.placeBid(this, amount); // Place a bid using the mediator
    }

    @Override
    public void receiveBidNotification(int bidAmount) {
        System.out.println("Bidder: " + name + " received the notification that someone has put bid of " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }
}
