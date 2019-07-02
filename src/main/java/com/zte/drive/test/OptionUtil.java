package com.zte.drive.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 刘煦健
 * Date:2019-07-02 9:21
 * Description:<描述>
 */
public class OptionUtil {
    /**
     * 将选项合成为一个字符串，特殊符号为#号
     * @param options 选项的字符串数组
     * @return 合成字符串
     */
    static public String combineOptions(List<String> options) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (String str : options) {
            stringBuffer.append(str + "#");

        }
        return stringBuffer.toString();
    }

    /**
     * 将组合的特殊字符穿分解，按#号分解
     * @param combinedOptions 组合后的字符串
     * @return 选项数组
     */
    static public List<String> separateOptions(String combinedOptions) {
        String [] split = combinedOptions.split("#");
        List<String> strings = new ArrayList<>();
        strings.addAll(Arrays.asList(split));
        return strings;
    }

    /**
     * 测试用main函数
     * @param args
     */
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("A 李白");
        strings.add("B 杜甫");
        strings.add("C 杜牧");
        String combined = combineOptions(strings);
        System.out.println(combined);
        System.out.println(separateOptions(combined).toString());
    }

}
