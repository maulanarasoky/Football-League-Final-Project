package com.example.footballleaguefinalproject.model.league

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(val id : String?, val name : String?, val description : String?, val image : Int?) : Parcelable