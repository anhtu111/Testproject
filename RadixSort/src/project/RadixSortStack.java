package project;



import java.util.*;
// sử dụng Stack để giải thuật toán Radix Sort đối với số - & +
public class RadixSortStack {
	
	
	//tim so lon nhat va co bao nhieu so 
	public static int count(int arr[], int n) {
		int max = Math.abs(arr[0]);
		int dem = 0;
		for (int i = 1; i < n; i++)
			if (Math.abs(arr[i]) > max)
				max = arr[i];

		while (Math.abs(max) > 0) {
				max /= 10;
				dem++;
		}
		return dem;
	}
	//chay ham while stack rôi lấy ra rồi setTest ào khung
	public static void sx(int a[] ) {
		
		//ArrayList<String> stringValue= new ArrayList<String>();
		
		// buoc 1:
		Stack Q = new Stack(); // tạo stack Q rỗng để cho các pt cua mang vao
		Stack[] QQ;  
		QQ = new Stack [20]; // Tạo 20 stack QQ rỗng
		for (int i = 0; i <= 19; i++)
		{	
			QQ[i] = new Stack();
		}
		//add gia tri vao mang stack
		for (int i = 0; i <a.length; i++) {
				Q.add(a[i]);
		}
		int d = 1;
		int k = count(a, a.length);
		int x, vt;
		//i=0 k=3
		for (int i = 0; i <k; i++)
		{
			while (!Q.isEmpty()) 
			{	
				x = (int) Q.pop(); //10
				if(x<0)
				{	
					//so am
					vt = ((Math.abs(x) / d) % 10)+10; 
					QQ[vt].add(x);
				}
				else
				{	
					//so duong
					vt = ((x / d) % 10); //0
					QQ[vt].add(x);
				}
			}	
			
			String tamp1="",tamp2="";
			
			//so duong
			for(int m=9;m>=0;m--) {
				
				while (!QQ[m].isEmpty()) 
					{
						x = (int) QQ[m].pop();
						Q.add(x);
						
						tamp1=tamp1+x+",";
					}
				
			}
			System.out.println("tam1 "+tamp1);
			//stringValue.add(tamp1);
			
			//so am
			for(int m1=10;m1<=19;m1++)
			{
					while (!QQ[m1].isEmpty()) 
					{
						x = (int) QQ[m1].pop();
						Q.add(x);
						
						tamp2=tamp2+x+",";
					}
					
			}
			System.out.println("tam2 "+tamp2);
			//stringValue.add(tamp2);
			
			//tang don vi chay
				d = Math.abs(d) * 10;
		}
		
		System.out.println("Q"+Q.toString());
		//in lộn lại mãng stack
		for(int i=0;i<a.length;i++)
		{
			a[i]=(int) Q.pop();
		}
		
		
			
	}

		static void println(int arr[]) {
			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
		}

		public static void main(String[] args) {
			int mang[] = { 8, 1, 21, -182, -577, -35,99, -67, 298, 10 };
			println(mang);
			System.out.println();
			sx(mang); 
			println(mang);
			


	}

}