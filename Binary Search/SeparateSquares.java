class Solution{

    public boolean check(double mid_y,int[][] squares,double totalArea){
        double bottomA = 0.0;

        for(int i=0;i<squares.length;i++){
            double y = squares[i][1];
            double l = squares[i][2];

            double min_y = y;
            double top_y = y+l;

            if(mid_y >= top_y){
                bottomA += l*l;
            }else{
                bottomA += (mid_y - min_y)*l;
            }
        }

        return bottomA >= (totalArea-bottomA);
    }

    public double separateSquares(int[][] squares){
        int n=squares.length;
        double totalArea = 0.0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for(int i=0;i<n;i++){
            double y = squares[i][1];
            double l = squares[i][2];

            totalArea += l*l;

            low = Math.min(low,y);
            high = Math.max(high,y+l);
        }

        double result = 0.0;

        while(high-low > 1e-5){
            double mid_y = low + (high-low)/2;

            result = mid_y;

            if(check(mid_y,squares,totalArea)){
                low = mid_y;
            }else{
                high = mid_y;
            }
        }

        return result;
    }
}