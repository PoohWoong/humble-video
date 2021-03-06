/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.6
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.humble.video;
import io.humble.ferry.*;
/**
 * A class that defines meta-data about audio channels and layouts.
 */
public class AudioChannel extends RefCounted {
  // JNIHelper.swg: Start generated code
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>
  /**
   * This method is only here to use some references and remove
   * a Eclipse compiler warning.
   */
  @SuppressWarnings("unused")
  private void noop()
  {
    Buffer.make(null, 1);
  }
   
  private volatile long swigCPtr;

  /**
   * Internal Only.
   */
  protected AudioChannel(long cPtr, boolean cMemoryOwn) {
    super(VideoJNI.AudioChannel_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }
  
  /**
   * Internal Only.
   */
  protected AudioChannel(long cPtr, boolean cMemoryOwn,
      java.util.concurrent.atomic.AtomicLong ref)
  {
    super(VideoJNI.AudioChannel_SWIGUpcast(cPtr),
     cMemoryOwn, ref);
    swigCPtr = cPtr;
  }
    
  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that obj is proxying for.
   *   
   * @param obj The java proxy object for a native object.
   * @return The raw pointer obj is proxying for.
   */
  protected static long getCPtr(AudioChannel obj) {
    if (obj == null) return 0;
    return obj.getMyCPtr();
  }

  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that we're proxying for.
   *   
   * @return The raw pointer we're proxying for.
   */  
  protected long getMyCPtr() {
    if (swigCPtr == 0) throw new IllegalStateException("underlying native object already deleted");
    return swigCPtr;
  }
  
  /**
   * Create a new AudioChannel object that is actually referring to the
   * exact same underlying native object.
   *
   * @return the new Java object.
   */
  @Override
  public AudioChannel copyReference() {
    if (swigCPtr == 0)
      return null;
    else
      return new AudioChannel(swigCPtr, swigCMemOwn, getJavaRefCount());
  }

  /**
   * Compares two values, returning true if the underlying objects in native code are the same object.
   *
   * That means you can have two different Java objects, but when you do a comparison, you'll find out
   * they are the EXACT same object.
   *
   * @return True if the underlying native object is the same.  False otherwise.
   */
  public boolean equals(Object obj) {
    boolean equal = false;
    if (obj instanceof AudioChannel)
      equal = (((AudioChannel)obj).swigCPtr == this.swigCPtr);
    return equal;
  }
  
  /**
   * Get a hashable value for this object.
   *
   * @return the hashable value.
   */
  public int hashCode() {
     return (int)swigCPtr;
  }
  
  // <<<<<<<<<<<<<<<<<<<<<<<<<<<
  // JNIHelper.swg: End generated code
  
/**
 * Return a channel layout bitmask that matches name, or 0 if no match is found.<br>
 * <br>
 * name can be one or several of the following notations,<br>
 * separated by '+' or '|':<br>
 * - the name of an usual channel layout (mono, stereo, 4.0, quad, 5.0,<br>
 *   5.0(side), 5.1, 5.1(side), 7.1, 7.1(wide), downmix);<br>
 * - the name of a single channel (FL, FR, FC, LFE, BL, BR, FLC, FRC, BC,<br>
 *   SL, SR, TC, TFL, TFC, TFR, TBL, TBC, TBR, DL, DR);<br>
 * - a number of channels, in decimal, optionally followed by 'c', yielding<br>
 *   the default channel layout for that number of channels (@see   av_get_default_channel_layout);- a channel layout mask, in hexadecimal starting with "0x" (see the  Layout and Channel enums).<br>
 * <br>
 * Example: "stereo+FC" = "2+FC" = "2c+1c" = "0x7"
 */
  public static long getChannelBitmask(String name) {
    return VideoJNI.AudioChannel_getChannelBitmask(name);
  }

/**
 * Return a description of a channel bitmask.<br>
 * If numChannels is &lt;= 0, it is guessed from the layout.<br>
 * Note to C/C++ callers. You must call free() on the returned value.
 */
  public static String getChannelLayoutString(int numChannels, long layout) {
    return VideoJNI.AudioChannel_getChannelLayoutString(numChannels, layout);
  }

/**
 * Return the number of channels in the channel layout.
 */
  public static int getNumChannelsInLayout(AudioChannel.Layout layout) {
    return VideoJNI.AudioChannel_getNumChannelsInLayout(layout.swigValue());
  }

/**
 * Return default channel layout for a given number of channels.
 */
  public static AudioChannel.Layout getDefaultLayout(int numChannels) {
    return AudioChannel.Layout.swigToEnum(VideoJNI.AudioChannel_getDefaultLayout(numChannels));
  }

/**
 * Get the index of a channel in channel_layout.<br>
 * <br>
 * <p><br>
 * Use this method to find out which index into channel data corresponds<br>
 * to the channel you care about. The way you use this differs depending<br>
 * on whether your audio is packed or planar.  To illustrate, let's assume<br>
 * you have CH_LAYOUT_STEREO audio, and you ask for the index of CH_FRONT_LEFT,<br>
 * and we return 1 (indexes are zero based).<br>
 * </p><p><br>
 * If packed, then audio is laid out in one big buffer as "RLRLRLRLRLRLRLRL" audio,<br>
 * and every 2nd (1+1) sample is the left channel<br>
 * </p><p><br>
 * If planar, then audio is out in two buffer as "RRRRRRRR" and "LLLLLLLL", and the<br>
 * second plan (1+1) is the left channel.<br>
 * </p><br>
 * <br>
 * @param channel a channel layout describing exactly one channel which must be<br>
 *                present in channel_layout.<br>
 * <br>
 * @return index of channel in channel_layout on success, a negative AVERROR<br>
 *         on error.
 */
  public static int getIndexOfChannelInLayout(AudioChannel.Layout layout, AudioChannel.Type channel) {
    return VideoJNI.AudioChannel_getIndexOfChannelInLayout(layout.swigValue(), channel.swigValue());
  }

/**
 * Get the channel with the given index in channel_layout.
 */
  public static AudioChannel.Type getChannelFromLayoutAtIndex(AudioChannel.Layout layout, int index) {
    return AudioChannel.Type.swigToEnum(VideoJNI.AudioChannel_getChannelFromLayoutAtIndex(layout.swigValue(), index));
  }

/**
 * Get the name of a given channel.<br>
 * <br>
 * @return channel name on success, NULL on error.
 */
  public static String getChannelName(AudioChannel.Type channel) {
    return VideoJNI.AudioChannel_getChannelName(channel.swigValue());
  }

/**
 * Get the description of a given channel.<br>
 * <br>
 * @param channel  a channel layout with a single channel<br>
 * @return channel description on success, NULL on error
 */
  public static String getChannelDescription(AudioChannel.Type channel) {
    return VideoJNI.AudioChannel_getChannelDescription(channel.swigValue());
  }

/**
 * Get the value and name of a standard channel layout.<br>
 * <br>
 * index   index in an internal list, starting at 0<br>
 * layout  channel layout mask<br>
 * name    name of the layout<br>
 * @return 0  if the layout exists,<br>
 *          &lt;0 if index is beyond the limits
 */
  public static String getLayoutName(AudioChannel.Layout layout) {
    return VideoJNI.AudioChannel_getLayoutName(layout.swigValue());
  }

  /**
   * Flags for each type of audio channel that can be in multi-channel audio.
   */
  public enum Type {
    CH_UNKNOWN(VideoJNI.AudioChannel_CH_UNKNOWN_get()),
    CH_FRONT_LEFT(VideoJNI.AudioChannel_CH_FRONT_LEFT_get()),
    CH_FRONT_RIGHT(VideoJNI.AudioChannel_CH_FRONT_RIGHT_get()),
    CH_FRONT_CENTER(VideoJNI.AudioChannel_CH_FRONT_CENTER_get()),
    CH_LOW_FREQUENCY(VideoJNI.AudioChannel_CH_LOW_FREQUENCY_get()),
    CH_BACK_LEFT(VideoJNI.AudioChannel_CH_BACK_LEFT_get()),
    CH_BACK_RIGHT(VideoJNI.AudioChannel_CH_BACK_RIGHT_get()),
    CH_FRONT_LEFT_OF_CENTER(VideoJNI.AudioChannel_CH_FRONT_LEFT_OF_CENTER_get()),
    CH_FRONT_RIGHT_OF_CENTER(VideoJNI.AudioChannel_CH_FRONT_RIGHT_OF_CENTER_get()),
    CH_BACK_CENTER(VideoJNI.AudioChannel_CH_BACK_CENTER_get()),
    CH_SIDE_LEFT(VideoJNI.AudioChannel_CH_SIDE_LEFT_get()),
    CH_SIDE_RIGHT(VideoJNI.AudioChannel_CH_SIDE_RIGHT_get()),
    CH_TOP_CENTER(VideoJNI.AudioChannel_CH_TOP_CENTER_get()),
    CH_TOP_FRONT_LEFT(VideoJNI.AudioChannel_CH_TOP_FRONT_LEFT_get()),
    CH_TOP_FRONT_CENTER(VideoJNI.AudioChannel_CH_TOP_FRONT_CENTER_get()),
    CH_TOP_FRONT_RIGHT(VideoJNI.AudioChannel_CH_TOP_FRONT_RIGHT_get()),
    CH_TOP_BACK_LEFT(VideoJNI.AudioChannel_CH_TOP_BACK_LEFT_get()),
    CH_TOP_BACK_CENTER(VideoJNI.AudioChannel_CH_TOP_BACK_CENTER_get()),
    CH_TOP_BACK_RIGHT(VideoJNI.AudioChannel_CH_TOP_BACK_RIGHT_get()),
    CH_STEREO_LEFT(VideoJNI.AudioChannel_CH_STEREO_LEFT_get()),
    CH_STEREO_RIGHT(VideoJNI.AudioChannel_CH_STEREO_RIGHT_get()),
    CH_WIDE_LEFT(VideoJNI.AudioChannel_CH_WIDE_LEFT_get()),
    CH_WIDE_RIGHT(VideoJNI.AudioChannel_CH_WIDE_RIGHT_get()),
    CH_SURROUND_DIRECT_LEFT(VideoJNI.AudioChannel_CH_SURROUND_DIRECT_LEFT_get()),
    CH_SURROUND_DIRECT_RIGHT(VideoJNI.AudioChannel_CH_SURROUND_DIRECT_RIGHT_get()),
    CH_LOW_FREQUENCY_2(VideoJNI.AudioChannel_CH_LOW_FREQUENCY_2_get()),
  ;

    public final int swigValue() {
      return swigValue;
    }

    public static Type swigToEnum(int swigValue) {
      Type[] swigValues = Type.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (Type swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + Type.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private Type() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private Type(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private Type(Type swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

  /**
   * Different layouts of audio channels. The<br>
   * value of these flags are ultimately a<br>
   * bitmask of different {#Type} flags.
   */
  public enum Layout {
    CH_LAYOUT_UNKNOWN(VideoJNI.AudioChannel_CH_LAYOUT_UNKNOWN_get()),
    CH_LAYOUT_NATIVE(VideoJNI.AudioChannel_CH_LAYOUT_NATIVE_get()),
    CH_LAYOUT_MONO(VideoJNI.AudioChannel_CH_LAYOUT_MONO_get()),
    CH_LAYOUT_STEREO(VideoJNI.AudioChannel_CH_LAYOUT_STEREO_get()),
    CH_LAYOUT_2POINT1(VideoJNI.AudioChannel_CH_LAYOUT_2POINT1_get()),
    CH_LAYOUT_2_1(VideoJNI.AudioChannel_CH_LAYOUT_2_1_get()),
    CH_LAYOUT_SURROUND(VideoJNI.AudioChannel_CH_LAYOUT_SURROUND_get()),
    CH_LAYOUT_3POINT1(VideoJNI.AudioChannel_CH_LAYOUT_3POINT1_get()),
    CH_LAYOUT_4POINT0(VideoJNI.AudioChannel_CH_LAYOUT_4POINT0_get()),
    CH_LAYOUT_4POINT1(VideoJNI.AudioChannel_CH_LAYOUT_4POINT1_get()),
    CH_LAYOUT_2_2(VideoJNI.AudioChannel_CH_LAYOUT_2_2_get()),
    CH_LAYOUT_QUAD(VideoJNI.AudioChannel_CH_LAYOUT_QUAD_get()),
    CH_LAYOUT_5POINT0(VideoJNI.AudioChannel_CH_LAYOUT_5POINT0_get()),
    CH_LAYOUT_5POINT1(VideoJNI.AudioChannel_CH_LAYOUT_5POINT1_get()),
    CH_LAYOUT_5POINT0_BACK(VideoJNI.AudioChannel_CH_LAYOUT_5POINT0_BACK_get()),
    CH_LAYOUT_5POINT1_BACK(VideoJNI.AudioChannel_CH_LAYOUT_5POINT1_BACK_get()),
    CH_LAYOUT_6POINT0(VideoJNI.AudioChannel_CH_LAYOUT_6POINT0_get()),
    CH_LAYOUT_6POINT0_FRONT(VideoJNI.AudioChannel_CH_LAYOUT_6POINT0_FRONT_get()),
    CH_LAYOUT_HEXAGONAL(VideoJNI.AudioChannel_CH_LAYOUT_HEXAGONAL_get()),
    CH_LAYOUT_6POINT1(VideoJNI.AudioChannel_CH_LAYOUT_6POINT1_get()),
    CH_LAYOUT_6POINT1_BACK(VideoJNI.AudioChannel_CH_LAYOUT_6POINT1_BACK_get()),
    CH_LAYOUT_6POINT1_FRONT(VideoJNI.AudioChannel_CH_LAYOUT_6POINT1_FRONT_get()),
    CH_LAYOUT_7POINT0(VideoJNI.AudioChannel_CH_LAYOUT_7POINT0_get()),
    CH_LAYOUT_7POINT0_FRONT(VideoJNI.AudioChannel_CH_LAYOUT_7POINT0_FRONT_get()),
    CH_LAYOUT_7POINT1(VideoJNI.AudioChannel_CH_LAYOUT_7POINT1_get()),
    CH_LAYOUT_7POINT1_WIDE(VideoJNI.AudioChannel_CH_LAYOUT_7POINT1_WIDE_get()),
    CH_LAYOUT_7POINT1_WIDE_BACK(VideoJNI.AudioChannel_CH_LAYOUT_7POINT1_WIDE_BACK_get()),
    CH_LAYOUT_OCTAGONAL(VideoJNI.AudioChannel_CH_LAYOUT_OCTAGONAL_get()),
    CH_LAYOUT_STEREO_DOWNMIX(VideoJNI.AudioChannel_CH_LAYOUT_STEREO_DOWNMIX_get()),
  ;

    public final int swigValue() {
      return swigValue;
    }

    public static Layout swigToEnum(int swigValue) {
      Layout[] swigValues = Layout.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (Layout swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + Layout.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private Layout() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private Layout(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private Layout(Layout swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

}
