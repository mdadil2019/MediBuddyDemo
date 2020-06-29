package com.mdadil2019.medibuddydemo.repo.remote

import com.mdadil2019.medibuddydemo.repo.local.model.User
import com.mdadil2019.medibuddydemo.repo.local.model.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("users")
    fun requestUsers(
        @Query("_format") format : String = "json",
        @Query("access-token") accessToken : String = "EpnNzv-Nt7lzSK38usuuNafAuJyTZnkkqQl5"
    ) : Single<UserResponse>

}