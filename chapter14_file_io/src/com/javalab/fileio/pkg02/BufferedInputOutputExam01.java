package com.javalab.fileio.pkg02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 보조스트림을 이용한 파일 복사
 * 	- FileInputStream의 성능 향상을 위한 보조적인 스트림
 * 	- BufferedInputStream : 하드디스크에서 읽어들이지 않고
 * 	    메모리 버퍼에 미리 읽어놓은 데이트를 읽어들임.
 * 	- 속도가 아주 빠름. 
 */
public class BufferedInputOutputExam01 {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// 원본 파일
			File sourceFile = new File("C:/filetest/originalFile.png");
			// 복사될 파일
			File destFile = new File("C:/filetest/newFile.png");
			
			fis = new FileInputStream(sourceFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			fos = new FileOutputStream(destFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte[] buffer = new byte[1024];
			
			int bytesRead;
			while ((bytesRead = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
			bis.close();	// FileInputStream을 닫아준다.
			bos.close();	// FileOutputStream을 닫아준다.
			System.out.println("Image file copied successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
