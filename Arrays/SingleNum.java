public class SingleNum {

    public int singleNumber(int[] nums) {

        int singleNum = 0;

        // Repeated XOR operations will lead to the single number!
        for (int i = 0; i < nums.length; i++) {
            singleNum = singleNum ^ nums[i];
        }

        return singleNum;
    }

}
