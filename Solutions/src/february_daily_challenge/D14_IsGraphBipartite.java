package february_daily_challenge;

import java.util.Arrays;

public class D14_IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] graph2 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        IsGraphBipartiteSolution isGraphBipartiteSol = new IsGraphBipartiteSolution();
        IsGraphBipartiteSolution1 isGraphBipartiteSol1 = new IsGraphBipartiteSolution1();
        System.out.println(isGraphBipartiteSol.isBipartite(graph));
        System.out.println(isGraphBipartiteSol.isBipartite(graph2));

        System.out.println(isGraphBipartiteSol1.isBipartite(graph));
        System.out.println(isGraphBipartiteSol1.isBipartite(graph2));
    }
}

class IsGraphBipartiteSolution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && dfs(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int[] colors, int color, int index) {
        if (colors[index] != 0) {
            return colors[index] != color;
        }
        colors[index] = color;
        for (int graphIndex :
                graph[index]) {
            if (dfs(graph, colors, -color, graphIndex)) {
                return true;
            }
        }
        return false;
    }
}

class IsGraphBipartiteSolution1 {
    private static final String UNCOLORED = "u";
    private static final String BLUE = "b";
    private static final String RED = "r";

    public boolean isBipartite(int[][] graph) {
        String[] color = new String[graph.length];
        boolean ans = true;
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(color, UNCOLORED);
            ans &= visit(graph, i, color, UNCOLORED);
        }
        return ans;
    }

    private boolean visit(int[][] graph, int vertexIndex, String[] color, String parentVertexColor) {
        if (parentVertexColor.equals(UNCOLORED)) {
            color[vertexIndex] = BLUE;
        } else {
            if (color[vertexIndex].equals(UNCOLORED)) {
                color[vertexIndex] = parentVertexColor.equals(BLUE) ? RED : BLUE;
            } else {
                return !parentVertexColor.equals(color[vertexIndex]);
            }
        }
        boolean temp = true;
        for (int connectedVertexIndex : graph[vertexIndex]) {
            temp &= visit(graph, connectedVertexIndex, color, color[vertexIndex]);
        }
        return temp;
    }
}