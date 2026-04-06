/**
 * @param {number[]} nums
 * @param {number} lower
 * @param {number} upper
 * @return {number}
 */
var countFairPairs = function(nums, lower, upper) {
    nums.sort((a, b) => a - b);
    let count = 0;
    for (let i = 0; i < nums.length; i++) {
        let left = i + 1, right = nums.length;
        while (left < right) {
            let mid = Math.floor((left + right) / 2);
            if (nums[mid] < lower - nums[i]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        let lowerIndex = left;
        left = i + 1, right = nums.length;
        while (left < right) {
            let mid = Math.floor((left + right) / 2);
            if (nums[mid] <= upper - nums[i]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        let upperIndex = left - 1;
        if (lowerIndex <= upperIndex) {
            count += upperIndex - lowerIndex + 1;
        }
    }
    return count;
};