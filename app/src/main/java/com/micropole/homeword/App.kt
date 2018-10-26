package com.micropole.homeword

import com.micropole.baseapplibrary.BaseApplication
import com.micropole.homeword.util.LocationManagerUtil
import com.umeng.commonsdk.UMConfigure
import com.umeng.socialize.PlatformConfig
import com.xx.anypay.WxAppIDProvider
import com.xx.anypay.XxAnyPay

/**
 * @ClassName       App
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 15:11
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class App : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        LocationManagerUtil.getInstance().init(this)
        UMInit()
        XxAnyPay.intance.init(this)
        XxAnyPay.intance.wxAppIDProvider = object : WxAppIDProvider {
            override val weChatAppID: String
                get() = "wxe13c15b520e07f80"
        }
    }

    private fun UMInit() {
        //初始化友盟
        UMConfigure.init(this, "5b4c573e8f4a9d233f000140"
                , "umeng", UMConfigure.DEVICE_TYPE_PHONE, "")//  5af105248f4a9d6df300028a
        //PlatformConfig.setWeixin("wxd08a9b205494c248", "35c0bcca128270bd9b7ec01812fc97fa")
        PlatformConfig.setWeixin("wx97bb14db1693f6cf", "a217a89c349fa1fa4b4574dacb6a935b")
        PlatformConfig.setSinaWeibo("520026000", "0d858f5828e954e57ebd795782036c74", "http://v1.xj-yl.com/api/User/ThirdLogin")
        PlatformConfig.setQQZone("101492282", "75b744ba4e5febd8b9dcf581685d0557")
        //PlatformConfig.setAlipay("2018080860920512")
        //PlatformConfig.setQQZone("1106602798", "gDWIr2lY4PT4OIVa")
    }
}