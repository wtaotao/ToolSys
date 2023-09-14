package com.nikki.sample;

import java.nio.ByteBuffer;

public class ByteBufferSample {
	  public void testBuffer() {
		    // 初始化一个大小为6的ByteBuffer
		    ByteBuffer buffer = ByteBuffer.allocate(6);
		    print(buffer);  // 初始状态：position: 0, limit: 6, capacity: 6

		    // 往buffer中写入3个字节的数据
		    buffer.put((byte) 1);
		    buffer.put((byte) 2);
		    buffer.put((byte) 3);
		    print(buffer);  // 写入之后的状态：position: 3, limit: 6, capacity: 6

		    System.out.println("************** after flip **************");
		    buffer.flip();
		    print(buffer);  // 切换为读取模式之后的状态：position: 0, limit: 3, capacity: 6

		    buffer.get();
		    buffer.get();
		    print(buffer);  // 读取两个数据之后的状态：position: 2, limit: 3, capacity: 6
		  }

		  private void print(ByteBuffer buffer) {
		    System.out.printf("position: %d, limit: %d, capacity: %d\n",
		      buffer.position(), buffer.limit(), buffer.capacity());
		  }
	public static void main(String[] args) {
		(new ByteBufferSample()).testBuffer();
	}

}
