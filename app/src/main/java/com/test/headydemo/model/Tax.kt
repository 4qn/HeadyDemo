package com.test.headydemo.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity

/**
 * Created by Furqan on 03-01-2019.
 */
@Entity
data class Tax(
    val name: String?,
    val value: Float
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeFloat(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tax> {
        override fun createFromParcel(parcel: Parcel): Tax {
            return Tax(parcel)
        }

        override fun newArray(size: Int): Array<Tax?> {
            return arrayOfNulls(size)
        }
    }
}