# NumbericalAnalysis
数值分析（计算方法）
##实验一 非线性方程求根
>###实验题1 不动点迭代法求根
>迭代函数对收敛性的影响  

>方案1： x = ((x+1)/2)^()1/3  

>初值 x0 = 0   迭代10次  

>方案2： x = 2*(x^3) - 1  

>初值 x0 = 0  迭代10次
>###实验题2 牛顿迭代法求根
>初值的选取对迭代法的影响   

>方案1 ： x^3-x-1=0  在x=1.5附近的根  

>X(k+1) = X(k) - f(X(k))/f'(X(k))  

>取x0 = 1.5  迭代10次  

>方案2：  x^3-x-1=0  在x=1.5附近的根  

>X(k+1) = X(k) - f(X(k))/f'(X(k))  

>取x0 = 0  迭代10次  
>###实验题3 收敛性与收敛速度的比较
>求方程f(x) = x^3 - sinx - 12x + 1的全部实根,esp = 10^(-6)  

>方案1.用牛顿法求解  

>方案2.用简单迭代法  

>方案3.用埃特金迭代加速法  

>取相同迭代法初值，比较各方法的收敛速度
##实验二 解线性方程组
>###实验题1 用高斯列主元消元法求解下面的方程组
			1  -1  1  -4   2
			5  -4  3  12   4
			2   1  1  11   3
			2  -1  7  -1   0
>###实验题2 分别用列主元消元法与不选主元消元法求解，分析对结果的影响。
			0.3E-15   59.14    3  1   59.17
			  5.291  -6.130   -1  2   46.78
			   11.2       9    5  2   1
                               1      2    1  1   2
