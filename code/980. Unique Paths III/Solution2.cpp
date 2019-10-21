#include <vector>
using std::vector;

class Solution {
public:
    void getGridInfo(vector<vector<int>>& grid) {
        emptyNum = 0;
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                switch (grid[i][j]) {
                    case 0:
                        emptyNum++;
                        break;
                    case 1:
                        startX = i;
                        startY = j;
                        break;
                    case 2:
                        endX = i;
                        endY = j;
                        break;
                }
            }
        }
    }

    int findPath(vector<vector<int>>& grid, int visited, int currentEmptyNum, int x, int y) {
        if (result[visited][x][y] >= 0) {
            return result[visited][x][y];
        }

        if (x == endX && y == endY) {
            if (currentEmptyNum - 1 == emptyNum) {
                return result[visited][x][y] = 1;
            } else {
                return 0;
            }
        }

        int direction[][2] = {0, -1, 0, 1, -1, 0, 1, 0};
        result[visited][x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            if (nextX >= 0 && nextX < height && nextY >= 0 && nextY < width &&
                (visited & (1<<(nextX * width + nextY))) == 0 && grid[nextX][nextY] != -1) {
                result[visited][x][y] += findPath(grid, visited | (1<<(nextX * width + nextY)), currentEmptyNum + 1, nextX, nextY);
            }
        }
        return result[visited][x][y];
    }

    int uniquePathsIII(vector<vector<int>>& grid) {
        // get size
        height = grid.size();
        width = grid[0].size();
        getGridInfo(grid);

        // DFS search
        result = vector<vector<vector<int>>>(1 << (height * width), vector<vector<int>>(
                height, vector<int>(width, -1)));
        return findPath(grid, 1<<(startX * width + startY), 0, startX, startY);
    }

private:
    int height, width;
    int startX, startY;
    int endX, endY;
    int emptyNum;
    vector<vector<bool>> visited;
    vector<vector<vector<int>>> result;
};
