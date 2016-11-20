/*
	Gaussian column principal component elimination method
	��˹����Ԫ��Ԫ��
	1.(1) �ø�˹������Ԫ��Ԫ���������ķ�����
			1 -1 1 -4  2
			5 -4 3 12  4
			2  1 1 11  3
			2 -1 7 -1  0
	1.(2) �ֱ�������Ԫ��Ԫ���벻ѡ��Ԫ��Ԫ����⣬
		  �����Խ����Ӱ�졣
			0.3E-15  59.14   3 1   59.17
			  5.291 -6.130  -1 2   46.78
			   11.2     9    5 2   1
				  1     2    1 1   2
			
			test:
				1 -1 1 -4  -2
				5 -4 3 12  -6
				2  1 1 11   3
				2 -1 7  1  -7
				
			    x1=1 x2=2 x3=-1 x4=0
*/

import java.util.Scanner;

class lieGauss{
	static int N;				//���Է��������
	private double[][] matrix;	//�������
	private double[] x;			//���x�Ľ�(x[0]�����Ԫ��)
	
	public void setMatrix(double[][] args){		//�����������
		matrix = new double[N][N+1];
		x = new double[N + 1];
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[i].length;j++)
				matrix[i][j] = args[i][j];
	}
	public void getMatrix(){					//����������
		for(int i = 0; i < matrix.length; i++){		
			for(int j = 0; j < matrix[i].length;j++){
				System.out.printf(String.format("%12.6f",matrix[i][j]));
			}
			System.out.println();
		}
	}
	public void getSolve(){						//������̵Ľ�
		for(int i = 0; i < N - 1; i++){
			changeRow(i,max(i));
			System.out.println("��"+(i+1)+"�ν���");
			System.out.println("������");
			getMatrix();
			if(calculate(i) == false){
				System.out.println("�÷������޽⣡");
				return;
			}
			System.out.println("�����");
			getMatrix();
		}
		back();
		System.out.println("�ش����ã�");
		for(int j = 1; j <= N; j++){
			System.out.printf("X["+j+"]="+ String.format("%12.6f",x[j]) + "  ");
		}
		System.out.println();
	}
	public int max(int i){						//ѡ���i���������Ԫ,���������Ԫ������
		double temp = 0.0;
		int flag = 0;
		int j = i;
		while(j < N){
			if(Math.abs(matrix[j][i]) > temp){
				temp = Math.abs(matrix[j][i]);
				flag = j;
			}
			j++;
		}
		return flag;
	}
	public void changeRow(int i,int j){			//������i�к͵�j��
		double[] temp = new double[N + 1];
		for(int m = 0; m < N + 1; m++){
			temp[m] = matrix[i][m];
			matrix[i][m] = matrix[j][m];
			matrix[j][m] = temp[m];
		}
		/*��������
		System.out.println("��"+ i +"�к͵�"+ j +"�н�����ɣ�");
		*/
	}
	public boolean calculate(int i){			//����ѡȡ��i�е�i����Ԫ����������Ԫ�������
		for(int m = i + 1; m < N; m++){//�ӵ�i+1�п�ʼ��ÿһ��������
				double first = matrix[m][i];//�洢������Ԫ����ĸ��еĵ�i��Ԫ�أ���r2=r2-(first/matrix[i][i])*r1
				for(int n = i; n < N + 1; n++){
					if(Math.abs(matrix[i][i]) < 1E-20)
						return false;
					matrix[m][n] = matrix[m][n] - matrix[i][n]*(first/matrix[i][i]);
					/*�����������
					System.out.println("matrix[m][n] = " + (matrix[m][n] - matrix[i][n]*(first/matrix[i][i])));
					System.out.println(matrix[m][n] +"=" +(matrix[m][n] +"-"+ matrix[i][n]+"*"+(first+"/"+matrix[i][i])));
					System.out.println("**************\n" + "("+m+ "," +n+ ")");
					getMatrix();
					System.out.println("**************\n");
					*/
				}	
			}	
		return true;
	}
	public void back(){							//�ش���ⷽ����
		
		x[N] = matrix[N-1][N]/matrix[N-1][N-1];	//��һ���ش������X(n)�Ľ�

		for(int i = N-2; i >= 0; i--){//iΪ����
			double num = 0.0;						//�洢ϵ������ϵ������x(i)�ĺ�
			for(int j = i+1; j < N; j++){//jΪ����
				num = num + matrix[i][j]*x[j+1];	
			}
				/*��������
					System.out.println("num = "+num);
				*/
			x[i+1] = (matrix[i][N] - num)/matrix[i][i];
				/*��������
					System.out.println("-----------x["+(i+1)+"]--"+x[i+1]+"---------------");
				*/
		}
	}
}

class LieGaussTest{
	public static void main(String[] args){
		lieGauss g = new lieGauss();
		Scanner scanner = new Scanner(System.in);
		System.out.println("************************** ��˹����Ԫ��Ԫ�� *************************************\n");
		System.out.println("���������Է�����Ľ���:");
		lieGauss.N = scanner.nextInt();							//���÷��������
		System.out.println("���������Է������Ӧ���������:");
		double[][] m = new double[lieGauss.N][lieGauss.N+1];	//������ʱ�����ȡ����ֵ
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length;j++)
				m[i][j] = scanner.nextDouble();
		g.setMatrix(m);
		g.getSolve();
	}
}