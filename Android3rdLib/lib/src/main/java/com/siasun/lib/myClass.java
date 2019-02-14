package com.siasun.lib;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class myClass {
    public static void main(String[] args) {
//        Tree root = new Tree("A");
//        root.addNode(new Tree("B"));
//        root.addNode(new Tree("C"));
//        root.addNode(new Tree("D"));
//        Tree t = null;
//        t = root.getChild(0);
//        t.addNode(new Tree("L"));
//        t.addNode(new Tree("E"));
//        t = root.getChild(1);
//        t.addNode(new Tree("F"));
//        t = root.getChild(2);
//        t.addNode(new Tree("I"));
//        t.addNode(new Tree("H"));
//        t = t.getFirstChild();
//        t.addNode(new Tree("L"));
//
//        System.out.println("first node:" + root.getRootData());
//        //System.out.println("size:" + root.size());
//        //System.out.println("dept:" + root.dept());
//        System.out.println("is left:" + root.isLeaf());
//        System.out.println("data:" + root.getRootData());
//
//        Order order = new Order();
//        System.out.println("前根遍历：");//选择前跟遍历
//        order.preOrder(root);
//        System.out.println("\n后根遍历：");
//        order.postOrder(root);

        int Xs0 = 0;
        int Ys0 = 0;
        int Xd0 = 120;
        int Yd0 = 140;

        int Xs1 = 0;
        int Ys1 = 240;
        int Xd1 = 120;
        int Yd1 = 890;

        int Xs2 = 320;
        int Ys2 = 240;
        int Xd2 = 870;
        int Yd2 = 890;

        int Xs3 = 320;
        int Ys3 = 0;
        int Xd3 = 870;
        int Yd3 = 140;

        int s = 65536;

        // s * Xs = a * Xd + b * Yd + c
        // s * Ys = d * Xd + e * Yd + f

        // a * Xd[i] + b * Yd[i] + 1 * c + 0 = s * Xs[i]
        // d * Xd[i] + e * Yd[i] + 1 * f + 0 = s * Ys[i]

        //解四元一次方程
//        double[][] d1 = new double[][]
//                {
//                        {Xd0,Yd0,1,0,s * Xs0},
//                        {Xd1,Yd1,1,0,s * Xs1},
//                        {Xd2,Yd2,1,0,s * Xs2},
//                        {Xd3,Yd3,1,0,s * Xs3},
//                };
//
//        DataUtil.calculate(d1);

        Set<Integer> ss = new HashSet<>();
        ss.add(0x33);
        ss.add(0x22);
        ss.add(0x11);
        ss.add(0x77);
        ss.add(0x66);
        ss.add(0x11);
        ss.add(0x11);

        Iterator<Integer> integerIterator = ss.iterator();
        while (integerIterator.hasNext()) {
            System.out.print(integerIterator.next() + ",");
        }

    }
}
