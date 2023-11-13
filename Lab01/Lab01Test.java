
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab01Test {

    public static void main(String[] args) throws IOException {
        useFunction();
        usePoint3D();
    }

    public static void useFunction() throws IOException {
        // Scanner scanner = new Scanner(System.in); // Scanner 객체 생성
		// shfit + alt + O => import 하는거 자동추가
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int number = Integer.parseInt(br.readLine());

        Functions f = new Functions();
        // f1.getTriples(50);
		System.out.println("숫자를 입력해주세요.");
        // int number = scanner.nextInt(); // Scanner 객체를 사용하여 정수 입력 받기

        if(f.ispalindrome(Integer.parseInt(br.readLine()))){
			System.out.println("성립하는 수입니다.");
		}
		else{
			System.out.println("성립하지 않는 수입니다.");
		}
		
		System.out.println("1 ~ 4를 입력해주세요.");
		// int new_number = scanner.nextInt(); // Scanner 객체를 사용하여 정수 입력 받기
		// int new_number = Integer.parseInt(br.readLine());
		f.printtriangles(Integer.parseInt(br.readLine()));
       
    }

    public static void usePoint3D() {
		Point_3D p1 = new Point_3D(0.0, 0.0, 0.0);
		Point_3D p2 = new Point_3D();
		System.out.println(p1); // => 주소 출력하는거
		System.out.println(p2);	// => 주소 출력하는거
		p1.displayPoint();
		p2.displayPoint();
	
		p1.setcord(5.7, 3.0, 8.1);
		p2.setcord(1.7, 1.0, 3.5);
	
		// System.out.println("Length of P1 Point " + p1.getlength());
		// System.out.println("Length of P2 Point " + p2.getlength());
		// System.out.println("Distance between p1 and p2 = " + p1.getdistance(p2));

		StringBuilder sb = new StringBuilder();
		sb.append("Length of P1 Point ").append(p1.getlength());
		sb.append("\nLength of P2 Point ").append(p2.getlength());
		sb.append("\nDistance between p1 and p2 = ").append(p1.getdistance(p2));

		System.out.println(sb);
	}	
}
