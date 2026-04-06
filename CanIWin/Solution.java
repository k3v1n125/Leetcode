package CanIWin;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Boolean> result = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) return true;

        int totalSum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (totalSum < desiredTotal) return false;

        return canWin(0, 0, maxChoosableInteger, desiredTotal);
    }

    private boolean canWin(int usedMask, int currentTotal, int maxNum, int target) {
        // Return cached result for this exact set of used numbers
        if (result.containsKey(usedMask)) return result.get(usedMask);

        for (int i = 0; i < maxNum; i++) {
            if ((usedMask & (1 << i)) != 0) continue; // number already picked

            int pick = i + 1;
            //wins if:
            //this pick win
            //this pick make player 2 lose in next pick
            if (currentTotal + pick >= target ||
                !canWin(usedMask | (1 << i), currentTotal + pick, maxNum, target)) {
                result.put(usedMask, true);
                return true;
            }
        }

        result.put(usedMask, false);
        return false;
    }
}