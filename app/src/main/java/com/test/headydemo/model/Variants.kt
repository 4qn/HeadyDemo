package com.test.headydemo.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity

/**
 * Created by Furqan on 03-01-2019.
 */
@Entity
data class Variants(
    val id: Int,
    val color: String?,
    val size: Int,
    val price: Long
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readLong()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(color)
        parcel.writeInt(size)
        parcel.writeLong(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Variants> {
        override fun createFromParcel(parcel: Parcel): Variants {
            return Variants(parcel)
        }

        override fun newArray(size: Int): Array<Variants?> {
            return arrayOfNulls(size)
        }
    }
}