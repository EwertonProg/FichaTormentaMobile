import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class TalentosLifecycleObs(private val lifecycle: Lifecycle): LifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onChangeState(){
        Log.d("Lifecycle", lifecycle.currentState.name)
    }

}
