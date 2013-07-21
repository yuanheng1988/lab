package weka.filters.supervised.instance;

import weka.core.Capabilities;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Option;
import weka.core.OptionHandler;
import weka.core.RevisionUtils;
import weka.core.Utils;
import weka.core.Capabilities.Capability;
import weka.filters.Filter;
import weka.filters.SupervisedFilter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

/** 
 <!-- globalinfo-start -->
 * Produces a random subsample of a dataset using either sampling with replacement or without replacement.<br/>
 * The original dataset must fit entirely in memory. The number of instances in the generated dataset may be specified. The dataset must have a nominal class attribute. If not, use the unsupervised version. The filter can be made to maintain the class distribution in the subsample, or to bias the class distribution toward a uniform distribution. When used in batch mode (i.e. in the FilteredClassifier), subsequent batches are NOT resampled.
 * <p/>
 <!-- globalinfo-end -->
 * 
 <!-- options-start -->
 * Valid options are: <p/>
 * 
 * <pre> -S &lt;num&gt;
 *  Specify the random number seed (default 1)</pre>
 * 
 * <pre> -Z &lt;num&gt;
 *  The size of the output dataset, as a percentage of
 *  the input dataset (default 100)</pre>
 * 
 * <pre> -B &lt;num&gt;
 *  Bias factor towards uniform class distribution.
 *  0 = distribution in input data -- 1 = uniform distribution.
 *  (default 0)</pre>
 * 
 * <pre> -no-replacement
 *  Disables replacement of instances
 *  (default: with replacement)</pre>
 * 
 * <pre> -V
 *  Inverts the selection - only available with '-no-replacement'.</pre>
 * 
 <!-- options-end -->
 *
 * @author Len Trigg (len@reeltwo.com)
 * @author FracPete (fracpete at waikato dot ac dot nz)
 * @version $Revision: 5542 $ 
 */
public class RemoveClass
  extends Filter 
  implements SupervisedFilter, OptionHandler {


  /**
	 * 
	 */
	private static final long serialVersionUID = -3543118741278666078L;


  /** The random number generator seed. */
  protected int m_RandomSeed = 1;
  protected Random m_Random;

  /**
   * Returns an enumeration describing the available options.
   *
   * @return an enumeration of all the available options.
   */
  public Enumeration listOptions() {
    Vector result = new Vector();

    result.addElement(new Option(
	"\tSpecify the random number seed (default 1)",
	"S", 1, "-S <num>"));

    return result.elements();
  }

  public void setOptions(String[] options) throws Exception {
    String	tmpStr;
    
    tmpStr = Utils.getOption('S', options);
    if (tmpStr.length() != 0)
      setRandomSeed(Integer.parseInt(tmpStr));
    else
      setRandomSeed(1);
  }

  /**
   * Gets the current settings of the filter.
   *
   * @return an array of strings suitable for passing to setOptions
   */
  public String [] getOptions() {
    Vector<String>	result;

    result = new Vector<String>();

    result.add("-S");
    result.add("" + getRandomSeed());
    
    return result.toArray(new String[result.size()]);
  }
    
  /**
   * Returns the tip text for this property.
   *
   * @return tip text for this property suitable for
   * displaying in the explorer/experimenter gui
   */
  public String biasToUniformClassTipText() {
    return "Whether to use bias towards a uniform class. A value of 0 leaves the class "
      + "distribution as-is, a value of 1 ensures the class distribution is "
      + "uniform in the output data.";
  }
    
  /**
   * Returns the tip text for this property.
   *
   * @return tip text for this property suitable for
   * displaying in the explorer/experimenter gui
   */
  public String randomSeedTipText() {
    return "Sets the random number seed for subsampling.";
  }
  
  /**
   * Gets the random number seed.
   *
   * @return the random number seed.
   */
  public int getRandomSeed() {
    return m_RandomSeed;
  }
  
  /**
   * Sets the random number seed.
   *
   * @param newSeed the new random number seed.
   */
  public void setRandomSeed(int newSeed) {
    m_RandomSeed = newSeed;
  }
    
  /** 
   * Returns the Capabilities of this filter.
   *
   * @return            the capabilities of this object
   * @see               Capabilities
   */
  public Capabilities getCapabilities() {
    Capabilities result = super.getCapabilities();
    result.disableAll();

    // attributes
    result.enableAllAttributes();
    result.enable(Capability.MISSING_VALUES);
    
    // class
    result.enable(Capability.NOMINAL_CLASS);
    
    return result;
  }
  
  /**
   * Sets the format of the input instances.
   *
   * @param instanceInfo an Instances object containing the input 
   * instance structure (any instances contained in the object are 
   * ignored - only the structure is required).
   * @return true if the outputFormat may be collected immediately
   * @throws Exception if the input format can't be set 
   * successfully
   */
  public boolean setInputFormat(Instances instanceInfo) 
       throws Exception {

    super.setInputFormat(instanceInfo);
    setOutputFormat(instanceInfo);
    m_Random = new Random(m_RandomSeed);
    return true;
  }

  /**
   * Input an instance for filtering. Filter requires all
   * training instances be read before producing output.
   *
   * @param instance the input instance
   * @return true if the filtered instance may now be
   * collected with output().
   * @throws IllegalStateException if no input structure has been defined
   */
  public boolean input(Instance instance) {

    if (getInputFormat() == null) {
      throw new IllegalStateException("No input instance format defined");
    }
    if (m_NewBatch) {
      resetQueue();
      m_NewBatch = false;
    }
    if (isFirstBatchDone()) {
      push(instance);
      return true;
    } else {
      bufferInput(instance);
      return false;
    }
  }

  /**
   * Signify that this batch of input to the filter is finished. 
   * If the filter requires all instances prior to filtering,
   * output() may now be called to retrieve the filtered instances.
   *
   * @return true if there are instances pending output
   * @throws IllegalStateException if no input structure has been defined
   */
  public boolean batchFinished() {

    if (getInputFormat() == null) {
      throw new IllegalStateException("No input instance format defined");
    }

    if (!isFirstBatchDone()) {
      // Do the subsample, and clear the input instances.
    	getInputFormat().randomize(m_Random);
    	createRemoveClass();
    }
    flushInput();

    m_NewBatch = true;
    m_FirstBatchDone = true;
    return (numPendingOutput() != 0);
  }

  /**
   * creates the subsample with replacement.
   * 
   * @param random		the random number generator to use
   * @param origSize		the original size of the dataset
   * @param sampleSize		the size to generate
   * @param actualClasses	the number of classes found in the data
   * @param classIndices	the indices where classes start
   */
 

  /**
   * Creates a subsample of the current set of input instances. The output
   * instances are pushed onto the output queue for collection.
   */
  protected void createRemoveClass() {
	Instances data = getInputFormat();
    int origSize = data.numInstances();
    for(int i = 0;i < origSize; i++){
    	Instance ins = data.instance(i);
    	if(ins.classValue() == 1){
    		push((Instance)ins.copy());
    	}
    }
  }
  
  /**
   * Returns the revision string.
   * 
   * @return		the revision
   */
  public String getRevision() {
    return RevisionUtils.extract("$Revision: 5542 $");
  }
  
  /**
   * Main method for testing this class.
   *
   * @param argv should contain arguments to the filter: 
   * use -h for help
   */
  public static void main(String [] argv) {
    runFilter(new Resample(), argv);
  }
}
