package com.test.headydemo.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity

/**
 * Created by Furqan on 03-01-2019.
 */
@Entity
data class Products(
    val id: Int,
    val name: String,
    val date_added: String,
    val variants: List<Variants>,
    val tax: Tax,
    var view_count: Long,
    var order_count: Long,
    var shares: Long
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createTypedArrayList(Variants)!!,
        parcel.readParcelable(Tax::class.java.classLoader)!!,
        parcel.readLong(),
        parcel.readLong(),
        parcel.readLong()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(date_added)
        parcel.writeTypedList(variants)
        parcel.writeParcelable(tax, flags)
        parcel.writeLong(view_count)
        parcel.writeLong(order_count)
        parcel.writeLong(shares)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Products> {
        override fun createFromParcel(parcel: Parcel): Products {
            return Products(parcel)
        }

        override fun newArray(size: Int): Array<Products?> {
            return arrayOfNulls(size)
        }
    }
}