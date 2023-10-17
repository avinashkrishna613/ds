/**
 * This problem was asked by Twitter.
 *
 * You are given an array of length 24, where each element represents the number of new subscribers during the corresponding hour. Implement a data structure that efficiently supports the following:
 *
 *     update(hour: int, value: int): Increment the element at index hour by value.
 *     query(start: int, end: int): Retrieve the number of subscribers that have signed up between start and end (inclusive).
 *
 * You can assume that all values get cleared at the end of the day, and that you will not be asked for start and end values that wrap around midnight.
 */

class UpdateDataStructure {
    private int[] subscribersData;
    private int[] consolidatedData = new int[24];

    public UpdateDataStructure(int[] subscribersData) {
        this.subscribersData = subscribersData;
        int i = 0, prevInd = 0;
        for (Integer count: this.subscribersData) {
            this.consolidatedData[i] = count + prevInd;
            prevInd = this.consolidatedData[i];
            i++;
        }
    }

    public void update(int hour, int incrCount) {
        if (hour-1 < 24) {
            this.subscribersData[hour-1] += incrCount;
        }
        printMain();
        for (int j = hour-1; j < 24; j++) {
            this.consolidatedData[j] += incrCount;
        }
    }

    public int query(int start, int end) {
        return this.consolidatedData[end] - this.consolidatedData[start-1];
    }

    public void print() {
        for (int k=0; k<24; k++) {
            System.out.print(this.consolidatedData[k] + " ");
        }
        System.out.println();
    }

    public void printMain() {
        for (int k=0; k<24; k++) {
            System.out.print(this.subscribersData[k] + " ");
        }
        System.out.println();
    }
}
public class UpdateDataStructureMain {
    public static void main(String[] args) {
        int[] subscribesData = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
        UpdateDataStructure updateDataStructure = new UpdateDataStructure(subscribesData);
        updateDataStructure.print();
        System.out.println(updateDataStructure.query(2,4));
        updateDataStructure.update(4,25);
        updateDataStructure.print();
        System.out.println(updateDataStructure.query(2,4));
    }
}
