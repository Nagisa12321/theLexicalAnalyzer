package com.JtChen;


import java.io.File;
import java.util.List;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Analyzer analyzer = new Analyzer();
        if (args.length > 0) {
            analyzer.readFile(new File(args[0]));
        } else {
            analyzer.readFile(new File("src/main/resources/test.c"));
        }
        List<TwoTuple> list = analyzer.getList();
        System.err.println("********************二元组********************");
        for (int i = 0; i < list.size(); ++i) {
            System.out.println("< " + list.get(i).SpeciesCode + ", " + list.get(i).WordSymbol + " >");
            System.out.print("_\033[31m(^-^)\033[0m");
            Thread.sleep(100);
            System.out.print("\b\b\b\b\b\b");
        }
        System.exit(10086);
    }
}

