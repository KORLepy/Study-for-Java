import java.util.ArrayList;

public class BugerShop implements Workplace {
	//버거 개수
	int[] number = {10};
	//버거 종류
	String[] name = {"치즈버거"};
	//버거 가격
	int[] price = {20};
	
	boolean trigger = false;
	int i = 0;
	//버거 가게 자금
	int money = 5000;
	
	//직원 이름
	String[] staff = new String[4];
	//직원 체력
	int[] health = new int[4];
	//직원 위치
	String[] place = new String[4];
	//직원 일급
	int[] pay = new int[4];
	
	//버거판매
	public void sellBuger(int bugerName, int Number, Bank bank, Account account) {
		if(Number < 0) {
			System.out.println("개수를 확인해주세요 :)");
		}
		else {
			if(this.number[bugerName - 1]-Number >= 0) {
				if(bank.payMent(account, price[bugerName - 1] * Number) == 0) {
					System.out.println("버거 개수를 확인해 주세요. :)");
				}
				else{
					this.number[bugerName - 1] -= Number;
					this.money = money + price[bugerName - 1] * Number;
					for(int j = 0 ; j < this.staff.length ; j++) {
						if(this.place[j] == "카운터") {
							this.health[j]--;
							
						}
					}
				}
			}
			else {
				System.out.println("현재 " + Number + "만큼의 " + bugerName + "가 없습니다.\n다시 주문해 주세요 :)");
			}
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
			this.pay[i] = 30;
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
					  this.pay[k] = this.pay[k+1];
					  this.i = k+1;
				}
				this.staff[staff.length] = "";
				this.health[staff.length] = 0;
				this.place[staff.length] = "";
				this.pay[staff.length] = 0;
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
		for(int j = 0 ; j < this.staff.length ; j++) {
			if(this.staff[j] == "") {
				break;
			}
			System.out.println(j+1 + ". 이름 : " + staff[j] + " | 체력 : " + health[j] + " | 일하는 장소 : " + place[j]);
		}
		
	}
	
	//직원 일급 지급
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
	
	//버거 만들기
	public void makeBuger(String bugerName) {
		for(int j = 0 ; j < this.name.length ; j++) {
			if(this.name[j] == bugerName) {
				this.number[j]++;
				break;
			}
		}
	}
}
