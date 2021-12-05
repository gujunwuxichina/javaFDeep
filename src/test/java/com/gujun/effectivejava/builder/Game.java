package com.gujun.effectivejava.builder;

/**
 * @ClassName: Game
 * @Author GuJun
 * @Description:
 * @Date 2021年12月05日 21:03
 */
public class Game {
    
    private final String name;
    
    private final String company;
    
    private final Boolean isAdult;
    
    private final Boolean isSupportNet;
    
    private final Double price;
    
    public static class Builder{
        private final String name;
        private final String company;
        private final Double price;

        private Boolean isAdult=false;

        private Boolean isSupportNet=true;
        
        public Builder(String name,String company,Double price){
            this.name=name;
            this.company=company;
            this.price=price;
        }
        public Builder adult(boolean b){
            isAdult=b;
            return this;
        }
        public Builder supportNet(boolean b){
            isSupportNet=b;
            return this;
        }

        public Game build(){
            return  new Game(this);
        }
        
    }

    private Game(Builder builder) {
        this.name=builder.name;
        this.company=builder.company;
        this.price=builder.price;
        this.isAdult=builder.isAdult;
        this.isSupportNet=builder.isSupportNet;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", isAdult=" + isAdult +
                ", isSupportNet=" + isSupportNet +
                ", price=" + price +
                '}';
    }
}
