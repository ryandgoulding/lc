package impl;

class Solution {


    private int getNextValidL(char[] s, int l, int r) throws IllegalArgumentException{
        while (!(Character.isLetter(s[l]) || Character.isDigit(s[l]))) {
            l++;
            if (l > r) {
                throw new IllegalArgumentException();
            }
        }
        return l;
    }

    private int getNextValidR(char[] s, int r, int l) throws IllegalArgumentException{
        while (!(Character.isLetter(s[r]) || Character.isDigit(s[r]))) {
            r--;
            if (r < l) {
                throw new IllegalArgumentException();
            }
        }
        return r;
    }

    private boolean isPalindrome(char[] s) {
        int l = 0;
        int r = s.length - 1;
        try {
            while(l <= r) {
                int newl = getNextValidL(s, l, r);
                int newr = getNextValidR(s, r, l);
                if (Character.toLowerCase(s[newl]) != Character.toLowerCase(s[newr])) {
                    return false;
                }
                l = newl + 1;
                r = newr - 1;
            }
        } catch (IllegalArgumentException e) {
            return true;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        return isPalindrome(s.toCharArray());
    }
}
