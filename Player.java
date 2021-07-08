
public class Player extends Human {
	
	private Bank bank;
	private boolean check = false;
	private String name;
	private String account;
	private int i = 0;
	private Account acount;
	
	
	public Player(Bank bank, Account acount) {
		super(bank);
		this.bank = bank;
		this.acount = acount;
	}

	//출근
	public void workIn(String name) {
		for(int j = 0 ; j < name.length() ; j++) {
			if(this.name == name) {
				check = true;
			}
			else {
				System.out.println("없는 직원입니다. 대상을 확인해주세요.");
			}
		}
	}
	
	//퇴근
	public void workOut(String name) {
		for(int j = 0 ; j < name.length() ; j++) {
			if(this.name == name) {
				check = false;
			}
			else {
				System.out.println("없는 직원입니다. 대상을 확인해주세요.");
			}
		}
	}

	//직원 추가
	public void addPlayer() {
		this.name = getName();
		this.account = getAccount();
		i++;
	}
	
	//일급 지급
	public void workPay(int pay, String name) {
		if(this.name == name) {
			bank.InpayMent(acount, pay);
		}
	}
	
}