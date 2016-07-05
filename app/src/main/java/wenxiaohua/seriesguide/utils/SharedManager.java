package wenxiaohua.seriesguide.utils;

/**
 * Created by Administrator on 2015/12/8 0008.
 */
public class SharedManager {

//    private static SharedManager sharedManager = null;
//    private UMSocialService mController;
//    private Activity context; //最好使用application的context
//    private static String WEXIN_APPID = "wxa617cd8d8103aabd";
//    private static String WEXIN_APPSECRET = "146ed8808d874d503a342d5e819f7f90";
//
//    private static String QQ_APPID = "1105204097";
//    private static String QQ_APPSECRET = "fUmWz2WZF3jvdvjN";
//    private static String SINA_APPID = "4231848542";
//    private static String SINA_APPSECRET = "f28ced1600d5dceb59114813a6d51f38";
//
//
//    private SharedManager(Activity activity) {
//        mController = UMServiceFactory.getUMSocialService("com.umeng.share");
//        mController.getConfig().cleanListeners();
//        context = activity;
//        configPlatforms();
//    }
//
//    public static SharedManager newInstance(Activity activity) {
//
//        if (sharedManager == null) {
//            synchronized (SharedManager.class) {
//                if (sharedManager == null) {
//                    return sharedManager = new SharedManager(activity);
//                }
//            }
//        }
//        return sharedManager;
//    }
//
//    public UMSocialService getController() {
//        return mController;
//    }
//
//
//    /**
//     * 配置分享平台参数</br>
//     */
//    public void configPlatforms() {
//
//        // 添加新浪SSO授权
//        addSINAPlatform();
//
//
//        // 添加微信、微信朋友圈平台
//        addWXPlatform();
//        // 添加QQ平台
//        addQQPlatform();
//
//    }
//
//    private void addSINAPlatform() {
//        SinaSsoHandler mSinaSsoHandler  = new SinaSsoHandler();
////        mSinaSsoHandler.addToSocialSDK();
//
//        mController.getConfig().setSsoHandler(mSinaSsoHandler);
//    }
//
//    private void addQQPlatform() {
//        //参数1为当前Activity，参数2为开发者在QQ互联申请的APP ID，参数3为开发者在QQ互联申请的APP kEY.
//        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(context, QQ_APPID,
//                QQ_APPSECRET);
//        qqSsoHandler.addToSocialSDK();
//    }
//
//    /**
//     * @return
//     * @功能描述 : 添加微信平台分享
//     */
//    private void addWXPlatform() {
//        // 注意：在微信授权的时候，必须传递appSecret
//        // wx967daebe835fbeac是你在微信开发平台注册应用的AppID, 这里需要替换成你注册的AppID
//        // 添加微信平台
//        UMWXHandler wxHandler = new UMWXHandler(context, WEXIN_APPID, WEXIN_APPSECRET);
//        wxHandler.addToSocialSDK();
//
//
//        // 支持微信朋友圈
//        UMWXHandler wxCircleHandler = new UMWXHandler(context, WEXIN_APPID, WEXIN_APPSECRET);
//        wxCircleHandler.setToCircle(true);
//        wxCircleHandler.addToSocialSDK();
//    }
//
//    /**
//     * 根据不同的平台设置不同的分享内容</br>
//     */
//    public SharedManager setShareContent(String title, String imageUrl, String content, String url) {
//
//        UMImage sharedImage;
//        if (TextUtils.isEmpty(imageUrl)){
//            sharedImage = new UMImage(context, R.mipmap.ic_launcher);
//        }else{
//            sharedImage = new UMImage(context,imageUrl);
//        }
//
//        WeiXinShareContent weixinContent = new WeiXinShareContent();
//        weixinContent
//                .setShareContent(content);
//        weixinContent.setTitle(title);
//        weixinContent.setTargetUrl(url);
//        weixinContent.setShareImage(sharedImage);
//        mController.setShareMedia(weixinContent);
//
//        // 设置朋友圈分享的内容
//        CircleShareContent circleMedia = new CircleShareContent();
//        circleMedia
//                .setShareContent(title+"\n"+content);
//        circleMedia.setTitle(title+"\n"+content);
//        circleMedia.setShareImage(sharedImage);
//        circleMedia.setTargetUrl(url);
//        mController.setShareMedia(circleMedia);
//
//        // 设置QQ分享的内容
//        QQShareContent qqMedia = new QQShareContent();
//        qqMedia
//                .setShareContent(content);
//        qqMedia.setTitle(title);
//        qqMedia.setShareImage(sharedImage);
//        qqMedia.setTargetUrl(url);
//        mController.setShareMedia(qqMedia);
//
//
//
//
//
//        // 设置SINA分享的内容
//        SinaShareContent sinaMedia = new SinaShareContent();
//        sinaMedia
//                .setShareContent(title + "\n" + content + "\n" + url);
//        sinaMedia.setTitle(title + "\n" + content);
//        sinaMedia.setShareImage(sharedImage);
//        sinaMedia.setTargetUrl(url);
//        mController.setShareMedia(sinaMedia);
//        Log.v("SharedManager" , url);
////        SinaShareContent sinaContent = new SinaShareContent();
////        sinaContent
////                .setShareContent(content);
////        sinaContent.setTitle(title);
////        sinaContent.setTargetUrl(url);
////        sinaContent.setShareImage(sharedImage);
////        mController.setShareMedia(sinaContent);
//
//        return null;
//    }
//
//    /**
//     * @功能描述 : 初始化与SDK相关的成员变量
//     */
//    public void share(String title,String imageUrl,String content,String url) {
//
//        // 要分享的文字内容
//        String mShareContent = content;
//        mController.setShareContent(mShareContent);
//
//        UMImage mUMImgBitmap = new UMImage(context, imageUrl);
//        mController.setShareImage(mUMImgBitmap);
//        mController.setShareImage(mUMImgBitmap);
//        mController.setAppWebSite(""); // 设置应用地址
//
//
//
//        // 设置微信好友分享内容
//        WeiXinShareContent weixinContent = new WeiXinShareContent();
//        // 设置分享文字
//        weixinContent.setShareContent(mShareContent);
//        // 设置title
//        weixinContent.setTitle(title);
//        // 设置分享内容跳转URL
//        weixinContent.setTargetUrl(url);
//        // 设置分享图片
//        weixinContent.setShareImage(mUMImgBitmap);
//        mController.setShareMedia(weixinContent);
//
//        // 设置微信朋友圈分享内容
//        CircleShareContent circleMedia = new CircleShareContent();
//        circleMedia.setShareContent(mShareContent);
//        // 设置朋友圈title
//        circleMedia.setTitle(title);
//        circleMedia.setShareImage(mUMImgBitmap);
//        circleMedia.setTargetUrl(url);
//        mController.setShareMedia(circleMedia);
//
//
//
//        mController.getConfig().setPlatforms( SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE);
//        mController.openShare(context, false);
//    }
//
//    public UMSocialService getmController() {
//        return mController;
//    }
}
