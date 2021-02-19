package february_daily_challenge;

public class D17_ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWaterSolution solution = new ContainerWithMostWaterSolution();
        ContainerWithMostWaterSolution_1 solution_1 = new ContainerWithMostWaterSolution_1();
        System.out.println(solution.maxArea(new int[]{4,3,2,1,4}));
        System.out.println(solution_1.maxArea(new int[]{4,3,2,1,4}));
    }
}

class ContainerWithMostWaterSolution {
    public int maxArea(int[] height) {
        int leftCol = 0;
        int rightCol = height.length - 1;
        int vol = 0;

        while (leftCol < rightCol) {
            if (height[leftCol] < height[rightCol]) {
                vol = Math.max(vol, height[leftCol] * (rightCol - leftCol));
                leftCol++;
            } else {
                vol = Math.max(vol, height[rightCol] * (rightCol - leftCol));
                rightCol--;
            }
        }
        return vol;
    }
}

class ContainerWithMostWaterSolution_1 {
    public int maxArea(int[] height) {
        int vol = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                vol = Math.max(vol, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return vol;
    }
}
