package com.example.checkup.models

import android.os.Parcel
import android.os.Parcelable

class Twin() : Parcelable {
    var propertyString: String? = ""
    var valueObject: Any? = null

    constructor(parcel: Parcel) : this() {
        propertyString = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(propertyString)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Twin> {
        override fun createFromParcel(parcel: Parcel): Twin {
            return Twin(parcel)
        }

        override fun newArray(size: Int): Array<Twin?> {
            return arrayOfNulls(size)
        }
    }
}