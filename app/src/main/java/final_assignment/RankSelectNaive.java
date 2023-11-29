package final_assignment;

public class RankSelectNaive {
      private int[] array;
   
      public RankSelectNaive(int[] array) {
         this.array = array;
      }
   
      public int rank(int i) {
         int count = 0;
         for (int j = 0; j < i; j++) {
               if (array[j] == 1) {
                  count++;
               }
         }
         return count;
      }
   
      public int select(int r) {
         int count = 0;
         for (int i = 0; i < array.length; i++) {
               if (array[i] == 1) {
                  count++;
               }
               if (count == r) {
                  return i;
               }
         }
         return -1;
      }

}
