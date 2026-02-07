class Solution {
    private List<Integer> generatedRow(int r) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // first element

        for (int c = 1; c <= r; c++) {
            ans = ans * (r - c + 1);
            ans = ans / c;
            ansRow.add((int) ans);
        }

        return ansRow;
    }

    public List<Integer> getRow(int rowIndex) {
        return generatedRow(rowIndex);
    }
}