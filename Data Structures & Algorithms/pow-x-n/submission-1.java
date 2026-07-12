class Solution {
    public double myPow(double x, int n) {
        double num = 1;
        if(n > 0){
            for(int i=0;i<n;i++){
                num = num * x;
            }
        }
        if(n < 0){
            for(int i=0;i<-n;i++){
                num = num * (1 / x);
            }
        }

        return n == 0 ? 1 : num;
    }
}
