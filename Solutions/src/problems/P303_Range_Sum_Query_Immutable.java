package problems;

public class P303_Range_Sum_Query_Immutable {
    public static void main(String[] args) {
        NumArray sol = new NumArray(new int[]{1, 2, 3, 4, 5});
    }
}


class NumArray {
    int[] arr;
    int sum;

    public NumArray(int[] nums) {
        arr = nums;
    }

    public int sumRange(int left, int right) {
        sum = 0;
        for (int i = left; i <= right; i++) {
            this.sum += arr[i];
        }
        return this.sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */