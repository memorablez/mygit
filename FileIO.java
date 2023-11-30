
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;



public class FileIO {
	
	/*
	 * 사용자가 입력한 파일명이 윈도우OS에 사용하기 적합한지 검사합니다.
	 */
	public static final String INVALID_FILENAME_PATTERN = "^[A-Za-z0-9.]{1,255}$";
	public static boolean IsValidFileName(String fileName)
	{
		if (fileName.isBlank())
		{
			return false;
		}
		
		return fileName.matches(INVALID_FILENAME_PATTERN);

	}
	
	/*
	 * 생성된 로또 열들을 파일로 저장합니다.
	 */
	public static void WriteFile(String fileName, List<Integer[]> lottoRows, boolean showIndex) throws IOException
	{
		
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName, false));
		
		// 파일의 각 줄에 로또 열 작성
		for (int i=0; i<lottoRows.size(); ++i)
		{
			String line = "";
			
			// 순번 및 로또 열 추가
			line += showIndex ? String.valueOf(i+1) + '\t' : "";
			line += Arrays.toString(lottoRows.get(i));
			
			bWriter.write(line);
			
			// 마지막 줄을 제외하고 줄 넘기기
			if (i != lottoRows.size()-1)
			{
				bWriter.newLine();	
			}
		}
		bWriter.close();		
		
	}
	
	
}
