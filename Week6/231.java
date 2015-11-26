    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        float once=n&(n-1);
        return once==0?true:false;
    }