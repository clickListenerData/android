package com.micropole.homemodule.mvp.present

import com.blankj.utilcode.util.RegexUtils
import com.micropole.baseapplibrary.constants.Constants
import com.micropole.homemodule.mvp.constract.FillOrderConstract
import com.micropole.homemodule.mvp.model.FillOrderModel
import com.micropole.homemodule.util.refreshToken
import com.xx.baseutilslibrary.extensions.ui

/**
 * @ClassName       FillOrderPresent
 * @Description     todo
 * @Author          HuaiXianZhong
 * @Sign            。。。
 * @Date            2018/10/25 17:04
 * @Copyright       Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
class FillOrderPresent : FillOrderConstract.Present(){
    override fun commitOrder(h_id: String, startTime: String, endTime: String, num: Int, balance: Int, nickName: String, idCard: String, phone: String) {
        if (!RegexUtils.isIDCard18(idCard) && !RegexUtils.isIDCard15(idCard)){
            getView()?.showToast("请输入正确的验证码")
            return
        }else if (!RegexUtils.isMobileSimple(phone)){
            getView()?.showToast("请输入正确的手机号")
            return
        }
        getView()?.showLoadingDialog("正在提交")
        getModel()?.commitOrder(Constants.SHORT_TOKEN, Constants.getLocation()[0], Constants.getLocation()[1],h_id,startTime, endTime, num, balance,nickName, idCard, phone)
                .ui({
                    getView()?.dismissLoadingDialog()
                    getView()?.commit(it.data)
                },{
                    getView()?.dismissLoadingDialog()
                    getView()?.refreshToken(it,{commitOrder(h_id, startTime, endTime, num, balance, nickName, idCard, phone)})
                })
    }

    override fun bookingHouse(h_id: String, startTime: String, endTime: String, num: Int, balance: Int) {
        if (Constants.isLogin()){
            getView()?.showLoadingDialog("获取中")
            getModel().bookingHouse(Constants.SHORT_TOKEN, Constants.getLocation()[0], Constants.getLocation()[1],h_id,startTime, endTime, num, balance)
                    .ui({
                        getView()?.dismissLoadingDialog()
                        getView()?.bookingSuc(it.data)
                    },{
                        getView()?.dismissLoadingDialog()
                        getView()?.refreshToken(it,{bookingHouse(h_id, startTime, endTime, num, balance)})
                    })
        }else{
            getView()?.showToast("请先登录")
        }
    }

    override fun createModel(): FillOrderConstract.Model {
        return FillOrderModel()
    }
}