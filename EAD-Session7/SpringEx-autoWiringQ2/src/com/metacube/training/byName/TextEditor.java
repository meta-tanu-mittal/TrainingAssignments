package com.metacube.training.byName;

public class TextEditor {
	private SpellChecker spellChecker;

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void checkSpell() {
		System.out.println(spellChecker.checkSpelling());
	}

}
