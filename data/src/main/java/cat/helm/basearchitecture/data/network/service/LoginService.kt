package cat.helm.basearchitecture.data.network.service

import cat.helm.basearchitecture.data.network.ApiConstants
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Héctor on 15/12/2017.
 */
interface LoginService {

    @FormUrlEncoded
    @POST(ApiConstants.LOGIN)
    fun login(@Field("username") username: String, @Field("password") password: String): Call<JsonElement>
}