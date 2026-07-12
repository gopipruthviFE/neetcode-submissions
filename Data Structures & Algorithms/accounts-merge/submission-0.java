class Solution {
    int[] parent;
    int[] size;

    public int find(int x){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }

        return x;
    }

    public void union(int a, int b){
        int ra = find(a);
        int rb = find(b);

        if(ra == rb){
            return;
        }
        if(size[ra] < size[rb]){
            int temp = ra;
            ra = rb;
            rb = temp;
        }
        parent[rb] = ra;
        size[ra] += size[rb];
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        int n = 0;

        for(List<String> account : accounts){
            for(int i=1;i<account.size();i++){
                String email = account.get(i);
                if(!emailToId.containsKey(email)){
                    emailToId.put(email, n++);
                }
                emailToName.put(email, account.get(0));
            }
        }

        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(List<String> account : accounts){
            int firstEmail = emailToId.get(account.get(1));

            for(int i=2;i<account.size();i++){
                union(firstEmail, emailToId.get(account.get(i)));
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();

        for(String email : emailToId.keySet()){
            int root = find(emailToId.get(email));
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for(List<String> emails : groups.values()){
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(emails);
            result.add(merged);
        }

        return result;
    }
}