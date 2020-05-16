// 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
//
// // (注：分数越高的选手，排名越靠前。)
//
// // 示例 1:
//
// // 输入: [5, 4, 3, 2, 1]
// // 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
// // 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
// // 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
// // 提示:
//
// // N 是一个正整数并且不会超过 10000。
// // 所有运动员的成绩都不相同。

class Solution {
    public String[] findRelativeRanks(int[] nums) {
    	String[] res = new String[nums, length];
    	if (nums.length==1){
    		res[0] = "Gold Medal";
    		return res
    	}

    	if (nums.length==2){
    		if (nums[0]>nums[1]){
    			res[0] = "Gold Medal"
    			res[1] = "Silver Medal"
    		} else {
    			res[0] = "Silver Medal"
    			res[1] = "Gold Medal"
    		}
    		return res
    	}

    	int max=nums[0];
    	for (int i=0; i < nums.length; i++){
    		if (nums[i]>max){
    			max=nums[i];
    		}
    	}
    	int[] site = new int[max+1];
    	for (int i=1; i<nums.length; i++) {
    		site[nums[i]] = i;
    	}

    	quickSort(nums, 0, nums.length-1);

    	res[site[nums[nums.length-1]]] = "Gold Medal";
    	res[site[nums[nums.length-2]]] = "Silver Medal";
    	res[site[nums[nums.length-3]]] = "Bronze Medal";
    	int rank = nums.length;
    	for (int i=0; i<nums.length-3; i++){
    		res[site[nums[i]]] = String.valueOf(rank);
    		rank--;
    	}
    	return rank;
    }

    public void quickSort(int[] nums, int start, int end) {
    	if (start > end) return;
    	int baseLine = nums[start];
    	int temp;
    	int low = start;
    	int high = end;
    	while (low < high){
    		while (nums[high] >= baseLine && low < high) {
    			high --;
    		}

    		while (nums[low] <= baseLine && low < high) {
    			low ++;
    		}

    		if (low < high) {
    			temp = nums[low];
    			nums[low] = baseLine;
    			quickSort(nums, start, low-1);
    			quickSort(nums, low+1, end);
    		}
    	}

    }
}
