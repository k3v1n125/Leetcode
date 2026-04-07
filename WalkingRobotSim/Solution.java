package WalkingRobotSim;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private int x = 0;
    private int y = 0;
    private int currDir = 0;
    private String[] direction = { "North", "East", "South", "West" };
    private int farthest = 0;
    Set<Long> obstacleSet = new HashSet<>();

    public int robotSim(int[] commands, int[][] obstacles) {
        for (int[] o : obstacles) {
            obstacleSet.add(encode(o[0], o[1]));
        }

        for (int command : commands) {
            if (command == -2) {
                turnLeft();
            } else if (command == -1) {
                turnRight();
            } else {
                move(command, obstacles);
            }
        }
        return farthest;
    }

    private void turnLeft() {
        currDir = (currDir - 1 + 4) % 4;
    }

    private void turnRight() {
        currDir = (currDir + 1) % 4;
    }

    private void move(int command, int[][] obstacles) {
        for (int i = 0; i < command; i++) {
            String currDirection = direction[currDir];
            int nextX = x;
            int nextY = y;
            if (currDirection.equals("North")) {
                nextY = y + 1;
            } else if (currDirection.equals("East")) {
                nextX = x + 1;
            } else if (currDirection.equals("South")) {
                nextY = y - 1;
            } else if (currDirection.equals("West")) {
                nextX = x - 1;
            }
            if (obstacleSet.contains(encode(nextX, nextY))) {
                break;
            }
            x = nextX;
            y = nextY;
        }
        int currDistance = x * x + y * y;
        if (currDistance > farthest) {
            farthest = currDistance;
        }
    }

    private long encode(int x, int y) {
        return (((long) x) << 32) ^ (y & 0xffffffffL);
    }
}