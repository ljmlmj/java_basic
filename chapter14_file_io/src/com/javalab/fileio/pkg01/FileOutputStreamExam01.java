package com.javalab.fileio.pkg01;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream
 * 	-write() 메소드를 사용해서 1byte씩 write함.
 */
public class FileOutputStreamExam01 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("C:/filetest/test1.txt");
			
			byte a = 65;
			byte b = 66;
			byte c = 67;
			
			fos.write(a);
			fos.write(b);
			fos.write(c);
			
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					System.out.println("파일의 자원을 닫다가 오류남 : " + e.getMessage());
				}
			}
		}
	}
}
