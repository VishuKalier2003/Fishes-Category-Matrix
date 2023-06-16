/* You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:
1)- A land cell if grid[r][c] = 0, or
2)- A water cell containing grid[r][c] fish if grid[r][c] > 0.
A fisher can start at any water cell (r, c) and can do the following operations any number of times:
1)- Catch all the fish at cell (r, c), or
2)- Move to any adjacent water cell.
Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water 
cell exists. An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or 
(r - 1, c) if it exists.
* Eg 1 :  grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]     Output = 7 
* Eg 2 :  grid = [[1,0,0,0],[1,0,0,0],[1,0,0,0],[0,0,1,1]]     Output = 3 
*/
import java.util.*;
public class Fishes
{
      public static int sum = 0;     // Static variable declared for storing Sum of fishes of every pool...
      public int MaximumFishesToCatch(int grid[][])
      {
            int Sum = Integer.MIN_VALUE;      //* Variable for storing the Maximum Fishes -> O(1)
            for(int i = 0; i < grid.length; i++)        //! Grid Traversal -> O(N x M)
            {
                  for(int j = 0; j < grid[i].length; j++)
                  {
                        if((grid[i][j] != 0))    // If the cell is unvisited water cell...
                        {
                              Sum = Math.max(FishesInThePool(grid, i, j), Sum);   //! Function Call -> O(k)
                              sum = 0;     // Setting static variable to again zero...
                              grid[i][j] = 0;     // Drying up the cell (converting it to land)...
                        }
                  }
            }
            return Sum;
      }
      public int FishesInThePool(int grid[][], int row, int col)
      {
            if((row < 0) || (col < 0) || (row == grid.length) || (col == grid[0].length) || (grid[row][col] == 0))    // Base exit conditions...
                  return sum;
            sum = sum + grid[row][col];     // Adding the fishes sum...
            grid[row][col] = 0;       // Setting the current water cell as visited...
            FishesInThePool(grid, row + 1, col);        // Recursive Down...
            FishesInThePool(grid, row - 1, col);        // Recursive Up...
            FishesInThePool(grid, row, col + 1);        // Recursive Right...
            FishesInThePool(grid, row, col - 1);        // Recursive Left...
            return sum;
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int row, col;
            System.out.print("Enter number of Rows : ");
            row = sc.nextInt();
            System.out.print("Enter number of Columns : ");
            col = sc.nextInt();
            int grid[][] = new int[row][col];
            for(int i = 0; i < grid.length; i++)
            {
                  for(int j = 0; j < grid[0].length; j++)
                  {
                        System.out.print("Enter value of "+(i+1)+" row and "+(j+1)+" column : ");
                        grid[i][j] = sc.nextInt();
                  }
            }
            Fishes fishes = new Fishes();           // Object creation...
            System.out.println("The Maximum Fishes Catched : "+fishes.MaximumFishesToCatch(grid));  // Function calling...
            sc.close();
      }
}



//! Time Complexity -> O(N x M)
//* Space Complexity -> O(1)