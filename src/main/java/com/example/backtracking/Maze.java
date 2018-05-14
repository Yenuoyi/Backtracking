package com.example.backtracking;

import java.util.Iterator;
import java.util.Stack;

public class Maze {
    public Stack<String> getPath(int[][] maze,int x, int y){
        Stack<String> stack = new Stack<String>();
        stack.push("-1,-1");
        String backPath;
        int tempX ,tempY;
        int curX=0,curY=0;
        while(curX<x&&curY<y){
            if(curX==x-1&&curY==y-1){
                stack.push(curX+","+curY);
                break;
            }
            if(stack.empty()){
                System.out.println("没有解！");
                break;
            }
            backPath = stack.peek();
            tempX = curX;
            tempY = curY;
            tempX = curX+1;
            if(tempX<x&&maze[tempX][tempY]==0&&!backPath.equals(tempX+","+tempY)&&!stack.contains(tempX+","+tempY)){
                stack.push(curX+","+curY);
                curX = tempX;
                continue;
            }

            tempX = curX;
            tempY = curY;
            tempX = curX-1;
            if(tempX>=0&&maze[tempX][tempY]==0&&!backPath.equals(tempX+","+tempY)&&!stack.contains(tempX+","+tempY)){
                stack.push(curX+","+curY);
                curX = tempX;
                continue;
            }

            tempX = curX;
            tempY = curY;
            tempY = curY+1;
            if(tempY<y&&maze[tempX][tempY]==0&&!backPath.equals(tempX+","+tempY)&&!stack.contains(tempX+","+tempY)){
                stack.push(curX+","+curY);
                curY = tempY;
                continue;
            }

            tempX = curX;
            tempY = curY;
            tempY = curY-1;
            if(tempY>=0&&maze[tempX][tempY]==0&&!backPath.equals(tempX+","+tempY)&&!stack.contains(tempX+","+tempY)){
                stack.push(curX+","+curY);
                curY = tempY;
                continue;
            }
            maze[curX][curY] = 1;
            String[] backPathArray = stack.pop().split(",");
            curX = Integer.parseInt(backPathArray[0]);
            curY = Integer.parseInt(backPathArray[1]);
        }
        return stack;
    }
    public static void main(String[] args){
        int[][] maze= {{0,1,1,0,0},{0,0,0,0,0},{1,0,1,1,0},{0,0,0,0,0},{0,0,1,1,0}};
        int[][] maze1 = {
                {0,0,1,0,0,0,1,0},
                {0,0,1,0,0,0,1,0},
                {0,0,1,0,1,1,0,1},
                {0,1,1,1,0,0,1,0},
                {0,0,0,1,0,0,0,0},
                {0,1,0,0,0,1,0,1},
                {0,1,1,1,1,0,0,1},
                {1,1,0,0,0,1,0,1},
                {1,1,0,0,0,0,0,0}
        };
        Maze backtracking = new Maze();
        Stack<String> stack;
        stack = backtracking.getPath(maze1,9,8);
        Iterator<String> iterator = stack.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"  ");
        }
    }
}
