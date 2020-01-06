package demo.serve.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@SuppressWarnings("all")
public class DruidConfig {
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	public DataSource druid() 
	{
		 DruidDataSource datasource = new DruidDataSource();
	        List<Filter> filters = new ArrayList<Filter>();
	        filters.add(wallFilter);
	        datasource.setProxyFilters(filters);

	        return datasource;
//		return new DruidDataSource();
	}
	@Autowired
    WallFilter wallFilter;


    @Bean(name = "wallConfig")
    WallConfig wallFilterConfig(){
        WallConfig wc = new WallConfig ();
        wc.setMultiStatementAllow(true);
        return wc;
    }

    @Bean(name = "wallFilter")
    @DependsOn("wallConfig")
    WallFilter wallFilter(WallConfig wallConfig){
        WallFilter wfilter = new WallFilter ();
        wfilter.setConfig(wallConfig);
        return wfilter;
    }
	
	
}
