package com.JtChen;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static com.JtChen.KeywordJudgment.*;
import static com.JtChen.KeywordJudgment.getBinarySymbolSyc;

/**
 * 词法分析器
 * @author jtchen
 * @date 2020/11/21
 * @version 1.0
 */
public class Analyzer {
    private final List<TwoTuple> list;//二元组表
    private String str;

    /**
     * 初始化函数
     */
    public Analyzer() {
        list = new LinkedList<>();
        str = "";
    }

    /**
     *
     * @param theFile 传入的文件，如test.c,readFile方法将把此文件读为一个String
     */
    public void readFile(File theFile) throws InterruptedException {
        try {
            FileInputStream fs = new FileInputStream(theFile);
            BufferedReader in = new BufferedReader(new InputStreamReader(fs));
            StringBuilder buffer = new StringBuilder();
            String line;
            System.err.println("********************The FIle********************");
            while ((line = in.readLine()) != null) {
                for(int i = 0 ;i < line.length(); i++) {
                    System.out.print(line.charAt(i));
                    System.out.print("_\033[31m(^-^)\033[0m");
                    Thread.sleep(5);
                    System.out.print("\b\b\b\b\b\b");
                }
                System.out.println();
                buffer.append(line);
            }
            str = buffer.toString();
        } catch (FileNotFoundException e) {
            System.out.println("the File doesn't exist!");
        } catch (IOException e) {
            System.out.println("there is an IOException");
        }
    }

    /**
     *
     * @return 二元组表
     */
    public List<TwoTuple> getList() {
        getTwoTuples();
        return list;
    }

    /**
     * 通过遍历str依次获得二元组，并且加入表中
     */
    private void getTwoTuples() {
        Automata automata = new Automata();
        for (int i = 0; i < str.length(); ++i) {
            int tmp = automata.StateTransition(str.charAt(i));
            if (tmp == 2) {
                String temp = automata.getID();
                list.add(new TwoTuple(getKeyWordSyc(temp), temp));
                i--;
            } else if (tmp == 3) {
                list.add(new TwoTuple(10, automata.getID()));
                i--;
            } else if (tmp == 5) {
                list.add(new TwoTuple(20, automata.getINT()));
                i--;
            } else if (tmp == 7)
                list.add(new TwoTuple(50, automata.getString()));
            else if (tmp == 8)
                list.add(new TwoTuple(getUnarySymbolSyc(str.charAt(i)), str.charAt(i) + ""));
            else if (tmp == 10) {
                String temp = automata.getSymbol();
                list.add(new TwoTuple(getBinarySymbolSyc(temp), temp));
            } else if (tmp == 11) {
                String temp = automata.getSymbol();
                list.add(new TwoTuple(getFirstSymbolOfUnarySymbolSyc(temp), temp));
                i--;
            } else if (tmp == 13) {
                String temp = automata.getError();
                System.err.println("Error word : " + temp);
                i--;
            }
        }
    }
}
