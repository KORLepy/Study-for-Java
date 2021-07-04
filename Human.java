
public class Human {
	private String name = "°­±Ô";
	private int age = 25;
	private int maxHealth = 50;
	private String account = "";
	private String card = "";
	private Bank bank;
	private int i = 0;
	

	public Human(Bank bank) {

		this.bank = bank;
		this.account = bank.getName() + " " + bank.getCode();
		
	}

	public String getName() {
		return this.name;
	}
	
	public String getAccount() {
		return this.account;
	}
	
	public void setHuman(String name, int age, int Health) {
		this.name = name;
		this.age = age;
		this.maxHealth = Health;
	}
	
}