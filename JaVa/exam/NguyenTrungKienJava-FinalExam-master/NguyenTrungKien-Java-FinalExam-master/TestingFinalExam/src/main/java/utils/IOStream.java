package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOStream {

//	Question 1: Tạo method        //READ FILE
	// Tạo 1 method có đầu vào là String filePath và return ra nội dung trong file.
	// Chú ý:
	// Nếu file không tồn tại thì sẽ throw ra Exception "Error! File
	// Not Exist." (sử dụng FileManager ở trên đẻ check)
	// Gợi ý: Tạo method String readFile(String pathFile)

	public static String readFile(String filePath) throws Exception {
		// check exists
		if (!FileManager.checkExist(filePath)) {
			throw new Exception("Sorry! File is not Exist!");
		}

		FileInputStream file = new FileInputStream(filePath);
		byte[] b = new byte[1024];
		int length = file.read(b);
		System.out.println(length);

		while (length > -1) {
			String content = new String(b, 0, length);
			System.out.println(content);
			System.out.println("------------------------------------");
			length = file.read(b);

		}
		file.close();
		String content = "";
		return content;
	}

//	Question 2: Tạo method write content to File
//	Tạo 1 method để write file
//	Chú ý:
//	Nếu file không tồn tại thì sẽ throw ra Exception "Error! File
//	Not Exist." (sử dụng FileManager ở exercise trên để check)
//	Gợi ý: Tạo method void writeFile(String pathFile, isContinuing
//	String content)
//	Nếu isContinuing = false thì sẽ xóa hết nội dung trong file đi và write content mới vào
//	Nếu isContinuing = true thì sẽ ghi content vào cuối file

	public static String writeFile(String pathFile, boolean isContinuing, String content) throws Exception {
		if (!FileManager.checkExist(pathFile)) {
			throw new Exception("Error! File Not Exist");
		}
		FileOutputStream fileOutPut = new FileOutputStream(pathFile, isContinuing);
		fileOutPut.write(content.getBytes());
		fileOutPut.close();
		return content;

	}

}