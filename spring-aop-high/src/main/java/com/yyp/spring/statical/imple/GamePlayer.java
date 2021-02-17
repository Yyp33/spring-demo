package com.yyp.spring.statical.imple;

import com.yyp.spring.statical.PlayGame;

public class GamePlayer implements PlayGame {
    private String name;

    public GamePlayer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        System.out.println("我是"+name+",登录游戏！");
    }

    @Override
    public void play() {
        System.out.println("游戏刚开始就被杀害了");
    }
}
