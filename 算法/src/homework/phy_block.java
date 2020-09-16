package homework;

import java.util.HashMap;
import java.util.Map;

/*
 * 构筑一个index*block_nums大小的矩阵用以记录其变化
 * 内部算法可以从表述运行的类中剥离出更方便,且赋值函数重复多次亦可剥离
 *
 */
public class phy_block {
	int index = 1;// 描述当前运行至步数,初始为1
	int block_nums = 0;// 描述物理块个数
	int length = 0;//
	int[][] block;
	int[] serials;

	//
	public phy_block(int kuai, int length, int[] a) {
		// TODO 自动生成的构造函数存根
		this.block_nums = kuai;
		this.length = length;
		block = new int[kuai][length];
		serials = new int[this.length];
		serials = a;
	}

	/*
	 * opt利用了向后找,利用了map存储当前内存块的存储情况,可调用查看,同时利用了一个100大小的数组辅助存储查找状态,0为未经过查找,
 */
	public void OPT() {

		if (length <= block_nums) {
			for (int i = 0; i < length; i++) {
				for (int j = i; j < length; j++) {
					block[i][j] = serials[i];
				}
			}
			return;
		}
		Map<Integer, Integer> nowMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < block_nums; i++) {
			nowMap.put(serials[i], i);
			for (int j = i; j < block_nums; j++) {
				block[i][j] = serials[i];
			}
		}

		for (int i = block_nums; i < length - 1; i++) {// 表示从此到最后一个,i表示当前处理的步数
			if (nowMap.containsKey(serials[i])) {// 如果当前处理到的已经在内存里了

				nowMap.put(serials[i], i);
				for (int j = 0; j < block_nums; j++) {
					block[j][i] = block[j][i - 1];
				}
			} else {// 当前的不在
				int myindex = -1;// 存储了键,即数据块
				int max = -1;
				int[] flags = new int[100];// 储存当前数据块是否被比较过,初始为0

				for (int k = i + 1; k < length; k++) {// 比较后面第k个元素是否出现了当前数据块内的元素
					if (nowMap.containsKey(serials[k]) && flags[serials[k]] == 0) {// 如果包含于当下的数据块内且未被比较过

						if (max <= k - nowMap.get(serials[k])) {// max小于这一个的距离差,更新
							max = k - nowMap.get(serials[k]);
							myindex = serials[k];
							flags[serials[k]] = 1;
						} else {
							flags[serials[k]] = 1;
						}
					}
				}
				System.out.println(myindex);
				if (myindex == -1) {// 后面都不再出现,就默认去除第一个
					nowMap.remove(block[0][i - 1]);
					nowMap.put(serials[i], i);
					block[0][i] = serials[i];
					for (int j = 1; j < block_nums; j++) {
						block[j][i] = block[j][i - 1];
					}

				} else {
					nowMap.remove(myindex);
					nowMap.put(serials[i], i);
					for (int j = 0; j < block_nums; j++) {
						if (block[j][i - 1] == myindex) {
							block[j][i] = serials[i];
						} else {
							block[j][i] = block[j][i - 1];
						}
					}
				}
			}
		}
		block[0][serials.length - 1] = serials[length - 1];
		for (int i = 1; i < block_nums; i++) {// 表示最后一列
			block[i][length - 1] = block[i][length - 2];
		}
	}

	public void showinfo() {
		for (int j = 0; j < block_nums; j++) {
			for (int i = 0; i < length; i++) {
				if (block[j][i] < 10) {
					System.out.print(block[j][i] + "  ");
				} else {
					System.out.print(block[j][i] + " ");
				}

			}
			System.out.println();
		}
	}
/*
 * lru利用了step以計算各个内存块内的内存存放时间
 */
	public void LRU() {
		if (length <= block_nums) {
			for (int i = 0; i < length; i++) {
				for (int j = i; j < length; j++) {
					block[i][j] = serials[i];
				}
			}
			return;
		}
		Map<Integer, Integer> nowMap = new HashMap<Integer, Integer>();
		int[] steps = new int[block_nums];

		for (int i = 0; i < block_nums; i++) {
			nowMap.put(serials[i], i);
			for (int j = i; j < block_nums; j++) {
				block[i][j] = serials[i];
				steps[i]++;
			}
		}

		for (int i = block_nums; i < length; i++) {
			int myindex = 0;// 默认换第一个快
			int max = -1;
			if (nowMap.containsKey(serials[i])) {
				for (int j = 0; j < block_nums; j++) {
					steps[j]++;
					block[j][i] = block[j][i - 1];
				}
			} else {
				for (int k = 0; k < block_nums; k++) {
					if (max < steps[k]) {
						max = steps[k];
						myindex = k;// 表示第几块的
					}
					steps[k]++;
				}
				steps[myindex] = 1;
				for (int j = 0; j < block_nums; j++) {
					block[j][i] = block[j][i - 1];
				}
				nowMap.remove(block[myindex][i]);
				block[myindex][i] = serials[i];
				nowMap.put(serials[i], i);
			}
		}
	}
/*
 * 先入先出较为简单,已经包含就继续,否则剔除最前,从最后插入
 */
	public void FIFO() {
		if (length <= block_nums) {
			for (int i = 0; i < length; i++) {
				for (int j = i; j < length; j++) {
					block[i][j] = serials[i];
				}
			}
			return;
		}
		
		Map<Integer, Integer> nowMap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < block_nums; i++) {
			nowMap.put(serials[i], i);
			for (int j = i; j < block_nums; j++) {
				block[i][j] = serials[i];
			}
		}

		for (int i = block_nums; i < length; i++) {
			if (nowMap.containsKey(serials[i])) {
				for (int j = 0; j < block_nums; j++) {
					block[j][i] = block[j][i - 1];
				}
			} else {
				nowMap.remove(block[block_nums - 1][i - 1]);
				nowMap.put(serials[i], i);
				block[0][i] = serials[i];
				for (int j = 1; j < block_nums; j++) {
					block[j][i] = block[j - 1][i - 1];
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] myserials = { 1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 7 };
		phy_block myBlock = new phy_block(4, myserials.length, myserials);

		myBlock.OPT();//此处调用各类算法FIFO,LRU
		myBlock.showinfo();
	}

}