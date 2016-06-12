import java.io.File;
import java.io.IOException;

public class FileDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("hello.txt");
		File renameTo=new File("new hello.txt");
		if (file.exists()) {
			System.out.println("文件已经存在");
			file.renameTo(renameTo);
			System.out.println(file.isDirectory());
			System.out.println(file.isFile());
		}else {
			try {
				file.createNewFile();
				System.out.println("文件创建成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("文件无法创建");
			}
			
		}
	}

}
