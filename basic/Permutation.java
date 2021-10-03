import java.util.ArrayList;
import java.util.Arrays;
 
public class Permutation {
 
    private int n; // nPr�� n
    private int r; // nPr�� r
    private ArrayList<Integer> itemList;
    private int[] res;
    
    // �ʱ�ȭ
    public Permutation(int[] intArr, int r){
        this.r = r;             // nPr�� r
        this.n = intArr.length; // nPr�� n
        this.res = new int[r];  // ����� �迭
        
        // �������� �� ����Ʈ
        itemList = new ArrayList<Integer>();
        for(int item : intArr)
            itemList.add(item);
    }
    
		public Permutation(int end, int r){
			this.n = end;
			this.r = r;
			itemList = new ArrayList<>();
			for(int i=0; i < end; i++)
				itemList.add(i);
		}

    public void perm(int depth){
        perm(itemList, depth);
    }
 
    public void perm(ArrayList<Integer> itemList, int depth) {
        
        // depth�� 0���� �������� ��� depth == r���� ����
        if (depth == r) {
            System.out.println(Arrays.toString(res));
            return;
        }
        
        for (int i = 0; i < n-depth; i++){
            res[depth] = itemList.remove(i); // ������ ���� + ����Ʈ���� ����
            perm(itemList, depth+1);         // ���ȣ��
            itemList.add(i, res[depth]);     // ���ŵ� ������ ����
        }
    }
    
    public static void main(String[] args) {
 
        int r = 2;
        int[] arr = {1,2,3,4};
        
        //Permutation ma = new Permutation(arr, r);
        //ma.perm(0);
			Permutation ma = new Permutation(10, r);
			ma.perm(0);
    }
}
