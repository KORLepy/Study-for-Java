import java.util.ArrayList;

public class BugerShop implements Workplace {
	int[] number = {10};
	String[] name = {"ġ�����"};
	int[] price = {20};
	boolean trigger = false;
	int i = 0;
	
	String[] staff = new String[4];
	int[] health = new int[4];
	String[] place = new String[4];
	
	//�����Ǹ�
	public int sellBuger(int bugerName, int Number, Bank bank, Account account) {
		if(Number < 0) {
			System.out.println("������ Ȯ�����ּ��� :)");
			return 0;
		}
		if(this.number[bugerName - 1]-Number >= 0) {
			if(bank.payMent(account, price[bugerName - 1] * Number) == 0) {
				this.trigger = false;
			}
			else{
				this.number[bugerName - 1] -= Number;
				trigger = true;
			}
		}
		//�˸°� �Ⱦ��� ��� ī���� ���� ü�� -1
		if(trigger == true) {
			for(int j = 0 ; j < this.staff.length ; j++) {
				if(this.place[j] == "ī����") {
					this.health[j]--;
					
				}
			}
			return price[bugerName - 1] * Number;
		}
		else {
			return 1;
		}
	}

	//���� ���
	@Override
	public void inHuman(String HumanName) {
		if(this.i == 4) {
			System.out.println("������ �� á���ϴ�.");
		}
		else {
			this.staff[i] = HumanName;
			this.health[i] = 100;
			System.out.println("������ ���ԵǾ����ϴ�.");
			i++;
		}
	}

	//���� �ذ�
	@Override
	public void outHuman(String HumanName) {
		for(int j = 0 ; j < this.staff.length ; j++) {
			if(this.staff[j] == HumanName) {
				for(int k = j; k < this.staff.length-1; k++) {
					  this.staff[k] = this.staff[k+1];
					  this.health[k] = this.health[k+1];
					  this.place[k] = this.place[k+1];
					  this.i = k+1;
				}
				this.staff[staff.length] = "";
				this.health[staff.length] = 0;
				this.place[staff.length] = "";
				System.out.println("������ �ذ� �Ǿ����ϴ�.");
				break;
			}
		}
	}

	//���� �޽�
	@Override
	public void timeHuman(String HumanName) {
		for(int j = 0 ; j < staff.length ; j++) {
			if(this.staff[j] == HumanName) {
				this.place[j] = "time";
				break;
			}
		}
	}

	//������ ��ġ ����
	@Override
	public void workPlace(String workplace, String HumanName) {
		for(int j = 0 ; j < this.staff.length ; j++) {
			if(this.staff[j] == HumanName) {
				this.place[j] = workplace;
				break;
			}
		}
	}

	//���� ���� �ý���
	@Override
	public void workHuman() {
		for(int j = 0 ; j < staff.length ; j++) {
			if(staff[j] == "") {
				break;
			}
			System.out.println(j+1 + ". �̸� : " + staff[j] + " | ü�� : " + health[j] + " | ���ϴ� ��� : " + place[j]);
		}
		
	}
}
