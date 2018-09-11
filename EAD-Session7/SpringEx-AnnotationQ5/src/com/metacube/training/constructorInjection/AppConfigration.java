package com.metacube.training.constructorInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigration {
	
	@Bean
	public TextEditor textEditor()
	{
		TextEditor textEditor=new TextEditor(spellChecker(),"constructor injecttion");
		return textEditor;
	}
	
	@Bean
	public SpellChecker spellChecker()
	{
		SpellChecker spellChecker=new SpellChecker();
		return spellChecker;
	}

}
