package com.keke.string;

import java.util.HashMap;

/**
 * Created by KEKE on 2018/11/6
 *
 * Trie  字典树
 */
public class P299 {

    public static void main(String[] args){

        String s1 = "abc";
        String s2 = "bcd";
        Trie trie = new Trie();
        trie.insert(s1);
        trie.insert(s2);
        trie.insert(s2);
        System.out.println(trie.search(s2));
        System.out.println(trie.search("123"));
        System.out.println(trie.search(s1));
        trie.delete(s1);
        System.out.println(trie.search(s1));
        System.out.println(trie.prefixNum(s2));
    }

    static class TrieNode{

        public int path;
        public int end;
        public HashMap<Character, TrieNode> map;

        public TrieNode(){
            path = 0;
            end = 0;
            map = new HashMap<>();
        }
    }

    static class Trie{

        private TrieNode root;

        public Trie(){
            this.root = new TrieNode();
        }

        public void insert(String word){
            if (word==null)
                return;
            char[] ch = word.toCharArray();
            char key;
            TrieNode node = root;
            for (int i=0;i<ch.length;i++){
                key = ch[i];
                if (!node.map.containsKey(key)){
                    node.map.put(key, new TrieNode());
                }
                node = node.map.get(key);
                node.path++;
            }
            node.end++;
        }

        public void delete(String word){

            if (search(word)){
                char[] ch = word.toCharArray();
                TrieNode node = root;
                char key;
                for (int i=0;i<ch.length;i++){
                    key = ch[i];
                    if (node.map.get(key).path--==1){
                        node.map.remove(key);
                        return;
                    }
                    node = node.map.get(key);
                }
                node.end--;
            }
        }

        public boolean search(String word){

            if (word==null)
                return false;
            char[] ch = word.toCharArray();
            TrieNode node = root;
            char key;
            for (int i=0;i<ch.length;i++){
                key = ch[i];
                if (!node.map.containsKey(key))
                    return false;
                node = node.map.get(key);
            }
            return node.end!=0;
        }

        public int prefixNum(String word){

            if (word==null)
                return 0;
            char[] ch = word.toCharArray();
            TrieNode node = root;
            char key;
            for (int i=0;i<ch.length;i++){
                key = ch[i];
                if (!node.map.containsKey(key))
                    return 0;
                node = node.map.get(key);
            }
            return node.path;
        }
    }

}
