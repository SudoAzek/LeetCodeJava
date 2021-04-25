package april_daily_challenge;

import java.util.*;

public class D24_CriticalConnectionsInNetwork {
    public static void main(String[] args) {

    }
}

class CriticalConnectionInNetworkSolution {
    int[] disc, low;
    int time = 1;
    List<List<Integer>> answer = new ArrayList<>();
    Map<Integer, List<Integer>> edgeMap = new HashMap<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc = new int[n];
        low = new int[n];
        for (int i = 0; i < n; i++) {
            edgeMap.put(i, new ArrayList<Integer>());
        }
        for (List<Integer> connection : connections) {
            edgeMap.get(connection.get(0)).add(connection.get(1));
            edgeMap.get(connection.get(1)).add(connection.get(0));
        }
        dfs(0, 1);
        return answer;
    }

    public void dfs(int current, int previous) {
        disc[current] = low[current] = time++;
        for (int next : edgeMap.get(current)) {
            if (disc[next] == 0) {
                dfs(next, current);
                low[current] = Math.min(low[current], low[next]);
            } else if (next != previous) {
                low[current] = Math.min(low[current], disc[next]);
            }
            if (low[next] > disc[current]) {
                answer.add(Arrays.asList(current, next));
            }
        }
    }
}

class CriticalConnectionInNetworkSolution1 {
    class Com {
        int val;

        Com() {
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // n servers will have n-1 connections
        if (connections.size() == n - 1)
            return connections;

        int i, j, loopn = connections.size() - n + 1;
        int[] anc = new int[n + 1], lv = new int[n + 1];
        Com[] com = new Com[n + 1];
        Com comm;
        List<Integer> conn;
        ListIterator<List<Integer>> li = connections.listIterator();
        i = connections.get(0).get(0) + 1;
        anc[i] = i;
        lv[i] = 1;

        while (li.hasNext()) {
            conn = li.next();
            if (loopn == 0) {
                results.add(conn);
                continue;
            }

            i = conn.get(0) + 1;
            j = conn.get(1) + 1;
            if (anc[j] == 0) {   //Add to tree;
                if (anc[i] == 0) {
                    connections.add(conn);
                    continue;
                }
                anc[j] = i;
                lv[j] = lv[i] + 1;
            } else if (anc[i] == 0) {
                anc[i] = j;
                lv[i] = lv[j] + 1;
            } else {   //A loop
                loopn--;
                comm = new Com();
                while (i != j) {
                    if (lv[i] > lv[j]) {
                        if (com[i] != null) {
                            i = com[i].val;
                        } else {
                            com[i] = comm;
                            i = anc[i];
                        }
                    } else {
                        if (com[j] != null) {
                            j = com[j].val;
                        } else {
                            com[j] = comm;
                            j = anc[j];
                        }
                    }
                }
                comm.val = i;
            }
        }
        List<Integer> ret;
        for (i = 1; i < n + 1; i++) {
            if (anc[i] != 0 && anc[i] != i && com[i] == null) {
                ret = new ArrayList<Integer>();
                ret.add(i - 1);
                ret.add(anc[i] - 1);
                results.add(ret);
            }
        }
        return results;
    }
}