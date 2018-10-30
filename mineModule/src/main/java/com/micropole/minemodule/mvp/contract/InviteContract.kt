package com.micropole.minemodule.mvp.contract

import com.micropole.minemodule.bean.RefreshTokenBean
import com.micropole.minemodule.bean.Share
import com.micropole.minemodule.bean.UserInfo
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseuilibrary.mvp.presenter.BaseMvpPresenter
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/10/24
 * describe:
 */
interface InviteContract {
    interface View:BaseMvpView{
        fun getShare(share:Share)

    }
    interface Model{
        fun getShare(token:String,lat:String,lng:String):Observable<BaseResponseEntity<Share>>

    }
    abstract class Presenter:BaseMvpPresenter<Model,View>(){
        abstract fun getShare()

    }
}