
public class Card {
	private Account account;
	private int uuid = 111;
	private String name = "";
	
	public void makeCard(Account account) {
		this.account = account;
		this.name = account.getCard();
		uuid++;
	}
	
	public int getUUID() {
		return this.uuid;
	}
}
