package cn.ac.iscas.io;

import java.awt.Point;
import java.util.ArrayList;

public class SmartData {
	String path;
	public ArrayList<Doc> doclist = new ArrayList<Doc>();
	private boolean isTrain = true;
	
	public SmartData(String path){
		this.path = path;
		getData();
	}
	
	public SmartData(String path, boolean isTest){
		this.path = path;
		this.isTrain = false;
		getData();
	}
	
	void getData(){
		System.out.println("Data Process Begin..");
		SmartFile sf = new SmartFile(path, true);
		String line = sf.readLine();
		while (line != null){
			Doc doc = getDocFromString(line);
			if (doc != null)
				doclist.add(doc);
			line = sf.readLine();
		}
		sf.close();
		System.out.println(doclist.size() + " files");
		System.out.println("Data Process End..");
	}
	
	Doc getDocFromString(String line){
		Doc doc = new Doc();
		String[] fields = line.split("\t");
		try{
			doc.ID = Integer.parseInt(fields[0]);
			doc.sentiment = Integer.parseInt(fields[1]);
			if ((isTrain) && (doc.sentiment == 0)) return null;
			///////////
		} catch (Exception e){
			System.out.println("id, sentiment read error");
			e.printStackTrace();
		}
		try{
			for (int i = 2; i < fields.length; i++){
				String[] temp = fields[i].split(":");
				Point p = new Point();
				p.x = Integer.parseInt(temp[0]);
				p.y = Integer.parseInt(temp[1]);
				doc.tfs.add(p);
			}
		} catch (Exception e){
			System.out.println("tf read error");
			e.printStackTrace();
		}
		return doc;
	}
	
	void printData(){
		for (int i = 0; i < doclist.size(); i++){
			Doc doc = doclist.get(i);
			System.out.println(doc.getString());
		}
	}
}
