package com.yasser;

import java.util.Arrays;

public class BTree {
    public int value;
    public BTree left;
    public BTree right;

    public BTree(int value, BTree left, BTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static BTree createBTreeFromArray(int[] nums) {
        if (nums.length == 0) return null;

        int mid = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);

        BTree leftTree = createBTreeFromArray(left);
        BTree rightTree = createBTreeFromArray(right);
        return new BTree(nums[mid], leftTree, rightTree);
    }

    public static void main(String[] args) {
        int[] n = {5, 4, 2, 8, 7, 6, 9};
        Arrays.sort(n);
        BTree t = createBTreeFromArray(n);
        System.out.println(t);
    }
}
