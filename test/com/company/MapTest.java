package com.company;

import junit.framework.TestCase;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MapTest extends TestCase {
    public void testMap() throws Exception {
        Text key = new Text("key");
        Text value = new Text("value");

        Mapper.Context context = mock(Mapper.Context.class);

        Map map = new Map();
        map.map(new LongWritable(), value, context);

        verify(context).write(key, value);
    }
}
