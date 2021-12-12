package problems;

public class P278_First_Bad_Version {
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl {
    boolean isBadVersion(int pivotVer) {
        return true;
    }
}

class Solution_First_Bad_Version extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 0) return -1;
        if (n == 1) return 1;

        int right = n;
        int left = 0;
        int pivotVer = 0;

        while(left <= right) {
            pivotVer = left + (right - left) / 2;

            if (isBadVersion(pivotVer) && !isBadVersion(pivotVer - 1)) return pivotVer;

            if (isBadVersion(pivotVer)) {
                right = pivotVer - 1;
            } else {
                left = pivotVer + 1;
            }
        }
        return -1;
    }
}