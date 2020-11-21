package com.JtChen;

/**
 * 二元组
 * @author jtchen
 * @date 2020/11/21
 * @version 1.0
 */
public class TwoTuple {
    public int SpeciesCode;
    public String WordSymbol;

    /**
     *
     * @param SpeciesCode 种别码
     * @param WordSymbol 字符
     */
    public TwoTuple(int SpeciesCode, String WordSymbol){
        this.SpeciesCode = SpeciesCode;
        this.WordSymbol = WordSymbol;
    }
}