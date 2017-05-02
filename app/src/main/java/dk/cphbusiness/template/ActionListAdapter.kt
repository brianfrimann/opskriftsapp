package dk.cphbusiness.template

import android.widget.ArrayAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_action.view.*
import org.jetbrains.anko.*
import android.media.RingtoneManager
import android.media.Ringtone
import android.os.Vibrator


class ActionListAdapter(context: Context, val actions: List<Action>) :
        ArrayAdapter<Action>(context, 0, actions) {

    override fun getView(position: Int, template: View?, parent: ViewGroup): View {
        val notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val r = RingtoneManager.getRingtone(context, notification)

        val action = actions[position]
        val view = template ?: LayoutInflater
                        .from(context)
                        .inflate(R.layout.item_action, parent, false)
        view.editName.setText(action.actionTxt)
        view.editTime.setText(action.time.toString())
        view.editName.onKey { v, i, event ->
            action.actionTxt = v.editName.text.toString()
            false
            }
        view.startTimerButton.onClick {
            doAsync {
                Thread.sleep(view.editTime.text.toString().toLong()*60*1000)
                uiThread {
                    context.toast("Tiden er nu gået ${view.editName.text}")
                    context.vibrator.vibrate(3000)
                    r.play()
                }
            }
        }
        view.stopTimerButton.onClick {
            r.stop()
        }
        return view
        }
    }