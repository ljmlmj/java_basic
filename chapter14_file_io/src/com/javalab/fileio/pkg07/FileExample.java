package com.javalab.fileio.pkg07;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File 객체 - 탐색기의 파일에 대한 다양한 정보를 알아 볼 수 있음.
 */
public class FileExample {

	public static void main(String[] args) throws IOException {
		// File 객체 새엉
		File dir = new File("C:/filtest/images");
		File file1 = new File("C:/filetest/file1.txt");
		File file2 = new File("C:/filetest/file2.txt");
		File file3 = new File("C:/filetest/file3.txt");
		
		// 존재하지 않으면 디렉토리 또는 파일 생성
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		if (file1.exists() == false) {
			file1.createNewFile();
		}
		if (file2.exists() == false) {
			file2.createNewFile();
		}
		if (file3.exists() == false) {
			file3.createNewFile();
		}
		
		// filetest 폴더의 내용 (하위폴더, 파일) 출력
		File temp = new File("C:/filtest");
		File[] contents = temp.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		for (File file : contents) {
			System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
			if (file.isDirectory()) {
				System.out.printf("%-10s%-20s", "<DIR>", file.getName());
			} else {
				System.out.printf("%-10s%-20s", file.length(), file.getName());
			}
			System.out.println();
		}
	}
	
}
