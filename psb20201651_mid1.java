//랜덤,입력 함수 패키지 import
import java.util.Scanner;
import java.util.Random;


public class psb20201651_mid1 {
	
	//사용자의 값과 컴퓨터의 값 비교
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

	public static void main(String[] args) {
		String [] RSP = {"가위","바위","보"};
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		while(true) {
		System.out.print("가위 바위 보 중 하나 선택: ");
		String userChoice = s.nextLine();
		
		//!를 처음 부분에 쓰면 값을 부정
		while(!(userChoice.equals("가위") || userChoice.equals("바위") || userChoice.equals("보"))) {
			System.out.println("입력이 잘못되었습니다. 다시 시도해주십시오");
			System.out.print("가위 바위 보 중 하나 선택: ");
			userChoice = s.nextLine();
		}
			//랜덤 함수를 이용한 컴퓨터의 배열 순서 값 하나 지정
			int C_Choice = r.nextInt(3);
			String comChoice = RSP[C_Choice];
			
	        System.out.println("사용자의 선택: " + userChoice);
	        System.out.println("컴퓨터의 선택: " + comChoice);
	        
	        String result = RSP_Check(userChoice,comChoice);
	        System.out.println("결과: " + result);
	        System.out.print("게임을 그만두겠습니까? (y이나 ㅇㅇ 입력 시 종료): ");
	        String exit = s.nextLine();
	        if (exit.equals("y") || exit.equals("Y")||exit.equals("ㅇㅇ")) {
	        	System.out.println("게임을 종료합니다. 다음에 또 봐요 :)");
	        	break;
	        }
	        System.out.println("게임을 계속 진행합니다.");
		}
	}
}