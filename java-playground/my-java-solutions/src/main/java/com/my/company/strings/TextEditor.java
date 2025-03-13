package com.my.company.strings;

import lombok.Getter;

@Getter
public class TextEditor {

    private String text = "";
    private int cursorPosition = 0;

    public void append(String inputText) {
        text += inputText;
        cursorPosition += inputText.length();
    }

    public void backspace(int i) {

        if (0 == cursorPosition) {
            return;
        }

        if (text.substring(0, cursorPosition).length() <= i) {
            text = text.substring(cursorPosition);
            cursorPosition = 0;
            return;
        }

        int initialCursorPosition = cursorPosition;

        text = text.substring(0, text.length() - i);

        decrementCursorPosition(initialCursorPosition, i);
    }

    private void decrementCursorPosition(int initialCursorPosition, int i) {
        if (initialCursorPosition > i) {
            cursorPosition -= i;
        }
        if (cursorPosition <= 0) {
            cursorPosition = 0;
        }
    }

    public void cursorRight(int i) {
        if (cursorPosition == text.length()) {
            return;
        }

        if (cursorPosition + i <= text.length()) {
            cursorPosition = i;
            return;
        }

        cursorPosition += i;
    }

    public void cursorLeft(int i) {
        if (0 == cursorPosition) {
            return;
        }
        if (text.length() <= i) {
            cursorPosition = 0;
        }
        cursorPosition -= i;
    }
}
