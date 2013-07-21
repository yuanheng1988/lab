package samplingAnalysis;

import io.SmartFile;

import java.io.File;
import java.io.FilenameFilter;

public class MethodBias4Data {
	
	public static void generateFile4MethodBias(String sampleDir, String dataName, String analysisDir,String measure){
		
		File dir = new File(sampleDir);
		File[] files = dir.listFiles(new DataNameFilter(dataName)); 
		SmartFile reader = null;
		SmartFile writer = new SmartFile(analysisDir.concat(dataName + "_methodBias_" + measure + ".txt"),false);
		writer.writeLine(dataName + "_" + measure);
		
		reader = new SmartFile(files[0].getAbsolutePath(),true);
		String bias = reader.readLine();
		bias = reader.readLine();
		bias = reader.readLine().split("\t")[0];
		reader.close();
		writer.writeLine("Method\t" + Double.parseDouble(bias) + "\t0.5\t0.55\t0.6\t0.65\t0.7\t0.75\t0.8\t0.85\t0.9\t0.95\t1.0\t1.05\t1.1\t1.15\t1.2\t1.25\t1.3\t1.35\t1.4\t1.45\t1.5");
		
		String line2write = "";		
		for(int i = 0; i < files.length; i++){
			reader = new SmartFile(files[i].getAbsolutePath(),true);

			String AUC = null;
			String TPR = null;
			String FPR = null;
			String FMeansure = null;
			
			int index = 0;
			if (measure.equals("AUC"))
				index = 1;
			else if (measure.equals("TPR"))
				index = 2;
			else if (measure.equals("FPR"))
				index = 3;
			else if (measure.equals("FMeasure"))
				index = 4;
			
			line2write = "";
			String method = reader.readLine();
			line2write += method.substring(4) + "\t";
						
			String line = reader.readLine();
			line = reader.readLine();
			while(line != null){
				line2write += line.split("\t")[index] + "\t";
				line = reader.readLine();
			}
			writer.writeLine(line2write.trim());
			reader.close();
		}
		
		writer.close();
		
	}
}

class DataNameFilter implements FilenameFilter{
	private String type;
	public DataNameFilter(String type){
		this.type = type;
	}  
	
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.startsWith(type);
	}
	
}
