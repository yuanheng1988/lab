package sampling;

import java.text.DecimalFormat;
import java.util.Random;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.filters.supervised.instance.SMOTE;

public class SMOTESample {
	public static String SMOTEsample(Classifier cf,int seed, Instances data,int ratio, double percentage) throws Exception{
		DecimalFormat df = new DecimalFormat("#.0000");
		
		
		
		SMOTE smote = new SMOTE();
		smote.setNearestNeighbors(5);
		smote.setPercentage((ratio-1) * percentage * 100);
		smote.setRandomSeed(seed);
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(smote);
		fc.setClassifier(cf);
		fc.buildClassifier(data);
		
		Evaluation eval = new Evaluation(data);
		eval.crossValidateModel(fc, data, 10, new Random(1));
		
		
		String result = percentage + "\t" +df.format(eval.areaUnderROC(0)) + "\t" + df.format(eval.truePositiveRate(0)) + "\t" +
							df.format(eval.falsePositiveRate(0)) + "\t" + df.format(eval.fMeasure(0)) + "\t" + df.format(eval.pctCorrect());
		return result;
		
	}

}
