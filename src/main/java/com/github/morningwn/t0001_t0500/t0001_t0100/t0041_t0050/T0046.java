package com.github.morningwn.t0001_t0500.t0001_t0100.t0041_t0050;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningwn
 * @date Created in 2020/4/25 23:25
 */
public class T0046 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        Out.println(permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> integers = new ArrayList<>();
        for (int num : nums) {
            integers.add(num);
        }
        helper(0, integers, res);

        return res;
    }

    public void helper(int index, List<Integer> nums, List<List<Integer>> res) {
        if (index >= nums.size()) {
            res.add(new ArrayList<Integer>(nums));
        }

        for (int i = index; i < nums.size(); i++) {
            swap(index, i, nums);
            helper(index + 1, nums, res);
            swap(i, index, nums);
        }

    }

    public void swap(int i, int j, List<Integer> nums) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }
/*    public List<List<Integer>> permute(int[] nums) {
        Queue<List<Integer>> queue = new LinkedList<>();
        for (int num : nums) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(num);
            queue.offer(tmp);
        }

        for (int k = 1; k < nums.length; k++) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                for (int num : nums) {
                    assert queue.peek() != null;
                    List<Integer> tmp = new ArrayList<>(queue.peek());
                    if (!tmp.contains(num)) {
                        tmp.add(num);
                        queue.offer(tmp);
                    }
                }
                queue.poll();
            }
        }

        return new ArrayList<>(queue);
    }*/

}
