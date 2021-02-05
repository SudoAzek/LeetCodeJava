package daily_challenge;

public class D04_LongestHarmoniousSubsequence {
    public static void main(String[] args) {

    }
}

class D04_LongestHarmoniousSubsequenceSolution_1 {
    public int findLHS(int[] nums) {
        return 1;
    }
}

/* CPP solution

class Solution {
public:
    int findLHS(vector<int>& nums) {
        unordered_map<int,int> map;
        for(int i = 0; i < nums.size(); i++)
            map[nums[i]]++;
        int answer = 0;
        for(auto x : nums)
            if(map[x + 1])
                answer = max(answer, map[x] + map[x + 1]);
        return answer;
    }
};
 */

/* Python 3 Solution

class Solution:
    def findLHS(self, nums: List[int]) -> int:
        hmap = {}
        res = 0
        for n in nums:
            hmap[n] = hmap.get(n, 0) + 1
        for k, v in hmap.items():
            if k + 1 in hmap:
                res = max(res, v + hmap[k + 1])
        return res
 */
