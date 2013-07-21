package iscas.itechs.crossvalidation;

import weka.core.Instances;
import weka.core.Utils;
import weka.filters.supervised.instance.StratifiedRemoveFolds;

public class straCrossValidation {
	
	public static Instances get9FoldTrainingSet(Instances data,int fold) throws Exception{
		StratifiedRemoveFolds srf = new StratifiedRemoveFolds();
		String[] options = Utils.splitOptions("-S 0 -N 10 -F " + fold);
		srf.setOptions(options);
		srf.setInputFormat(data);
		
		Instances trainingSet = null;
		trainingSet = StratifiedRemoveFolds.useFilter(data, srf);
		return trainingSet;
	}

}
