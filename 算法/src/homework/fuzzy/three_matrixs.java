package homework.fuzzy;

public class three_matrixs {
	public static void main(String[] args) {
		System.out.println("???");
		my_main aMatrixs = new my_main();
		double a[][]={ // 分类标准矩阵
				{ 0.05, 0.15, 0.25, 0.5, 0.85 },
				{ 0.05, 0.1, 0.15, 0.3, 0.5 },
				{ 0.15, 0.3, 0.5, 1, 1.7 },
				{ 3, 13, 22, 44, 75 },
				     };
		
		aMatrixs.setfenlei(a);
		double b[][]= {//各年的指标
				{ 0.37, 0.03, 0.59, 15.9 }, 
				{ 0.41, 0.04, 0.48, 15.7 }, 
				{ 0.61, 0.06, 0.62,11 },
				{ 0.59, 0.08, 0.69, 14.6 },
				{ 0.4, 0.06, 0.39, 9.9 }, 
				};
		aMatrixs.setyangben(b);
		
		aMatrixs.setquanzhi();
		
		
		aMatrixs.calculate();
		aMatrixs.showinfo();


	}
}

class my_main {
	// 表示分类标准矩阵
	// 默认
	int hang_fenlei=4;// 表示样本评价指数个数
	int lie_fenlei=5;// 表示程度的种类
	public double[][] fenlei = new double[30][30];

	// 表示提供的样本的参数
	// 默认其为30年30份大小
	public double[][] yangben = new double[30][30];
	int hang_yangben=5;// 表示样本的年数,个数
	int lie_yangben=4;// 表示表示样本评价指数个数

	// 表示样本各项评价指标对应于 fenlei的贴近指数
	// 三个指标分为:hang_yangben(年数),hang_fenlei(评价指标),lie_fenlei(程度个数)
	double[][][] tiejin = new double[30][30][30];

	// 提供了各项的权值,默認设置30个
	// 如果需要特定设置,
	// 数组元素个数应为评价指标个数,
	// 即hang_fenlei
	double quanzhi[] = new double[20];

	// 记录了最终各年的贴近值,
	// 行数应为年数,即hang_yangben
	// 列数应为程度个数,即lie_fenlei
	double[][] final_tiejin = new double[30][30];
	
	double[]fen = new double[30];
	
	public void setfenlei(double[][] a) {
		hang_fenlei = a.length;
		lie_fenlei = a[0].length;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				fenlei[i][j] = a[i][j];
			}
		}
	}

	public void setyangben(double[][] b) {
		hang_yangben = b.length;
		lie_yangben = b[0].length;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				yangben[i][j] = b[i][j];
			}
		}
	}

	public void setquanzhi() {
		for (int i = 0; i < hang_fenlei; i++) {
			quanzhi[i] = 1.0 / hang_fenlei;
		}
	}

	public void setquanzhi(double a[]) {
		for (int i = 0; i < hang_fenlei; i++) {
			quanzhi[i] = a[i];
		}
	}

	public void calculate() {
		for (int i = 0; i < hang_yangben; i++) {// 表示第几年
			for (int j = 0; j < hang_fenlei; j++) {// 表示第i个评测指标
				if (yangben[i][j] <= fenlei[j][0]) {
					tiejin[i][j][0] = 1;
				} else if (yangben[i][j] >= fenlei[j][lie_fenlei - 1]) {
					tiejin[i][j][lie_fenlei - 1] = 1;
				} else {
					for (int k = 0; k < lie_fenlei-1; k++) {
						if (yangben[i][j] >= fenlei[j][k] && yangben[i][j] <= fenlei[j][k + 1]) {
							tiejin[i][j][k] = ((Math.abs(yangben[i][j] - fenlei[j][k + 1]))
									/ (Math.abs(fenlei[j][k] - fenlei[j][k + 1])));
							tiejin[i][j][k + 1] = ((Math.abs(yangben[i][j] - fenlei[j][k]))
									/ (Math.abs(fenlei[j][k] - fenlei[j][k + 1])));
							break;
						}
					}
				}
			}
		}

		// 此时计算完毕各年各项的对应程度
		// 下面计算经过权值计算后的结果
		for (int i = 0; i < hang_yangben; i++) {
			for (int j = 0; j < lie_fenlei; j++) {
				for (int k = 0; k < lie_fenlei; k++) {
					final_tiejin[i][k] += quanzhi[j] * tiejin[i][j][k];
				}
			}

		}
		
		for (int i = 0; i < hang_yangben; i++) {
			for (int j = 0; j < lie_fenlei; j++) {
				fen[i]+=(6-j-1)*final_tiejin[i][j];
			}
		}

	}


	public void showinfo() {
		for (int i = 0; i < hang_fenlei; i++) {
			for (int j = 0; j < lie_fenlei; j++) {
				System.out.print(fenlei[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("=================");
		for (int i = 0; i < hang_yangben; i++) {
			for (int j = 0; j < lie_fenlei; j++) {
				System.out.print(yangben[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("=================");
		for (int i = 0; i <hang_yangben; i++) {
			for (int j = 0; j < lie_fenlei; j++) {
				System.out.print(String.format("%.2f", final_tiejin[i][j]) + "  ");
			}
			System.out.println();
		}
		System.out.println("=================");
		for (int i = 0; i < hang_yangben; i++) {
			System.out.print(String.format("%.2f", fen[i]) + "  ");
		}
	}
}
