package emeter.tic;

/**
 * Class used to handle TIC buffer
 */
public class TICBuffer
{
    /**
     * Buffer start marker
     */
    public static final byte START = (byte)0x02;
    /**
     * Buffer end marker
     */
    public static final byte END = (byte)0x03;
    private static final int LENGTH_MIN = 128;
    private boolean start;
    private boolean end;
    private int length;
    private byte[] buffer;

    /**
     * Default constructor resetting buffer
     */
    public TICBuffer()
    {
        this.reset();
    }
    /**
     * Reset full buffer
     */
    public void reset()
    {
        this.start = false;
        this.end = false;
        this.length = 0;
        this.buffer = new byte[LENGTH_MIN];
    }
    /**
     * Push a byte into buffer
     *
     * @param octet the byte to push
     * @return true if the byte has been pushed, false otherwise
     */
    public boolean push(byte octet)
    {
        int initialLength = this.length;

        if(!this.hasStart())
        {
            if(octet == START)
            {
                this.buffer[this.length++] = START;
                this.start = true;
            }
        }
        else if(!this.hasEnd())
        {
            this.resize();
            this.buffer[this.length++] = octet;
            if(octet == END)
            {
                this.end = true;
            }
        }

        return this.length > initialLength;
    }
    /**
     * Read buffer and reset it
     *
     * @return Full buffer
     * @see #read()
     * @see #reset()
     */
    public byte[] pop()
    {
        byte[] buffer = this.read();

        this.reset();

        return buffer;
    }
    /**
     * Read buffer
     *
     * @return Full buffer
     */
    public byte[] read()
    {
        byte[] buffer = new byte[this.length];
        System.arraycopy(this.buffer,0,buffer,0,this.length);
        return buffer;
    }
    /**
     * Check if buffer is complete
     *
     * @return true if buffer is complete, false otherwise
     */
    public boolean isComplete()
    {
        return this.hasStart() && this.hasEnd();
    }

    private boolean hasStart()
    {
        return this.start;
    }

    private boolean hasEnd()
    {
        return this.end;
    }
    private void resize()
    {
        if(this.buffer.length == this.length)
        {
            int capacity = this.length + LENGTH_MIN;
            byte[] newBuffer = new byte[capacity];
            System.arraycopy(this.buffer,0,newBuffer,0,this.buffer.length);
            this.buffer = newBuffer;
        }
    }
}
