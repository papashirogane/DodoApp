package com.example.learnandroid.util;

import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.learnandroid.R;

import java.util.Hashtable;

public class Util {
    private static Util singleton = null;
    private Hashtable<String, String> dict = new Hashtable<>();

    private Util() {
        dict.put("bipedal locomotion", "Two-footed movement\n(Merriam-Webster)");
        dict.put("columbids", "A family of game birds comprising the doves and pigeons\n(Merriam-Webster)");
        dict.put("duty factor", "the fraction of the stride period in which the foot is on the ground\n(Blanco 2003)");
        dict.put("extant", "Currently or actually existing\n(Merriam-Webster)");
        dict.put("femur", "The proximal bone of the hind or lower limb that extends from the hip to the knee\n(Merriam-Webster)");
        dict.put("hind leg proportion", "Length proportion of hind leg bones (femur to tibiotarsus to tarsometatarsus)\n(Claessens 2015");
        dict.put("kiwi", "Any of a small genus (Apteryx) of flightless New Zealand birds with rudimentary wings, stout legs, a long bill, and grayish brown hairlike plumage\n(Merriam-Webster)");
        dict.put("Mauritius", "An island in the Indian Ocean in the central Mascarenes located east of Madagascar\n(Merriam-Webster)");
        dict.put("Rhea americana", "A species of flightless bird native to eastern South America\n(Wikipedia)");
        dict.put("vestigial", "Remaining in a form that is small or imperfectly developed and not able to function\n(Merriam-Webster)");
    }

    public static Util getSingleton() {
        if (singleton == null) {
            singleton = new Util();
        }
        return singleton;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void searchClickableText(Context context, TextView tv) {
        String tvt = tv.getText().toString();
        dict.forEach((key, def) -> {
            CharSequence cs = key.toLowerCase();
            if (tvt.toLowerCase().contains(cs)) {
                setClickableText(tv, key, view -> {
                    Toast.makeText(context
                            , key + ":\n" + def
                            , Toast.LENGTH_LONG).show();
                });
            }
        });
    }


    // Learned from:
    //      1) Coding in Flow's ClickableSpan video, and
    //      2) Khemraj's answer to https://stackoverflow.com/questions/52476980/how-to-find-particular-word-from-full-text-and-make-it-hyperlink-clickable-with
    public void setClickableText(TextView tv, String textToHighlight, View.OnClickListener onClickListener) {
        String tvt = tv.getText().toString();
        int indexKey = tvt.indexOf(textToHighlight, 0);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                if (onClickListener != null) onClickListener.onClick(view);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(tv.getContext().getResources().getColor(R.color.colorPrimaryDark));
                ds.setUnderlineText(true);
            }
        };

        SpannableString ss = new SpannableString(tv.getText());
        ss.setSpan(clickableSpan, indexKey, indexKey + textToHighlight.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(ss, TextView.BufferType.SPANNABLE);
        // setMovementMethod is necessary for ClickableSpan, unnecessary when doing others (colour).
        tv.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
