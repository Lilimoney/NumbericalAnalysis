/*
	������[-5,5] 10�ȷ֣��к���
	(1)y = 5/(1 + x^2)  (2)y = arctan x  (3)y = x/(1 + x^4)
	�ֱ���������������X(k)�ϵ�ֵ��������ֵ������ͼ�β���y=f(x)��ͼ�αȽϡ�
	(2)��ţ�ٲ�ֵ
*/
import java.util.Scanner;

class Newton{
	private int N;//��ֵ����
	private double a,b;//��ֵ�������Ҷ˵�a,b
	private double X[],Y[];//����ڵ�
	
	public Newton(){
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
		setNode();
		getNode();
		System.out.println("\n\n����ֵL("+xk+") = "+NewtonFun(xk));
		System.out.println("��ȷֵf("+xk+") = "+function(xk));
	}
	
	public double NewtonFun(double x){//ţ�ٲ�ֵ����
		int i,j,k;
		double s = Y[0];
		double d = 1;
		double df[][] = new double[N+1][N+2];//�������
		for(i = 0; i <= N; i++){
			df[i][0] = X[i];//����X��ֵ
			df[i][1] = Y[i];//����0�ײ���
		}
		//for(j = 1; j < N+1; j++)
			//for(k = j + 1; k < N+2; k++)
		for(k = 2; k < N + 2; k++)
			for(j = k - 1; j < N + 1; j++)
				df[j][k] = (df[j][k-1] - df[j-1][k-1])/(df[k-1][0] - df[0][0]);//����1~N�ײ���
		
		//���1~N�ײ���
		System.out.printf("   x\t    f(x) ");
		for(i = 1; i <= N; i++)
			System.out.print("\t   "+i+"��");
		System.out.println();
		for(i = 0; i <= N; i++){
			for(j = 0; j <= i+1;j++)
				System.out.print(String.format("%10.5f",df[i][j]));
			System.out.println();
		}
		
		//����ţ�ٲ�ֵ
		for(i = 1; i <= N; i++){
			d *= (x - X[i-1]);
			s += df[i][i+1]*d;
		}
		return s;
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
		System.out.println("\n");
	}
	
	public double function(double x){//����f(x)
		return 5.0/(1 + x*x);//����(1)
		//return Math.atan(x); //����2
		//return x/(1 + x*x*x*x); //����3
	}
}
class NewtonTest{
	public static void main(String[] args){
		System.out.println("************************ţ�ٲ�ֵ*************************");
		Newton n = new Newton();
		n.solve();
	}
}