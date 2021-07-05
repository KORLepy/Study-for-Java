
public class BugerShop implements Workplace {
	int[] number = {10};
	String[] name = {"치즈버거"};
	int[] price = {20};
	boolean trigger = false;
	int i = 0;
	
	public int sellBuger(int bugerName, int Number, Bank bank) {
		if(Number < 0) {
			System.out.println("개수를 확인해주세요 :)");
			return 0;
		}
		if(this.number[bugerName - 1]-Number > 0) {
			this.number[bugerName - 1] -= Number;
			trigger = true;
		}
		
		if(trigger == true) {
			return price[bugerName - 1] * Number;
		}
		else {
			return 1;
		}
	}
}
