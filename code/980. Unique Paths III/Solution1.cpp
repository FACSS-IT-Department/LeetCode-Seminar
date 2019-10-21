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

    void findPath(vector<vector<int>>& grid, int currentEmptyNum, int x, int y) {
        if (x == endX && y == endY) {
            if (currentEmptyNum - 1 == emptyNum) {
                result++;
            }
            return;
        }
        int direction[][2] = {0, -1, 0, 1, -1, 0, 1, 0};
        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            if (nextX >= 0 && nextX < height && nextY >= 0 && nextY < width &&
                !visited[nextX][nextY] && grid[nextX][nextY] != -1) {
                visited[nextX][nextY] = true;
                findPath(grid, currentEmptyNum + 1, nextX, nextY);
                visited[nextX][nextY] = false;
            }
        }
    }

    int uniquePathsIII(vector<vector<int>>& grid) {
        // get size
        height = grid.size();
        width = grid[0].size();
        getGridInfo(grid);

        // DFS search
        result = 0;
        visited = vector<vector<bool>>(height, vector<bool>(width, false));
        visited[startX][startY] = true;
        findPath(grid, 0, startX, startY);

        return result;
    }

private:
    int height, width;
    int startX, startY;
    int endX, endY;
    int emptyNum;
    int result;
    vector<vector<bool>> visited;
};
