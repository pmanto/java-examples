package com.antonella.javaexample.util;

import lombok.NonNull;

public final class VersionUtil {
  /*
   * Returns 1 if v1 is bigger v2
   * 0 if v1 is equals to v2
   * -1 if v1 is smaller than v2
   */
  public static int compareVersions(
    @NonNull final String version1, 
    @NonNull final String version2
  ) {
    if(version1.equals(version2)){
      return 0;
    }

    final String[] version1Array = version1.split("\\.");
    final String[] version2Array = version2.split("\\.");
    for(int i = 0; i < version1Array.length; i++){
      if(version2Array.length == i || 
          Integer.parseInt(version1Array[i]) > Integer.parseInt(version2Array[i])){
        return 1;
      }

      if(Integer.parseInt(version1Array[i]) < Integer.parseInt(version2Array[i])){
        return -1;
      }
    }

    return -1;
  }
}