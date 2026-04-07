package ShiftingLettersII;

public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] shiftEffect = new int[s.length() + 1];
        StringBuilder result = new StringBuilder(s);
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            if (direction == 0) {
                direction = -1;
            }
            
            shiftEffect[start] += direction;
            shiftEffect[end + 1] -= direction;
        }

        int currentShift = 0;

        for (int i = 0; i < s.length(); i++) {
            currentShift += shiftEffect[i];
            char newChar = (char) ((s.charAt(i) - 'a' + currentShift % 26 + 26) % 26 + 'a');
            result.setCharAt(i, newChar);
        }

        return result.toString();
    }
}