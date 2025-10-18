class ContainerWithMostWater {
    public static int maxArea(int[]height) {
        int maxArea = 0, left = 0, right = height.length-1;
        while(left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, w * h);
            while(left < right && height[left] <= h) left++;
            while(left < right && height[right] <= h) right--;
        }
        return maxArea;
    }
    public static void main(String[]args) {
        int[]arr1 = {1,8,6,2,5,4,8,3,7};
        int[]arr2 = {1,1};
        log.info(maxArea(arr1)); // 49
        log.info(maxArea(arr2)); // 1
    }
    private static final Log log = new Log();
}
/**
    public static int maxArea(int[]height) {
        int maxArea = 0, left = 0, right = height.length-1;
        while(left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, w * h);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

 */
