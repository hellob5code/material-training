package com.training.android.material.model;

import android.text.TextUtils;
import org.apache.commons.lang3.text.WordUtils;

public class Contact {

    public enum PhoneType {
        HOME, MOBILE, WORK, MAIN, FAX, PAGER, OTHER
    }

    public enum EmailType {
        HOME, WORK, OTHER
    }

    public enum AddressType {
        HOME, WORK, OTHER
    }
}
