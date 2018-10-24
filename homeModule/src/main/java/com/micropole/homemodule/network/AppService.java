package com.micropole.homemodule.network;

import com.micropole.homemodule.entity.EvaluationBean;
import com.micropole.homemodule.entity.HomeBean;
import com.micropole.homemodule.entity.HouseDetailBean;
import com.micropole.homemodule.entity.OrderDetailBean;
import com.micropole.homemodule.entity.OrderListBean;
import com.micropole.homemodule.entity.RefreshTokenBean;
import com.micropole.homemodule.entity.SearchBean;
import com.micropole.homemodule.entity.SearchStyleBean;
import com.xx.baseutilslibrary.entity.BaseResponseEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * @ClassName AppService
 * @Description todo
 * @Author HuaiXianZhong
 * @Sign 。。。
 * @Date 2018/10/22 17:33
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
public interface AppService {

    /**
     * 刷新token
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("login/get_short_token")
    Observable<BaseResponseEntity<RefreshTokenBean>> refreshToken(@Field("long_token") String token);

    /**
     * 首页
     */
    @POST("Index/index")
    Observable<BaseResponseEntity<HomeBean>> homeData(@Header("lat")String lat, @Header("lng")String lng);

    /**
     * 获取搜索风格
     * @return
     */
    @POST("Index/hotel_search_get_area")
    Observable<BaseResponseEntity<List<SearchStyleBean>>> getStyleData(@Header("lat")String lat, @Header("lng")String lng);

    /**
     * 搜索
     * @param styleId  风格id
     * @param type     排序类型
     * @param page     页数
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param num       人数
     * @return
     */
    @FormUrlEncoded
    @POST("Index/hotel_search")
    Observable<BaseResponseEntity<SearchBean>> getSearchData(@Header("lat")String lat, @Header("lng")String lng,
                                                             @Field("area_id") String styleId, @Field("type_deac") int type, @Field("page") int page,
                                                             @Field("start_time") String startTime, @Field("end_time") String endTime, @Field("people_number") String num);

    /**
     * 旅馆详情
     * @return
     */
    @FormUrlEncoded
    @POST("Index/hotel_detail")
    Observable<BaseResponseEntity<HouseDetailBean>> getHouseDetail(@Header("token")String token,@Header("lat")String lat, @Header("lng")String lng,
                                                                   @Field("h_id") String h_id);

    /**
     * 举报房源
     * @return
     */
    @FormUrlEncoded
    @POST("Hotel/hotel_report")
    Observable<BaseResponseEntity<Object>> reportHotel(@Header("token")String token,@Header("lat")String lat, @Header("lng")String lng,
                                                           @Field("h_id") String h_id,@Field("report_content") String content);

    /**
     * 评论列表
     * @return
     */
    @FormUrlEncoded
    @POST("Index/hotel_comments")
    Observable<BaseResponseEntity<List<EvaluationBean>>> getHouseComment(@Header("lat")String lat, @Header("lng")String lng,
                                                                         @Field("h_id") String h_id, @Field("page") int page);

    /**
     * 收藏旅馆
     * @param token
     * @param lat
     * @param lng
     * @param h_id
     * @return
     */
    @FormUrlEncoded
    @POST("Hotel/hotel_collect")
    Observable<BaseResponseEntity<Object>> collectHotel(@Header("token")String token,@Header("lat")String lat, @Header("lng")String lng,
                                                                      @Field("h_id") String h_id);

    /**
     * 订单列表
     * @param staut 1=支付成功，待确认，2=管理员确认预约，已预订，3=已经完成 4=已取消 5=退款中 7=全部订单 8=待评价
     * @param page
     * @return
     */
    @FormUrlEncoded
    @POST("Userorder/order_list")
    Observable<BaseResponseEntity<List<OrderListBean>>> orderList(@Header("token")String token, @Header("lat")String lat, @Header("lng")String lng,
                                                                  @Field("or_stat") int staut, @Field("page") int page);

    @FormUrlEncoded
    @POST("Userorder/order_detail")
    Observable<BaseResponseEntity<OrderDetailBean>> orderDetail(@Header("token")String token, @Header("lat")String lat, @Header("lng")String lng,
                                                                @Field("or_id") String orderId);
}
