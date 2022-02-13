package com.termux.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import com.termux.terminal.TerminalSession;
import com.termux.view.TerminalViewClient;

public final class TermuxViewClient implements TerminalViewClient {

    final TermuxActivity mActivity;

    private boolean mIsEscaped = false;

    public TermuxViewClient(TermuxActivity activity) {
        this.mActivity = activity;
    }

    @Override
    public float onScale(float scale) {
        if (scale < 0.9f || scale > 1.1f) {
            boolean increase = scale > 1.f;
            mActivity.changeFontSize(increase);
            return 1.0f;
        }
        return scale;
    }

    @Override
    public void onSingleTapUp(MotionEvent e) {
        InputMethodManager mgr = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(mActivity.mTerminalView, InputMethodManager.SHOW_IMPLICIT);
    }

    @Override
    public boolean shouldBackButtonBeMappedToEscape() {
        return false;
    }

    @Override
    public void copyModeChanged(boolean copyMode) {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent e, TerminalSession currentSession) {
        if (keyCode == KeyEvent.KEYCODE_ENTER && !currentSession.isRunning()) {
            mActivity.removeFinishedSession(currentSession);
            return true;
        } else if (e.isCtrlPressed() && e.isAltPressed() && keyCode == KeyEvent.KEYCODE_ESCAPE) {
            mIsEscaped = true;
            return true;
        } else if (mIsEscaped) {
            mIsEscaped = false;

            // Get the unmodified code point:
            int unicodeChar = e.getUnicodeChar(0);

            if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN || unicodeChar == 'n'/* next */) {
                mActivity.switchToSession(true);
            } else if (keyCode == KeyEvent.KEYCODE_DPAD_UP || unicodeChar == 'p' /* previous */) {
                mActivity.switchToSession(false);
            } else if (unicodeChar == 'm'/* menu */) {
                mActivity.mTerminalView.showContextMenu();
            } else if (unicodeChar == 'r'/* rename */) {
                mActivity.renameSession(currentSession);
            } else if (unicodeChar == 'a'/* apply */) {
                mActivity.reloadSettings();
            } else if (unicodeChar == 'c'/* create */) {
                mActivity.addNewSession(false, null);
            } else if (unicodeChar == '=') {
                mActivity.changeFontSize(true);
            } else if (unicodeChar == '-') {
                mActivity.changeFontSize(false);
            } else if (unicodeChar >= '1' && unicodeChar <= '9') {
                int num = unicodeChar - '1';
                TermuxService service = mActivity.mTermService;
                if (service.getSessions().size() > num)
                    mActivity.switchToSession(service.getSessions().get(num));
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent e) {
        return false;
    }

    @Override
    public boolean readControlKey() {
        return false;
    }

    @Override
    public boolean readAltKey() {
        return false;
    }

    @Override
    public boolean onCodePoint(final int codePoint, boolean ctrlDown, TerminalSession session) {
        if (ctrlDown) {
            if (codePoint == 106 /* Ctrl+j or \n */ && !session.isRunning()) {
                mActivity.removeFinishedSession(session);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean onLongPress(MotionEvent event) {
        return false;
    }

    @Override
    public boolean getUseAltGr() {
        return mActivity.mSettings.mUseAltGr;
    }
}
