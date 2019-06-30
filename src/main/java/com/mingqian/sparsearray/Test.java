package com.mingqian.sparsearray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mingqian on 2019/6/30
 */
public class Test {
  public static void main(String[] args) throws IOException {
    String path = "F:\\file.txt\\";

    FileReader reader = new FileReader(path);
    BufferedReader br = new BufferedReader(reader);
    String line;
    int row=0;
    int[][] arr2 = new int[11][11];
    while((line = br.readLine()) != null){
      String[] temp = line.split("\t");
      for (int i = 0; i < temp.length; i++) {
        arr2[row][i] = Integer.valueOf(temp[i]);
      }
      row++;

    }
    for (int[] ints : arr2) {
      for (int anInt : ints) {
        System.out.printf("%d\t", anInt);
      }
      System.out.println();

    }
  }
}
