package com.wds.app.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * nio的channel、buffer学习
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-24 14:29
 */
public class NioChannelBufferTestCase {

    // nio读文件
    @Test
    public void testReadFile() throws IOException {
        RandomAccessFile file = new RandomAccessFile("d://test.txt", "rw");
        // 获取channel
        FileChannel channel = file.getChannel();

        // 分配buffer大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        // channel写入到buffer中
        int byteRead = channel.read(byteBuffer);
        while (-1 != byteRead){
            //  buffer写模式转为读模式
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.println((char) byteBuffer.get());
            }
            // 清理buffer数据
            byteBuffer.clear();
            byteRead = channel.read(byteBuffer);
        }
        file.close();
    }
}
