import java.util.ArrayList;

public class Bank {
	private String name = "Ä«Ä«¿À¹ðÅ©";
	private String code = "ABCJUICE";
	private ArrayList account = new ArrayList();
	private int i = 0;
	
	
	
	public String getName() {
		return this.name;
	}
	
	public String getCode() {
		return this.code;
	}
	

	public void makeAccount(Human human) {
		Account acount = new Account();
		this.account.add(i, this.name + " " + this.code);
		acount.Account(this, human);
		i++;
	}
	
	public void makeCard(Account account) {
		account.makeCard();
	}
	
	public int payMent(Account account, int price) {
		//if(this.Canpayment(account) == true) {
			if(price != 0) {
				account.outPut(price);
			}
			//return 1;
		//}
		return 0;
	}
	
	public boolean Canpayment(Account account) {
		for(int i = 0 ; i < this.account.size() ; i++) {
			if((String)this.account.get(i) == (String)account.getAccount()) {
				return true;
			}
		}
		return false;
	}
}
