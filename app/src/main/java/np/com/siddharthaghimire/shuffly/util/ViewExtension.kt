package np.com.siddharthaghimire.shuffly.util

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import np.com.siddharthaghimire.shuffly.R

fun View.gone() {
    this.visibility = View.GONE
}


fun View.invisible() {
    this.visibility = View.INVISIBLE
}


fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.loadFadeInOutAnimation(){
    startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in_out))
}

fun AppCompatImageView.loadImage(
    source: Any,
    onLoad: () -> RequestOptions
) {
    Glide.with(context)
        .load(source)
        .apply(onLoad())
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .into(this)
}

fun View.preventTwoClick() {
    this.isEnabled = false
    this.postDelayed({ this.isEnabled = true }, 500)
}

fun EditText.showKeyboard() {
    post {
        requestFocus()
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun Any?.notNullAndEmpty(): Boolean {
    return if (this != null) {
        if (this is String) {
            this.isNotBlank()
        } else true
    } else false
}

fun BottomNavigationView.active(position: Int) {
    menu.getItem(position).isChecked = true
}