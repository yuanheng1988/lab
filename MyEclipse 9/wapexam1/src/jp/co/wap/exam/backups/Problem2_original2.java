package jp.co.wap.exam.backups;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jp.co.wap.exam.lib.Interval;

public class Problem2_original2 {
	private List<Integer> deadlineTime;
	private List<Integer> executeTime;
	private List<Integer> startTime;
	private int[][] maxstore;
	
	public int getMaxWorkingTime(List<Interval> intervals){
		Map<Integer,Integer> itervalMap = new IdentityHashMap<Integer, Integer>(); 
		for(int i = 0; i < intervals.size();i++){
			itervalMap.put(intervals.get(i).getEndMinuteUnit(), intervals.get(i).getIntervalMinute());
		}
		
		List<Entry<Integer, Integer>> itervallist = new ArrayList<Entry<Integer, Integer>>(itervalMap.entrySet());  
        Collections.sort(itervallist, new Comparator<Object>() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Entry) (o1)).getKey())
						.compareTo(((Entry) (o2)).getKey());
			}
		});
        
        deadlineTime = new ArrayList<Integer>();
        executeTime = new ArrayList<Integer>();
        startTime = new ArrayList<Integer>();
        for (Entry<Integer, Integer> entry : itervallist) {  
//          System.out.println("\t" + entry.getKey() + "\t\t" + entry.getValue());  
          deadlineTime.add(entry.getKey());
          executeTime.add(entry.getValue());
          startTime.add(entry.getKey()- entry.getValue());
        }

        int size = itervallist.size();
        maxstore = new int[size][24*60];
    	for(int i = 0; i < size; i++){
    		for(int j = 0; j < 24*60; j++){
    			maxstore[i][j] = -1; 
    		}
    	}
        
		return getMaxtime(size-1,deadlineTime.get(size-1));
	}
	
	//use space to exchange for time, but still will overflow when the number of intervals exceeds 5000 around.
	private int getMaxtime(int i, int Deadline){
		if(Deadline<0) return 0;
		if (maxstore[i][Deadline] == -1)
		{	
			if (i == 0 && deadlineTime.get(0) <= Deadline)
				maxstore[i][Deadline]=executeTime.get(0);
			else if (i == 0 && deadlineTime.get(0) > Deadline)
				maxstore[i][Deadline]=0;
			else if (deadlineTime.get(i) > Deadline)
				maxstore[i][Deadline]=getMaxtime(i-1,Deadline);
			else
			maxstore[i][Deadline] = Math.max(getMaxtime(i-1,startTime.get(i)-1)+executeTime.get(i), getMaxtime(i-1,Deadline));
		}
		return maxstore[i][Deadline];
	}

}
