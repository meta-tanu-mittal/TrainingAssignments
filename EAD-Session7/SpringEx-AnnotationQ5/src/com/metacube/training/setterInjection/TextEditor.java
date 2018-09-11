package com.metacube.training.setterInjection;

public class TextEditor {
	private SpellChecker spellChecker;
	private String word;

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void checkSpell() {
		System.out.println(spellChecker.checkSpelling() + " word :" + getWord());
	}

}
