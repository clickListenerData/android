package com.micropole.homemodule.order

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.micropole.baseapplibrary.constants.ARouterConst
import com.micropole.homemodule.R
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @ClassName       OrderFragment
 * @Description     订单列表
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/16 16:21
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Route(path = ARouterConst.Order.ORDER_FRAGEMENT)
class OrderFragment  : BaseMvpViewFragment(){

    override fun getFragmentLayoutId(): Int = R.layout.fragment_home

    override fun initView(view: View?) {

    }

    override fun initEvent(view: View?) {
    }

    override fun initData() {
        tv_home.text = "订单"
    }
}