package com.codeagles.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Codeagles
 * Date: 2020/11/12
 * Time: 4:36 下午
 * <p>
 * Description:
 * 采用两种方式题解
 *
 * //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * //
 * // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * //
 * //
 * //
 * // 示例:
 * //
 * // 给定 nums = [2, 7, 11, 15], target = 9
 * //
 * //因为 nums[0] + nums[1] = 2 + 7 = 9
 * //所以返回 [0, 1]
 * //
 * // Related Topics 数组 哈希表
 */
public class TwoNums {

    //0. 暴力解法 双循环
    //TODO

    //1. 双指针夹逼方法
    public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        int start=0, end =nums.length-1;
        int originA, originB;
        //判断数据是否为空
        if(nums == null){
            return null;
        }
        //如果是一个值或者两个值直接判断
        //对数组进行排序
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums2);
        //双指针由两端向中间移动
        while (start != end ){
            int sum = nums2[start] + nums2[end];
            if( sum >target){
                end--;
                continue;
            }else if(sum < target){
                start++;
                continue;
            }else{
                break;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums2[start]==nums[i]){
                res[0] = i;
                break;
            }
        }
        for(int i=nums.length-1;i>0;i--){
            if(nums2[end]==nums[i]){
                res[1] = i;
                break;
            }
        }

        return res;
    }

    //2. hash表方式
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer res = hashMap.get(target - nums[i]);
            if(hashMap.containsKey(target - nums[i])){
                return new int[]{res,i};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        int target = 6;
        int[] ints = twoSum1(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
