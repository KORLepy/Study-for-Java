
public interface Workplace {
	//�ܹ���, ����� ����
	String[] materialNum = {};
	//���� ���
	void inHuman(String human);
	//���� �ذ�
	void outHuman(String HumanName);
	//���� �޽�
	void timeHuman(String HumanName);
	//������ ��ġ ����
	void workPlace(String workplace, String HumanName);
	//���� ���� �ý���
	void workHuman();
}
