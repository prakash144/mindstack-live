import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator {

    List<Colleague> colleagues = new ArrayList<>(); // List of all bidders

    @Override
    public void addBidder(Colleague bidder) {
        colleagues.add(bidder); // Add bidder to auction
    }

    @Override
    public void placeBid(Colleague bidder, int bidAmount) {
        // Notify all bidders except the one who placed the bid
        for (Colleague colleague : colleagues) {
            if (!colleague.getName().equals(bidder.getName())) {
                colleague.receiveBidNotification(bidAmount);
            }
        }
    }
}
