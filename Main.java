import java.util.Scanner;
import java.io.IOException;


public class Main {
	
	// 프로그램 시작 지점
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int gen_count = 0;
	
		System.out.println("|| 로또 번호 뽑기 프로그램입니다. ||");
		
		
		// 단일 최대 뽑기개수에 부합할 때까지 입력 반복
		while (!LottoBox.IsBuyable(gen_count))
		{
			System.out.println("\n=========================");
			System.out.print("몇 개의 로또를 뽑아보시겠습니까?(1~" + LottoBox.MAX_GENERATE + ") > ");
		
			// 로또 발생 매수 입력 받기
			gen_count = scanner.nextInt();		
		}
		
		System.out.println("\n======= " + gen_count + "개의 로또를 뽑습니다. =======");
		
		// 입력받은 매수만큼 로또 번호를 생성하고 출력
		LottoBox lotto = new LottoBox();
		lotto.Generate(gen_count);
		lotto.Print(true);
		
		// 사용자가 원하는 파일명으로 출력한 로또 번호들을 저장
		System.out.println("\n=========================");
		System.out.print("생성한 " + gen_count + "개의 로또를 파일로 저장하시겠습니까?(Y/N) > ");
		scanner = new Scanner(System.in);
		String userInput = scanner.nextLine().toLowerCase();
		
		// 파일로 저장하는 것을 취소했다면 이대로 프로그램 종료
		if (userInput.contains("n"))
		{
			System.out.println("\n\n 프로그램을 종료합니다.");
			scanner.next();
			return;
		}
		
		
		System.out.println("\n=========================");
		System.out.print("\n원하는 파일명을 입력하세요: ");
		
		// 적절한 파일명이 입력될 때까지 반복입력
		String fileName = scanner.nextLine();
		while (!FileIO.IsValidFileName(fileName))
		{
			System.out.print("\n적합한 파일명이 아닙니다. 다시 입력하세요: ");
			fileName = scanner.nextLine();
		}
		
		// 파이롤 저장할 때 순번을 출력할지 입력받기
		System.out.println("\n=========================");
		System.out.print("\n로또 순번도 함께 저장할까요?(Y/N) > ");
	
		// y 입력받으면 순번도 함께, 아니면 순번 없이 로또 번호들을 파일로 저장
		boolean showIndex = scanner.nextLine().toLowerCase().contains("y") ? true : false;
		try 
		{
			FileIO.WriteFile(fileName, lotto.lotto, showIndex);
			
			System.out.println('\n' + fileName + "에 로또 번호들이 저장되었습니다. 엔터 입력 시 프로그램을 종료합니다.");
		}
		
		catch (IOException e)
		{
			System.out.println("\n오류가 발생했습니다. 엔터 입력 시 프로그램을 종료합니다.");
		}
		
		scanner.next();
		
	}
}


