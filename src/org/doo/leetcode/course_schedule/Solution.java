package org.doo.leetcode.course_schedule;

class Solution {

    private int[] nodes;
    private boolean[] seen;
    private int[][] edges;
    private int[] edgeLen;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        nodes = new int[numCourses];
        seen = new boolean[numCourses];

        edges = new int[numCourses][numCourses];
        edgeLen = new int[numCourses];

        //convert to a more convenient edges format
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            edges[from][edgeLen[from]++] = to;
        }

        for (int i = 0; i < numCourses; i++) {
            if (!seen[i]) {
                if (!mark(i, i + 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean mark(int from, int color) {
        seen[from] = true;
        nodes[from] = color;

        for (int i = 0, len = edgeLen[from]; i < len; i++) {
            int to = edges[from][i];

            if (nodes[to] == color) {
                return false;
            } else {
                if (!mark(to, color)) {
                    return false;
                }
            }
        }

        nodes[from] = 0; //it wasn't that easy to come up with this :)

        return true;
    }
}