import java.util.ArrayList;
import java.util.Scanner;

public class World {
   static int date;
   public static void main(String[] args){
       
	   //Ŭ���� : ��ü�� ����� ���� ���赵
	   //��ü : ��ü ��ü�� ������
	   //new : Ŭ������� ��ü�� ���� ����� ������
	   //new Object() != new Object();
	   
	  
      date = 1;
      int stack = 0;
      
      Scanner sc = new Scanner(System.in);
      
      Bank bank = new Bank();
      Human human = new Human(bank);
      human.setHuman("����", 25, 100);
      Account acount = new Account();
      bank.makeAccount(human);
      
      
      
      
      //���������� ���ư��°���
      while(true) {
         
    	  System.out.println("�Ա��Ͻðڽ��ϱ�? ���� �Ͻðڽ��ϱ�?");
    	  String talk = sc.next();
    	  int cash;
    	  switch(talk) {
    	  case "�Ա�":
    		  System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�?");
    		  cash = sc.nextInt();
    		  acount.inPut(cash);
    		  break;
    		  
    	  case "����":
    		  System.out.println("�󸶸� �����Ͻðڽ��ϱ�?");
    		  cash = sc.nextInt();
    		  acount.outPut(cash);
    		  break;
    	  }
    	  
    	  acount.List();
    	  
    	  date++;
      }
      
   }
}