// leetcode link - https://leetcode.com/problems/check-if-it-is-a-straight-line/
public class NPointsCollinearity {
        public boolean checkStraightLine(int[][] coordinates) {
            int size = coordinates.length;
            if (size == 2) return true;
            int[] first = coordinates[0];
            int[] second = coordinates[1];
            int yDiff = second[1]-first[1];
            int xDiff = second[0]-first[0];
            for (int i=2; i<size; i++) {
                if (xDiff*(coordinates[i][1] - second[1]) == yDiff*(coordinates[i][0] - second[0])) {
                    continue;
                } else {
                    return false;
                }
            }

            return true;
        }
}
