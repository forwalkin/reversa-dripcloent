//menuview.java

package com.dts.Wreefiremax;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

/* JADX INFO: loaded from: /tmp/decompiler/261309cd6a8f497bbd4c575abae56d8d/classes.dex */
public class MenuView extends LinearLayout {
    public static int PrimaryColor = -10868094;
    private static LinearLayout box_functions;
    private LinearLayout box_actions;
    private LinearLayout box_icon;
    private LinearLayout box_menu;
    private LinearLayout box_title;
    private ScrollView scroll_menu;
    private int tapCount;
    private TextView text_banner;
    private TextView text_icon;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onChanges(int i, int i2);

    private static native void onFeatures();

    public MenuView(Context context) {
        super(context);
        this.tapCount = 0;
        onCreateLayout(context);
        onCreateDesign();
        onFeatures();
        DragListener dragListener = new DragListener(this);
        this.box_icon.setOnTouchListener(dragListener);
        this.text_banner.setOnTouchListener(dragListener);
    }

    private void onCreateLayout(Context context) {
        setAlpha(0.9f);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(0);
        LinearLayout linearLayout = new LinearLayout(context);
        this.box_icon = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(dp(context, 37), dp(context, 37)));
        this.box_icon.setGravity(17);
        this.box_icon.setOnClickListener(new View.OnClickListener(this) { // from class: com.dts.Wreefiremax.MenuView.100000000
            private final MenuView this$0;

            {
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.this$0.box_icon.setVisibility(8);
                this.this$0.box_menu.setVisibility(0);
            }
        });
        TextView textView = new TextView(context);
        this.text_icon = textView;
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.text_icon.setText("☰");
        this.text_icon.setTextColor(-1);
        this.text_icon.setTextSize(2, 20);
        this.text_icon.setGravity(17);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.box_menu = linearLayout2;
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(dp(context, 220), -2));
        this.box_menu.setOrientation(1);
        this.box_menu.setVisibility(8);
        LinearLayout linearLayout3 = new LinearLayout(context);
        this.box_title = linearLayout3;
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.box_title.setPadding(dp(context, 6), dp(context, 6), dp(context, 6), dp(context, 6));
        this.box_title.setGravity(17);
        TextView textView2 = new TextView(context);
        this.text_banner = textView2;
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, dp(context, 30)));
        this.text_banner.setText("DRIP CLIENT");
        this.text_banner.setTextColor(-1);
        this.text_banner.setTextSize(2, 14);
        this.text_banner.setGravity(17);
        this.text_banner.setTypeface(Typeface.DEFAULT_BOLD);
        this.text_banner.setOnClickListener(new View.OnClickListener(this) { // from class: com.dts.Wreefiremax.MenuView.100000001
            private final MenuView this$0;

            {
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.this$0.tapCount++;
                if (this.this$0.tapCount >= 3) {
                    this.this$0.box_icon.setVisibility(0);
                    this.this$0.box_menu.setVisibility(8);
                    this.this$0.tapCount = 0;
                }
            }
        });
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-15070694);
        gradientDrawable.setCornerRadius(dp(context, 6));
        gradientDrawable.setStroke(dp(context, 1), -4504372);
        this.text_banner.setBackground(gradientDrawable);
        this.text_banner.setTextColor(-1144577);
        this.text_banner.setShadowLayer(6.0f, 0.0f, 0.0f, -4504372);
        this.text_banner.setTypeface(Typeface.DEFAULT_BOLD);
        ScrollView scrollView = new ScrollView(context);
        this.scroll_menu = scrollView;
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, dp(context, 220)));
        LinearLayout linearLayout4 = new LinearLayout(context);
        box_functions = linearLayout4;
        linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        box_functions.setPadding(dp(context, 6), dp(context, 6), dp(context, 6), dp(context, 6));
        box_functions.setOrientation(1);
        LinearLayout linearLayout5 = new LinearLayout(context);
        this.box_actions = linearLayout5;
        linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.box_actions.setGravity(17);
        this.box_actions.setOrientation(1);
        this.box_actions.setPadding(dp(context, 6), dp(context, 6), dp(context, 6), dp(context, 6));
        addView(this.box_icon);
        this.box_icon.addView(this.text_icon);
        addView(this.box_menu);
        this.box_menu.addView(this.box_title);
        this.box_title.addView(this.text_banner);
        this.box_menu.addView(this.scroll_menu);
        this.scroll_menu.addView(box_functions);
        this.box_menu.addView(this.box_actions);
    }

    private void onCreateDesign() {
        Context context = getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(PrimaryColor);
        gradientDrawable.setCornerRadius(dp(context, 6));
        this.box_icon.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-15658735);
        gradientDrawable2.setCornerRadius(dp(context, 6));
        gradientDrawable2.setStroke(dp(context, 1), -4504372);
        this.box_menu.setBackground(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(PrimaryColor);
        gradientDrawable3.setCornerRadius(dp(context, 6));
    }

    public static void addSwitch(String str, final int i) {
        Context context = box_functions.getContext();
        final GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(dp(context, 50));
        gradientDrawable.setSize(dp(context, 21), dp(context, 21));
        gradientDrawable.setStroke(dp(context, 3), -14606047);
        final GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-14606047);
        gradientDrawable2.setCornerRadius(dp(context, 50));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, dp(context, 8));
        Switch r5 = new Switch(context);
        r5.setLayoutParams(layoutParams);
        r5.setPadding(dp(context, 6), dp(context, 6), dp(context, 6), dp(context, 6));
        r5.setGravity(16);
        r5.setText(str);
        r5.setTextColor(-1);
        r5.setThumbDrawable(gradientDrawable);
        r5.setTrackDrawable(gradientDrawable2);
        r5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.dts.Wreefiremax.MenuView.100000002
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gradientDrawable2.setColor(z ? MenuView.PrimaryColor : -14606047);
                gradientDrawable.setStroke(MenuView.dp(compoundButton.getContext(), 3), z ? MenuView.PrimaryColor : -14606047);
                MenuView.onChanges(i, z ? 1 : 0);
            }
        });
        box_functions.addView(r5);
    }

    public static void addSeekbar(final String str, int i, int i2, final int i3) {
        Context context = box_functions.getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(dp(context, 50));
        gradientDrawable.setSize(dp(context, 18), dp(context, 18));
        final GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-14606047);
        gradientDrawable2.setCornerRadius(dp(context, 50));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setPadding(0, 0, 0, dp(context, 8));
        linearLayout.setOrientation(1);
        final TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setText(new StringBuffer().append(new StringBuffer().append(str).append(": ").toString()).append(i).toString());
        textView.setPadding(dp(context, 6), dp(context, 6), dp(context, 6), dp(context, 6));
        textView.setTextColor(-1);
        SeekBar seekBar = new SeekBar(context);
        seekBar.setPadding(dp(context, 16), dp(context, 4), dp(context, 16), dp(context, 4));
        seekBar.setThumb(gradientDrawable);
        seekBar.getProgressDrawable().setColorFilter(0, PorterDuff.Mode.SRC);
        seekBar.setBackground(gradientDrawable2);
        seekBar.setMax(i2);
        seekBar.setProgress(i);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.dts.Wreefiremax.MenuView.100000003
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int i4, boolean z) {
                textView.setText(new StringBuffer().append(new StringBuffer().append(str).append(": ").toString()).append(i4).toString());
                MenuView.onChanges(i3, i4);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar2) {
                gradientDrawable2.setColor(MenuView.PrimaryColor);
                textView.setTextColor(MenuView.PrimaryColor);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar2) {
                gradientDrawable2.setColor(-14606047);
                textView.setTextColor(-1);
            }
        });
        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        box_functions.addView(linearLayout);
    }

    private class DragListener implements View.OnTouchListener {
        private boolean dragging;
        private int lastX;
        private int lastY;
        private final MenuView this$0;

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.lastX = (int) motionEvent.getRawX();
                    this.lastY = (int) motionEvent.getRawY();
                    this.dragging = false;
                    return true;
                case 1:
                    if (!this.dragging) {
                        view.performClick();
                    }
                    return true;
                case 2:
                    int rawX = ((int) motionEvent.getRawX()) - this.lastX;
                    int rawY = ((int) motionEvent.getRawY()) - this.lastY;
                    if (!this.dragging && Math.abs(rawX) < 5 && Math.abs(rawY) < 5) {
                        return true;
                    }
                    this.dragging = true;
                    this.lastX = (int) motionEvent.getRawX();
                    this.lastY = (int) motionEvent.getRawY();
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.this$0.getLayoutParams();
                    int i = this.this$0.getResources().getDisplayMetrics().widthPixels;
                    int i2 = this.this$0.getResources().getDisplayMetrics().heightPixels;
                    int i3 = marginLayoutParams.leftMargin + rawX;
                    int i4 = marginLayoutParams.topMargin + rawY;
                    int iMax = Math.max(0, Math.min(i3, i - this.this$0.getWidth()));
                    int iMax2 = Math.max(0, Math.min(i4, i2 - this.this$0.getHeight()));
                    marginLayoutParams.leftMargin = iMax;
                    marginLayoutParams.topMargin = iMax2;
                    this.this$0.setLayoutParams(marginLayoutParams);
                    return true;
                default:
                    return false;
            }
        }

        public DragListener(MenuView menuView) {
            this.this$0 = menuView;
        }
    }

    public static int dp(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }
}
