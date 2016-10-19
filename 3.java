/*
	�󷽳�f(x) = x^3 - sinx - 12x + 1��ȫ��ʵ��,esp = 10^(-6)
	����1.��ţ�ٷ����
	����2.�ü򵥵�����
	����3.�ð��ؽ�������ٷ�
	ȡ��ͬ��������ֵ���Ƚϸ������������ٶ�
*/

import java.util.Scanner;
import java.text.NumberFormat;

class fx3_1{	//ţ�ٵ�����
	
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
		return x*x*x - Math.sin(x) - 12*x + 1;
	}
	
	public double f_x(double x){//f_x��fx�������������ĵ���
		return 3*x*x - Math.cos(x) - 12;
	}
}

class fx3_2{	//�򵥵�����
	
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
				d.setMinimumFractionDigits(s);//�������С��λ��
				System.out.println("�÷����Է��̸�Ϊ:" + d.format(x2) +", ��" + i +"�ε���");
				return;
			}
			x1 = x2;
		}
		System.out.println("�÷��̵��������ʧ�ܣ�");
	}
	
	public double fx(double x){	//fx: ��������
		return x*x*x - Math.sin(x) - 12*x + 1;
	}
}

/*
  Aitken��������
  ����:		x(k+1) = g(x(k));
  �ٵ���:   x(k+2) = g(x(k+1));
  ����:		^x = x(k+2)-[(x(k+2)-x(k+1))^2]/[x(k+2)-2*x(k+1)+x(k)]
*/

class fx3_3{	//���ؽ�������ٷ�   
	
	public void root(double x0,int n,double esp){
		//x0:������ֵ  n:��������  esp:����
		int s = (esp + "").length() - 2;	//����������Чλ��
		double x1 = x0,x2 = x0,x3,x4;
		System.out.println("k\tx(k)");
		System.out.println("0\t" + x0);
		for(int i = 1; i <= n; i++){
			//��������
			x2 = fx(x1);
			x3 = fx(x2);
			x4 = x3 - Math.pow((x3-x2),2)/(x3-2*x2+x1);
			System.out.println(i + "\t" + x4); 
			if(Math.abs(x4 - x1) < esp){
				NumberFormat d = NumberFormat.getNumberInstance();
				d.setMinimumFractionDigits(s);//�������С��λ��
				System.out.println("�÷����Է��̸�Ϊ:" + d.format(x4) +", ��" + i +"�ε���");
				return;
			}
			x1 = x4;
		}
		System.out.println("�÷��̵��������ʧ�ܣ�");
	}
	
	public double fx(double x){	//fx: ��������
		return x*x*x - Math.sin(x) - 12*x + 1;
	}
}

class test{
	public static void main(String[] args){
		double x0,esp;
		int n;
		fx3_1 f1 = new fx3_1();
		fx3_2 f2 = new fx3_2();
		fx3_3 f3 = new fx3_3();
		Scanner scanner = new Scanner(System.in);
		System.out.println("*****************************���������*******************************\n");
		System.out.print(" �������ֵ:");
		x0 = scanner.nextDouble();
		System.out.print(" �������������:");
		n = scanner.nextInt();
		System.out.print(" �����뾫��:");
		esp = scanner.nextDouble();	
		
		System.out.println("\n����һ����ţ�ٷ����");
		f1.root(x0,n,esp);
		
		System.out.println("\n����2���ü򵥵��������");
		f2.root(x0,n,esp);
		
		System.out.println("\n����3.�ð��ؽ�������ٷ�");
		f3.root(x0,n,esp);
	}
}