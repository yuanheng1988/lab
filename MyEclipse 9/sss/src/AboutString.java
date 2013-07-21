public class AboutString  
{  
    public static void main(String[]arsgs)  
    {  
  
        String x=new StringBuffer().append("a").append("b").append("c").toString();  
        //效果与String x="a"+"b"+"c";一样  
        //但是使用StringBuffer()的效率要高  
        /* 
        原因如下(特别注明 该原因摘自OExpress(CSDN会员)的解释并稍作修订,我觉得他说得更为清楚,非常感谢OExpress): 
        java中StringBuffer与String在处理字符串时在效率上有很大的差异，尤其是当字符串很长时！ 
        字符串对象（String对象）的直是不可改变的，一旦创建了String类对象，就不能在改变其直，引起字符串的属性和长度改变的操作，将会得到一个复制了原对象中所需部分的新String对象（java实现努力试图将同一个类中的同样的字符串和字符的直合并到一个共享的字符串池中）。 
    StringBuffer类是一个为字符提供的可增大的缓冲区，他向缓冲区附加各种类型的数据，提供了大量的Append（）方法的重载。 
    例如以下例子： 
        String   testStr="hello "; 
        testStr=testStr+"world "; 
        testStr=testStr+"how are you "; 
    这里用String会反复产生新的String对象，字符数组必须反复复制，着对性能回产生负面影响。若使用StringBuffer类则为更好： 
        StringBuffer   testStrBuff=new testStrBuff("hello "); 
        testStrBuff.append("world "); 
        testStrBuff.append("how   are   you "); 
    长的字符串，应该是用StringBuffer来操作，建议可以把这个字符串接成几个字符串来处理，调用append方法类追加，这样将比使用String类有非常大的效率提升！！ 
    */  
        System.out.println(x);  
  
        String myName="xixifeng.com";  
        //输出索引为0的字符  
        System.out.println(myName.charAt(0));  
  
        System.out.println(myName.concat("xyz")); //表示myName+xyz  
  
        System.out.println(myName.endsWith(".com"));//判断myName是否是以".com"为后缀的结束,是:返回true 反之:false  
  
        //计算出字符床的长度  
        System.out.println("myname的长度:"+myName.length());  
  
        //检测字符串是否为空,是返回true 反之false  
        System.out.println("myName.isEmpty:"+myName.isEmpty());  
  
        //myName.indexOf('x') //表示从左到右搜寻myName字符串中的字符x所在的索引(从0开始计数)  
        System.out.println(myName.indexOf('f')); //如果没有,返回-1  
  
        //myName.indexOf('x') //表示从左到右从第2(以0开始计数)个开始搜寻myName字符串中的字符x所在的索引(从0开始计数)  
        System.out.println(myName.indexOf('x', 2));//如果没有,返回-1  
  
        //myName.indexOf("xi") 表示从左到右开始搜索myName字符串中的字符串"xi"所在的索引  
        System.out.println(myName.indexOf("xi"));//如果没有,返回-1  
  
        //myName.indexOf("xi") 表示从左到右从第2个开始搜索myName字符串中的字符串"xi"所在的索引  
        System.out.println(myName.indexOf("xi",2));//如果没有,返回-1  
  
        //左到右,从索引[2开始输出后面的内容  
        System.out.println("substring(2)->"+myName.substring(2));  
  
        //截取的字符串∈[8,10) 输出索引8(包括8)到10(不含10)区间的字符串  
        System.out.println("myName.substring(8, 10)->"+myName.substring(8, 10));  
  
        String myName2="Xixifeng.coM";  
  
        //myName.equals(myName2)表示:忽略大小写myName的值与myName2的值(注意:equals不是用于比较两个对象是否相等,而是比较对象的值)是否相等,相等返回true 反之 false  
        boolean iseq=myName.equals(myName2);  
        System.out.println(iseq);  
  
        //myName.equalsIgnoreCase(myName2)表示:忽略大小写myName与myName2是否相等,相等返回true 反之 false  
        boolean isEquals=myName.equalsIgnoreCase(myName2);  
        System.out.println("myName和myName2通过equalsIgnoreCase比较的结果:"+isEquals);  
  
        System.out.println("x在字符串中最后一次出现时所对应的索引是:"+myName.lastIndexOf('x'));  
  
        //startsWith, endsWith方法  
        System.out.println("该字符串是以xixifeng为前缀开始嘛?"+myName.startsWith("xixifeng"));  
        System.out.println("该字符串是以.com为后缀结束的嘛?"+myName.endsWith(".com"));  
          
        //java regionMatches方法应用  
        //myName.regionMatches(int firstStart, String otherStr, int otherFirst, int len);   
        //表示: 字符串myName从firstStart位(索引位置)开始截取,截取到长度为len时所得到的字符串,拿去  
        //跟 字符串otherStr从otherFirst开始截取,截取到长度为len得到的字符串比较,相等得true,反之false  
        System.out.println("regionMatches:"+myName.regionMatches(2, myName2, 2, 4));  
          
        //java replace方法应用举例  
        //myName.replace(char oldChar, char newChar) //返回一个新字符串, 是通过把myName中的oldChar字符全部替换成newChar字符而得到.  
        System.out.println(myName.replace('x', 'y'));  
        //myName.replaceAll(String oldStr,String newStr); //与上同理, 这里是替换字符串  
        //myName.replaceFirst(String oldStr,String newStr)//返回一个新字符串, 是通过把myName中的第一个oldStr字符串替换成newStr字符串而得到.  
    }  
}  