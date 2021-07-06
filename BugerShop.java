import java.util.ArrayList;

public class BugerShop implements Workplace {
	int[] number = {10};
	String[] name = {"치즈버거"};
	int[] price = {20};
	boolean trigger = false;
	int i = 0;
	
	String[] staff = new String[4];
	int[] health = new int[4];
	String[] place = new String[4];
	
	//버거판매
	public int sellBuger(int bugerName, int Number, Bank bank, Account account) {
		if(Number < 0) {
			System.out.println("개수를 확인해주세요 :)");
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
		//알맞게 팔았을 경우 카운터 직원 체력 -1
		if(trigger == true) {
			for(int j = 0 ; j < this.staff.length ; j++) {
				if(this.place[j] == "카운터") {
					this.health[j]--;
					
				}
			}
			return price[bugerName - 1] * Number;
		}
		else {
			return 1;
		}
	}

	//직원 고용
	@Override
	public void inHuman(String HumanName) {
		if(this.i == 4) {
			System.out.println("직원이 다 찼습니다.");
		}
		else {
			this.staff[i] = HumanName;
			this.health[i] = 100;
			System.out.println("직원이 영입되었습니다.");
			i++;
		}
	}

	//직원 해고
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
				System.out.println("직원은 해고 되었습니다.");
				break;
			}
		}
	}

	//직원 휴식
	@Override
	public void timeHuman(String HumanName) {
		for(int j = 0 ; j < staff.length ; j++) {
			if(this.staff[j] == HumanName) {
				this.place[j] = "time";
				break;
			}
		}
	}

	//직원의 위치 배정
	@Override
	public void workPlace(String workplace, String HumanName) {
		for(int j = 0 ; j < this.staff.length ; j++) {
			if(this.staff[j] == HumanName) {
				this.place[j] = workplace;
				break;
			}
		}
	}

	//직원 관리 시스템
	@Override
	public void workHuman() {
		for(int j = 0 ; j < staff.length ; j++) {
			if(staff[j] == "") {
				break;
			}
			System.out.println(j+1 + ". 이름 : " + staff[j] + " | 체력 : " + health[j] + " | 일하는 장소 : " + place[j]);
		}
		
	}
}
