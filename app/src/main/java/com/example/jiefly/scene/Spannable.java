package com.example.jiefly.scene;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Spannable extends AppCompatActivity {

    @BindView(R.id.tv_1)
    TextView mTv1;
    @BindView(R.id.activity_spannable)
    RelativeLayout mActivitySpannable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable);
        ButterKnife.bind(this);
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder("<上标+前景颜色+size>（如果sizeSpan在superscriptSpan之前superscriptSpan将不起作用）\n有新的消息●");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        SpannableString spannableString = new SpannableString("<下标+背景颜色+前景颜色>试试备注jiefly");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.GREEN);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.5f);
        stringBuilder.setSpan(superscriptSpan, stringBuilder.length() - 1, stringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringBuilder.setSpan(foregroundColorSpan, stringBuilder.length() - 1, stringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringBuilder.setSpan(relativeSizeSpan, stringBuilder.length() - 1, stringBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) findViewById(R.id.tv_1)).setText(stringBuilder);
        spannableString.setSpan(subscriptSpan, spannableString.length() - 6, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(backgroundColorSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(foregroundColorSpan, spannableString.length() - 6, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) findViewById(R.id.tv_2)).setText(spannableString);
        SpannableString spannableString1 = new SpannableString("我是中划线，嘻嘻");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString1.setSpan(strikethroughSpan, 2, spannableString1.length() - 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) findViewById(R.id.tv_3)).setText(spannableString1);
        SpannableString spannableString2 = new SpannableString("我是下划线，嘻嘻");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableString1.setSpan(underlineSpan, 2, spannableString1.length() - 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) findViewById(R.id.tv_4)).setText(spannableString2);
        SpannableString spannableString3 = new SpannableString("<ImageSpan>蝈蝈发来了一个表情");
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0, 0, drawable.getMinimumHeight(), drawable.getMinimumHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, DynamicDrawableSpan.ALIGN_BOTTOM);
        spannableString3.setSpan(imageSpan, spannableString3.length() - 2, spannableString3.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) findViewById(R.id.tv_5)).setText(spannableString3);
        SpannableString spannableString4 = new SpannableString("<ClickableSpan>点击我试试吧");
        spannableString4.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "点击了文字", Toast.LENGTH_SHORT).show();
            }

        }, spannableString4.length() - 6, spannableString4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = ((TextView) findViewById(R.id.tv_6));
//        必须为tv设置movementMethod才能使点击事件生效
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString4);

        SpannableString spannableString5 = new SpannableString("<MaskFilterSpan>这是一个-模糊-模糊-模糊-模糊-的字");
        MaskFilterSpan maskFilterSpanOuter = new MaskFilterSpan(new BlurMaskFilter(10, BlurMaskFilter.Blur.OUTER));
        MaskFilterSpan maskFilterSpanInner = new MaskFilterSpan(new BlurMaskFilter(10, BlurMaskFilter.Blur.INNER));
        MaskFilterSpan maskFilterSpanNormal = new MaskFilterSpan(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
        MaskFilterSpan maskFilterSpanSolid = new MaskFilterSpan(new BlurMaskFilter(10, BlurMaskFilter.Blur.SOLID));
        spannableString5.setSpan(maskFilterSpanOuter, 21, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString5.setSpan(maskFilterSpanInner, 24, 26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString5.setSpan(maskFilterSpanNormal, 27, 29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString5.setSpan(maskFilterSpanSolid, 30, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) findViewById(R.id.tv_7)).setText(spannableString5);

        SpannableString spannableString6 = new SpannableString("<ImageSpan实现边框>我在边框里面");
        spannableString6.setSpan(new ImageSpan(Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565)) {
            @Override
            public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
//                super.draw(canvas, text, start, end, x, top, y, bottom, paint);
//                start -> text起始位置
//                end -> text终止位置
//                x ->目标substring的起始x坐标
//                y-> 目标substring的起始y坐标（字体leading的位置）
                float strLen = paint.measureText(text, start, end);
                Paint.FontMetrics fm = paint.getFontMetrics();
                paint.setColor(Color.RED);
                canvas.drawRoundRect(x, y + fm.top, x + strLen, y + fm.bottom, 10, 10, paint);
                paint.setColor(Color.WHITE);
                canvas.drawText(text, start, end, x, y, paint);
            }
        }, spannableString6.length() - 6, spannableString6.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) findViewById(R.id.tv_8)).setText(spannableString6);
        SpannableString spannableString7 = new SpannableString("<ImageSpan实现边框1> 我在边框里面");
        spannableString7.setSpan(new ImageSpan(Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565)) {
            @Override
            public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
//                super.draw(canvas, text, start, end, x, top, y, bottom, paint);
//                start -> text起始位置
//                end -> text终止位置
//                x ->目标substring的起始x坐标
//                y-> 目标substring的起始y坐标（字体leading的位置）
                x += 20;
                float strLen = paint.measureText(text, start, end);
                Paint.FontMetrics fm = paint.getFontMetrics();
                paint.setColor(Color.RED);
                float centerY = (fm.ascent + fm.descent) / 2 + y;
                Path path = new Path();
                path.moveTo(x - 20, centerY);
                path.lineTo(x, fm.ascent + y);
                path.lineTo(x, fm.descent + y);
                path.close();
                canvas.drawPath(path, paint);
                canvas.drawRect(x, y + fm.ascent, x + strLen, y + fm.descent, paint);
                paint.setColor(Color.WHITE);
                canvas.drawCircle(x - 10, centerY, 5, paint);
                canvas.drawText(text, start, end, x, y, paint);
            }
        }, spannableString7.length() - 7, spannableString7.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) findViewById(R.id.tv_9)).setText(spannableString7);
        SpannableString spannableString8 = new SpannableString("<ImageSpan>蝈蝈发来了一个表情");
        ImageSpan imageSpan1 = new ImageSpan(getApplicationContext(), R.mipmap.ic_launcher, DynamicDrawableSpan.ALIGN_BOTTOM) {
            @Override
            public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
                Drawable b = getDrawable();
                // font metrics of text to be replaced
                Paint.FontMetricsInt fm = paint.getFontMetricsInt();
                int transY = (y + fm.descent + y + fm.ascent) / 2
                        - b.getBounds().bottom / 2;

                canvas.save();
                canvas.translate(x, transY);
                b.draw(canvas);
                canvas.restore();
            }
        };
        spannableString8.setSpan(imageSpan1, spannableString8.length() - 2, spannableString8.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) findViewById(R.id.tv_10)).setText(spannableString8);

    }


    @OnClick(R.id.tv_1)
    public void onClick() {
    }
}
