
public class qsort {
	private final void qsort(int[] array, int from, int to) {
        if(to-from<1)return;
        int pivot=selectPivot(array,from,to);

        pivot=partion(array,from,to,pivot);
        
        qsort(array,from,pivot-1);
        qsort(array,pivot+1,to);
        
    }


    private int partion(int[] array, int from, int to, int pivot) {
        int tmp=array[pivot];
        array[pivot]=array[to];//now to's position is available
        
        while(from!=to)
        {
            while(from<to && tmp < array[from])from++;
            if(from<to)
            {
                array[to]=array[from];//now from's position is available
                to--;
            }
            while(from<to && tmp > array[to])to--;
            if(from<to)
            {
                array[from]=array[to];//now to's position is available now 
                from++;
            }
        }
        array[from]=tmp;
        return from;
    }
    
    private int selectPivot(int[] array, int from, int to) {
        return (from+to)/2;
    }
	
	public static void quicksort(int[] time,int left,int right){
		if(left < right){
			int i = left;
			int j = right;
			int x = time[left];
			
			while (i < j){
				while(i<j && time[j] >= x)
					j--;
				if(i < j)
					time[i++] = time[j];
				while(i < j && time[i] < x)
					i++;
				if(i < j)
					time[j--] = time[i];
			}
			time[i] = x;
			quicksort(time,left,i-1);
			quicksort(time,i+1,right);
		}
	}
}
