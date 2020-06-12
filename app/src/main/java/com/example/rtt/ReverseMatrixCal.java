package com.example.rtt;

public class ReverseMatrixCal {
    private MatrixClass matrixClass;
    public ReverseMatrixCal(){};
    public ReverseMatrixCal(MatrixClass matrixClass){
        this.matrixClass=matrixClass;
    }
    //计算逆矩阵 A的逆矩阵公式为 A*/|A|，需要分别求出A*、|A|
    public double[][] getReverseMatrix(double[][] matrix){
        double[][] newmatrix=new double[matrix.length][matrix[0].length];
        double A=getMatrixResult(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if((i+j)%2==0){
                    newmatrix[i][j] = getMatrixResult(getConfactor(matrix, i+1, j+1)) / A;
                }else{
                    newmatrix[i][j] = -getMatrixResult(getConfactor(matrix, i+1, j+1)) / A;
                }
            }
        }
        newmatrix=trans(newmatrix);
        return newmatrix;
    }
    private double[][] trans(double[][] newmatrix){
        double[][] newmatrix2=new double[newmatrix[0].length][newmatrix.length];
        for(int i=0;i<newmatrix.length;i++){
            for(int j=0;j<newmatrix[0].length;j++){
                newmatrix2[j][i]=newmatrix[i][j];
            }
        }
        return newmatrix2;
    }
    //计算行列式|A|
    public double getMatrixResult(double[][] matrix){
        //二维矩阵
        if(matrix.length==2){
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        }
        //二维以上的矩阵
        double result=0;
        int num=matrix.length;
        double[] nums=new double[num];
        for(int i=0; i<matrix.length; i++) {
            if(i%2 == 0) {
                nums[i] = matrix[0][i] * getMatrixResult(getConfactor(matrix, 1, i+1));
            }else {
                nums[i] = -matrix[0][i] * getMatrixResult(getConfactor(matrix, 1, i+1));
            }
        }
        for(int i=0; i<matrix.length; i++) {
            result += nums[i];
        }

//		System.out.println(result);
        return result;
    }

    //计算余子式A*
    public double [][] getConfactor(double[][] matrix, int h, int v) {
        int H = matrix.length;
        int V = matrix[0].length;
        double[][] newmatrix = new double[H-1][V-1];
        for(int i=0; i<newmatrix.length; i++) {
            if(i < h-1) {
                for(int j=0; j<newmatrix[i].length; j++) {
                    if(j < v-1) {
                        newmatrix[i][j] = matrix[i][j];
                    }else {
                        newmatrix[i][j] = matrix[i][j+1];
                    }
                }
            }else {
                for(int j=0; j<newmatrix[i].length; j++) {
                    if(j < v-1) {
                        newmatrix[i][j] = matrix[i+1][j];
                    }else {
                        newmatrix[i][j] = matrix[i+1][j+1];
                    }
                }
            }
        }

//		for(int i=0; i<newdata.length; i ++)
//			for(int j=0; j<newdata[i].length; j++) {
//				System.out.println(newdata[i][j]);
//			}
        return newmatrix;
    }
}
