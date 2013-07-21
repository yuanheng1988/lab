package interviewTest;

/*给定一数组a[N]，我们希望构造数组b [N]，其中b[j]=a[0]*a[1]…a[N-1] / a[j]，在构造过程中，不允许使用除法：

要求O（1）空间复杂度和O（n）的时间复杂度；

除遍历计数器与a[N] b[N]外，不可使用新的变量（包括栈临时变量、堆空间和全局静态变量等）；

实现程序（主流编程语言任选）实现并简单描述。*/

public class qq2012_additionTest {
	
	public static void main(String[] args){
		int N = 5;
		int[] a = {1,3,5,7,9};
		int[] b = new int[N];
		/*for(int i=0;i<N;i++)
			b[i] = 1;
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(i == j)
					continue;
				b[i] *= a[j];
			}
		}*/
		/*上面的方法不满足时间复杂度要求*/
		//其实这是一个正三角与倒三角的问题，以b[j]为界，用两个循环完成任务。
		b[0] = 1;
		for(int i=1;i<N;i++){
			b[i] = b[i-1]*a[i-1];
		}
		for(int i=N-2;i>=0;i--){
			b[0] *= a[i+1];
			if(i!=0)
				b[i] *= b[0] ; 
		}
		/*该方法满足时间复杂度要求。*/
		
		System.out.println("Array a is:");
		for(int i=0;i<N;i++){
			System.out.print(a[i] + " ");
		}
			
		System.out.println("\n\nArray b is:");
		for(int i=0;i<N;i++){
			System.out.print(b[i] + " ");
		}
			
	}	
}
