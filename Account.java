import java.util.ArrayList;

public class Account {
	private String account = "";
	private Bank bank;
	private ArrayList list = new ArrayList();
	private int uuid = 0;
	private Human human;
	private int cash = 0;
	private String Card = "";
	private int i = 0;
	
	public void Account(Bank bank, Human human) {
		this.account = human.getAccount();
		this.bank = bank;
		this.human = human;
		
	}
	
	public void outPut(int money) {
		if(this.cash - money < 0) {
			list.add(i, World.date + "일\n행위 : 결재 오류\n금액 : " + money + "\n잔액 : " + this.cash);
			i++;
		}
		else if(money <= 0) {
			list.add(i, World.date + "일\n행위 : 결재 금액 오류\n금액 : " + money + "\n잔액 : " + this.cash);
			i++;
		}
		else {
			this.cash = this.cash - money;
			list.add(i, World.date + "일\n행위 : 결재 성공\n금액 : " + money + "\n잔액 : " + this.cash);
			i++;
		}
	}
	
	public void inPut(int money) {
		if(money > 0) {
			this.cash = this.cash + money;
			list.add(i, World.date + "일\n행위 : 입금 성공\n금액 : " + money + "\n잔액 : " + this.cash);
			i++;
		}
		else {
			list.add(i, World.date + "일\n행위 : 입금 금액 오류\n금액 : " + money + "\n잔액 : " + this.cash);
			i++;
		}
	}
	
	public void List() {
		for(int j = 0 ; j < this.list.size() ; j++) {
			System.out.println(list.get(j));
			System.out.println("-------------------------------");
		}
	}
	
	public String getCard() {
		return this.Card;
	}
	
	public int getUUID() {
		return this.uuid;
	}
	
	public void makeCard() {
		Card card = new Card();
		card.makeCard(this);
		this.uuid = card.getUUID();
	}
	
	public String getAccount() {
		return this.account;
	}
	
	public int getCash() {
		return cash;
	}
}
