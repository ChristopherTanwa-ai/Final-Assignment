package final_assignment;

public class RankSelectSpaceEfficient implements RankSelectDataStructures {
    private int[] bitVector;
    private int[] rankTable;
    private int blockSize;

    public RankSelectSpaceEfficient(int[] bitVector, int k) {
        this.bitVector = bitVector;
        this.blockSize = 32 * k;
        this.rankTable = preprocess(bitVector, k);
    }

    private int[] preprocess(int[] bitVector, int k) {
        int n = bitVector.length;
        int numBlocks = (int) Math.ceil((double) n / blockSize);
        int[] rankTable = new int[numBlocks];

        for (int i = 0; i < numBlocks; i++) {
            int start = i * blockSize;
            int end = Math.min((i + 1) * blockSize, n);
            int countOnes = 0;

            for (int j = start; j < end; j++) {
                if (bitVector[j] == 1) {
                    countOnes++;
                }
            }

            rankTable[i] = countOnes;
        }

        return rankTable;
    }

    public int rank(int j) {
        int blockIndex = j / blockSize;
        int countLeftBlocks = blockIndex > 0 ? rankTable[blockIndex - 1] : 0;

        int start = blockIndex * blockSize;
        int end = Math.min((blockIndex + 1) * blockSize, bitVector.length);

        int countOnes = countLeftBlocks;

        for (int i = start; i < end && i <= j; i++) {
            if (bitVector[i] == 1) {
                countOnes++;
            }
        }

        return countOnes;
    }

    public int select(int r){
        return -1;
    }

    public static void main(String[] args) {
        int[] bitVector = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        int k = 2;

        RankSelectSpaceEfficient rankStructure = new RankSelectSpaceEfficient(bitVector, k);

        // Example queries
        System.out.println("Rank at position 15: " + rankStructure.rank(15));
        System.out.println("Rank at position 30: " + rankStructure.rank(30));
    }
}
