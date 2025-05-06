public class Problem1 {
    public static void main(String[] args) {
        int [][] arr = {
                {1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,0,2,4,4,0},
                {0,0,0,2,0,0},
                {0,0,1,2,4,0},
        };

        int ans =  Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<(6-2);i++){
            for(int j = 0;j<(6-2);j++){
                int element1 = arr[i][j];
                int element2 = arr[i][j+1];
                int element3 = arr[i][j+2];
                int element4 = arr[i+1][j+1];
                int element5 = arr[i+2][j];
                int element6 = arr[i+2][j+1];
                int element7 = arr[i+2][j+2];
                sum = element1+element2+element3+element4+element5+element6+element7;

                if(ans<sum){
                    ans = sum;
                }
            }
        }
        System.out.println(ans);
    }
}
