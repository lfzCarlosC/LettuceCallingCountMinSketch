package com.brandwatch.signals.detector;


import java.util.List;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.output.IntegerOutput;
import io.lettuce.core.output.StatusOutput;
import io.lettuce.core.protocol.CommandArgs;

public class LettuceRedisClientTests {

    public static void main( String[] args){
        RedisClient client = RedisClient.create("redis://localhost:6379");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisCodec<String, String> codec = StringCodec.UTF8;
        RedisCommands commands = connection.sync();

//        cmsIncrby(commands, codec);
//        cmsQuery(commands, codec);
//        cmsMerge(commands, codec);
//        cmsInitByDim(commands, codec);
//        cmsInitByErr(commands, codec);
//        cmsDebug(commands, codec);
        connection.close();
    }

   public static Object cmsIncrby(RedisCommands commands, RedisCodec codec){
       Object response = commands.dispatch(myclass.CMS_INCRBY,
               new StatusOutput(codec),
               new CommandArgs<>(codec)
                       .addKey("key").addKey("item1").addValue("1"));
       System.out.println((String) response);
       return response;
   }

   public static Object cmsQuery(RedisCommands commands, RedisCodec codec){
       Object response = commands.dispatch(myclass.CMS_QUERY,
               new IntegerOutput(codec),
               new CommandArgs<>(codec)
                       .addKey("key").addKey("item1"));
       System.out.println((long)response);
       return response;
   }

   public static Object cmsMerge(RedisCommands commands, RedisCodec codec){
       Object response = commands.dispatch(myclass.CMS_MERGE,
               new StatusOutput(codec),
               new CommandArgs<>(codec)
                       .add("key").addKey("2").addValue("key").addValue("key1")
                       .addKey("WEIGHTS").addValue("5").addValue("3"));
       System.out.println((String) response);
       return response;
   }

    public static Object cmsInitByDim(RedisCommands commands, RedisCodec codec){
        Object response = commands.dispatch(myclass.CMS_INITBYDIM,
                new StatusOutput(codec),
                new CommandArgs<>(codec)
                        .addKey("key3").add("100").add("200"));
        System.out.println((String) response);
        return response;
    }

    public static Object cmsInitByErr(RedisCommands commands, RedisCodec codec){
        Object response = commands.dispatch(myclass.CMS_INITBYERR,
                new StatusOutput(codec),
                new CommandArgs<>(codec)
                        .addKey("key4").add("0.001").add("0.001"));
        System.out.println((String) response);
        return response;
    }

    public static Object cmsDebug(RedisCommands commands, RedisCodec codec){
        Object response = commands.dispatch(myclass.CMS_DEBUG,
                new StatusOutput(codec),
                new CommandArgs<>(codec)
                        .addKey("key4"));
        System.out.println((String[]) response);
        return response;
    }

}
