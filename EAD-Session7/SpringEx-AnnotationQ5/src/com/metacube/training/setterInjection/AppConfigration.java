package com.metacube.training.setterInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigration {
	
	@Bean
	public TextEditor textEditor()
	{
		TextEditor textEditor=new TextEditor();
		textEditor.setWord("setter injection");
		textEditor.setSpellChecker(spellChecker());
		return textEditor;
	}
	
	@Bean
	public SpellChecker spellChecker()
	{
		SpellChecker spellChecker=new SpellChecker();
		return spellChecker;
	}

}
