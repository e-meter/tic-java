package emeter.tic;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class TICBufferTest
{
    private static final byte START = 0x02;
    private static final byte END = 0x03;

    @Test
    public void test_constructor()
    {
        // Given

        // When
        TICBuffer buffer = new TICBuffer();

        // Then
        assertFalse(buffer.isComplete());
        assertNotNull(buffer.read());
        assertEquals(0,buffer.read().length);
    }

    @Test
    public void test_push()
    {
        // Given
        byte[] frame = new byte[1024];
        int start = 123;
        int end = 936;
        int length = end - start + 1;
        frame[start] = START;
        frame[end] = END;

        // When
        TICBuffer buffer = new TICBuffer();
        boolean[] isPushed = new boolean[frame.length];
        boolean[] isComplete = new boolean[frame.length];
        for(int i = 0; i < frame.length; i++)
        {
            isPushed[i] = buffer.push(frame[i]);
            isComplete[i] = buffer.isComplete();
        }

        // Then
        for(int i = 0; i < frame.length; i++)
        {
            if( i < start)
            {
                assertFalse(isPushed[i]);
                assertFalse(isComplete[i]);

            }
            else if(i < end)
            {
                assertTrue(isPushed[i]);
                assertFalse(isComplete[i]);
            }
            else if(i == end)
            {
                assertTrue(isPushed[i]);
                assertTrue(isComplete[i]);
            }
            else
            {
                assertFalse(isPushed[i]);
                assertTrue(isComplete[i]);
            }
        }
        assertTrue(buffer.isComplete());
        assertNotNull(buffer.read());
        assertEquals(length,buffer.read().length);
        byte[] expected = new byte[length];
        expected[0] = START;
        expected[length - 1] = END;
        assertArrayEquals(expected,buffer.read());
    }

    @Test
    public void test_reset()
    {
        // Given
        byte[] frame = new byte[] {START,END};

        // When
        TICBuffer buffer = new TICBuffer();
        for (byte octet : frame)
        {
            buffer.push(octet);
        }
        boolean isCompleteBeforeReset = buffer.isComplete();
        int lengthBeforeReset = buffer.read().length;
        buffer.reset();

        // Then
        assertTrue(isCompleteBeforeReset);
        assertEquals(frame.length,lengthBeforeReset);
        assertFalse(buffer.isComplete());
        assertNotNull(buffer.read());
        assertEquals(0,buffer.read().length);
    }

    @Test
    public void test_pop()
    {
        // Given
        byte[] frame = new byte[] {START,END};

        // When
        TICBuffer buffer = new TICBuffer();
        for (byte octet : frame)
        {
            buffer.push(octet);
        }
        boolean isCompleteBeforePop = buffer.isComplete();
        byte[] popedFrame = buffer.pop();

        // Then
        assertTrue(isCompleteBeforePop);
        assertEquals(frame.length,popedFrame.length);
        assertArrayEquals(frame,popedFrame);
        assertFalse(buffer.isComplete());
        assertNotNull(buffer.read());
        assertEquals(0,buffer.read().length);
    }
}
