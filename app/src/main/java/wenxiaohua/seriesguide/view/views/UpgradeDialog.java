package wenxiaohua.seriesguide.view.views;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import wenxiaohua.seriesguide.R;
import wenxiaohua.seriesguide.bean.UpgradeSetting;


/**
 * Created by hexun on 2016/2/16.
 */
public class UpgradeDialog extends Dialog {

    private UpgradeSetting setting;
    private Context context;
    private TextView messageView;
    private View positiveBtn;
    private View negativeBtn;

    public UpgradeDialog(Context context, UpgradeSetting setting) {
        super(context, R.style.HeDialog);
        this.context = context;
        this.setting = setting;

        setContentView(R.layout.dialog_upgrade_alert);
        initView();
    }

    private void initView() {

        messageView = (TextView)findViewById(R.id.message);
        positiveBtn = findViewById(R.id.positive);
        negativeBtn = findViewById(R.id.negative);

        messageView.setText(setting.getReleaseNotes());

        positiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(setting.getDownloadUrl()));
                    context.startActivity(i);

                } catch (Exception e) {

                }
                dismiss();
            }
        });

        if (setting.isForcedUpdate()) {
            negativeBtn.setVisibility(View.GONE);
            setCancelable(false);
        } else {
            setCancelable(true);
            negativeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }

    }

}
