package interviewTest;

/*����һ����a[N]������ϣ����������b [N]������b[j]=a[0]*a[1]��a[N-1] / a[j]���ڹ�������У�������ʹ�ó�����

Ҫ��O��1���ռ临�ӶȺ�O��n����ʱ�临�Ӷȣ�

��������������a[N] b[N]�⣬����ʹ���µı���������ջ��ʱ�������ѿռ��ȫ�־�̬�����ȣ���

ʵ�ֳ����������������ѡ��ʵ�ֲ���������*/

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
		/*����ķ���������ʱ�临�Ӷ�Ҫ��*/
		//��ʵ����һ���������뵹���ǵ����⣬��b[j]Ϊ�磬������ѭ���������
		b[0] = 1;
		for(int i=1;i<N;i++){
			b[i] = b[i-1]*a[i-1];
		}
		for(int i=N-2;i>=0;i--){
			b[0] *= a[i+1];
			if(i!=0)
				b[i] *= b[0] ; 
		}
		/*�÷�������ʱ�临�Ӷ�Ҫ��*/
		
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
