package com.moda;

import com.moda.decorator.Cup;
import com.moda.decorator.KeepWarmDecorator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        KeepWarmDecorator keepWarmDecorator = new KeepWarmDecorator(new Cup());
        keepWarmDecorator.fillWater();

    }
}
