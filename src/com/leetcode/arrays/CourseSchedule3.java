package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/problems/course-schedule-iii/
public class CourseSchedule3 {
    public static void main(String[] args) {
        System.out.println(scheduleCourse(new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200}}));
    }
    public static int scheduleCourse(int[][] courses) {
        ArrayList<Course> clist = new ArrayList<>();
        for (int[] cours : courses) {
            clist.add(new Course(cours[0], cours[1]));
        }
        Collections.sort(clist);
        int maxDay = clist.get(courses.length - 1).lastDay;
        PriorityQueue<Course> pq = new PriorityQueue<>();
        for(Course c : clist)
            pq.add(c);
        int count = 0;
        int day = 1;
        while (pq.size() > 0) {
            Course c = pq.poll();
            day += c.duration;
            if (day < maxDay) {


                count++;
            }
        }
        return count ;

    }

    static class Course implements Comparable<Course> {
        int duration;
        int lastDay;
        Course(int duration,int lastDay) {
            this.duration = duration;
            this.lastDay = lastDay;
        }
        @Override
        public int compareTo(Course o) {
            return this.lastDay - o.lastDay;
        }
    }
}
