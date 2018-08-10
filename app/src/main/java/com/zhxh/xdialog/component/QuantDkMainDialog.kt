package com.zhxh.xdialog.component;

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zhxh.xdialog.R

/**
 * Created by zhxh on 2018/8/10
 */
class QuantDkMainDialog : DialogFragment() {

    companion object {

        fun newInstance(dialogType: Int): QuantDkMainDialog {
            val args = Bundle()
            args.putInt("dialogType", dialogType)
            val fragment = QuantDkMainDialog()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.dialog)
    }

    override fun onStart() {
        super.onStart()

        val dm = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(dm)
        dialog?.window?.setLayout(dm.widthPixels, dialog.window.attributes.height)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.dialog_quant_dk_main, container, false)
        initView(root!!)
        return root
    }

    private fun initView(root: View) {

        val dialogType = arguments?.getInt("dialogType")

        val type1Layout = root.findViewById<View>(R.id.type1Layout)
        val type2Layout = root.findViewById<View>(R.id.type2Layout)
        val type3Layout = root.findViewById<View>(R.id.type3Layout)
        val tvTitle = root.findViewById<TextView>(R.id.tvTitle)


        when (dialogType) {
            1 -> {
                type1Layout.visibility = View.VISIBLE
                type2Layout.visibility = View.GONE
                type3Layout.visibility = View.GONE

                tvTitle.text = "恭喜你获得看盘神器\\nDK短线宝+指标"
            }
            2 -> {
                type1Layout.visibility = View.GONE
                type2Layout.visibility = View.VISIBLE
                type3Layout.visibility = View.GONE
            }
            3 -> {
                type1Layout.visibility = View.GONE
                type2Layout.visibility = View.GONE
                type3Layout.visibility = View.VISIBLE
            }
        }
    }

}