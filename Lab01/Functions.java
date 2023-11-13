
public class Functions {
	public void getTriples(int bound) {
		for (int i=1; i <= bound;i++) {
			for(int j =1; j <= bound; j++) {
				for (int k =1 ; k <= bound; k++) {
					if (k*k == i*i + j*j) {
						System.out.println("a: "+i+ "b: "+j+"c: "+k);
						
					}
					
				}
			}
		}	
	}
	public boolean ispalindrome(int number){
		// int left = number % 10;
		// int right = number / 10000;
		// if( left != right){
		// 	return false;
		// }
		// int new_number = ((number - number%10) / 10) % 1000;
		// left = new_number % 10;
		// right = new_number / 100;
		// if( left != right){
		// 	return false;
		// }
		// return true;
		StringBuilder sb = new StringBuilder(String.valueOf(number));
		int palindrome = Integer.parseInt(sb.reverse().toString());
		return number == palindrome;
	}
	public void printtriangles(int number) {
		if(number == 1){		
			for(int i = 0; i<10;i++){
					for(int j = 0; j<=i;j++){
						System.out.print("*");
				}
				System.out.println("");
			}
		}
		else if(number == 2){
			for(int i =0; i<10;i++){
				for(int j = 0; j<10-i;j++){
					System.out.print("*");
				}
				System.out.println("");
			}
		}
		else if(number == 3){
			for(int i =0; i<10;i++){
				for(int j = 0; j<10;j++){
					if(i<=j){
						System.out.print("*");
					}
					else{
						System.out.print(" ");
					}
				}
				System.out.println("");
			}
		}
		else if(number == 4){
			for(int i =0; i<10;i++){
				for(int j = 0; j<10;j++){
					if(i<=j){
						System.out.print(" ");
					}
					else{
						System.out.print("*");
					}
				}
				System.out.println("");
			}
		}
	}
}