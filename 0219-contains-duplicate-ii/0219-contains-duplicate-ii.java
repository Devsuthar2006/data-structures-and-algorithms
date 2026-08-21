

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer , Integer> set = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
        if(set.containsKey(nums[i])){
            int oldIndex = set.get(nums[i]);
            if(i - oldIndex <=k){
                return true;
            }
        }
        set.put(nums[i], i);
        }
        return false;
    }
}