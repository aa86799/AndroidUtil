import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;


public class SpannableStringUtil {

    /**
     * 超链接
     */
    private static SpannableString addUrlSpan() {
        SpannableString spanString = new SpannableString("超链接");
        URLSpan span = new URLSpan("tel:0123456789");
        spanString.setSpan(span, 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanString;
    }


    /**
     * 文字背景颜色
     */
    private static SpannableString addBackColorSpan() {
        SpannableString spanString = new SpannableString("颜色2");
        BackgroundColorSpan span = new BackgroundColorSpan(Color.YELLOW);
        spanString.setSpan(span, 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanString;
    }


    /**
     * 文字颜色
     */
    private static SpannableString addForeColorSpan() {
        SpannableString spanString = new SpannableString("颜色1");
        ForegroundColorSpan span = new ForegroundColorSpan(Color.BLUE);
        spanString.setSpan(span, 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanString;
    }


    /**
     * 字体大小
     */
    private static SpannableString addFontSpan() {
        SpannableString spanString = new SpannableString("36号字体");
        AbsoluteSizeSpan span = new AbsoluteSizeSpan(36);
        spanString.setSpan(span, 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanString;
    }


    /**
     * 粗体，斜体
     */
    private static SpannableString addStyleSpan() {
        SpannableString spanString = new SpannableString("BIBI");
        StyleSpan span = new StyleSpan(Typeface.BOLD_ITALIC);
        spanString.setSpan(span, 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanString;
    }


    /**
     * 删除线
     */
    private static SpannableString addStrikeSpan() {
        SpannableString spanString = new SpannableString("删除线");
        StrikethroughSpan span = new StrikethroughSpan();
        spanString.setSpan(span, 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanString;
    }

    /**
     * 下划线
     */
    private static SpannableString addUnderLineSpan() {
        SpannableString spanString = new SpannableString("下划线");
        UnderlineSpan span = new UnderlineSpan();
        spanString.setSpan(span, 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanString;
    }


    /**
     * 图片
     */
    private static SpannableString addImageSpan(Context context, int resId, String text) {
        Drawable drawable = context.getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        //需要处理的文本，[smile]是需要被替代的文本
        SpannableString spanString = new SpannableString(text + "[smile]");
        //要让图片替代指定的文字就要用ImageSpan
        ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
        //开始替换，注意第2和第3个参数表示从哪里开始替换到哪里替换结束（start和end）
        //最后一个参数类似数学中的集合,[5,12)表示从5到12，包括5但不包括12
        spanString.setSpan(span, text.length(), text.length() + "[smile]".length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        return spanString;
    }
}
