import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("hello.txt");
		try {
			FileInputStream fileInputStream=new FileInputStream(file);
			InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			String line;
			try {
				line = bufferedReader.readLine();
				while (line!=null) {
				System.out.println(line);
				line = bufferedReader.readLine();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					bufferedReader.close();
					inputStreamReader.close();
					fileInputStream.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
