import java.util.ArrayList;

public class BugerShop implements Workplace {
	//���� ����
	int[] number = {10};
	//���� ����
	String[] name = {"ġ�����"};
	//���� ����
	int[] price = {20};
	
	boolean trigger = false;
	int i = 0;
	//���� ���� �ڱ�
	int money = 5000;
	
	//���� �̸�
	String[] staff = new String[4];
	//���� ü��
	int[] health = new int[4];
	//���� ��ġ
	String[] place = new String[4];
	//���� �ϱ�
	int[] pay = new int[4];
	
	//�����Ǹ�
	public void sellBuger(int bugerName, int Number, Bank bank, Account account) {
		if(Number < 0) {
			System.out.println("������ Ȯ�����ּ��� :)");
		}
		else {
			if(this.number[bugerName - 1]-Number >= 0) {
				if(bank.payMent(account, price[bugerName - 1] * Number) == 0) {
					System.out.println("���� ������ Ȯ���� �ּ���. :)");
				}
				else{
					this.number[bugerName - 1] -= Number;
					this.money = money + price[bugerName - 1] * Number;
					for(int j = 0 ; j < this.staff.length ; j++) {
						if(this.place[j] == "ī����") {
							this.health[j]--;
							
						}
					}
				}
			}
			else {
				System.out.println("���� " + Number + "��ŭ�� " + bugerName + "�� �����ϴ�.\n�ٽ� �ֹ��� �ּ��� :)");
			}
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
			this.pay[i] = 30;
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
					  this.pay[k] = this.pay[k+1];
					  this.i = k+1;
				}
				this.staff[staff.length] = "";
				this.health[staff.length] = 0;
				this.place[staff.length] = "";
				this.pay[staff.length] = 0;
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
		for(int j = 0 ; j < this.staff.length ; j++) {
			if(this.staff[j] == "") {
				break;
			}
			System.out.println(j+1 + ". �̸� : " + staff[j] + " | ü�� : " + health[j] + " | ���ϴ� ��� : " + place[j]);
		}
		
	}
	
	//���� �ϱ� ����
	public void workPay(Player player) {
		int count = 0;
		for(int j = 0 ; j < this.staff.length ; j++) {
			if(this.staff[j] != "") {
				count++;
			}
		}
		this.money = money - (30 * count);
		for(int j = 0 ; j < this.staff.length ; j++) {
			player.workPay(this.pay[j], staff[j]);
		}
		
	}
	
	//���� �����
	public void makeBuger(String bugerName) {
		for(int j = 0 ; j < this.name.length ; j++) {
			if(this.name[j] == bugerName) {
				this.number[j]++;
				break;
			}
		}
	}
}
