import java.util.HashSet;
import java.util.Set;

class FirstMissingNumber {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set= new HashSet<>();
        int ans=0;
        int size=nums.length;

        for(int i=0;i<size;i++){
            set.add(nums[i]);
        }

        for(int i=1;i<=size+1;i++){
            if(!set.contains(i)){
                ans=i;
                break;

            }
        }
        return ans;
    }
}