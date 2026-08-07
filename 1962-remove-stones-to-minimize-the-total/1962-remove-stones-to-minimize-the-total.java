class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

        int sum = 0;
        for (int p : piles) {
            max.add(p);
            sum += p;
        }

        while (k-- > 0) {
            int pile = max.poll();
            max.add(pile - pile / 2);
            sum -= pile / 2;
        }

        return sum;
    }
}