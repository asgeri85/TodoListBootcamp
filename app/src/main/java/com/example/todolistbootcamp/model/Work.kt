package com.example.todolistbootcamp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Work(var name:String,var date:String):Parcelable
