public class AboutString  
{  
    public static void main(String[]arsgs)  
    {  
  
        String x=new StringBuffer().append("a").append("b").append("c").toString();  
        //Ч����String x="a"+"b"+"c";һ��  
        //����ʹ��StringBuffer()��Ч��Ҫ��  
        /* 
        ԭ������(�ر�ע�� ��ԭ��ժ��OExpress(CSDN��Ա)�Ľ��Ͳ������޶�,�Ҿ�����˵�ø�Ϊ���,�ǳ���лOExpress): 
        java��StringBuffer��String�ڴ����ַ���ʱ��Ч�����кܴ�Ĳ��죬�����ǵ��ַ����ܳ�ʱ�� 
        �ַ�������String���󣩵�ֱ�ǲ��ɸı�ģ�һ��������String����󣬾Ͳ����ڸı���ֱ�������ַ��������Ժͳ��ȸı�Ĳ���������õ�һ��������ԭ���������貿�ֵ���String����javaʵ��Ŭ����ͼ��ͬһ�����е�ͬ�����ַ������ַ���ֱ�ϲ���һ��������ַ������У��� 
    StringBuffer����һ��Ϊ�ַ��ṩ�Ŀ�����Ļ����������򻺳������Ӹ������͵����ݣ��ṩ�˴�����Append�������������ء� 
    �����������ӣ� 
        String   testStr="hello "; 
        testStr=testStr+"world "; 
        testStr=testStr+"how are you "; 
    ������String�ᷴ�������µ�String�����ַ�������뷴�����ƣ��Ŷ����ܻز�������Ӱ�졣��ʹ��StringBuffer����Ϊ���ã� 
        StringBuffer   testStrBuff=new testStrBuff("hello "); 
        testStrBuff.append("world "); 
        testStrBuff.append("how   are   you "); 
    �����ַ�����Ӧ������StringBuffer��������������԰�����ַ����ӳɼ����ַ�������������append������׷�ӣ���������ʹ��String���зǳ����Ч���������� 
    */  
        System.out.println(x);  
  
        String myName="xixifeng.com";  
        //�������Ϊ0���ַ�  
        System.out.println(myName.charAt(0));  
  
        System.out.println(myName.concat("xyz")); //��ʾmyName+xyz  
  
        System.out.println(myName.endsWith(".com"));//�ж�myName�Ƿ�����".com"Ϊ��׺�Ľ���,��:����true ��֮:false  
  
        //������ַ����ĳ���  
        System.out.println("myname�ĳ���:"+myName.length());  
  
        //����ַ����Ƿ�Ϊ��,�Ƿ���true ��֮false  
        System.out.println("myName.isEmpty:"+myName.isEmpty());  
  
        //myName.indexOf('x') //��ʾ��������ѰmyName�ַ����е��ַ�x���ڵ�����(��0��ʼ����)  
        System.out.println(myName.indexOf('f')); //���û��,����-1  
  
        //myName.indexOf('x') //��ʾ�����Ҵӵ�2(��0��ʼ����)����ʼ��ѰmyName�ַ����е��ַ�x���ڵ�����(��0��ʼ����)  
        System.out.println(myName.indexOf('x', 2));//���û��,����-1  
  
        //myName.indexOf("xi") ��ʾ�����ҿ�ʼ����myName�ַ����е��ַ���"xi"���ڵ�����  
        System.out.println(myName.indexOf("xi"));//���û��,����-1  
  
        //myName.indexOf("xi") ��ʾ�����Ҵӵ�2����ʼ����myName�ַ����е��ַ���"xi"���ڵ�����  
        System.out.println(myName.indexOf("xi",2));//���û��,����-1  
  
        //����,������[2��ʼ������������  
        System.out.println("substring(2)->"+myName.substring(2));  
  
        //��ȡ���ַ�����[8,10) �������8(����8)��10(����10)������ַ���  
        System.out.println("myName.substring(8, 10)->"+myName.substring(8, 10));  
  
        String myName2="Xixifeng.coM";  
  
        //myName.equals(myName2)��ʾ:���Դ�СдmyName��ֵ��myName2��ֵ(ע��:equals�������ڱȽ����������Ƿ����,���ǱȽ϶����ֵ)�Ƿ����,��ȷ���true ��֮ false  
        boolean iseq=myName.equals(myName2);  
        System.out.println(iseq);  
  
        //myName.equalsIgnoreCase(myName2)��ʾ:���Դ�СдmyName��myName2�Ƿ����,��ȷ���true ��֮ false  
        boolean isEquals=myName.equalsIgnoreCase(myName2);  
        System.out.println("myName��myName2ͨ��equalsIgnoreCase�ȽϵĽ��:"+isEquals);  
  
        System.out.println("x���ַ��������һ�γ���ʱ����Ӧ��������:"+myName.lastIndexOf('x'));  
  
        //startsWith, endsWith����  
        System.out.println("���ַ�������xixifengΪǰ׺��ʼ��?"+myName.startsWith("xixifeng"));  
        System.out.println("���ַ�������.comΪ��׺��������?"+myName.endsWith(".com"));  
          
        //java regionMatches����Ӧ��  
        //myName.regionMatches(int firstStart, String otherStr, int otherFirst, int len);   
        //��ʾ: �ַ���myName��firstStartλ(����λ��)��ʼ��ȡ,��ȡ������Ϊlenʱ���õ����ַ���,��ȥ  
        //�� �ַ���otherStr��otherFirst��ʼ��ȡ,��ȡ������Ϊlen�õ����ַ����Ƚ�,��ȵ�true,��֮false  
        System.out.println("regionMatches:"+myName.regionMatches(2, myName2, 2, 4));  
          
        //java replace����Ӧ�þ���  
        //myName.replace(char oldChar, char newChar) //����һ�����ַ���, ��ͨ����myName�е�oldChar�ַ�ȫ���滻��newChar�ַ����õ�.  
        System.out.println(myName.replace('x', 'y'));  
        //myName.replaceAll(String oldStr,String newStr); //����ͬ��, �������滻�ַ���  
        //myName.replaceFirst(String oldStr,String newStr)//����һ�����ַ���, ��ͨ����myName�еĵ�һ��oldStr�ַ����滻��newStr�ַ������õ�.  
    }  
}  