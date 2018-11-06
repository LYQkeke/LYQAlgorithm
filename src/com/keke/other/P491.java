package com.keke.other;

/**
 * Created by KEKE on 2018/11/5
 *
 * KMP
 *
 */
public class P491 {

    public static void main(String[] args){

        String ss = "iamatroublemaker";
        String ms = "trouble";
        String s1 = "abababac";
        String s2 = "babac";
        System.out.println(getIndex(ss, ms));
        System.out.println(getIndex(s1, s2));
    }

    public static int getIndex(String s, String m){

        if (s==null||m==null||s.length()==0||m.length()==0||s.length()<m.length())
            return -1;
        char[] chs = s.toCharArray();
        char[] chm = m.toCharArray();
        int[] next = getNext(chm);
        int si = 0;
        int mi = 0;
        while (si<chs.length&&mi<chm.length){
            if (chs[si]==chm[mi]){
                si++;
                mi++;
            }else if (next[mi]==-1)//在next数组中，只有next[0]的值为-1
                si++;
            else
                mi = next[mi];
        }
        return mi==chm.length?(si-chm.length):-1;
    }

    private static int[] getNext(char[] m){

        if (m.length==1)
            return new int[]{-1};
        int[] next = new int[m.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int c = 0;
        while (pos<m.length){
            if (m[pos-1]==m[c])
                next[pos++] = ++c;
            else if (c>0)
                c = next[c];
            else
                next[pos++] = 0;
        }
        return next;
    }
}
