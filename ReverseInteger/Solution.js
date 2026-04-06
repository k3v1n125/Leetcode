/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    var reversed = 0;
    var isNegative = x < 0;
    x = Math.abs(x);
    
    while (x > 0) {
        var digit = x % 10;
        reversed = reversed * 10 + digit;
        x = Math.floor(x / 10);
    }
    
    if (isNegative) {
        reversed = -reversed;
    }
    
    if (reversed < -Math.pow(2, 31) || reversed > Math.pow(2, 31) - 1) {
        return 0;
    }

    return reversed;
};