package hasan.gurgur.rickandmorty.view

import android.annotation.SuppressLint
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import hasan.gurgur.rickandmorty.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImageFromUrl(imageview: ImageView, url : String?) {
        Glide.with(imageview.context).load(url).into(imageview)
    }
    @SuppressLint("ResourceAsColor")
    @JvmStatic
    @BindingAdapter("statusColor")
    fun statusColor(textView: TextView,status:String){
        if (status.equals("Alive")){
            textView.setTextColor(ContextCompat.getColor(textView.context, R.color.status_alive))
        }else{
            textView.setTextColor(ContextCompat.getColor(textView.context, R.color.status_dead))
        }
    }

    @JvmStatic
    @BindingAdapter("genderColor")
    fun genderColor(textView: TextView,gender:String){
        if (gender.equals("Male")){
            textView.setTextColor(ContextCompat.getColor(textView.context, R.color.gender_male))
        }else{
            textView.setTextColor(ContextCompat.getColor(textView.context, R.color.gender_female))
        }
    }

    @JvmStatic
    @BindingAdapter("loadAvatarImage")
    fun loadAvatarImage(imageview: ImageView, url : String?) {
        //https://rickandmortyapi.com/api/character/38
        //https://rickandmortyapi.com/api/character/avatar/38.jpeg
        val mString = url!!.split("/").toTypedArray()

        mString.forEach {
           Log.d("TAG",it)
        }

        val newString = "https://rickandmortyapi.com/api/character/avatar/"+mString[5]+".jpeg"

        Log.d("TAG",newString)
        Glide.with(imageview.context).load(newString).into(imageview)
    }

}