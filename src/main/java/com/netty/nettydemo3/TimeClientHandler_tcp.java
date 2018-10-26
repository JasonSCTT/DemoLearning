package com.netty.nettydemo3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @author jason
 */
public class TimeClientHandler_tcp extends ChannelHandlerAdapter {

    private int counter;
    private byte[] req;

    public TimeClientHandler_tcp() {
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }


    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf message = null;
        for (int i = 0; i < 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }


    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);

        String body = (String) msg;
        System.out.println("Now is : " + body + " ; the counter is :" + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        ctx.close();
    }
}
