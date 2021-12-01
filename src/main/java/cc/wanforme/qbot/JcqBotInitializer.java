package cc.wanforme.qbot;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import cc.wanforme.qbot.cqextra.ExtraAt;
import cc.wanforme.qbot.cqextra.ExtraComponents;
import cc.wanforme.qbot.extra.setu.SetuHandler;
import cc.wanforme.qbot.handler.HandlerManager;

/** 启动后做一些初始化操作
 * @author wanne
 * 2021年8月6日
 */
@Component
public class JcqBotInitializer implements ApplicationRunner{
	
	@Autowired
	private SetuHandler setuHandler;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.initComponents();
		this.initHandlers();
	}

	// 注册组件
	private void initComponents() {
		// 禁止注册纯文本组件
		ExtraComponents.registerComponent(Pattern.compile("\\[CQ:at\\,qq=\\]"), ExtraAt.class);
	}
	
	private void initHandlers() {
		HandlerManager.register(setuHandler);
	}
	
}