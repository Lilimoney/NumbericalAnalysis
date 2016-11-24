/*
	������[-5,5] 10�ȷ֣��к���
	(1)y = 5/(1 + x^2)  (2)y = arctan x  (3)y = x/(1 + x^4)
	�ֱ���������������X(k)�ϵ�ֵ��������ֵ������ͼ�β���y=f(x)��ͼ�αȽϡ�
	(1)���������ղ�ֵ
*/
import java.util.Scanner;

class Lagrange{
	private int N;//��ֵ����
	private double a,b;//��ֵ�������Ҷ˵�a,b
	private double X[],Y[];//����ڵ�
	
	public Lagrange(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("�������ֵ����(a b)��");
		a = scanner.nextDouble();
		b = scanner.nextDouble();
		System.out.print("�������ֵ������");
		N = scanner.nextInt();
		X = new double[N+1];
		Y = new double[N+1];
	}
	
	public void solve(){//���
		Scanner s = new Scanner(System.in);
		System.out.print("������X(k)(��ΧΪ "+a+" ~ "+b+" )��ֵ��");
		double xk = s.nextDouble();
		setNode();//���ýڵ�����
		getNode();//����ڵ���Ϣ
		System.out.println("\n\n����ֵL("+xk+") = "+lagrangeFun(xk));
		System.out.println("��ȷֵf("+xk+") = "+function(xk));
	}
	
	public double lagrangeFun(double x){//�������ղ�ֵ����
		double m = 0.0;//f(x)�Ľ���ֵ
		for(int i = 0; i <= N; i++)
			m += lagrangeBasis(i,x)*Y[i];
		return m;
	}
	
	public double lagrangeBasis(int k,double x){//�������ղ�ֵ������
		double temp = 1;
		for(int i = 0; i <= N; i++)
			if(i != k) 
				temp *= (x - X[i])/(X[k] - X[i]);
		return temp;
	}
	
	public void setNode(){//���ø�����ֵ
		double temp;
		temp = (b - a)/N;
		for(int i = 0; i <= N; i++){
			X[i] = a + i*temp;
			Y[i] = function(X[i]);
		}
	}
	
	public void getNode(){//���������ֵ
		System.out.println("���������ֵ��\nX(i): ");
		for(int i = 0; i <= N; i++){
			System.out.printf(String.format("%10.6f",X[i]));	
		}
		System.out.println();
		System.out.println("Y(i): ");
		for(int j = 0; j <= N; j++){
			System.out.printf(String.format("%10.6f",Y[j]));	
		}
	}
	6r45
	public double function(double x){//����f(x)
		return 5.0/(1 + x*x);//����(1)
		//return Math.atan(x); //����2
		//return x/(1 + x*x*x*x); //����3
	}
}

class LagrangeTest{
	public static void main(String[] args){
		System.out.println("************************�������ղ�ֵ*************************");
		Lagrange l = new Lagrange();
		l.solve();
	}
}