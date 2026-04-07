package WalkingRobotSimII;

class Robot {
    private int width = 0;
    private int height = 0;
    private int maxWidth;
    private int maxHeight;
    private int totalLength;
    private int currDir = 0;
    private String[] direction = {"East", "North", "West", "South"};


    public Robot(int width, int height) {
        maxWidth = width - 1;
        maxHeight = height - 1;
        totalLength = 2 * (maxWidth + maxHeight);
    }
    
    public void step(int num) {
        int numReduce = num % totalLength;

        if (num != numReduce) {
            if (height == 0) {
                if (width == 0) {
                    currDir = 3;
                }
            }
        }

        for (int i = 0; i < numReduce; i++) {

            if (currDir == 0) {
                if (width < maxWidth) {
                    moveEast();
                } else {
                    turnDir();
                    moveNorth();
                }
            } else if (currDir == 1) {
                if (height < maxHeight) {
                    moveNorth();
                } else {
                    turnDir();
                    moveWest();
                }
            } else if (currDir == 2) {
                if (width > 0) {
                    moveWest();
                } else {
                    turnDir();
                    moveSouth();
                }
                
            } else if (currDir == 3) {
                if (height > 0) {
                    moveSouth();
                } else {
                    turnDir();
                    moveEast();
                }
            }
        }
    }

    private void moveEast() {
        width++;
    }

    private void moveWest() {
        width--;
    }

    private void moveSouth() {
        height--;
    }

    private void moveNorth() {
        height++;
    }

    private void turnDir() {
        currDir++;
        if (currDir == 4) {
            currDir = 0;
        } 
    }
    
    public int[] getPos() {
        return new int[]{width, height};
    }
    
    public String getDir() {
        return direction[currDir];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */