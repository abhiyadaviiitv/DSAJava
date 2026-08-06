class Solution {
    public int smallestNumber(int n, int t) {
        int flag = -1;
        int temp = n;
        int cnt = n;
        int pro = 1;
       while(flag < 0)
       {
         temp = cnt;
         pro = 1;
        while(temp > 0)
        {
        pro  *= temp % 10;
        temp = temp /10;
        }


        if(pro % t == 0)
        {
            flag = 0;
        }
        else
        cnt ++;
        
       }

       return cnt;
    }
}