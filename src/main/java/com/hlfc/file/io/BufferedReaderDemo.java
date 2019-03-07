package com.hlfc.file.io;

/**
 * 使用 BufferedReader读取文件流
 *  @Auther: HXL
 *  @Date: 2018/11/16
 */

import com.hlfc.util.EnvironmentUtil;

import java.io.*;

public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		String filepath = EnvironmentUtil.getInstance().getWebInfPath()+ "/other/file/File.txt";

		BufferedReader read = new BufferedReader(new FileReader(filepath));
		String s;
		StringBuffer sb = new StringBuffer();
		while((s=read.readLine()) != null){
			sb.append(s+"\n");
		}
		read.close();
		System.out.println(sb);
	}
}
