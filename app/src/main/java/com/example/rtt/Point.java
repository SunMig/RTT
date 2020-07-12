package com.example.rtt;

public class Point {
    //存储坐标点
    private double x,y;
    public Point(){};
    public Point(double x,double y){
        this.x=x;
        this.y=y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
