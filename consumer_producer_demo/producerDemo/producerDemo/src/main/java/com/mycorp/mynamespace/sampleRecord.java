/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.mycorp.mynamespace;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
/** Sample schema to help you get started. */
@org.apache.avro.specific.AvroGenerated
public class sampleRecord extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6828887732415556857L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"sampleRecord\",\"namespace\":\"com.mycorp.mynamespace\",\"doc\":\"Sample schema to help you get started.\",\"fields\":[{\"name\":\"orderId\",\"type\":\"int\",\"doc\":\"The id of the order.\"},{\"name\":\"orderTime\",\"type\":\"int\",\"doc\":\"Timestamp of the order.\"},{\"name\":\"orderAddress\",\"type\":\"string\",\"doc\":\"The address of the order.\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<sampleRecord> ENCODER =
      new BinaryMessageEncoder<sampleRecord>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<sampleRecord> DECODER =
      new BinaryMessageDecoder<sampleRecord>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<sampleRecord> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<sampleRecord> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<sampleRecord>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this sampleRecord to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a sampleRecord from a ByteBuffer. */
  public static sampleRecord fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** The id of the order. */
  @Deprecated public int orderId;
  /** Timestamp of the order. */
  @Deprecated public int orderTime;
  /** The address of the order. */
  @Deprecated public java.lang.CharSequence orderAddress;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public sampleRecord() {}

  /**
   * All-args constructor.
   * @param orderId The id of the order.
   * @param orderTime Timestamp of the order.
   * @param orderAddress The address of the order.
   */
  public sampleRecord(java.lang.Integer orderId, java.lang.Integer orderTime, java.lang.CharSequence orderAddress) {
    this.orderId = orderId;
    this.orderTime = orderTime;
    this.orderAddress = orderAddress;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return orderId;
    case 1: return orderTime;
    case 2: return orderAddress;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: orderId = (java.lang.Integer)value$; break;
    case 1: orderTime = (java.lang.Integer)value$; break;
    case 2: orderAddress = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'orderId' field.
   * @return The id of the order.
   */
  public java.lang.Integer getOrderId() {
    return orderId;
  }

  /**
   * Sets the value of the 'orderId' field.
   * The id of the order.
   * @param value the value to set.
   */
  public void setOrderId(java.lang.Integer value) {
    this.orderId = value;
  }

  /**
   * Gets the value of the 'orderTime' field.
   * @return Timestamp of the order.
   */
  public java.lang.Integer getOrderTime() {
    return orderTime;
  }

  /**
   * Sets the value of the 'orderTime' field.
   * Timestamp of the order.
   * @param value the value to set.
   */
  public void setOrderTime(java.lang.Integer value) {
    this.orderTime = value;
  }

  /**
   * Gets the value of the 'orderAddress' field.
   * @return The address of the order.
   */
  public java.lang.CharSequence getOrderAddress() {
    return orderAddress;
  }

  /**
   * Sets the value of the 'orderAddress' field.
   * The address of the order.
   * @param value the value to set.
   */
  public void setOrderAddress(java.lang.CharSequence value) {
    this.orderAddress = value;
  }

  /**
   * Creates a new sampleRecord RecordBuilder.
   * @return A new sampleRecord RecordBuilder
   */
  public static com.mycorp.mynamespace.sampleRecord.Builder newBuilder() {
    return new com.mycorp.mynamespace.sampleRecord.Builder();
  }

  /**
   * Creates a new sampleRecord RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new sampleRecord RecordBuilder
   */
  public static com.mycorp.mynamespace.sampleRecord.Builder newBuilder(com.mycorp.mynamespace.sampleRecord.Builder other) {
    return new com.mycorp.mynamespace.sampleRecord.Builder(other);
  }

  /**
   * Creates a new sampleRecord RecordBuilder by copying an existing sampleRecord instance.
   * @param other The existing instance to copy.
   * @return A new sampleRecord RecordBuilder
   */
  public static com.mycorp.mynamespace.sampleRecord.Builder newBuilder(com.mycorp.mynamespace.sampleRecord other) {
    return new com.mycorp.mynamespace.sampleRecord.Builder(other);
  }

  /**
   * RecordBuilder for sampleRecord instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<sampleRecord>
    implements org.apache.avro.data.RecordBuilder<sampleRecord> {

    /** The id of the order. */
    private int orderId;
    /** Timestamp of the order. */
    private int orderTime;
    /** The address of the order. */
    private java.lang.CharSequence orderAddress;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.mycorp.mynamespace.sampleRecord.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.orderId)) {
        this.orderId = data().deepCopy(fields()[0].schema(), other.orderId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.orderTime)) {
        this.orderTime = data().deepCopy(fields()[1].schema(), other.orderTime);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.orderAddress)) {
        this.orderAddress = data().deepCopy(fields()[2].schema(), other.orderAddress);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing sampleRecord instance
     * @param other The existing instance to copy.
     */
    private Builder(com.mycorp.mynamespace.sampleRecord other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.orderId)) {
        this.orderId = data().deepCopy(fields()[0].schema(), other.orderId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.orderTime)) {
        this.orderTime = data().deepCopy(fields()[1].schema(), other.orderTime);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.orderAddress)) {
        this.orderAddress = data().deepCopy(fields()[2].schema(), other.orderAddress);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'orderId' field.
      * The id of the order.
      * @return The value.
      */
    public java.lang.Integer getOrderId() {
      return orderId;
    }

    /**
      * Sets the value of the 'orderId' field.
      * The id of the order.
      * @param value The value of 'orderId'.
      * @return This builder.
      */
    public com.mycorp.mynamespace.sampleRecord.Builder setOrderId(int value) {
      validate(fields()[0], value);
      this.orderId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'orderId' field has been set.
      * The id of the order.
      * @return True if the 'orderId' field has been set, false otherwise.
      */
    public boolean hasOrderId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'orderId' field.
      * The id of the order.
      * @return This builder.
      */
    public com.mycorp.mynamespace.sampleRecord.Builder clearOrderId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'orderTime' field.
      * Timestamp of the order.
      * @return The value.
      */
    public java.lang.Integer getOrderTime() {
      return orderTime;
    }

    /**
      * Sets the value of the 'orderTime' field.
      * Timestamp of the order.
      * @param value The value of 'orderTime'.
      * @return This builder.
      */
    public com.mycorp.mynamespace.sampleRecord.Builder setOrderTime(int value) {
      validate(fields()[1], value);
      this.orderTime = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'orderTime' field has been set.
      * Timestamp of the order.
      * @return True if the 'orderTime' field has been set, false otherwise.
      */
    public boolean hasOrderTime() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'orderTime' field.
      * Timestamp of the order.
      * @return This builder.
      */
    public com.mycorp.mynamespace.sampleRecord.Builder clearOrderTime() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'orderAddress' field.
      * The address of the order.
      * @return The value.
      */
    public java.lang.CharSequence getOrderAddress() {
      return orderAddress;
    }

    /**
      * Sets the value of the 'orderAddress' field.
      * The address of the order.
      * @param value The value of 'orderAddress'.
      * @return This builder.
      */
    public com.mycorp.mynamespace.sampleRecord.Builder setOrderAddress(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.orderAddress = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'orderAddress' field has been set.
      * The address of the order.
      * @return True if the 'orderAddress' field has been set, false otherwise.
      */
    public boolean hasOrderAddress() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'orderAddress' field.
      * The address of the order.
      * @return This builder.
      */
    public com.mycorp.mynamespace.sampleRecord.Builder clearOrderAddress() {
      orderAddress = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public sampleRecord build() {
      try {
        sampleRecord record = new sampleRecord();
        record.orderId = fieldSetFlags()[0] ? this.orderId : (java.lang.Integer) defaultValue(fields()[0]);
        record.orderTime = fieldSetFlags()[1] ? this.orderTime : (java.lang.Integer) defaultValue(fields()[1]);
        record.orderAddress = fieldSetFlags()[2] ? this.orderAddress : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<sampleRecord>
    WRITER$ = (org.apache.avro.io.DatumWriter<sampleRecord>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<sampleRecord>
    READER$ = (org.apache.avro.io.DatumReader<sampleRecord>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
