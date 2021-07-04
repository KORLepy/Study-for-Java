import java.util.ArrayList;
import java.util.Scanner;

public class World {
   static int date;
   public static void main(String[] args){
       
	   //클래스 : 객체를 만들기 위한 설계도
	   //객체 : 객체 자체의 뭉텅이
	   //new : 클래스대로 객체를 새로 만드는 생성자
	   //new Object() != new Object();
	   
	  
      date = 1;
      int stack = 0;
      
      Scanner sc = new Scanner(System.in);
      
      Bank bank = new Bank();
      Human human = new Human(bank);
      human.setHuman("강규", 25, 100);
      Account acount = new Account();
      bank.makeAccount(human);
      
      
      
      
      //실질적으로 돌아가는거임
      while(true) {
         
    	  System.out.println("입금하시겠습니까? 결재 하시겠습니까?");
    	  String talk = sc.next();
    	  int cash;
    	  switch(talk) {
    	  case "입금":
    		  System.out.println("얼마를 입금하시겠습니까?");
    		  cash = sc.nextInt();
    		  acount.inPut(cash);
    		  break;
    		  
    	  case "결재":
    		  System.out.println("얼마를 결재하시겠습니까?");
    		  cash = sc.nextInt();
    		  acount.outPut(cash);
    		  break;
    	  }
    	  
    	  acount.List();
    	  
    	  date++;
      }
      
   }
}