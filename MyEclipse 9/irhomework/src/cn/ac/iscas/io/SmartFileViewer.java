package cn.ac.iscas.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 璇诲彇鐩綍鍙婂瓙鐩綍涓嬫寚瀹氭枃浠跺悕鐨勮矾寰�骞舵斁鍒颁竴涓暟缁勯噷闈㈣繑鍥為亶鍘�
 * 
 * @author peterstone
 * 
 */
public class SmartFileViewer {

	public static String path = "";
	// public static final String path =
	// "C:\\Users\\peterstone\\Desktop\\trainset";
	public static List<String> fileList = new ArrayList<String>();
	public static List<String> fileContent;
	public static List<String> fileLabel;
	public static List<Integer> fileId;
	public static int MaxFileNum = 0;
	static int count = 0;

	
	public SmartFileViewer(String path){
		this.path = path;
		fileContent = new ArrayList<String>();
		fileLabel = new ArrayList<String>();
		fileId = new ArrayList<Integer>();
	}

	public static void viewFiles() {
		File dir = new File(path);
		File[] t = dir.listFiles();
		MaxFileNum = t.length;
		List arrayList = SmartFileViewer.getListFiles(path, "txt", true);

		if (arrayList.isEmpty()) {
			System.out.println("娌℃湁绗﹀悎瑕佹眰鐨勬枃浠");
		} else {
			String message = "";
			message += "绗﹀悎瑕佹眰鐨勬枃浠舵暟锛" + arrayList.size() + "\r\n";
			System.out.println(message);
		}
	}

	/**
	 * 
	 * @param path
	 *            鏂囦欢璺緞
	 * @param suffix
	 *            鍚庣紑鍚�
	 * @param isdepth
	 *            鏄惁閬嶅巻瀛愮洰褰�
	 * @return
	 */
	public static List getListFiles(String path, String suffix, boolean isdepth) {
		File file = new File(path);
		return SmartFileViewer.listFile(file, suffix, isdepth);
	}

	public static List listFile(File f, String suffix, boolean isdepth) {
		// 鏄洰褰曪紝鍚屾椂闇�閬嶅巻瀛愮洰褰�
		if (f.isDirectory() && isdepth == true) {
			File[] t = f.listFiles();
			for (int i = 0; i < t.length; i++) {
				listFile(t[i], suffix, isdepth);
			}
		} else {
			String filePath = f.getAbsolutePath();

			if (suffix != null) {
				int begIndex = filePath.lastIndexOf(".");// 鏈�悗涓�釜.(鍗冲悗缂�悕鍓嶉潰鐨�)鐨勭储寮�
				String tempsuffix = "";

				if (begIndex != -1)// 闃叉鏄枃浠朵絾鍗存病鏈夊悗缂�悕缁撴潫鐨勬枃浠�
				{
					tempsuffix = filePath.substring(begIndex + 1, filePath
							.length());
				}

				if (tempsuffix.equals(suffix)) {
					int k = 0;
					
					String content = readFile(filePath);
					String filename = f.getName();
					count++;
					if(count % 1000 ==0)
					System.out.println("add " + filename + " (" + count +")..");
					String[] temp = filename.split("_");
					int fileid = Integer.valueOf(temp[0]);
					for(k = 0; k < fileId.size(); k++)
					{
						if(fileid < fileId.get(k))
							break;
					}
					fileId.add(k, fileid);
					fileContent.add(k, content);
					fileList.add(k, f.getAbsolutePath());
					if (temp[1].compareTo("寰堝ソ.txt") == 0
							|| temp[1].compareTo("濂�txt") == 0) {
						fileLabel.add(k,fileid + "\t1");
					} else if (temp[1].compareTo("宸�txt") == 0
							|| temp[1].compareTo("寰堝樊.txt") == 0) {
						fileLabel.add(k,fileid + "\t-1");
					} else {
						fileLabel.add(k,fileid + "\t0");
					}
				}
			} else {
				// 鍚庣紑鍚嶄负null鍒欎负鎵�湁鏂囦欢
				fileList.add(filePath);
			}
		}

		return fileList;

	}

	public static String readFile(String filename) {
		String line = "";
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(filename));
			String templine = "";
			while ((templine = bfr.readLine()) != null) {
				line += templine;
			}
			bfr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}
}