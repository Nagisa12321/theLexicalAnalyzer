package com.JtChen;

import static com.JtChen.KeywordJudgment.*;

/**
 * @author jtchen
 * @date 2020/11/21
 * @version 1.0
 */
public class Automata {
    private int theStatus, num;
    private StringBuilder theIDBuilder, theStringBuilder, theSymbolBuilder, theErrorBuilder;

    /**
     * 初始化各个字符串
     */
    public Automata() {
        theStatus = 0;
        num = 0;
        theIDBuilder = new StringBuilder();
        theStringBuilder = new StringBuilder();
        theSymbolBuilder = new StringBuilder();
        theErrorBuilder = new StringBuilder();
    }

    /**
     * 自动机，每次添加一个ch，根据原有状态theStatus改变状态
     * @param ch 遍历到的字符
     * @return 现在的状态
     */
    public int StateTransition(char ch) {
        if (theStatus == 0)
            if (isLetter(ch)) {
                theIDBuilder.append(ch);
                theStatus = 1;
                return 1;
            } else if (isNumberOrLetter(ch)) {
                num = 10 * num + ch - '0';
                theStatus = 4;
                return 4;
            } else if (ch == '"') {
                theStatus = 6;
                return 6;
            } else if (isUnarySymbol(ch)) {
                theStatus = 0;
                return 8;
            } else if (isFirstSymbolOfBinarySymbol(ch)) {
                theSymbolBuilder.append(ch);
                theStatus = 9;
                return 9;
            } else if (ch == ' ') {
                theStatus = 0;
                return 0;
            } else if (isErrorLetter(ch)) {
                theErrorBuilder.append(ch);
                theStatus = 12;
                return 12;
            }
        if (theStatus == 1)
            if (isKeyWord(theIDBuilder.toString())) {
                theStatus = 0;
                return 2;
            } else if (isNumberOrLetter(ch)) {
                theIDBuilder.append(ch);
                return 1;
            } else if (!isNumberOrLetter(ch)) {
                theStatus = 0;
                return 3;
            }
        if (theStatus == 4)
            if (isNumber(ch)) {
                num = 10 * num + ch - '0';
                return 4;
            } else if (!isNumber(ch)) {
                theStatus = 0;
                return 5;
            }
        if (theStatus == 6)
            if (ch == '"') {
                theStatus = 0;
                return 7;
            } else theStringBuilder.append(ch);
        if (theStatus == 9)
            if (isBinarySymbol(theSymbolBuilder.append(ch).toString())) {
                theStatus = 0;
                return 10;
            } else {
                theSymbolBuilder.deleteCharAt(theSymbolBuilder.length() - 1);
                theStatus = 0;
                return 11;
            }
        if (theStatus == 12) {
            if (isErrorLetter(ch)){
                theErrorBuilder.append(ch);
                theStatus = 12;
                return 12;
            } else {
                theStatus = 0;
                return 13;
            }
        }
        return 0;
    }

    /***************************************
     * 获得五种字符串，，每次获得后，
     * 都会重新new一下，防止出错
     * @return 相应字符串
     ***************************************/
    public String getID() {
        String tmp = theIDBuilder.toString();
        theIDBuilder = new StringBuilder();
        return tmp;
    }

    public String getINT() {
        int tmp = num;
        num = 0;
        return tmp + "";
    }

    public String getString() {
        String tmp = theStringBuilder.toString();
        theStringBuilder = new StringBuilder();
        return tmp;
    }

    public String getSymbol() {
        String tmp = theSymbolBuilder.toString();
        theSymbolBuilder = new StringBuilder();
        return tmp;
    }

    public String getError() {
        String tmp = theErrorBuilder.toString();
        theErrorBuilder = new StringBuilder();
        return tmp;
    }
}
