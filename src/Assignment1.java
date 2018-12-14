import java.util.ArrayList;
public class Assignment1
{
	public static void main(String[] args)
	{
		String misspell="abbout";
		Traverse T=new Traverse(misspell);
		ArrayList<String> al=T.ged();
		for(int i=0;i<al.size();i++)
			System.out.println(al.get(i));
	}
}
