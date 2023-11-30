import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoBox {
	
	private static final int RANGE = 45; 
	private static final int RAW_COUNT = 6;
	public static final int MAX_GENERATE = 999;
	
	public static List<Integer[]> lotto = new ArrayList<>();
	
	
	/*
	 * 현재 생성된 로또 열들을 출력합니다.
	 */
	public void Print(boolean showIndex)
	{
		// 로또 번호 리스트가 비어 있다면 중단
		if (lotto.size() == 0)
		{
			System.out.println("생성된 로또 번호가 없습니다.");
			return;
		}
		
		// 그동안 생성한 모든 로또 열들을 출력
		for (int i=0; i<lotto.size(); ++i)
		{
			// index 출력
			if (showIndex)
			{
				System.out.print(i+1 + "\t");
			}
			
			System.out.println(Arrays.toString(lotto.get(i)));
		}
	}
	
	
	/*
	 * 로또 여러 열이 나열된 리스트를 초기화합니다.
	 */
	public void Clear()
	{
		lotto.clear();
	}
	
	
	/*
	 * 로또 번호들로 구성된 열을 생성합니다.
	 * rowCount = 생성할 열의 개수입니다. 한 열은 6개의 중복되지 않는 로또 번호의 묶음입니다.
	 */
	public void Generate(int rowCount)
	{
		Random random = new Random();
		Set<Integer> set = new TreeSet<>();
		
		// 만들어낼 로또 열의 개수만큼 반복한다.
		for (int i=0; i<rowCount; ++i)
		{
			// 로또 한개는 총 1~45 범위의 6개의 중복되지 않는 숫자를 가지므로 조건에 맞게 열을 1개 생성
			while (set.size() < RAW_COUNT)
			{
				set.add(random.nextInt(RANGE) + 1);
			}

			// 무작위 생성 및 정렬된 세트를 추가
			lotto.add(set.toArray(new Integer[0]));
			set.clear();			
		}	

	}
	
	/*
	 * 유저가 입력한 로또 뽑기 개수가 적절한지 검사합니다. (1 ~ MAX_GENERATE 범위에 포함되는지)
	 */
	public static boolean IsBuyable(int gen_count)
	{
		return (gen_count > 0) && (gen_count <= MAX_GENERATE);
	}
}
