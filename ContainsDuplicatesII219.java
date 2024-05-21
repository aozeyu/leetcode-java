
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;


public class ContainsDuplicatesII219 {
  public boolean containsNearbyDuplicate(int[] nums,int k) {
    if (nums.length < 2) {
      return false;
    }
    for (int i = 0; i< nums.length; i++) {
      int numI = nums[i];
      for (int j = i + 1;j < nums.length && j -i <= k; j ++) {
        int numJ = nums[i];
        if (numI == numJ) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean containsNearbyDuplicate2(int[] nums,int k) {
    if (nums.length < 2) {
      return false;
    }
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i< nums.length; i++) {
      Integer key = nums[i];
      if (map.containsKey(key)) {
        if (i - map.get(key) <= k) {
          return true;
        }
      }
      map.put(key,i);
    }
    return false;
  }

  public boolean containsNearbyDuplicate3(int[] nums, int k) {
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i< nums.length; i++) {
      if (i > k) {
        set.remove(nums[i-k-1]);
      }
      if (!set.add(nums[i])) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    ContainsDuplicatesII219 cd2 = new ContainsDuplicatesII219();
    System.out.println(cd2.containsNearbyDuplicate(new int[]{5, 8, 2, 10, 5}, 4));
    System.out.println(cd2.containsNearbyDuplicate2(new int[]{5, 8, 2, 10, 5}, 4));
    System.out.println(cd2.containsNearbyDuplicate3(new int[]{5, 8, 2, 10, 5}, 4));
  }
}
