package com.mingqian.sparsearray;

import java.io.File;
import java.io.IOException;

/**
 * Created by mingqian on 2019/6/30
 * 创建文件工具类
 */
public class CreateFileUtils {

  public static boolean createFile(String filePath) {
    Boolean reuslt = Boolean.FALSE;

    File file = new File(filePath);
      if (!file.exists()) {
        try {
          file.createNewFile();
        } catch (IOException e) {
          e.printStackTrace();
        }
        reuslt = Boolean.TRUE;

      }
    return reuslt;
  }

}
