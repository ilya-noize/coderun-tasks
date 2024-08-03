package ru.yandex.coderun.solutions.stepik;

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

public class Robot {
    public static void main(String[] args) {
        T600 robot = new T600(1, 0, Direction.RIGHT);

        moveRobot(robot, 4, 4);
    }

    public static void moveRobot(T600 robot, int toX, int toY) {
        while (true) {
            int x = robot.getX();
            int y = robot.getY();
            if (x == toX && y == toY) break;
            //Влево или вправо
            if (x > toX) {
                //Двигаться влево
                turnAndMove(robot, Direction.LEFT);
            } else if (x < toX) {
                //Двигаться вправо
                while (robot.getDirection() != Direction.RIGHT) {
                    robot.turnRight();
                }
                robot.stepForward();
            }
            //Вверх или вниз
            if (y < toY) {
                //Двигаться вверх
                turnAndMove(robot, Direction.UP);
            } else {
                //Двигаться вниз
                turnAndMove(robot, Direction.DOWN);
            }
        }
    }

    private static void turnAndMove(T600 robot, Direction left) {
        while (robot.getDirection() != left) {
            robot.turnLeft();
        }
        robot.stepForward();
    }
}

class T800 extends T600 {
    public T800(int x, int y, Direction direction) {
        super(x, y, direction);
    }

    @Override
    public int getX() {
        return super.getX();
    }
}


class T600 {
    private int x;
    private int y;
    private Direction direction;

    public T600(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        switch (this.direction) {
            case UP -> this.direction = Direction.LEFT;
            case DOWN -> this.direction = Direction.RIGHT;
            case LEFT -> this.direction = Direction.DOWN;
            case RIGHT -> this.direction = Direction.UP;
        }
    }

    public void turnRight() {
        switch (this.direction) {
            case UP -> this.direction = Direction.RIGHT;
            case DOWN -> this.direction = Direction.LEFT;
            case LEFT -> this.direction = Direction.UP;
            case RIGHT -> this.direction = Direction.DOWN;
        }
    }

    public void stepForward() {
        switch (this.direction) {
            case DOWN -> this.y--;
            case UP -> this.y++;
            case LEFT -> this.x--;
            case RIGHT -> this.x++;
        }
    }
}