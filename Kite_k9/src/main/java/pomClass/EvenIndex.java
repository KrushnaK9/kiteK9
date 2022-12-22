package pomClass;

public class EvenIndex {

	public static void main(String[] args) {
		int str [] = {5,62,332,66,22,9,2,26,33,8252,56};
		for(int i=0; i<=str.length-1 ; i++)
		{
			if(i%2 == 0)
			{
				System.out.println(str[i]);
			}
		}

	}

}
