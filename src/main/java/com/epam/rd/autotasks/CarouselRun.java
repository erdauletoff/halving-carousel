package com.epam.rd.autotasks;

import java.util.ArrayList;

public class CarouselRun {
    private final DecrementingCarousel carousel;
    private final ArrayList<Integer> carouselNumbers;
    private int arrayIterator = 0;

    public CarouselRun(DecrementingCarousel carousel, ArrayList<Integer> numbers) {
        this.carousel = carousel;
        this.carouselNumbers = numbers;
    }

    public int next() {
        boolean zeroRemoved = false;
        int value;
        if (!this.isFinished()) {
            int curNum = this.carouselNumbers.get(arrayIterator);

            if (curNum == 1) {
                carouselNumbers.remove(arrayIterator);
                zeroRemoved = true;
            } else {
                carouselNumbers.set(arrayIterator, operation(curNum));
            }

            value = curNum;
            int decrementValue = zeroRemoved ? arrayIterator : arrayIterator + 1;
            if (carouselNumbers.size() == decrementValue) {
                this.arrayIterator = 0;
            } else if (!zeroRemoved) {
                this.arrayIterator++;
            }
        } else {
            value = -1;
        }
        return value;
    }

    private int operation(int curNum) {
        if (carousel instanceof HalvingCarousel) {
            return curNum / 2;
        } else {
            return curNum - 1;
        }
    }

    public boolean isFinished() {
        return this.carouselNumbers.isEmpty();
    }
}
