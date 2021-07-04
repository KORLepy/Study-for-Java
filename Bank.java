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
		this.account.add(i, name + " " + code);
		acount.Account(this, human);
		i++;
	}
	
	
}
