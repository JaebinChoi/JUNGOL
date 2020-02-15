package jungol;

import java.util.Scanner;

/**
 * 1291 : 구구단
 * 
 * 원하는 구구단의 범위를 입력받아 해당 구간의 구구단을 출력하는 프로그램을 작성하시오.
 * 
 * <처리조건>
 * (1) 구간의 처음과 끝을 입력받는다.
 * (2) 입력된 구간은 반드시 처음 입력 값이 끝의 입력 값보다 작아야 하는 것은 아니다.
 * 즉 입력된 구간의 범위는 증가하거나 감소하는 순서 그대로 출력되어야 한다.
 *
 * <입력조건>
 * 구구단의 시작 범위 s,와 끝 범위 e를 입력받는다.(s와 e는 2부터 9사이의 정수) 
 * 하나의 결과가 출력되면 프로그램을 종료한다.
 * 
 * <출력조건>
 * 시작 범위와 끝 범위사이의 구구단을 출력하되 모든 값과 부호 사이는 공백으로 구분하여 아래 출력 예와 같이 줄을 맞추어 출력해야 한다.
 * 구구단 사이는 3개의 공백으로 구분한다. 
 * 데이터의 크기가 주어진 범위를 벗어날 경우는 "INPUT ERROR!"를 출력하고 s와 e를 다시 입력받는다.
 */

public class Main1291 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s;
		int e;

		while (true) {
			s = sc.nextInt();
			e = sc.nextInt();
			if (s > 1 && s < 10 && e > 1 && e < 10)
				break;
			else
				System.out.println("INPUT ERROR!");
		}

		for (int i = 1; i < 10; i++) {
			if (s - e < 0) {
				for (int j = s; j < e + 1; j++) {
					if (j * i < 10)
						System.out.print(j + " * " + i + " =  " + j * i + "   ");
					else
						System.out.print(j + " * " + i + " = " + j * i + "   ");
				}
				System.out.println();
			} else {
				for (int j = s; j > e - 1; j--) {
					if (j * i < 10)
						System.out.print(j + " * " + i + " =  " + j * i + "   ");
					else
						System.out.print(j + " * " + i + " = " + j * i + "   ");
				}
				System.out.println();
			}
		}

	}
}