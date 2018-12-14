import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Traverse
{
	String token;
    Traverse(String t)
	{
		token=t;
	}
    public ArrayList<String> ged()
    {
    	int dis=-10000;
    	ArrayList<String> dic=new ArrayList<String>();
    	try
    	{
    		Scanner inputStream = new Scanner(new FileInputStream("dict.txt")); 
    		for(;inputStream.hasNextLine();)
    		{
    			String t=inputStream.nextLine();
    			int temp=calculate(t);
    			if(temp>dis)
    			{
    				dis=temp;
    				dic.clear();
    				dic.add(t);	
    			}
    			else if(temp==dis)
    			{
    				dic.add(t);
    			}
    		}
    		inputStream.close();
    	}
    	catch(FileNotFoundException e)
    	{
    		
    	}
    	return dic;
    }
    public int calculate(String t)
    {
        int lf=token.length();
    	int result=0;
    	int lt=t.length();
    	int[][]	matrix=new int[lf+1][lt+1];
    	matrix[0][0]=0;
    	for(int j=1;j<lt;j++)
    		matrix[j][0]=j*(-1);
    	for(int k=1;k<lf;k++)
    		matrix[0][k]=k*(-1);
    	for(int j=1;j<lt;j++)
    	{
    		for(int k=1;k<lf;k++)
    		{
    			int equal=token.charAt(k)==t.charAt(j)?1:(-1);
    			int temp=Math.max(matrix[j][k-1]-1, matrix[j-1][k]-1);
    			result=Math.max(temp, matrix[j-1][k-1]+equal);
    		}
    	}
    	return result;
    }

}

