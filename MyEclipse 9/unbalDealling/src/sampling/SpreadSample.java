package sampling;

import java.text.DecimalFormat;
import java.util.Random;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.filters.supervised.instance.SMOTE;
import weka.filters.supervised.instance.SpreadSubsample;

public class SpreadSample {
	public static String spreadsubsample(Classifier cf,int seed, Instances data,double percentage) throws Exception{
		DecimalFormat df = new DecimalFormat("#.0000");
		
		SpreadSubsample spread = new SpreadSubsample();
		spread.setDistributionSpread(percentage);
		spread.setRandomSeed(seed);
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(spread);
		fc.setClassifier(cf);
		fc.buildClassifier(data);
		
		Evaluation eval = new Evaluation(data);
		eval.crossValidateModel(fc, data, 10, new Random(1));
		
		
		String result = percentage + "\t" +df.format(eval.areaUnderROC(0)) + "\t" + df.format(eval.truePositiveRate(0)) + "\t" +
							df.format(eval.falsePositiveRate(0)) + "\t" + df.format(eval.fMeasure(0)) + "\t" + df.format(eval.pctCorrect());
		return result;
		
	}

}
