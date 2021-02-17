package com.yyp.spring.statical.imple;

import com.yyp.spring.statical.PlayGame;


/**
 * 静态代理类
 * 静态代理的缺点：要实现每个类的代理，都要手动创建一个这样的静态代理类
 */
public class GamePlayerProxy implements PlayGame {

    private String name;
    private GamePlayer gamePlayer;
    public GamePlayerProxy(String name, GamePlayer gamePlayer){
        this.name = name;
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void start() {
        System.out.println("我是"+name+",我要用"+gamePlayer.getName()+"账号登录，替他代练");
        gamePlayer.start();
    }

    @Override
    public void play() {
        System.out.println("我很厉害，完成了升级！");
    }
}
