package final_assignment;

public class RankSelectLookUp implements RankSelectDataStructures {
    private int[] array;
    private int[] rankArray;

    public RankSelectLookUp(int[] array) {
        this.array = array;
        this.rankArray = new int[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1){
                count++;
            }
            rankArray[i] = count;
        }
    }

    public int rank(int i) {
        if (i == 0) {
            return rankArray[i];
            
        }
        return rankArray[i-1];
    }

    public int select(int r) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (rankArray[mid] == r) {
                return mid;
            } else if (rankArray[mid] < r) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // not found
    }
    public static void main(String[] args) {
        int[] inputArray = new int[]{0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        RankSelectLookUp rs = new RankSelectLookUp(inputArray);
        System.out.println(rs.rank(10));
    }
}
