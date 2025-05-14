class Problem2 {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0;i < nums.length;){
            int pos = nums[i] - 1;
            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[pos]){
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
            }
            else{
                i++;
            }
        }

        for(int i = 0;i < nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
