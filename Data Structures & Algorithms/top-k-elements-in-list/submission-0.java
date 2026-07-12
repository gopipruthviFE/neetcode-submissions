class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> reverseLookUp = new ArrayList<>();
        int[] res = new int[k];

        for(int i=0;i<nums.length + 1;i++){
            reverseLookUp.add(new ArrayList<>());
        }

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            reverseLookUp.get(entry.getValue()).add(entry.getKey());
        }

        for(int i=nums.length;i>=0 && k > 0;i--){
            if(reverseLookUp.get(i).size() > 0){
                for(int j=0;j<reverseLookUp.get(i).size();j++){
                    res[--k] = reverseLookUp.get(i).get(j);
                }
            }
        }

        return res;
    }
}
