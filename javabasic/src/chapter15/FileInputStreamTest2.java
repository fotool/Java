package chapter15;


import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest2 {

	public static void main(String[] args) {
		try 
			(FileReader fis = new FileReader("d:/note/input2.txt")){
			int i;
			while((i=fis.read()) !=-1) {
				System.out.print((char)i);	// �쎌�댁�� 諛��댄�몃�� 臾몄��濡� 蹂������� 異��ν����.
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
