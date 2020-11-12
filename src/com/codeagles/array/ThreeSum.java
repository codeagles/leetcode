package com.codeagles.array;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Codeagles
 * Date: 2020/11/12
 * Time: 6:01 下午
 * <p>
 * Description:
 * //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
 * //的三元组。
 * //
 * // 注意：答案中不可以包含重复的三元组。
 * //
 * //
 * //
 * // 示例：
 * //
 * // 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * //
 * //满足要求的三元组集合为：
 * //[
 * //  [-1, 0, 1],
 * //  [-1, -1, 2]
 * //]
 * //
 * // Related Topics 数组 双指针
 */
public class ThreeSum {
    //0. 暴力法 三层循环 O(n^3)

    //1. 指针夹逼
    public static List<List<Integer>> threeSumSolution1(int[] nums) {
        // 三指针
//        Set<List<Integer>> res = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();


        Arrays.sort(nums);

        for(int key =0; key< nums.length-2;key++){
            if(key > 0 && nums[key] == nums[key-1]){
                continue;
            }
            int start = key+ 1, end=nums.length-1;
            while(start != end && start < end ){
                /**
                 * 如果 加和大于key值，说明结果偏大需要 右指针左移缩小结果
                 * 如果 加和小于key值，说明结果偏小需要 左指针右移增大结果
                 * 否则则为相等，保存结果，移动key指针，直至结束
                 * (优化后的去重代码)
                 */
                if(nums[start] + nums[end] + nums[key]>0){
//                    while(start<end && nums[end]==nums[end-1]){
//                        end--;
//                    }
                    end--;
                }else if(nums[start] + nums[end] + nums[key]<0){
//                    while(start<end && nums[start]==nums[start+1]){
//                        start++;
//                    }
                    start++;
                }else{
                    //通过指针去重
                    result.add(Arrays.asList(nums[key],nums[start],nums[end]));
                    while(start<end && nums[start]==nums[start+1]){
                        start++;
                    }
                    while(start<end && nums[end]==nums[end-1]){
                        end--;
                    }
                    start++;
                    end--;

                    /** 我的去重代码，利用了set集合的特性
                     *  List<Integer> subRes = new ArrayList<>();
                     *                     subRes.add(nums[key]);
                     *                     subRes.add(nums[start]);
                     *                     subRes.add(nums[end]);
                     *                     //找到结果后，跳出循环进行下一层循环
                     *                     res.add(subRes);
                     *                     start++;
                     *                     end--;
                     */

                }
            }
        }

//        Iterator<List<Integer>> iterator = res.iterator();
//        while (iterator.hasNext()){
//            result.add(iterator.next());
//        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,2,-1,-3};
        List<List<Integer>> lists = threeSumSolution1(nums);
        System.out.println(lists.toString());





    }
}
