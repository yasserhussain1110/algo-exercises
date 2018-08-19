package com.yasser;

import java.util.Arrays;
import java.util.Stack;

import static java.lang.System.out;
import static com.yasser.BTree.createBTreeFromArray;

public class StackTraversal {
    public static void main(String[] args) {
        createBTreeAndTraverse(new int[]{10, 8, 5, 4, 6, 9});
        createBTreeAndTraverse(new int[]{10, 8});
        createBTreeAndTraverse(new int[]{});
        createBTreeAndTraverse(new int[]{1});
        createBTreeAndTraverse(new int[]{7, 6, 4, 8, 2});
    }

    public static void createBTreeAndTraverse (int[] nums) {
        Arrays.sort(nums);
        BTree tree = createBTreeFromArray(nums);
        traverse(tree);
    }

    public static void pushAllLeft(Stack<BTree> stack, BTree t) {
        while (t != null) {
            stack.push(t);
            t = t.left;
        }
    }

    public static void traverse(BTree t) {
        Stack<BTree> stack = new Stack<>();
        BTree current = t;

        out.print("Tree - ");

        while (current != null) {
            pushAllLeft(stack, current);
            BTree last = stack.pop();
            out.print(last.value + " ");

            if (stack.isEmpty()) break;

            BTree secondLast = stack.pop();
            out.print(secondLast.value + " ");
            current = secondLast.right;
        }
        out.println();
    }
}
