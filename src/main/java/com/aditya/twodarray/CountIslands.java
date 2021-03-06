package com.aditya.twodarray;

public class CountIslands
{
    public int countNumberOfIslands(int[][] input)
    {
        // Initialize
        if (input.length == 0)
        {
            return 0;
        }
        int columns = input[0].length;
        int rows = input.length;
        int visited[][] = new int [rows][columns];
        int islands = 0;

        // Edge Case
        if (rows == 1 && columns == 1)
        {
            if (input[0][0] == 1)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (input[i][j] == 1 && visited[i][j] != 1)
                {
                    visited[i][j] = 1;
                    checkIfHaveAdjacentOne(input, i, j, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void checkIfHaveAdjacentOne(int[][] input, int row, int column, int[][] visited)
    {
        // North-East
        if (checkIfValid(input,row - 1, column - 1, visited))
        {
            visited[row-1][column - 1] = 1;
            checkIfHaveAdjacentOne(input, row - 1, column - 1, visited);
        }
        // North
        if (checkIfValid(input,row - 1, column, visited))
        {
            visited[row - 1][column] = 1;
            checkIfHaveAdjacentOne(input, row - 1, column, visited);
        }
        // North-West
        if (checkIfValid(input,row - 1, column + 1, visited))
        {
            visited[row - 1][column + 1] = 1;
            checkIfHaveAdjacentOne(input, row - 1, column + 1, visited);
        }
        // East
        if (checkIfValid(input, row, column - 1, visited))
        {
            visited[row][column - 1] = 1;
            checkIfHaveAdjacentOne(input, row, column - 1, visited);
        }
        // West
        if (checkIfValid(input, row, column + 1, visited))
        {
            visited[row][column+1] = 1;
            checkIfHaveAdjacentOne(input, row, column + 1, visited);
        }
        // South-East
        if (checkIfValid(input,row + 1, column - 1, visited))
        {
            visited[row + 1][column - 1] = 1;
            checkIfHaveAdjacentOne(input, row + 1, column - 1, visited);
        }
        // South
        if (checkIfValid(input,row + 1, column, visited))
        {
            visited[row + 1][column] = 1;
            checkIfHaveAdjacentOne(input, row + 1, column, visited);
        }
        // South-West
        if (checkIfValid(input,row + 1, column + 1, visited))
        {
            visited[row + 1][column + 1] = 1;
            checkIfHaveAdjacentOne(input, row + 1, column + 1, visited);
        }
    }

    private boolean checkIfValid(int[][] input, int row, int column, int[][] visited)
    {
        if (row >= 0 && column >= 0 && row < input.length && column < input[0].length && input[row][column] == 1 && visited[row][column] != 1)
        {
            return true;
        }
        return false;
    }
}