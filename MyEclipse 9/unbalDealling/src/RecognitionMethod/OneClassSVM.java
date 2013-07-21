package RecognitionMethod;

import java.text.DecimalFormat;
import java.util.Random;

import io.ReadArffFile;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.filters.supervised.instance.RemoveClass;

public class OneClassSVM {
	
	public static String oneclassSVM(Instances data, String output_path) throws Exception{
		DecimalFormat df = new DecimalFormat("#.0000");
		
		LibSVM libsvm = new LibSVM();
		libsvm.setDebug(false);
		libsvm.setNormalize(true);
		libsvm.setNu(2);
		
		RemoveClass rc = new RemoveClass();
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(rc);
		fc.setClassifier(libsvm);
		fc.buildClassifier(data);

		Evaluation eval = new Evaluation(data);
		eval.crossValidateModel(fc, data, 10, new Random(1));
		
		
		String result = df.format(eval.areaUnderROC(0)) + "\t" + df.format(eval.truePositiveRate(0)) + "\t" +
							df.format(eval.falsePositiveRate(0)) + "\t" + df.format(eval.fMeasure(0)) + "\t" + df.format(eval.pctCorrect());
		return result;
		
		
		
	}

}
