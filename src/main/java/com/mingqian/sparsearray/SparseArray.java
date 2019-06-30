package com.mingqian.sparsearray;

import java.io.*;

/**
 * Created by mingqian on 2019/6/30
 */
public class SparseArray {

  public static void main(String[] args) throws IOException {
    /**
     * 1. 创建一个原始的二维数组[11*11]
     * 2. 0:表示没有棋子,1表示黑子,2表示蓝子
     */
    int chessArr1[][] = new int[11][11];
    chessArr1[1][1] = 1;
    chessArr1[1][2] = 2;
    chessArr1[2][1] = 1;
    chessArr1[3][1] = 2;

    int sum = 0;
    System.out.println("原始的棋盘--------> {}:");
    for (int[] ints : chessArr1) {
      for (int anInt : ints) {
        if(anInt != 0){
          sum++;
        }
//        System.out.println("%d\t"+anInt);
        System.out.printf("%d\t", anInt);
      }
      System.out.println();
    }

    System.out.println("有效的棋子数量:" + sum);

    /**
     * 将二维数组 转 稀疏数组的思路
     * sparseArr
     */

    int sparseArr[][] = new int[sum+1][3];
    sparseArr[0][0] = chessArr1.length;
    sparseArr[0][1] = chessArr1.length;
    sparseArr[0][2] = sum;
    System.out.println("稀疏数组--------> {}:");
    int count = 0;
    System.out.println(chessArr1.length);
    for (int i = 0; i < chessArr1.length; i++) {
      for (int j = 0; j < chessArr1[0].length; j++) {
        if (chessArr1[i][j] != 0) {
          count++;
          sparseArr[count][0] = i;
          sparseArr[count][1] = j;
          sparseArr[count][2] = chessArr1[i][j];
        }
      }
    }

    for (int[] ints : sparseArr) {
      for (int anInt : ints) {
        System.out.printf("%d\t", anInt);
      }
      System.out.println();
    }

    boolean file = CreateFileUtils.createFile("F:\\file.txt\\");
    String path = "F:\\file.txt\\";
    FileOutputStream fileOutputStream = null;
    try {
      fileOutputStream = new FileOutputStream(path);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < sparseArr.length; i++) {
      for (int i1 = 0; i1 < sparseArr[0].length; i1++) {
        System.out.printf("%d\t", sparseArr[i][i1]);
        fileOutputStream.write((String.valueOf(sparseArr[i][i1])+"\t").getBytes());

      }
      fileOutputStream.write("\r\n".getBytes());
      fileOutputStream.flush();
    }
//    for (int[] ints : sparseArr) {
//      for (int anInt : ints) {
//
//        bos.flush();
//        System.out.printf("%d\t", anInt);
//      }
//      System.out.println();
//    }
    FileReader reader = new FileReader(path);
    BufferedReader br = new BufferedReader(reader);
    String s = br.readLine();
    System.out.println(s+"123131");


  }
}
