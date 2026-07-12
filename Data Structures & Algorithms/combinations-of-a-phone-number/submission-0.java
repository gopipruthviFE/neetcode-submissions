class Solution {
    public void backtrack(int index, String digits, Map<Integer, String> map, List<String> res, StringBuilder sb){
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }

        String s = map.get(digits.charAt(index) - '0');
        for(Character c : s.toCharArray()){
            sb.append(c);
            backtrack(index + 1, digits, map, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.isEmpty()){
            return res;
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        backtrack(0, digits, map, res, new StringBuilder());
        return res;
    }

    // Time : O(4 ^ n * n)
    // Space : O(digits.length)
}
