package com.example.myintentapp

import android.os.Parcel
import android.os.Parcelable

data class person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(age)
        parcel.writeString(email)
        parcel.writeString(city)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<person> {
        override fun createFromParcel(parcel: Parcel): person {
            return person(parcel)
        }

        override fun newArray(size: Int): Array<person?> {
            return arrayOfNulls(size)
        }
    }
}
