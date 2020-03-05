package S1342_Number_of_Steps_to_Reduce_a_Number_to_Zero;

class Solution {
    public int numberOfSteps (int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            count ++;
        }

        return count;
    }

    public int numberOfStepsRecurve (int num) {
        if (num == 0) {
            return 0;
        } else {
            if (num % 2 == 0) {
                return numberOfStepsRecurve(num / 2) + 1;
            } else {
                return numberOfStepsRecurve(num - 1) + 1;
            }
        }
    }
}