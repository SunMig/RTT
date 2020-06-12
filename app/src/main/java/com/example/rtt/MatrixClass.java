package com.example.rtt;

import android.util.Log;

//矩阵运算类,可实现加减乘除、转置、求逆、复制等操作
public class MatrixClass implements Cloneable{
    private final String TAG="MatrixClass";
    private int m,n;
    private double[][] A,B;
    private ReverseMatrixCal reverseMatrixCal;

    //构造方法
    public MatrixClass(double[][] a){
        reverseMatrixCal=new ReverseMatrixCal();
        this.m=a.length;
        this.n=a[0].length;
        this.A=a;
        for(int i=0;i<m;i++){
            if(A[i].length!=n){
                Log.d(TAG,"行数不一致！重新输入！");
            }
        }
    }
    //用数组构造矩阵
    public MatrixClass(double[][] a,int m,int n){
        reverseMatrixCal=new ReverseMatrixCal();
        this.A=a;this.m=m;this.n=n;
    }

    public MatrixClass(int m,int n){
        reverseMatrixCal=new ReverseMatrixCal();
        this.m=m;this.n=n;
        A=new double[m][n];
    }

    //获取矩阵的某个元素
    public double get(int i,int j){
        return A[i][j];
    }
    //返回矩阵的行数、列数
    public int getM(){return m;}//行数
    public int getN(){return n;};//列数
    public double[][] getArray(){
        return A;
    }
    //矩阵转置
    public MatrixClass transpose(){
        MatrixClass X=new MatrixClass(n,m);
        double[][] C=X.getArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                C[j][i]=A[i][j];
            }
        }
        return X;
    }
    //矩阵相加
    public MatrixClass plus(MatrixClass B){
        if(B.m!=m||B.n!=n){
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
        MatrixClass X=new MatrixClass(m,n);
        double[][] C=X.getArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                C[i][j]=A[i][j]+B.A[i][j];
            }
        }
        return X;
    }
    //矩阵相减
    public MatrixClass minus(MatrixClass B){
        if(B.m!=m||B.n!=n){
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
        MatrixClass X=new MatrixClass(m,n);
        double[][] C=X.getArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                C[i][j]=A[i][j]-B.A[i][j];
            }
        }
        return X;
    }
    //矩阵相乘
    public MatrixClass times(MatrixClass B){
        if(B.m!=n){
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
        MatrixClass X=new MatrixClass(m,B.n);
        double[][] C=X.getArray();
        double[] temp=new double[n];
        for(int j=0;j<B.n;j++){
            for(int k=0;k<n;k++){
                temp[k]=B.A[k][j];//矩阵B的列，00，10，20
            }
            for(int i=0;i<m;i++){
                double[] Arowi=A[i];//矩阵A的行
                double s=0;
                for(int k=0;k<n;k++){
                    s=s+Arowi[k]*temp[k];
                }
                C[i][j]=s;
            }
        }
        return X;
    }
    //矩阵点乘
    public MatrixClass dotTimes(MatrixClass B){
        if(B.m!=m||B.n!=n){
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
        MatrixClass X=new MatrixClass(m,n);
        double[][] C=X.getArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                C[i][j]=A[i][j]*B.A[i][j];
            }
        }
        return X;
    }
    //矩阵点除（右除）
    public MatrixClass RightDivide(MatrixClass B){
        if(B.m!=m||B.n!=n){
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
        MatrixClass X=new MatrixClass(m,n);
        double[][] C=X.getArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                C[i][j]=A[i][j]/B.A[i][j];
            }
        }
        return X;
    }
    //矩阵点除（左除）
    public MatrixClass LeftDivide(MatrixClass B){
        if(B.m!=m||B.n!=n){
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
        MatrixClass X=new MatrixClass(m,n);
        double[][] C=X.getArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                C[i][j]=B.A[i][j]/A[i][j];
            }
        }
        return X;
    }
    //矩阵乘以一个系数s
    public MatrixClass times(double s){
        MatrixClass X=new MatrixClass(m,n);
        double [][] C=X.getArray();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                C[i][j]=s*A[i][j];
            }
        }
        return X;
    }
    //矩阵的迹
    public double trace(){
        double t=0;
        for (int i=0;i<Math.min(m,n);i++){
            t=t+A[i][i];
        }
        return t;
    }
    //矩阵的逆矩阵
    public MatrixClass inverse(){
        MatrixClass X=new MatrixClass(m,n);
        double [][] C=X.getArray();
        double[][] temp=reverseMatrixCal.getReverseMatrix(A);
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                C[i][j]=temp[i][j];
            }
        }
//        C=reverseMatrixCal.getReverseMatrix(A);
        return X;
    }

}
