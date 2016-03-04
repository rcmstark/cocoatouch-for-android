package com.hummingbird.cocoatouch.uikit;
import com.hummingbird.objectivec.annotation.Optional;

public interface UITextFieldDelegate
{
    @Optional void textFieldDidChange(UITextField textField);
    @Optional void textFieldShouldChange(UITextField textField, CharSequence s, int start, int before, int count);
    @Optional void textFieldBeforeChange(UITextField textField, CharSequence s, int start, int count, int after);
}
