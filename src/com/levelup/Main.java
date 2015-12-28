package com.levelup;

public class Main {

    static int m=6;

    public static void printMas(int res[]){
        for (int i = 0; i < res.length; i++) {
            if(res[i]>0) System.out.print(res[i]+"+");
        }
        System.out.println();
    }
    public static void expandNum(int res[],int left,int end){
        for (int i = 1; i < end; i++) {
                if (i<=end/2) {
                    res[left] = end-i;
                    res[left + 1] = i;
                    printMas(res);
                    for (int j = left; j < res.length; j++) res[j]=0;
                }
                else {
                    res[left] = end - i;
                    if(i>=2) expandNum(res, left + 1, i);
                }
        }

    }

    public static void main(String[] args) {
        int[] res=new int[100];
        res[0]=m;
        expandNum(res,0,m);
    }
}
