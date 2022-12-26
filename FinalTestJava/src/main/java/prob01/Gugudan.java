package prob01;

import java.util.Scanner;

public class Gugudan {

	static int resultNumber = 0;

	public static void main(String[] args) {

		// 1-9까지의 난수를 반환하여 변수에 담는다
		int l = randomize(1, 9); //구구단 왼쪽 수 
		int r = randomize(1, 9); //구구단 오른쪽 수
		
		// 정답 저장
		resultNumber = l * r;
		
		// 9개의 난수를 반환
		int[] answerNumbers = randomizeAnswers();
		
		// 0-8까지의 난수를 반환
		int loc = randomize(0, 8);
		
		// 9개의 난수가 들어있는 배열에서 loc자리에 정답 저장
		answerNumbers[loc] = resultNumber;

		System.out.println(l + " x " + r + " = ?");

		// 9개의 난수를 3 * 3 모양으로 배치
		int length = answerNumbers.length;
		for (int i = 0; i < length; i++) {
			if (i % 3 == 0) {
				System.out.print("\n");
			} else {
				System.out.print("\t");
			}

			System.out.print(answerNumbers[i]);
		}

		System.out.print("\n\n");
		System.out.print("answer:");

		// 정답 입력을 받는다
		Scanner s = new Scanner(System.in);
		int answer = s.nextInt();
		s.close();

		// 입력받은값과 정답이 일치하면 정답, 아니면 오답 메세지 출력
		System.out.println((answer == resultNumber) ? "정답" : "오답");
	}

	private static int randomize(int lNum, int rNum) {
		// Math.random():0.0이상 1.0 미만 사이의 값을 반환   
		// rNum : 뽑을갯수 ,   lNum : 시작숫자
		// (int) : 정수형으로 반환
		int random = (int) (Math.random() * rNum) + lNum;
		return random;
	}

	private static int[] randomizeAnswers() {
		/* 코드 작성(수정 가능) */
		final int COUNT_ANSWER_NUMBER = 9;
		int[] boardNumbers = new int[COUNT_ANSWER_NUMBER];
		// 2-81 까지의 랜덤 숫자를 9개 뽑아서 배열에 저장하여 리턴
		for(int i=0 ; i<COUNT_ANSWER_NUMBER; i++) {
			boardNumbers[i]=(int)(Math.random()*81)+1 ;
		}
		return boardNumbers;
	}
}
