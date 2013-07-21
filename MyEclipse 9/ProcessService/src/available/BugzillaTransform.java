package available;


public class BugzillaTransform {

	/**
	 * @param args
	 */
	public static String Trans(String str)
	{
		String[] temp=str.split("\"");
		int n=temp.length;
		for(int i=0;i<n;i++)
		{
			System.out.println(temp[i]);
			boolean flag=true;
			for(int j=0;j<temp[i].length();j++)
			{
				if(Character.isLetter(temp[i].charAt(j))==false)
				{
					if(temp[i].charAt(j)!=':')
					{
						flag=false;
						break;
					}
				}
			}
			if(flag==true && temp[i].length()>1)
			{
				temp[i]=temp[i].replace(':','_');
			}
//			System.out.println(temp[i]+"***");
		}
		String ans="";
		for(int i=0;i<n;i++)
		{
			ans=ans+temp[i]+"\"";
		}
		return ans;
	}
}
