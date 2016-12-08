/*
	���������ʽ���㶨����
	��1��ln2 - ln3 = -2��(2,3)(1/(x^2-1))dx
	��2�� e^2 = ��(1,2)(xe^x)dx
	��������ʽ�󶨻��֣�Ҫ��������Ϊexp = 1/2 * 10^(-7)��
	���������뾫ȷ�����Ƚϣ����Լ��������з���

	test
		fx = -2.0/(x*x - 1)

		S(8)  = -0.405472
		S(16) =  -0.405466
		S(32) =  -0.405465
		��ȷֵΪ: -0.4054651081081645
*/
import java.util.Scanner;

class Romberg{
	private double a,b;			//��ʾ��������[a,b]
	private double step = 0.0;	//����
	private double T[][] = new double[10][4];	//T��
	
	public void solve(){//���
		Scanner scanner = new Scanner(System.in);
		System.out.println("****************************������ʽ****************************");
		System.out.println("�������������a,b:");
		a = scanner.nextDouble();
		b = scanner.nextDouble();
		System.out.println("�����뾫��:");
		double esp = scanner.nextDouble();
		
		double T1,T2;			//�洢����ǰ�Ͷ��ֺ��Romberg����ֵ
		double xk,sum = 0.0;	//xkΪÿ��ȡ������xֵ,sumΪ����ֵ
		int n = 1;				//nΪ�����
		step = b - a;			//��һ�ζ���
		int i = 1,j,k;
		T2 = step*(fx(a) + fx(b))/2.0;
		T[0][0] = T2;
		do{	//i:���� j:����
			sum = 0.0;  T1 = T[i-1][0];  xk = a;
			step /= 2;	//�������
			n *= 2;		//���������
			for(k = 1; k < n; k += 2){//������ֺ��������ĺ���ֵ֮��
				xk = a + k*step;
				sum += fx(xk);
			}
			T2 = T1/2.0 + sum*step;//������ֽ��
			
			T[i][0] = T2;
			for(j = 1; j <= i && j < T[i].length; j++)
				T[i][j] = (Math.pow(4,j)*T[i][j-1] - T[i-1][j-1])/(Math.pow(4,j) - 1);//����T,S,C,R
			T2 = T[i][j-1];
			T1 = T[i][j-2];
			i++;
		}while(Math.abs(T2 - T1) >= esp && i < T.length);
		
		getT();
		System.out.println("\nn = "+n+" R("+j+") = "+ T2);
		double exact = Math.log(2) - Math.log(3); 	//����(1)�ľ�ȷֵ
		//double exact = Math.E*Math.E;				//����(2)�ľ�ȷֵ
		System.out.println("��ȷֵΪ: " + exact);  
		
		double exp = Math.abs(exact - T2);	//���
		System.out.print("���Ϊ: " + String.format("%.3E",exp));
		if(exp < esp)
			System.out.println(" < " + esp);
		else
			System.out.println(" > " + esp);
	}
	
	public void getT(){
		int i = 0,j = 0;
		for(i = 0; i < T.length; i++){
			System.out.print(""+i+"\t");
			for(j = 0; j <= i && j < T[j].length; j++){
				if(T[i][j] == 0.0) return;
				if(j == 0) System.out.print("T("+(i+1)+") = "+ String.format("%12.6f",T[i][j])+"  ");
				else if(j == 1) System.out.print("S("+i+") = "+ String.format("%12.6f",T[i][j])+"  ");
				else if(j == 2) System.out.print("C("+(i-1)+") = "+String.format("%12.6f",T[i][j])+"  ");
				else System.out.print("R("+(i-2)+") = "+ String.format("%12.6f",T[i][j])+"  ");
				
			}
			System.out.println();
			
		}
		
	}
	
	public double fx(double x){//����f(x)
		return -2.0/(x*x - 1);			//����(1)
		//return x*Math.pow(Math.E,x);	//����(2)
	}
}
class RombergTest{
	public static void main(String[] args){
		Romberg r = new Romberg();
		r.solve();
	}
}