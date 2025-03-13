package com.my.company.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextEditorTests {

    TextEditor textEditor;

    @Test
    public void test_01() {

        textEditor = new TextEditor();

        textEditor.append("leetcode");
        assertEquals("leetcode", textEditor.getText());
        assertEquals(8, textEditor.getCursorPosition());

        textEditor.backspace(4);
        assertEquals("leet", textEditor.getText());
        assertEquals(4, textEditor.getCursorPosition());

        textEditor.append("practice");
        assertEquals("leetpractice", textEditor.getText());
        assertEquals(12, textEditor.getCursorPosition());

        textEditor.cursorRight(3);
        assertEquals("leetpractice", textEditor.getText());
        assertEquals(12, textEditor.getCursorPosition());

        textEditor.cursorLeft(8);
        assertEquals("leetpractice", textEditor.getText());
        assertEquals(4, textEditor.getCursorPosition());

        textEditor.backspace(10);
        assertEquals("practice", textEditor.getText());
        assertEquals(0, textEditor.getCursorPosition());

        textEditor.cursorLeft(2);
        assertEquals("practice", textEditor.getText());
        assertEquals(0, textEditor.getCursorPosition());

        textEditor.cursorRight(6);
        assertEquals("practice", textEditor.getText());
        assertEquals(6, textEditor.getCursorPosition());

        textEditor.cursorLeft(6);
        assertEquals("practice", textEditor.getText());
        assertEquals(0, textEditor.getCursorPosition());

        textEditor.append("leetcode");
        assertEquals("leetcodepractice", textEditor.getText());
        assertEquals(8, textEditor.getCursorPosition());
    }
}
