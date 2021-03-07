package utils;

import java.io.File;

public class FileManager {

//	Question 1: Check File is exists
//	Tạo 1 method có đầu vào là String path để check xem path đó có tồn
//	tại hay không.
//	VD: path = "C:\Users\pc\Desktop\Test.txt"

	public static boolean checkExist(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			System.out.println("File is exist!");
		} else {
			System.out.println("File is not exist!");
		}
		return true;

	}
//	Question 2: Create new file
//	Tạo 1 method để có thể tạo được file.
//	Chú ý:
//	Kiểm tra xem file đã tồn tại hay chưa, nếu file đã tồn tại thì sẽ
//	throw ra Exception "Error! File Exist."

//	Gợi ý:
//		Tạo method void createNewFile(String pathFile)
//		Vào tạo thêm method void createNewFile(String path, String
//		fileName)

	public static void createNewFile1(String pathFile) throws Exception {

		File file = new File(pathFile);
		if (file.exists()) {
			throw new Exception("Error! File Exist");

		} else if (file.createNewFile()) {
			System.out.println("Congratulations! Create Successfully");
		}
	}

//	Question 4: Delete file
//	Tạo 1 method để có thể delete file
//	Chú ý: 
//	Kiểm tra xem file đã tồn tại hay chưa, nếu file chưa tồn tại thì
//	sẽ throw ra Exception "Error! File Not Exist."
//	Gợi ý: Tạo method void deleteFile(String pathFile)

	public static void deleteFile(String pathFile) throws Exception {

		File file = new File(pathFile);

		if (file.exists()) {
			file.delete();
			System.out.println("Congratulations! Delete Successfully");

		} else {
			throw new Exception("Error! File Not Exist");
		}
	}
//	Question 5: Check path is File or Folder
//	Tạo 1 method để kiểm tra xem path có thể là File hay Folder.
//	Gợi ý: Tạo method boolean isFolder(String path)

	public static void isFolder(String path) {
		File file = new File(path);
		System.out.println(file.isDirectory() ? "Path is Folder " : "Path is File");
	}

//	Question 6: Get all File name of Folder
//	Tạo 1 method để lấy ra tất cả các tên file trong 1 Folder.
//	Chú ý:
//	Kiểm tra xem path nhập vào có phải là folder hay không, nếu
//	không phải thì sẽ throw ra Exception "Error! Path is not folder."
//	Gợi ý: Tạo method List<String> getAllFileName(String path)
	public static void getAllFileName(String path) throws Exception {
		File file = new File(path);
		if (file.isDirectory()) {
			for (String fileName : file.list()) {
				System.out.println(fileName);
			}
		} else {
			throw new Exception("Error! Path is not folder");
		}

	}

//	Question 7: Copy File
//	Tạo 1 method để copy file.
//	Chú ý:
//	Nếu file không tồn tại thì sẽ throw ra Exception "Error! Source
//	File Not Exist."
//	Nếu file đích đã tồn tại thì sẽ throw ra Exception "Error!
//	newPath has File same name."

	public static void copyFile(String sourceFile, String distinationPath, String newName) throws Exception {
		File file = new File(sourceFile);
		if (!file.exists()) {
			throw new Exception("Error! Source File Not Exist");
		} else if (file.exists()) {
			throw new Exception("Error! newPath has File same name");
		}
	}

}