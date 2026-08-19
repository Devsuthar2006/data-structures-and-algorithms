class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        long x = 0, y = 0, MOD = 1_000_000_007, b = 1;
        while (p != null) {
            x = (x * 10 + p.val) % MOD;
            y = (y + p.val * b) % MOD;
            p = p.next;
            b = b * 10 % MOD;
        }
        return x == y;
    }
}