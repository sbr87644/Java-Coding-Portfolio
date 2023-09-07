/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class GuitarString {

    public RingBuffer ringBuffer;
    private int time;

    public GuitarString(double frequency) { // use a sampling rate of 44,100
        time = 0;
        int size = (int)(44100/frequency);
        ringBuffer = new RingBuffer(size);
        for(int i = 0; i < size; i++){
            ringBuffer.enqueue(0);
        }
    }

    public GuitarString(double[] init) {
        time = 0;
        ringBuffer = new RingBuffer(init.length);
        for (double d : init) {
            ringBuffer.enqueue(d);
        }
    }

    public void pluck() {            // set the buffer to white noise
        for(int i = 0; i < ringBuffer.size(); i++){
             ringBuffer.dequeue();
             ringBuffer.enqueue(Math.random() - 0.5);
        }
    }

    public void tic() {                  // advance the simulation one time step
        time++;
        double f = ringBuffer.dequeue();
        double s = ringBuffer.peek();
        ringBuffer.enqueue((f + s) / 2.0 * 0.994);
    }

    public double sample() {               // return the current sample
        return ringBuffer.peek();
    }

    public int time() {                    // return number of tics
        return time;
    }
}
