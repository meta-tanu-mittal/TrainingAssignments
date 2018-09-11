package com.metacube.training.constructorInjection;

public class TextEditor {
	private SpellChecker spellChecker;
	private String word;

	public TextEditor(SpellChecker spellChecker, String word) {
		this.spellChecker = spellChecker;
		this.word = word;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public String getWord() {
		return word;
	}

	public void checkSpell() {
		System.out.println(spellChecker.checkSpelling() + " word :" + getWord());
	}

}
