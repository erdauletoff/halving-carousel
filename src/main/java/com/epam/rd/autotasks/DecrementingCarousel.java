package com.epam.rd.autotasks;

import java.util.ArrayList;

public class DecrementingCarousel {
    private final ArrayList<Integer> nums;
    private int arrayAddElementCounter = 0;
    private final int arrayMaxLength;
    private boolean carouselIsRunning = false;
    private boolean carouselIsLocked = false;

    public DecrementingCarousel(int capacity) {
        this.nums = new ArrayList<Integer>(capacity);
        this.arrayMaxLength = capacity;

    }

    public boolean addElement(int element){
        boolean elementAdded = false;
        if (!this.carouselIsLocked) {
            if(this.arrayAddElementCounter < this.arrayMaxLength){
                if(element>0) {
                    this.nums.add(element);
                    elementAdded = true;
                    this.arrayAddElementCounter++;
                }
            }
        }
        return elementAdded;
    }

    public CarouselRun run(){
        this.carouselIsLocked = true;
        if (!this.carouselIsRunning) {
            this.carouselIsRunning = true;
            return new CarouselRun(this, nums);
        }
        else {
            return null;
        }
    }
}
