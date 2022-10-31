package io.redis.jedis.jedisdemo.configuration;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

public class CustomCacheErrorHandler implements CacheErrorHandler {

	@Override
	public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
		// Auto-generated method stub
		
	}

	@Override
	public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
		// Auto-generated method stub
		
	}

	@Override
	public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
		// Auto-generated method stub
		
	}

	@Override
	public void handleCacheClearError(RuntimeException exception, Cache cache) {
		// Auto-generated method stub
		
	}

}
