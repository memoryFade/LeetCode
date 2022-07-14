package y2022.m07.d14;

import java.util.ArrayList;
import java.util.List;

public class Solution_745_H {
    class WordFilter {
        class TrieNode{
            TrieNode[] tns = new TrieNode[26];
            List<Integer> idxs = new ArrayList();
        }
        void add(TrieNode trieNode ,String word ,int index,boolean isTurn){
            int n = word.length();
            trieNode.idxs.add(index);
            for(int i = isTurn?n-1:0;i>=0&&i<n;i+= isTurn?-1:1){
                int u = word.charAt(i)-'a';
                if(trieNode.tns[u]==null){
                    trieNode.tns[u] = new TrieNode();
                }
                trieNode = trieNode.tns[u];
                trieNode.idxs.add(index);
            }
        }

        int query(String a, String b) {
            int n = a.length(), m = b.length();
            TrieNode p = tr1;
            for (int i = 0; i < n; i++) {
                int u = a.charAt(i) - 'a';
                if (p.tns[u] == null) return -1;
                p = p.tns[u];
            }
            List<Integer> l1 = p.idxs;
            p = tr2;
            for (int i = m - 1; i >= 0; i--) {
                int u = b.charAt(i) - 'a';
                if (p.tns[u] == null) return -1;
                p = p.tns[u];
            }
            List<Integer> l2 = p.idxs;
            n = l1.size(); m = l2.size();
            for (int i = n - 1, j = m - 1; i >= 0 && j >= 0; ) {
                if (l1.get(i) > l2.get(j)) i--;
                else if (l1.get(i) < l2.get(j)) j--;
                else return l1.get(i);
            }
            return -1;
        }

        TrieNode tr1 = new TrieNode(), tr2 = new TrieNode();

        public WordFilter(String[] ss) {
            int n = ss.length;
            for (int i = 0; i < n; i++) {
                add(tr1, ss[i], i, false);
                add(tr2, ss[i], i, true);
            }
        }

        public int f(String a, String b) {
            return query(a, b);
        }
    }
}
