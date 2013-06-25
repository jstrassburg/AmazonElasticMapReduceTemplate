package com.company;

import junit.framework.TestCase;
import org.apache.hadoop.io.Text;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReduceTest extends TestCase {
    public void testReduce() throws Exception {
        Text key = new Text("key");
        ArrayList<Text> values = new ArrayList<Text>() { { new Text(); new Text(); } };
        Text expectedReduceValue = new Text(String.format("%s", values.size()));

        Reduce.Context context = mock(Reduce.Context.class);

        Reduce reduce = new Reduce();
        reduce.reduce(key, values, context);

        verify(context).write(key, expectedReduceValue);
    }
}
