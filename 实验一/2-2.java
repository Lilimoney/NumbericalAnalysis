/*	
	��ֵ��ѡȡ�Ե�������Ӱ��
	ʵ����2 ţ�ٵ��������
	����2   x^3-x-1=0  ��x=1.5�����ĸ�
	X(k+1) = X(k) - f(X(k))/f'(X(k))
	ȡx0 = 0  ����10��
*/

import java.util.Scanner;
import java.text.NumberFormat;

class fx2_1{
	
	public void root(double x0,int n,double esp){
		//x0:������ֵ  n:��������  esp:����
		int s = (esp + "").length() - 2;	//����������Чλ��
		double x1 = x0,x2 = x0;	//�����������εĵ���ֵ
		System.out.println("k\tx(k) ");
		System.out.println("0\t" + x0);
		for(int i = 1; i <= n; i++){
			
			x2 = x1 - fx(x1)/f_x(x1);  //��������
			System.out.println(i + "\t" + x2);
			if(Math.abs(x2 - x1) < esp){
				NumberFormat d = NumberFormat.getNumberInstance();
				d.setMinimumFractionDigits(s);
				System.out.println("�÷����Է��̸�Ϊ:" + d.format(x2) +", ��" + i +"�ε���");
				return;
			}
			x1 = x2;
		}
		System.out.println("�÷��̵��������ʧ�ܣ�");
	}
	
	public double fx(double x){	//fx: ��������
		return x*x*x-x-1;
	}
	
	public double f_x(double x){//f_x��fx�������������ĵ���
		return 3*x*x-1;
	}
}


class test{
	public static void main(String[] args){
		double x0,esp;
		int n;
		fx2_1 f = new fx2_1();
		Scanner scanner = new Scanner(System.in);
		System.out.println("*****************************ţ�ٵ�����*******************************\n");
		System.out.print(" �������ֵ:");
		x0 = scanner.nextDouble();
		System.out.print(" �������������");
		n = scanner.nextInt();
		System.out.print(" �����뾫��:");
		esp = scanner.nextDouble();	
		f.root(x0,n,esp);
	}
}