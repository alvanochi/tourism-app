package com.dicoding.tourismapp.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface TourismDao {

    //Flowable untuk mengambil data
    //Completable untuk memasukkan data
//    cukup informasi apakah proses sudah selesai (complete) atau eror

    @Query("SELECT * FROM tourism")
    fun getAllTourism(): Flowable<List<TourismEntity>>

    @Query("SELECT * FROM tourism where isFavorite = 1")
    fun getFavoriteTourism(): Flowable<List<TourismEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTourism(tourism: List<TourismEntity>): Completable

    @Update
    fun updateFavoriteTourism(tourism: TourismEntity)
}
