/*
	���������ʽ���㶨����
	��1��ln2 - ln3 = -2��(2,3)(1/(x^2-1))dx
	��2�� e^2 = ��(1,2)(xe^x)dx
	�ø������ι�ʽ�󶨻��֣�Ҫ��������Ϊexp = 1/2 * 10^(-7)��
	���������뾫ȷ�����Ƚϣ����Լ��������з���

	test
		fx = -2.0/(x*x - 1)
		
		T(128) = -0.405469
		T(256) = -0.405466
		T(512) = -0.405465
		��ȷֵΪ: -0.4054651081081645
*/
import java.util.Scanner;

class Trapezoidal{
	private double a,b;			//��ʾ��������[a,b]
	private double step = 0.0;	//����
	private double T = 0.0;		//�������λ��ּ�����
	public void solve(){		//���
		Scanner scanner = new Scanner(System.in);
		System.out.println("****************************�������ι�ʽ****************************");
		System.out.println("�������������a,b:");
		a = scanner.nextDouble();
		b = scanner.nextDouble();
		System.out.println("������ȷֵ�������:");
		int n = scanner.nextInt();
		step = (b - a)/n;
		double xk = a;
		for(int i = 1; i < n; i++){
			xk += step;
			T += fx(xk);
		}
		T = (fx(a) + 2*T + fx(b))*step/2.0;//���㸴�����λ��ֽ��
		System.out.println("T(" + n + ") = " + String.format("%10.6f",T));
		
		double exact = (Math.log(2) - Math.log(3)); //����(1)�ľ�ȷֵ
		//double exact = Math.E*Math.E;				//����(2)�ľ�ȷֵ
		System.out.println("��ȷֵΪ: " + exact);  
		
		double exp = Math.abs(exact - T);	//���
		System.out.print("���Ϊ: " + String.format("%.3E",exp));
		if(exp < 0.5E-7)
			System.out.println(" < 0.5E-7");
		else
			System.out.println(" > 0.5E-7");
	}
	public double fx(double x){	//����f(x)
		return -2.0/(x*x - 1);			//����(1)	
		//return x*Math.pow(Math.E,x);	//����(2)
	}
}

class TrapezoidalTest{
	public static void main(String[] args){
		Trapezoidal z = new Trapezoidal();
		z.solve();
	}
}