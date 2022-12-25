package com.todak.playground.ui.word

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.todak.playground.R

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {
    // Generates a [CharRange] from 'A' to 'Z' and converts it to a list
    private val list = ('A').rangeTo('Z').toList()

    class LetterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        // Setup custom accessibility delegate to set the text read
        layout.accessibilityDelegate = Accessibility
        return LetterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list[position]
        holder.button.text = item.toString()

        holder.button.setOnClickListener {
            val action =
                LetterListFragmentDirections.actionLetterListFragmentToWordListFragment2(letter = holder.button.text.toString())
            holder.view.findNavController().navigate(action)
        }
    }

    // Setup custom accessibility delegate to set the text read with
    // an accessibility service
    companion object Accessibility : View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(
            host: View,
            info: AccessibilityNodeInfo
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            // With `null` as the second argument to [AccessibilityAction], the
            // accessibility service announces "double tap to activate".
            // If a custom string is provided,
            // it announces "double tap to <custom string>".
            val customString = host.context?.getString(R.string.look_up_words)
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info.addAction(customClick)
        }
    }

}
