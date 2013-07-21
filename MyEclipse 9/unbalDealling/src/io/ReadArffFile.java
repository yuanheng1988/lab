package io;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class ReadArffFile {
		
	public static Instances readArffData(String path) throws Exception{
		DataSource source = new DataSource(path);
		
		Instances data = source.getDataSet();
		
		if(data.classIndex() == -1)
			data.setClassIndex(data.numAttributes()-1);
		
		return data;
	}

}
