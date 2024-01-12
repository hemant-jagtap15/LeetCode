class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        //when rook and queen are on the same horizontal and vertical length
        if(a == e || b == f) {
            //condition for bishop inbetween rook and queen
            if(a == e && a == c && ((d - b) * (d - f) < 0)) return 2;
            if(b == f && b == d && ((c - a) * (c - e) < 0)) return 2;

            return 1;
        }

        //when bishop and queen are on the same diagonal 
        if(Math.abs(c - e) == Math.abs(d - f)) {
            //if rook is in between
            if(Math.abs(c - a) == Math.abs(d - b) && ((b - f) * (b - d) < 0)) return 2;
            return 1;
        }
        return 2; 
    }
}
