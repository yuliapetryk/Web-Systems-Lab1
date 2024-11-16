package lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

//@EnableCaching
@SpringBootApplication
public class Lab1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}

//	@Bean
//	public CacheManager cacheManager() {
//		SimpleCacheManager cacheManager = new SimpleCacheManager();
//
////		cacheManager.setCaches(Arrays.asList(
////				new ConcurrentMapCache("products")));
//
//		CaffeineCache productsCache = new CaffeineCache("products",
//				Caffeine.newBuilder()
//						.expireAfterWrite(1, TimeUnit.MINUTES)  // TTL
//                        .expireAfterAccess(1, TimeUnit.MINUTES) // TTI
//						.maximumSize(1000)
//						.build());
//		cacheManager.setCaches(Arrays.asList(productsCache));
//
//		return cacheManager;
//	}

}
