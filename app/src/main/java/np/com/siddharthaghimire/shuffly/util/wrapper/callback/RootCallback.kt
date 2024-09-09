package np.com.siddharthaghimire.shuffly.util.wrapper.callback

import android.view.View
import np.com.siddharthaghimire.shuffly.util.wrapper.CallbackType

interface RootCallback<T> {
    fun onRootCallback(index: Int, data: T?, type: CallbackType, view: View?) {}
}