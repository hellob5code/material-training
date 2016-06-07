package fr.erictruong.material.training.domain

import java.util.*
import android.os.Parcel
import android.os.Parcelable

data class DummyModel(var id: Long = 0, var avatarUrl: String = "", var text1: String = "", var text2: String = "", var text3: String = "", var isSelected: Boolean = false) : Parcelable {

    constructor(source: Parcel): this(source.readLong(), source.readString(), source.readString(), source.readString(), source.readString(), 1.toByte().equals(source.readByte()))

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeLong(id)
        dest?.writeString(avatarUrl)
        dest?.writeString(text1)
        dest?.writeString(text2)
        dest?.writeString(text3)
        dest?.writeByte((if (isSelected) 1 else 0).toByte())
    }

    companion object {
        @JvmField final val CREATOR: Parcelable.Creator<DummyModel> = object : Parcelable.Creator<DummyModel> {
            override fun createFromParcel(source: Parcel): DummyModel {
                return DummyModel(source)
            }

            override fun newArray(size: Int): Array<DummyModel?> {
                return arrayOfNulls(size)
            }
        }
    }
}