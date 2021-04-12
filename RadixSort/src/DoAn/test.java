package DoAn;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.midi.Soundbank;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.Timer;

//import java.util.RadixSortStack;
import java.awt.Color;


public class test extends JFrame {
	
	//////////////////////animation
	static int cinTime=1000;
	static int cin=0;
	static int indexAnimation=-1;
	static String valueAnimation=" ";
	static ArrayList<Integer> ArrNumber= new ArrayList<Integer>();
	static ArrayList<Integer> ArrNumberM;
	
	static ArrayList<Stack<Integer>[]> eAnimation ;
	
	
	///////////////////////
	
	
	
	
	//tim chu so cua so lon nhat
	public static int count(ArrayList arr, int n) {
		int max = Math.abs((int)arr.get(0));
		int dem = 0;
		for (int i = 1; i < n; i++)
			if ( Math.abs( (int) arr.get(i)) > max)
				max =(int) arr.get(i);

		while (Math.abs(max) > 0) {
				max /= 10;
				dem++;
		}
		return dem;
	}
	//chay ham while stack rôi lấy ra rồi setTest ào khung
	public static void sx(ArrayList a , JTextField[] valueStack2 )  {
		// buoc 1:
		
		ArrayList<String> stringValue= new ArrayList<String>();
		
		Stack Q = new Stack(); // tạo stack Q rỗng để cho các pt cua mang vao
		
		Stack[] QQ,kk;
		QQ = new Stack [20]; // Tạo 20 stack QQ rỗng
		kk=new Stack [20];
		
		// Minh code 
		//mãng 3 chi�?u
		eAnimation = new ArrayList<Stack<Integer>[]>();
		
		/////
		
		
		for (int i = 0; i <= 19; i++)
		{	
			
			
			QQ[i] = new Stack();
			
			 
			//
			kk[i] = new Stack();
			
		}
		
		//add gia tri vao mang stack
		for (int i = 0; i <a.size(); i++) {
			
				Q.add( (a.get(i)) );
		}
		int d = 1;
		int k = count(a, a.size());
		int x, vt;
		//i=0 k=4
		for (int i = 0; i <k; i++)
		{
			
			// bốc từ Q-> QQ
			while (!Q.isEmpty()) 
			{	
				x = (int) Q.pop(); //
				if(x<0)
				{	
					vt = ((Math.abs(x) / d) % 10)+10; 
					QQ[vt].add(x);

					// Minh code
					 
					
					kk[vt].add(x);

				}
				else
				{
					vt = ((x / d) % 10); 
					QQ[vt].add(x);

					
					
					// Minh code
					 
					
					
					kk[vt].add(x);
					
				}
			}
			
			//eAnimation có vd có tới 3 thằng Stack kk
			eAnimation.add(kk);
			
//			if( !eAnimation.get(0)[1].isEmpty()) {
//				System.out.println("------------"+eAnimation.get(0)[1].pop());
//			}
			
//			di dia chi moi cho kk
			kk= new Stack[20];
			for (int m = 0; m <= 19; m++)
			{	
			
				kk[m] = new Stack();

			}
//			
			

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
			stringValue.add(tamp1);
			
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
			stringValue.add(tamp2);
				
				d = Math.abs(d) * 10;
		}
		
		//lay ket qua sau khi sort xong
		ArrNumberM= new ArrayList<Integer>();
		while( !Q.isEmpty()) {
			ArrNumberM.add((int)Q.pop());
		}
	
		
	}

		
		
	
	//////////////////////////

	private JPanel contentPane;
	private JTextField getValueArr;
	private Timer timer;
	private JLabel infoStack[];
	private JTextField valueStack[];
	private int index,index2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	int number=0;
	String valueTextStack;
	
	private JLabel lblNewLabel_1;
	private JTextField displayArr;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JTextField arrKetqua;
	private JButton btnRunSort;
	private JLabel lblNewLabel_4;
	
	

	
	
	
//	public void delayDemo( int num , String value ,int s  ) {
//		
//		
//		valueTextStack=value;
//		index2=num;
//		
//		
//		
//		Timer timer0 = new Timer(s ,index -> {
////			String tampValue=valueStack[index.getModifiers()].getText()+","+index.getModifiers()*3;
//			valueStack[index2].setText(valueTextStack);
////		    System.out.println("index:"+index2);
//		});
//		
//		
//		
//		timer0.setRepeats( false );
//		timer0.start();
//		
//	
//	}
	
	// hàm ch�? 
	synchronized private void delay(int milliseconds) {
        try {
            wait(milliseconds);
        }
        catch (InterruptedException e) {
        }
    }
	
	
	public test() {
		
		setSize(1000,1000);
		
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		getValueArr = new JTextField();
		getValueArr.setBounds(339, 11, 297, 30);
		contentPane.add(getValueArr);
		getValueArr.setColumns(10);
		
		JButton btnGetValueArr = new JButton("getValue");
		btnGetValueArr.setBounds(762, 15, 89, 23);
		btnGetValueArr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//nhap va lay so phan tu trong mang
				String tapm=getValueArr.getText();
				Scanner enter= new Scanner(tapm);
				number=enter.nextInt();
//				System.out.println(number);
				enter.close();
				Random rd=new Random();
				for(int i=0;i<number;i++)
				{	
					ArrNumber.add(rd.nextInt(2000)-1000);
//					ArrNumber.add(rd.nextInt((1000 - (-1000)) + 1) + (-1000));
				}
				System.out.print(ArrNumber); 
				
				///
				displayArr.setText("Arr:"+ArrNumber.toString());
				
			}
		});
		contentPane.add(btnGetValueArr);
		
		JLabel lblNewLabel = new JLabel("Nhập Vào Số Lượng Phần Tử");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(98, 15, 192, 22);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Value");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(148, 50, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		displayArr = new JTextField();
		displayArr.setBounds(236, 42, 509, 30);
		contentPane.add(displayArr);
		displayArr.setColumns(10);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(373, 620, 165, 54);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("K\u1EBFt qu\u1EA3");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(27, 545, 84, 34);
		contentPane.add(lblNewLabel_2);
		
		arrKetqua = new JTextField();
		arrKetqua.setBounds(98, 535, 753, 54);
		contentPane.add(arrKetqua);
		arrKetqua.setColumns(10);
		
		
		
	//	 khoi toa 20 thang inforstack  và valueStack
				infoStack= new JLabel[20];
				valueStack= new JTextField[20];
				
				int x10=100;
				int x20=500;
				int y=160;
				
				for(int i=0;i<20;i++) {
					
					int xNow=x10,yNow=y;
					
					String name="";
					name="F"+(i-9)*-1;
					if(i>=0&&i<10) {
						
						xNow=x10;
						yNow=y+(i*30);
						name="F"+i;
					}
					else {
						name="F"+((i-10)*-1);
						xNow=x20;
						yNow=y+((i-10)*30);
						
					}

					valueStack[i]=new JTextField(i);
					valueStack[i].setBounds(xNow+20, yNow, 300, 30);
					contentPane.add(valueStack[i]);
					infoStack[i] = new JLabel(name);
					infoStack[i].setBounds(xNow, yNow, 70, 25);
					contentPane.add(infoStack[i]);
					
				}
		
		btnRunSort = new JButton("RunSort");
		btnRunSort.setBounds(762, 46, 89, 23);
		btnRunSort.addActionListener(
				
			new ActionListener() {
				
			//	khoi toa 20 thang inforstack  và valueStack
			public void actionPerformed(ActionEvent e) {
				
					sx(ArrNumber, valueStack);
				System.out.println("---------------su ly xong ----------------");
				
				System.out.println("--0ke---");
				
//				for( int i=0 ;i< eAnimation.size();i++) {
//					
//					System.out.println("run"+i);
//					
//					for( int j=0 ;j<eAnimation.get(i).length;j++) {
//						
////						System.out.println("runj"+j);
//
//						while(!eAnimation.get(i)[j].isEmpty() ) {
//							
////							System.out.println("run --");
//							System.out.println(" giá trị lần chạy "+i+" với giá trị queu thứ "+j+"   --   "+eAnimation.get(i)[j].peek());
//						}
//						
//						
//					}
//				}
				
				
				/////////////////////////////////////////////////////
				Timer time = new Timer (cinTime, new ActionListener() {
				
				                @Override
				                public void actionPerformed(ActionEvent e) {                    
				                	
				                	indexAnimation+=1;
//				                	valueAnimation+="i";
				                	//số lần chạy 
				                	//size = 3 (gồm có 3 stack )
				                	if(cin<eAnimation.size()) {
				                		
				                		//lân đầu tiên lấy stack[0]
				                		//cin=0 thì eAnimation[1]
				                		if( indexAnimation< eAnimation.get(cin).length) {
				                			
					                		while(!eAnimation.get(cin)[indexAnimation].isEmpty()) {
					                			valueAnimation+=eAnimation.get(cin)[indexAnimation].pop()+" , ";

					                		}
					                		
					                		// lấy ra xong giá trị b�? vô va in ra man hình
					                		lblNewLabel_4.setText("�?ang Chạy Lần "+(cin+1));
					                		valueStack[indexAnimation].setText(valueAnimation);
					                		//gan lay cho rỗng
					                		valueAnimation="";
					                		
					                	}
					                	
				                		//truong hợp để dừng khi hết gia tri trong mang
					                	if( indexAnimation>=eAnimation.get(cin).length) {
					                		indexAnimation=-1;
					                		cin++;
					                		//chạy xong rồi xóa hết các textFile đi rồi chạy laiij rồi nhập lại
					                		for( int k=0; k<valueStack.length;k++) {
					                			valueStack[k].setText("");
					                		}
					                		//dung lai ke check 2 giay
					                		delay(3000);
					                	}
				                		
					                	//in ra kết quả khi đếm lần chạy cuối cùng
					                	if( cin==eAnimation.size()) {
						                		arrKetqua.setText(ArrNumberM.toString());
						                	}
				                	}
				                }
				            });
//							time.setRepeats(false);
							time.start();	
				
			}
		});
		contentPane.add(btnRunSort);
		
		lblNewLabel_4 = new JLabel("Đang Chạy Lần : 1");
		lblNewLabel_4.setBounds(339, 84, 500, 40);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel_4);
		
	}
}
