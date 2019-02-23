package lianxi.cloud.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author wangyuanhang
 */
public class Main extends ChannelHandlerAdapter {

    private final ByteBuf byteMsg;

    public Main() {
        byte[] req="我是请求数据llllll".getBytes();
        byteMsg=Unpooled.buffer(req.length);
        byteMsg.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(byteMsg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf=(ByteBuf)msg;
        byte[] req=new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body=new String(req,"UTF-8");
        System.out.println("body:"+body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //释放资源
        ctx.close();
    }

    public static void main(String[] args) throws Exception{
        connect("127.0.0.1", 10001);
    }
    public static void connect(String addr,int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new Main());
                        }
                    });
            ChannelFuture f = b.connect(addr, port);
            f.channel().closeFuture().sync();//等待客户端关闭连接
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            group.shutdownGracefully();
        }
    }
}
