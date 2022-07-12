package com.borisov.pressure.ui.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.borisov.pressure.data.Record
import com.borisov.pressure.databinding.FragmentEditorBinding
import com.borisov.pressure.ui.BaseFragment
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Borisov Andrey on 12.07.2022
 **/
class EditorFragment : BaseFragment<FragmentEditorBinding>() {
    private var listener: SubmitRecordListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listener = context as? SubmitRecordListener

        val date = Date()
        val df = SimpleDateFormat("d MMMM yyyy, HH:mm", Locale.getDefault())
        binding.dateTimeTextView.text = df.format(date)

        binding.commitButton.setOnClickListener {
            try {
                val sys = binding.systolicEditText.text.toString().toInt()
                val dia = binding.diastolicEditText.text.toString().toInt()
                val pulse = binding.pulseEditText.text.toString().toInt()

                listener?.submitRecord(
                    Record(date.time, sys, dia, pulse)
                )
            } catch (e: Throwable) {
                showError(e)
            }
        }
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentEditorBinding.inflate(inflater, container, false)
}