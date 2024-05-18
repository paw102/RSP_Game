import java.util.Scanner;
import java.util.Random;

public class psb20201651_mid2 {
	
	//사용자와 컴퓨터의 가위바위보 결과 판별
	static String RSP_Check(String userChoice, String comChoice) {
		if (userChoice.equals(comChoice)) {
			return "비겼습니다 ㅡ_ㅡ";
		}
		else if(userChoice.equals("가위")&&comChoice.equals("보")||userChoice.equals("바위")&&comChoice.equals("가위")||userChoice.equals("보")&&comChoice.equals("바위")) {
			return "이겼습니다 ^o^!";
		}
        else
            return "졌습니다.. ㅠㅡㅠ";
	}
	
	//사용자와 컴퓨터의 가위바위보 매서드
	static void PvsC(Scanner s, Random r) {
			String [] RSP = {"가위","바위","보"};
			int win = 0;
			int lose = 0;
			int draw = 0;
			System.out.print("판 수 입력(숫자 외 소수,문자 입력 시 에러남!!!!!!!): ");
			int Game_num = s.nextInt();
			s.nextLine();
			
			for(int i=0; i < Game_num; i++ ) {
				System.out.print("가위 바위 보 중 하나 선택: ");
				String userChoice = s.nextLine();
			
				while(!(userChoice.equals("가위") || userChoice.equals("바위") || userChoice.equals("보"))) {
					System.out.println("입력이 잘못되었습니다. 다시 시도해주십시오");
					System.out.print("가위 바위 보 중 하나 선택: ");
					userChoice = s.nextLine();
				}
					
			int C_Choice = r.nextInt(3);
			String comChoice = RSP[C_Choice];
			
			System.out.println("사용자의 선택: " + userChoice);
			System.out.println("컴퓨터의 선택: " + comChoice);
	        
			String result = RSP_Check(userChoice,comChoice);
			System.out.println(" " + result);
			//판 수, 승패무, 승률 출력
			if (result.equals("이겼습니다 ^o^!")) {
					win +=1;
					}
			else if (result.equals("졌습니다.. ㅠㅡㅠ")) {
					lose +=1;
					}
			else {
					draw +=1;
					}
				}
			float winRate = ((float)win/(float)Game_num)*100;
			System.out.println(""+Game_num + "판 동안 이긴 횟수: "+win);
			System.out.println(""+Game_num + "판 동안 비긴 횟수: "+draw);
			System.out.println(""+Game_num + "판 동안 진 횟수: "+lose);
			System.out.println("승률: "+winRate+"%");
			}
	
	//컴퓨터와의 가위바위보 결과 판별
	static String Com_Chcek(String comChoice_1, String comChoice_2) {
		if (comChoice_1.equals(comChoice_2)) {
			return "비김";
		}
		else if(comChoice_1.equals("가위")&&comChoice_2.equals("보")||comChoice_1.equals("바위")&&comChoice_2.equals("가위")||comChoice_1.equals("보")&&comChoice_2.equals("바위")) {
			return "컴퓨터 1의 승리";
		}
        else
            return "컴퓨터 2의 승리";
	}
	
	
	//컴퓨터끼리의 가위바위보 게임 매서드
	static void CvsC(Scanner s, Random r) {
		String [] RSP = {"가위","바위","보"};
		int win1 = 0;
		int lose1 = 0;
		
		int win2 = 0;
		int lose2 = 0;
		
		int draw = 0;
		
		
		System.out.print("판 수 입력(숫자 외 소수,문자 입력 시 에러남!!!!!!!): ");
		int Game_num = s.nextInt();
		s.nextLine();
		for(int i=0; i < Game_num; i++ ) {
			
		int C_choice1 = r.nextInt(3);
		String comChoice_1 = RSP[C_choice1];
		
		int C_choice2 = r.nextInt(3);
		String comChoice_2 = RSP[C_choice2];
		
		System.out.println("컴퓨터1의 선택: " + comChoice_1);
		System.out.println("컴퓨터2의 선택: " + comChoice_2);
		
		String result = Com_Chcek(comChoice_1,comChoice_2);
		System.out.println(" "+ result);
		if (result.equals("컴퓨터 1의 승리")) {
			win1 +=1;
			lose2 +=1;
			}
		
		else if (result.equals("컴퓨터 2의 승리")) {
			lose1 +=1;
			win2 +=1;
			}
		else {
			draw +=1;
			}
		System.out.println("");
		}
		float winRate1 = ((float)win1/(float)Game_num)*100;
		System.out.println(""+Game_num + "판 동안 컴퓨터1이 이긴 횟수: "+win1);
		System.out.println(""+Game_num + "판 동안 컴퓨터1이 비긴 횟수: "+draw);
		System.out.println(""+Game_num + "판 동안 컴퓨터1이 진 횟수: "+lose1);
		System.out.println("");
		
		float winRate2 = ((float)win2/(float)Game_num)*100;
		System.out.println(""+Game_num + "판 동안 컴퓨터1이 이긴 횟수: "+win2);
		System.out.println(""+Game_num + "판 동안 컴퓨터1이 비긴 횟수: "+draw);
		System.out.println(""+Game_num + "판 동안 컴퓨터1이 진 횟수: "+lose2);
		System.out.println("");
		
		System.out.println("컴퓨터1의 승률: "+winRate1+"%\n" + "컴퓨터2의 승률: "+winRate2+"%");
	}
	
	
// 메인매서드(대결 상대 선택)
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println("대결 상대 선택");
		System.out.print("1.사용자vs컴퓨터, 2.컴퓨터vs컴퓨터: ");
		int Choice = s.nextInt();
		
		while(!(Choice == 1 || Choice == 2)) {
			System.out.println("잘못된 입력입니다. 다시 입력해주십시오: ");
			Choice = s.nextInt();
		}
		if (Choice == 1) {
			PvsC(s, r);
			System.out.println("");
		}
		else if (Choice == 2) {
			CvsC(s,r);
			System.out.println("");
		}
	}
}