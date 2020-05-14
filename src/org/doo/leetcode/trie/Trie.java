package org.doo.leetcode.trie;

class Trie {

    private static class Node {
        boolean fullWord;
        Node[] children = new Node[26];

        public void insert(String word, int index) {
            if (index == word.length()) {
                fullWord = true;
            } else {
                Node next = children[word.charAt(index) - 'a'];
                if (next == null) {
                    next = new Node();
                    children[word.charAt(index) - 'a'] = next;
                }

                next.insert(word, index + 1);
            }
        }

        public boolean search(String word, int index) {
            if (word.length() == index) {
                return fullWord;
            }

            Node next = children[word.charAt(index) - 'a'];
            if (next == null) {
                return false;
            }

            return next.search(word, index + 1);
        }

        public boolean startsWith(String word, int index) {
            if (word.length() == index) {
                return true;
            }

            Node next = children[word.charAt(index) - 'a'];
            if (next == null) {
                return false;
            }

            return next.startsWith(word, index + 1);
        }
    }

    private Node root = new Node();

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word, 0);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return root.search(word, 0);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }
}