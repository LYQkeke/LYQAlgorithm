package com.keke.other;


import java.util.LinkedList;

/**
 * Created by KEKE on 2018/11/7
 *
 * AC 自动机
 *
 */
public class ACAutomation {

    public static void main(String[] args){

        String s = "sdmfhsgnshejfgnihaofhsrnihao";
        String[] m = {"nihao", "hao", "hs", "hsr"};
        AcA acAutomation = new AcA();
        for (String word: m){
            acAutomation.insert(word);
        }
        acAutomation.getfial();
        LinkedList<Answer> answers = acAutomation.run(s);
        System.out.println(answers);
    }

    /**
     * Ac自动机节点
     */
    static class AcNode{

        /*
        str用来存储模式字符串，如果该节点表示一个字符串的结尾
        那么该节点存储对应的字符串
        否则为空值
         */
        String str;
        AcNode[] map;
        AcNode fail;

        public AcNode(){
            map = new AcNode[26];
        }
    }

    /**
     * 用来存储返回的答案
     */
    static class Answer{

        String str;
        int idx;

        public Answer(String str, int idx){
            this.str = str;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "["+str+", "+idx+"]";
        }
    }

    static class AcA{

        AcNode root;

        public AcA(){
            root = new AcNode();
        }

        public void insert(String word){
            if (word==null||word.length()==0)
                return;
            char[] ch = word.toCharArray();
            AcNode node = root;
            int idx;
            for (int i=0;i<ch.length;i++){
                idx = ch[i]-'a';
                if (node.map[idx]==null){
                    node.map[idx] = new AcNode();
                }
                node = node.map[idx];
            }
            node.str = word;
        }


        /**
         * 设置每一个节点的fail指针
         */
        public void getfial(){

            LinkedList<AcNode> queue = new LinkedList<>();
            AcNode temp;
            for (int i=0;i<26;i++){
                temp = root.map[i];
                if (temp!=null) {
                    temp.fail = root;
                    queue.addLast(temp);
                }
            }
            while (!queue.isEmpty()){
                temp = queue.pollFirst();
                for (int i=0;i<26;i++){
                    if (temp.map[i]!=null){
                        AcNode cur = temp.fail;
                        while (cur!=null){
                            if (cur.map[i]!=null){
                                temp.map[i].fail = cur.map[i];
                                break;
                            }
                            cur = cur.fail;
                        }
                        if (cur==null)
                            temp.map[i].fail = root;
                        queue.offerLast(temp.map[i]);
                    }
                }
            }
        }

        /**
         * 使用构建好的AC自动机，对待匹配字符串text进行多模匹配
         * @param text
         */
        public LinkedList<Answer> run(String text){

            if (text==null||text.length()==0)
                return null;
            char[] chs = text.toCharArray();
            LinkedList<Answer> ans = new LinkedList<>();
            AcNode node = root;

            for (int i=0;i<chs.length;i++){
                int idx = chs[i] - 'a';
                while (node.map[idx]==null&&node!=root)
                    node = node.fail;
                node = node.map[idx];
                if (node == null)
                    node = root;
                AcNode p = node;
                while (p!=root){
                    String s = p.str;
                    if (s!=null){
                        ans.add(new Answer(s,i-s.length()+1));
                    }
//                    else break;// 加上这一局则仅匹配最长的字符串
                    p = p.fail;
                }
            }
            return ans;
        }

    }

}
