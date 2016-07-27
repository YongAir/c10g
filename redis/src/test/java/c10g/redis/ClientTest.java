package c10g.redis;

import redis.clients.jedis.Jedis;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ClientTest extends TestCase {

	public void testRedis(){
		Jedis jedis = new Jedis("localhost");
		String password = "c10g";
		jedis.auth(password);
		jedis.connect();
		for(int i=0 ; i<2 ;i++){
			jedis.set("key"+i, "value"+i);
		}
		String value = jedis.get("key"+25);
		System.out.println(value);
		for(int i=0 ; i<2 ;i++){
			System.out.println(jedis.get("key"+i));
		}
		jedis.ping();
		jedis.quit();
		jedis.disconnect();
		System.out.println("end");
	}
}
