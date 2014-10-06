/*
 *  Copyright 2011 Yuri Kanivets
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package kankan.wheel.widget.adapters;

import kankan.wheel.widget.WheelView;
import android.content.Context;

/**
 * Numeric Wheel adapter.
 */
public class NumericWheelAdapter extends AbstractWheelHighlightTextAdapter {
    
    /** The default min value */
    public static final int DEFAULT_MAX_VALUE = 9;

    /** The default max value */
    private static final int DEFAULT_MIN_VALUE = 0;
    
    // Values
    private int minValue;
    private int maxValue;
    static int selectedTextColor=0x99FFFF;
    static int itemTextColor=0x99FFFF;
    // format
    private String format;
    
    //interval
    private int interval = 0;
    
    /**
     * Constructor
     * @param context the current context
     */
    public NumericWheelAdapter(Context context) {
        this(context, null,selectedTextColor,itemTextColor, DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);
    }

    /**
     * Constructor
     * @param context the current context
     * @param minValue the wheel min value
     * @param maxValue the wheel max value
     */
    public NumericWheelAdapter(Context context, WheelView wheelView,int selectedTextColor,int itemTextColor, int minValue, int maxValue) {
        this(context, wheelView,selectedTextColor,itemTextColor, minValue, maxValue, null);
    }
    
    /*public NumericWheelAdapter(Context context, int minValue, int maxValue) {
        this(context, minValue, maxValue, null);
    }*/

    /**
     * Constructor
     * @param context the current context
     * @param minValue the wheel min value
     * @param maxValue the wheel max value
     * @param format the format string
     */
    public NumericWheelAdapter(Context context, WheelView wheelView,int selectedTextColor,int itemTextColor,int minValue, int maxValue, String format) {
        super(context, wheelView,selectedTextColor,itemTextColor);
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.format = format;
    }
    
    /**
     * Constructor
     * @param context the current context
     * @param minValue the wheel min value
     * @param noOfItems the no. of items in wheel
     * @param inerval the interval between two values
     */
    public NumericWheelAdapter(Context context, WheelView wheelView,int selectedTextColor,int itemTextColor, int minValue, int noOfItems, int interval) {
        super(context, wheelView,selectedTextColor,itemTextColor);
        this.minValue = minValue;
        this.maxValue = noOfItems;
        this.interval = interval;
    }

    @Override
    public CharSequence getItemText(int index) {
        if (index >= 0 && index < getItemsCount()) {
            int value = (minValue + index) ;
            if(interval > 0) value = (value*interval);
            return format != null ? String.format(format, value) : Integer.toString(value);
        }
        return null;
    }

    @Override
    public int getItemsCount() {
        return maxValue - minValue + 1;
    }
    
    public int getInterval() {
        return interval>0?interval:1;
    }
}
