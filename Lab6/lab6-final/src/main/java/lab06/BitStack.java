package lab06;

/**
 * A stack of bits.
 *
 * @author Nat Tuck
 * @author Erica Guenther
 * @author Violet Lempke
 * @author Daniel Whitney
 */
public class BitStack implements Stack<Boolean> {
    // Number of bits currently stored in the stack.
    int length;

    // Storing n bits should require a data array of
    // no more than 2+(n/4) bytes.
    byte[] data;

    /**
     * Initialize an empty BitStack.
     */ 
    BitStack() {
        this.data = new byte[0];
        this.length = 0;
        
        
        
        
        
    }

    @Override
    public void push(Boolean item) { 
    
            
        this.setCapacity(1); 
        this.set(this.length(), item);
        this.length += 1; 
            
            
    }    

    
    @Override
    public Boolean pop() {
        this.length -= 1;
        return get(this.length());
        
    }

    @Override
    public Boolean peek() {
       
        return this.get((this.length() - 1));
    }

    @Override
    public boolean empty() {
        if (this.length == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Get length in bits.
     *
     * @return length
     */
    int length() {
        return this.length;
    }

    /**
     * Set length in bits.
     *
     * @param  nn  New length
     */
    void setLength(int nn) {
        // incorrectly do nothing
    }

    /**
     * Get length in bytes.
     *
     * @return bytes
     */
    int byteLength() {
        return this.length/8;
    }

    /**
     * Get capacity in bits.
     *
     * @return bits
     */
    int capacity() {
        return 17;
    }

    /**
     * Set capacity in bits. Space will be allocated for
     * at least the number of bits requested.
     *
     * @param  nn  Bits requested
     */
    void setCapacity(int nn) {
        var newStack = new byte[data.length + nn]; 

        var baba = new BitStack(); 

        baba.data = newStack; 

        for (int ii = 0; ii < data.length; ++ii) { 

            baba.set(ii, get(ii)); 

        } 

        this.data = baba.data;
    }

    /**
     * Get the bit at the given index.
     *
     * @param  ii  index
     * @return     Bit at that index
     */
    Boolean get(int ii) {
        if (data[ii] == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Set the bit at the given index.
     *
     * @param  ii  index
     * @param  vv  bit value
     */
    void set(int ii, Boolean vv) {
        // This logic is incorrect, but it will set bit vv of byte 1
        // to true if vv is true and ii is in the range 0-7.
        if ((ii >= 0 && ii < 8) && (vv = true)) {
            data[0] = (byte)(data[0] | (byte)(1 << ii));
        }
        else {
            
            data[0] = (byte)(data[0] | (byte)(0 << ii));
        
            // It doesn't handle the case where vv is false.
            // And probably bits 0-7 don't go in byte 1.
            // And probably bits > 7 need to go somewhere.
        }
    }
}
