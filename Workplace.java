
public interface Workplace {
	//햄버거, 재료의 개수
	String[] materialNum = {};
	//직원 고용
	void inHuman(String human);
	//직원 해고
	void outHuman(String HumanName);
	//직원 휴식
	void timeHuman(String HumanName);
	//직원의 위치 배정
	void workPlace(String workplace, String HumanName);
	//직원 관리 시스템
	void workHuman();
}
