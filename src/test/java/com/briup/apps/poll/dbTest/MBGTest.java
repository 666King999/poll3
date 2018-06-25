package com.briup.apps.poll.dbTest;

import java.io.File;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import com.mysql.jdbc.log.LogFactory;


/**   
 * @ClassName:  MBGTest   
 * @Description:TODO  mybatis-generator逆向工程生成bean dao Mapper.xml映射表文件
 * @author: changqing
 * @date:   Jun 25, 2018 4:22:15 PM   
 *      
 */
public class MBGTest {

	public static void main(String[] args) throws Exception {
	   List<String> warnings = new ArrayList<String>();
	   boolean overwrite = true;
	   File configFile = new File("src/main/resources/mybatis-generator.xml");
	   ConfigurationParser cp = new ConfigurationParser(warnings);
	   Configuration config = cp.parseConfiguration(configFile);
	   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
	   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
	   myBatisGenerator.generate(null);
	   System.out.print("逆向工程完成");
	}
}
