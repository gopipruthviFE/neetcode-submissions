class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        int[] res = new int[k];

        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());// add arrayLists to the list 
        }

        for(int i=0;i<n;i++){// element -> freq
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.get(entry.getValue()).add(entry.getKey());
        }

        int idx = 0;

        for(int i=n;i>=0;i--){
            for(int ele : list.get(i)){
                if(k > 0){
                    res[idx++] = ele;
                    k--;
                }
            }
        }
        
        return res;
    }
    // Time : O(n) <--> as we check each element only once
    // Space : O(n) <--> as each element enters map so n elements in map and list
}
