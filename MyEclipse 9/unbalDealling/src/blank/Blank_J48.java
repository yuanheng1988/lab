package blank;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSink;
import weka.core.converters.ConverterUtils.DataSource;

public class Blank_J48 {
	public static void main(String args[]){
		Instances instances = null;
		try {
			instances = DataSource.read("C:\\Users\\xukexin\\Desktop\\È±ÏÝÔ¤²â\\kim\\unbalanced data\\MDP\\D'\\CM1.arff");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(instances.toSummaryString());
		try {
			DataSink.write("D:\\outputs\\CM1.arff", instances);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done.");
	}
}
