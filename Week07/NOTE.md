学习笔记
并查集代码实现：
class UnionFind {
        int count;
        int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for(int i = 0;i < n;i++) {
                parent[i] = 1;
            }
        }
        public int find(int p) {
            while(p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int q,int p) {
            int pRoot = parent[p];
            int qRoot = parent[q];
            if(pRoot == qRoot) return;
            parent[p] = parent[qRoot];
            count--;
        }
    }
	
双向dfs代码模板总结
Set beginSet；
Set endSet；
while(!beginSet.isEmpty() && !endSet.isEmpty()) {
	//比较长度，从长度小的开始遍历
	if(beginSet.size() > endSet.size()) {
        Set<String> temp = beginSet;
        beginSet = endSet;
        endSet = temp;
    }
	Set temp;
	//代码逻辑处理
	
	beginSet = temp；
}