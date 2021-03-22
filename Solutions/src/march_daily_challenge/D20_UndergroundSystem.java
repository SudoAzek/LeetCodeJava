package march_daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class D20_UndergroundSystem {
    public static void main(String[] args) {
        UndergroundSystemSolution solution = new UndergroundSystemSolution();
        System.out.println();
    }
}

class UndergroundSystemSolution {
    Map<Integer, checkinInfo> checkinMap;
    Map<Integer, checkoutInfo> timeMap;

    public UndergroundSystemSolution() {
        checkinMap = new HashMap<>();
        timeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkinInfo obj = new checkinInfo(stationName, t);
        checkinMap.put(id, obj);
    }


    public void checkOut(int id, String stationName, int t) {
        checkinInfo cin = checkinMap.get(id);
        int code1 = cin.station.hashCode(), code2 = stationName.hashCode();
        int hcode = Math.max(code1, code2) * 10 + Math.min(code1, code2);
        double curr_time = t - cin.time;
        checkoutInfo temp = timeMap.getOrDefault(hcode, null);

        if (temp == null)
            timeMap.put(hcode, new checkoutInfo(curr_time, 1));
        else {
            temp.cnt += 1;
            temp.time += curr_time;
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        int code1 = startStation.hashCode(), code2 = endStation.hashCode();
        int code = Math.max(code1, code2) * 10 + Math.min(code1, code2);
        checkoutInfo temp = timeMap.getOrDefault(code, null);

        return temp == null ? -1 : temp.time / temp.cnt;
    }


    private static class checkoutInfo {
        double time;
        double cnt;

        checkoutInfo(double time, double cnt) {
            this.cnt = cnt;
            this.time = time;
        }
    }

    private static class checkinInfo {
        String station;
        int time;

        checkinInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}