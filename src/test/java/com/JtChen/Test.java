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
        for (TwoTuple twoTuple : list) {
            System.out.println("< " + twoTuple.SpeciesCode + ", " + twoTuple.WordSymbol + " >");
/*
            System.out.print("_\033[31m(^-^)\033[0m");
            Thread.sleep(10);
            System.out.print("\b\b\b\b\b\b");
*/
        }
        System.exit(10086);
    }
}

