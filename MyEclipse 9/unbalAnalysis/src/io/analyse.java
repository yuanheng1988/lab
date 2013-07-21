package io;

import java.io.File;

import samplingAnalysis.MethodBias4Data;

public class analyse {
	
	public static void main(String[] args){
		String originalDir = "E:\\data\\NASA_MDP\\D'\\";
		String sampleDir = "E:\\outputs\\1\\";
		String analysisDir = "E:\\outputs\\1\\sampleAnalysis\\";
		
		File dir = new File(originalDir);
		File[] files = dir.listFiles();
		
		String[] fileNames = new String[files.length];
		for(int i = 0; i < files.length; i++){
			fileNames[i] = files[i].getName().split("_")[0].replace(".arff", "");
		}
		
		String[] measures = {"AUC","TPR","FPR","FMeasure"};
		for(int i = 0;i < files.length; i++){
			for(String measure : measures){
				MethodBias4Data.generateFile4MethodBias(sampleDir, fileNames[1],analysisDir,measure);
			}
		}
	}

}
