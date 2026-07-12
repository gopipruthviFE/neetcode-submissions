class Solution {
    public int f(int n){
        int sum = 0;

        while(n > 0){
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }

        return sum;
    }
    public boolean isHappy(int n) {
        if(n == 1){
            return true;
        }
        Set<Integer> seen = new HashSet<>();

        while(n != 1){
            int squaSum = f(n);
            if(seen.contains(squaSum)){
                return false;
            }
            seen.add(squaSum);
            n = squaSum;
        }

        return n == 1 ? true : false;
    }
}
