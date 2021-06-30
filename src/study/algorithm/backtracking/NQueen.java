package study.algorithm.backtracking;

import java.util.ArrayList;

public class NQueen {

    public void dfsFunc(int n, int currentRow, ArrayList<Integer> currentCandidate) {
        if (currentRow == n) {
            System.out.println(currentCandidate);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (this.isAvailable(currentCandidate, i)) {
                currentCandidate.add(i);
                this.dfsFunc(n, currentRow + 1, currentCandidate);
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }

    private boolean isAvailable(ArrayList<Integer> candidate, int currentCol) {
        int currentRow = candidate.size();

        for (int i = 0; i < currentRow; i++) {
            if (candidate.get(i) == currentCol || Math.abs(candidate.get(i) - currentCol) == currentRow - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.dfsFunc(4, 0, new ArrayList<Integer>());
    }
}
