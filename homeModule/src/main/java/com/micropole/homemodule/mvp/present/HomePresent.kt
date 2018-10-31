package com.micropole.homemodule.mvp.present

import com.micropole.baseapplibrary.constants.Constants
import com.micropole.baseapplibrary.network.AppApi
import com.micropole.homemodule.mvp.constract.HomeConstract
import com.micropole.homemodule.mvp.model.HomeModel
import com.micropole.homemodule.network.AppService
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui
import com.xx.baseutilslibrary.network.exception.ApiFaileException

/**
 * @ClassName       HomePresent
 * @Description     首页
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/22 17:19
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class HomePresent : HomeConstract.Present() {
    override fun getHomeData() {
        if (Constants.isLogin() && Constants.SHORT_TOKEN.isEmpty()) Constants.SHORT_TOKEN = Constants.getShotToken()
        getModel().getHomeData(Constants.getLocation()[0],Constants.getLocation()[1])
                .ui({getView()?.setData(it.data)},{
                    getView()?.showError(ApiFaileException(it),true)
                })
    }

    override fun createModel(): HomeConstract.Model {
        return HomeModel()
    }
}