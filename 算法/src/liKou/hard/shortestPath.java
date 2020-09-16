package liKou.hard;

/**
 * @author sc
 * @date 2020/8/29
 **/

import java.util.PriorityQueue;

/**
 * 该代码采用优先队列式的分支限界法解决了单源最短路径问题。相比贪心算法中的德杰特斯拉算法复杂度
 * 有所增加，但是作为搜索算法的经典问题，该算法完美展现了优先队列在分支限界法中的应用以及广度
 * 优先搜索算法的特点。该问题同样是一棵多子树的子集树搜索问题，和前几篇博客大有不同，
 * 这段代码采用的是广度优先搜索，不存在回溯的问题，每个节点只有一次成为扩展节点的机会，
 * 一旦成为扩展节点，就遍历其所有的孩子，通过剪枝函数，将有可能达到最优解的孩子放入到优先队列中，
 * 遍历结束后，这个节点变为死节点，从优先队列中继续取出下一个节点，进行操作，直到整个队列为空。
 * 优先队列中的优先级根据不同的题目有不同设定，在本题中优先级设定为从源节点到该节点距离。距离
 * 源节点越近，优先级就越高，这样就趋向于能够尽早发现最短路径，从而能够更好的实现剪枝操作。
 *
 * 剪枝函数：考虑某个节点的某个孩子是否应该加入队列时，我们从两个方面进行考量。
 * 第一，判断某一个孩子是否是可达的，如果该节点本身和选中的孩子节点并不联通，则该节点变为死节点。
 * 第二，判断经过这个节点到达其孩子节点后的总距离和该孩子节点中存储的最短距离比较，如果比那个距离
 * 要长，则这条路径是没有意义的。不放入优先队列。
 *
 * */
class Node implements Comparable<Node>{
    int id;
    int length;//当前情况下到达该顶点的长度
    public int compareTo(Node d){
        if(this.length < d.length)
            return -1;
        else if(this.length == d.length)
            return 0;
        return 1;
    }
}
class shortestPath {
    public static int INFINITE = Integer.MAX_VALUE;
    int n=5;
    int[] prev = new int[n];//用于存储节点们的前驱节点。
    int[] dist = new int[n];//用于存储源节点到节点们的最短距离。
    //对节点之间的距离信息进行初始化，全部存储在二维数组中。
    int[][] c = {{0,100,30,INFINITE,10},
            {INFINITE,0,INFINITE,INFINITE,INFINITE},
            {INFINITE,60,0,60,INFINITE},
            {INFINITE,10,INFINITE,0,INFINITE},
            {INFINITE,INFINITE,INFINITE,50,0}};
    public void shorttestPath(int t){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(int i=0;i<dist.length;i++)
            dist[i] = INFINITE;
        for(int i=0;i<prev.length;i++)
            prev[i] = -1;
        //对给定的源节点进行初始化。
        Node source = new Node();
        source.id = t;
        source.length = 0;
        dist[t] = 0;
        pq.add(source);
        while(!pq.isEmpty()){
            Node fatherNode = pq.poll();
            //取出所有该节点能够到达，并且到达总长度不大于已发现的最优长度的节点
            for(int j=0;j<n;j++){
                if(c[fatherNode.id][j]<INFINITE
                        && fatherNode.length+c[fatherNode.id][j]<dist[j]){
                    //更新该孩子节点的最优长度和前驱节点。然后再将其放入优先队列中。
                    dist[j] = fatherNode.length+c[fatherNode.id][j];
                    prev[j] = fatherNode.id;
                    Node newNode = new Node();
                    newNode.id = j;
                    newNode.length = dist[j];
                    pq.add(newNode);
                }
            }
        }
        //信息输出。
        System.out.println(t+"号节点到其他节点的最短路径长度和路径分别为：");
        for(int i=0;i<n;i++){
            System.out.println("到"+i+"号节点的最短长度为:"+((dist[i]==INFINITE)?"不可达":""+dist[i]));
            if(dist[i]!=INFINITE && i!=t){
                System.out.print("其路径为:  "+i+"<----");
                int temp = i;
                while(prev[temp]!=t){
                    System.out.print(prev[temp]+"<----");
                    temp = prev[temp];
                }
                System.out.println(prev[temp]);
            }
        }

    }
    public static void main(String[] args){
        shortestPath sp = new shortestPath();
        sp.shorttestPath(2);
    }


}
