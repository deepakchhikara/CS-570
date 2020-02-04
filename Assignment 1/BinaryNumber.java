/* 
 * Assignment : 1
 * Name: Deepak
   CWID: 10442727 
   Course: CS-570
   */ 

package assn1;
import java.util.*; 
import java.util.Arrays;

public class BinaryNumber {
	
	private int data[]; //declare object type array
	private boolean overflow;
 //For creating a binary number of length
	public BinaryNumber(int length){
	data= new int[length];  // initialization with length
	for(int i=0; i<length;i++) {
		data[i]=0;
	}
	
	}
	//For creating a binary number String
	public BinaryNumber(String str){
		int length=str.length();// return the length of this string
		data= new int[length];
		for(int i=0; i<length; i++) {
			if(Character.getNumericValue(str.charAt(i))==1 || Character.getNumericValue(str.charAt(i))==0) {
				
				data[i]= Character.getNumericValue(str.charAt(i));
			} 
			else {System.out.println("Input number is not Binary");}
			
		}
		
		//For determining the length of binary number
	}
	public int getLength() {
			return data.length;
			
		}
	//for obtaining a digit of a binary number given an index
	public int getDigit(int index) {
		
		if(index>data.length) {
			System.out.println("The index is out of bounds");
			System.exit(1);
			return 0;
		} 
		else {
				return data[index];}
		}
	
	// For transforming a binary number to its decimal notation
	public int toDecimal() {
		int decimal = 0;int n = 0;int d = 0;
		 ;
		 for(int i=0; i<data.length; i++) {	
			 d = data[i];
			 decimal = (int) (decimal + d * Math.pow(2,n));
			n++;
		 }
		 return decimal;
		 
	 }
	public void shiftR(int amount) {
		
		data = Arrays.copyOf(data,(data.length + amount));
		int t = data.length;
		for(int a=0; a<amount; a++) {
			int temp = data[t-1];
			for(int i=t-1; i>0; i--) {
				data[i] = data[i-1];
			}
			data[0] = temp;}
	}
	//Adding two binary numbers.
		public void add(BinaryNumber aBinaryNumber) {
			int data1[] = new int[aBinaryNumber.getLength()];
			data1 = aBinaryNumber.getBinary();
			int carry = 0;
			if(data.length == data1.length) {
				for(int i=0; i<data.length; i++) {
					int t = (carry + data[i] + data1[i]);
					if(t == 0) {
						data[i] = 0;
						carry = 0;
					} else if(t == 1) {
						data[i] = 1;
						carry = 0;
					} else if(t == 2) {
						data[i] = 0;
						carry = 1;
					} else if(t == 3) {
						data[i] = 1;
						carry = 1;
					}
				}
				if(carry == 1) {
					overflow = true;				
				}
			}
			else {
				System.out.println("The lengths of the binary numbers do not coincide.");
			}
		}
		
		private int[] getBinary() {
			return data;
		}
		//Transforming a binary number to a String.
		public String toString(){
			if(overflow) {
				return "overflow";
			}
			else {
				for (int i=0; i<data.length; i++) {
	        	System.out.print(data[i]);
	        }
			return ".";
			}
		}
		public void clearOverflow() {
			overflow = false;
		}
		

	public static void main(String[] args) {
		
		BinaryNumber bn1 = new BinaryNumber(7);
		BinaryNumber bn2 = new BinaryNumber("1011011");
		
		bn1.toString();
		System.out.println();
		System.out.println(bn2.getLength());
		System.out.println(bn2.getDigit(3));
		//bn2.shiftR(3);
	  // System.out.println(bn2.toString());
		bn1.add(bn2);
		System.out.println(bn1.toString());
		System.out.println(bn2.toDecimal());
	}
		
	}


