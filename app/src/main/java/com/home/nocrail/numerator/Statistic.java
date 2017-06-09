package com.home.nocrail.numerator;

/**
 * Created by nocrail on 09.06.17.
 */

public class Statistic {
    private String name;
    private int time;
    private int lines;

    Statistic(){};

    public Statistic (String name, int time, int lines){
        this.name = name;
        this.time = time;
        this.lines = lines;
    };

    public Integer getTime (){
      return time;
    };
    public void setTime(Integer time){
      this.time = time;
    };

    public String getName(){
      return name;
    };
    public void setName(String name){
      this.name = name;
    };

    public Integer getLines(){
        return lines;
    };
    public void setLines(Integer lines){
        this.lines = lines;
    };

}
