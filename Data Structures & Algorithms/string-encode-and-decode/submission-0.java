class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i).length());
            sb.append('#');
            sb.append(strs.get(i));
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int pivot = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, pivot));
            String sub = str.substring(pivot + 1, pivot + 1 + length);
            i = 1 + pivot + length;
            res.add(sub);
        }
        return res;
    }
}
