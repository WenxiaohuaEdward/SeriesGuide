package wenxiaohua.seriesguide.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by hexun on 2016/6/15.
 * 轮播图适配器
 */
public class BannerAdapter extends PagerAdapter {
    private final Context context;
    private final List<ImageView> imageViewContainer;

    public BannerAdapter(Context context , List<ImageView> imageViewContainer) {
        this.context =context;
        this.imageViewContainer =imageViewContainer;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (!imageViewContainer.isEmpty())
        container.removeView(imageViewContainer.get(position % imageViewContainer.size()));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (!imageViewContainer.isEmpty()) {
            View view = imageViewContainer.get(position % imageViewContainer.size());

            // 为每一个page添加点击事件
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Page 被点击了", Toast.LENGTH_SHORT).show();
                }

            });

            container.addView(view);
            return view;
        }
       return null;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
