package com.mdadil2019.medibuddydemo.repo.local.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso

@Entity
data class User(

    @PrimaryKey
    val id : Int,

    @SerializedName("first_name")
    val firstName : String,

    @SerializedName("last_name")
    val lastName : String,

    @SerializedName("dob")
    val dateOfBirth : String,

    @SerializedName("gender")
    val gender : String,

    @SerializedName("_links")
    @Embedded
    val links : Links
){
    data class Links(
        @Embedded
        val avatar : Avatar
    ){
        data class Avatar(
            val href : String
        )
    }

    companion object{
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(imageView : ImageView, imageUrl: String){
            Picasso.get().load(imageUrl).into(imageView)
        }
    }
}