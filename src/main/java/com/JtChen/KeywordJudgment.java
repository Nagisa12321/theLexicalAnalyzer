package com.JtChen;

import java.util.HashMap;

/**
 * @author jtchen
 * @date 2020/11/21
 * @version 1.0
 */
public class KeywordJudgment {
    /**
     * 利用hashmap来存种别码以及其对应字符
     */
    private static final HashMap<String, Integer> KeyWordMap = new HashMap() {{
        put("main", 1);
        put("int", 2);
        put("char", 3);
        put("if", 4);
        put("else", 5);
        put("for", 6);
        put("while", 7);
        put("return", 8);
        put("void", 9);
    }};
    private static final HashMap<Character, Integer> UnarySymbolMap = new HashMap() {{
        put('+', 22);
        put('-', 23);
        put('*', 24);
        put('/', 25);
        put('(', 26);
        put(')', 27);
        put('[', 28);
        put(']', 29);
        put('{', 30);
        put('}', 31);
        put(',', 32);
        put(':', 33);
        put(';', 34);
    }};
    private static final HashMap<Character, Integer> FirstSymbolOfBinarySymbolMap = new HashMap<>() {{
        put('>', 35);
        put('<', 36);
        put('=', 21);
        put('!', 41);
    }};
    private static final HashMap<String, Integer> BinarySymbolMap = new HashMap() {{
        put(">=", 37);
        put("<=", 38);
        put("==", 39);
        put("!=", 40);
    }};

    /***************************************
     * 判断是否为数字、字母、空格等等
     * @param ch 待判断字符
     * @return 是否为所述内容
     ***************************************/
    public static boolean isFirstSymbolOfBinarySymbol(char ch) {
        return FirstSymbolOfBinarySymbolMap.containsKey(ch);
    }

    public static boolean isBinarySymbol(String str) {
        return BinarySymbolMap.containsKey(str);
    }

    public static boolean isUnarySymbol(char ch) {
        return UnarySymbolMap.containsKey(ch);
    }

    public static boolean isKeyWord(String str) {
        return KeyWordMap.containsKey(str);
    }

    public static boolean isNumber(char ch) {
        return (ch - '0' >= 0 && ch - '0' < 10);
    }

    public static boolean isLetter(char ch) {
        return isBigLetter(ch) || isSmallLetter(ch);
    }

    public static boolean isNumberOrLetter(char ch) {
        return isNumber(ch) || isLetter(ch);
    }

    public static boolean isErrorLetter(char ch) {
        if (!isLetter(ch) && !isNumber(ch) && ch != ' ') return true;
        else return false;
    }

    private static boolean isSmallLetter(char ch) {
        return (ch - 'a' >= 0 && ch - 'a' < 26);
    }

    private static boolean isBigLetter(char ch) {
        return (ch - 'A') >= 0 && (ch - 'A' < 26);
    }

    /***************************************
     * 通过字符在hashmap中获得相应种别码
     * @param str 字符、字符串
     * @return 种别码int
     **************************************/
    public static int getKeyWordSyc(String str) {
        return KeyWordMap.get(str);
    }

    public static int getUnarySymbolSyc(char ch) {
        return UnarySymbolMap.get(ch);
    }

    public static int getBinarySymbolSyc(String str) {
        return BinarySymbolMap.get(str);
    }

    public static int getFirstSymbolOfUnarySymbolSyc(String str) {
        return FirstSymbolOfBinarySymbolMap.get(str.charAt(0));
    }
}
