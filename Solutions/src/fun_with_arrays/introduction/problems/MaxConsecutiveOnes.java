package fun_with_arrays.introduction.problems;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnesSolution sol = new MaxConsecutiveOnesSolution();
        System.out.println(sol.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}

class MaxConsecutiveOnesSolution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxx = 0;
        int maxy = 0;
        int a = nums[0];

        int i = 0;
        while (i < nums.length) {
            if(nums[i] == 1) {
                maxx++;
                maxy = maxx;
            } else {
                maxx = 0;
            }
            i++;
        }
//
//        for (int i = 1; i < nums.length; i++) {
//
//        }
        return maxy;
    }
}