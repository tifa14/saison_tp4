package com.example.saison_tp4.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.saison_tp4.Fragment1;
import com.example.saison_tp4.R;

import com.example.saison_tp4.NatureFragment;

import java.util.Locale;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }



    @Nullable
    @Override

    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String titre="";
        Drawable icone=null;
        switch (position) {
            case 0:
                titre = "Printemps".toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.print);
                break;
            case 1:
                titre = mContext.getString(R.string.titre_section1).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.et);
                break;
            case 2:
                titre = mContext.getString(R.string.titre_section2).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.aut);
                break;
            case 3:
                titre = mContext.getString(R.string.titre_section3).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.hiv);
                break;

            case 4:
                titre = mContext.getString(R.string.saison).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.saison);
                break;
        }
        SpannableString sb = new SpannableString(" " + titre);
        // un espace est ajouté pour séparer le texte de l'image

        icone.setBounds(0, 0, icone.getIntrinsicWidth(), icone.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(icone, ImageSpan.ALIGN_BASELINE);
        sb.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;

    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NatureFragment.newInstance(0, mContext.getString(R.string.titre_section0),R.drawable.printemps);
            case 1:
                return NatureFragment.newInstance(1, mContext.getString(R.string.titre_section1),R.drawable.ete);
            case 2:
                return NatureFragment.newInstance(2, mContext.getString(R.string.titre_section2),R.drawable.autom);
            case 3:
                return NatureFragment.newInstance(3, mContext.getString(R.string.titre_section3),R.drawable.hiver);
            case 4:
                return Fragment1.newInstance("saison");
        }
        return null;
    }
    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}