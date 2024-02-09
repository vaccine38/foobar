# https://github.com/hirenvasani/foobar/blob/master/prepare_the_bunnies_escape.py
def solution(map):
    w = len(map[0])
    h = len(map)
    tb = sht_pth(0, 0, map)
    bt = sht_pth(h - 1, w - 1, map)

    ans = 2 ** 32 - 1
    for i in range(h):
        for j in range(w):
            if tb[i][j] and bt[i][j]:
                ans = min(tb[i][j] + bt[i][j] - 1, ans)
    return ans


def sht_pth(sx, sy, maze):
    w = len(maze[0])
    h = len(maze)
    board = [[None for _ in range(w)] for _ in range(h)]
    board[sx][sy] = 1

    arr = [(sx, sy)]
    while arr:
        x, y = arr.pop(0)
        for i in [[1, 0], [-1, 0], [0, -1], [0, 1]]:
            nx, ny = x + i[0], y + i[1]
            if 0 <= nx < h and 0 <= ny < w and board[nx][ny] is None:
                board[nx][ny] = board[x][y] + 1
                if maze[nx][ny] == 1:
                    continue
                arr.append((nx, ny))

    return board


maze = [[0, 0, 0, 0, 0, 0],[1, 1, 1, 1, 1, 0],[1, 1, 1, 1, 1, 1],[0, 0, 0, 0, 0, 0],[0, 1, 1, 1, 1, 1],[0, 0, 0, 0, 0, 0]] #Answer 21
print(solution(maze))
maze = [[0, 1, 1, 0], [0, 0, 0, 1], [1, 1, 0, 0], [1, 1, 1, 0]] #Answer 7
print(solution(maze))
maze = [[0,1,0,0,0],[0,0,0,1,0],[1,1,1,1,0]] #Answer 7
print(solution(maze))
maze = [[0,1,1,1],[0,1,0,0],[1,0,1,0],[1,1,0,0]] #Answer 7
print(solution(maze))
maze = [[0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 0], [0, 1, 1, 1, 1, 1], [0, 1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0, 0]]  # Answer 11
print(solution(maze))

