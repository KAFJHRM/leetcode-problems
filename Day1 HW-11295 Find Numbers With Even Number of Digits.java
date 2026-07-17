class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int count = 0;
        for (int num : nums) {
            // Under constraints (1 <= num <= 10^5), a number has an even number of digits if:
            // - It has 2 digits: [10, 99]
            // - It has 4 digits: [1000, 9999]
            // - It has 6 digits: 100000 (though upper constraint is 10^5, which is 6 digits)
            if ((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || num == 100000) {
                count++;
            }
        }
        return count;
        
    }
};
