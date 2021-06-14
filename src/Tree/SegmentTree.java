package Tree;

import javax.xml.stream.events.Characters;
import java.util.Arrays;

/**
 * @author Qian
 * @create 2021-04-203:22 下午
 */
public class SegmentTree {
    public static void main(String[] args) {
        int[] arr = {10,2,3,4,5,7};
        Arrays.sort(arr);
        String s = "sf".substring(0,2);
        int[] segmentTree = new int[4*arr.length];
        int left = 0,right = arr.length-1;
        buildTree(arr,segmentTree,left,right,0);
        for(int i : segmentTree){
            System.out.println(i);
        }
        System.out.println("---------------------------");
        arr[2] = 9;
        updateTree(0, arr.length - 1, segmentTree,0, 2, 9);
        for(int i : segmentTree){
            System.out.println(i);
        }
        System.out.println("---------------------------");
        System.out.println(queryTree(2, 5, segmentTree, 0, arr.length - 1, 0));
    }

    public static void buildTree(int[] arr, int[] segmentTree,int left, int right, int treeIndex){
        if(left==right){
            segmentTree[treeIndex] = arr[left];
            return;
        }
        int mid = (left+right)>>1;
        int leftNode = 1+(treeIndex << 1);
        int rightNode = 2+(treeIndex << 1);
        buildTree(arr,segmentTree,mid+1,right,rightNode);
        buildTree(arr,segmentTree,left,mid,leftNode);
        segmentTree[treeIndex] = segmentTree[leftNode]+segmentTree[rightNode];
    }

    public static int queryTree(int leftSearch, int rightSearch,int[] segmentTree,int left, int right, int treeNode){
        if(leftSearch>right || rightSearch<left){return 0;}
        if(leftSearch==left&&rightSearch==right){return segmentTree[treeNode];}
        int mid = (left+right)>>1;
        int leftNode = (treeNode<<1)+1;
        int rightNode = (treeNode<<1)+2;
        return queryTree(leftSearch, mid, segmentTree,left, mid, leftNode)+queryTree(mid+1,rightSearch,
                segmentTree,mid+1,right, rightNode);
    }

    public static void updateTree(int left, int right,int[] segmentTree,int treeIndex,int index,int val){
        if(left==right){
            segmentTree[treeIndex] = val;
            return;
        }
        int mid = (left + right)>>1;
        int leftNode = 1+(treeIndex << 1);
        int rightNode = 2+(treeIndex << 1);
        if (index > mid) {
            updateTree(mid+1,right,segmentTree,rightNode,index,val);
        }else {
            updateTree(left, mid, segmentTree, leftNode,index, val);
        }
        segmentTree[treeIndex] = segmentTree[rightNode]+segmentTree[leftNode];
    }
}
