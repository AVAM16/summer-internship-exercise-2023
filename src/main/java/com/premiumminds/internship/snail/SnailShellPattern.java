package com.premiumminds.internship.snail;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {
    CompletableFuture<int[]> future = new CompletableFuture<>();
    int n = matrix.length;
    int[] result = new int[n*n];
    int index = 0;
    boolean[][] checked = new boolean[n][n];
    int[][] directions = {{0, 1}, {1, 0}, {0,-1}, {-1, 0}};
    int x = 0, y = 0, direction = 0;
    for (int c = 0; c < n * n; c++) {
      result[index] = matrix[x][y];
      index++;
      checked[x][y] = true;
      int nextposx = x + directions[direction][0];
      int nextposy = y + directions[direction][1];
      if (nextposx >= 0 && nextposx < n && nextposy >= 0 && nextposy < n && !checked[nextposx][nextposy]) {
        x = nextposx;
        y = nextposy;
      } else {
        direction++;
        if (direction == 4){
          direction = 0;
        }
        x += directions[direction][0];
        y += directions[direction][1];
      }
    }
    future.complete(result);
    return future;
  };
}
