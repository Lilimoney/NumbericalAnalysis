/*	
	���������������Ե�Ӱ��
	ʵ����1 ��������������
	����2    x = 2*(x^3) - 1
	��ֵ x0 = 0  ����10��
*/

import java.util.Scanner;
import java.text.NumberFormat;

class fx1_2{
	
	public void root(double x0,int n,double esp){
		
		//x0:������ֵ  n:��������  esp:����
		int s = (esp + "").length() - 2;	//����������Чλ��
		double x1 = x0,x2 = x0;	//�����������εĵ���ֵ
		System.out.println("k\tx(k) ");
		System.out.println("0\t" + x0);
		for(int i = 1; i <= n; i++){
			
			x2 = fx(x1);  //��������
			System.out.println(i + "\t" + x2);
			if(Math.abs(x2 - x1) < esp){
				NumberFormat d = NumberFormat.getNumberInstance();
				//d.setMaximumFractionDigits(s);
				d.setMinimumFractionDigits(s);//�������С��λ��
				System.out.println("�÷����Է��̸�Ϊ:" + d.format(x2) +", ��" + i +"�ε���");
				return;
			}
			x1 = x2;
		}
		System.out.println("�÷��̵��������ʧ�ܣ�");
	}
	
	public double fx(double x){	//fx: ��������
		return 2*x*x*x-1;
	}
}
class test{
	public static void main(String[] args){
		int n;
		double x0,esp;
		fx1_2 f = new fx1_2();
		Scanner scanner = new Scanner(System.in);
		System.out.println("*****************************�����������*******************************\n");
		System.out.print(" �������ֵ:");
		x0 = scanner.nextDouble();
		System.out.print(" �������������:");
		n = scanner.nextInt();
		System.out.print(" �����뾫��:");
		esp = scanner.nextDouble();	
		f.root(x0,n,esp);
	}
}