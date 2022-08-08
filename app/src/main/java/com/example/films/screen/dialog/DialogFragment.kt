package com.example.films.screen.dialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.example.films.R
import com.example.films.databinding.NameFilmAlertDialogBinding

class DialogFragment : DialogFragment(R.layout.name_film_alert_dialog) {

    private var bindingDialog: NameFilmAlertDialogBinding? = null
    private val binding
        get() = bindingDialog

    private val args: DialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        bindingDialog = NameFilmAlertDialogBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            nameFilmDialog.text = "Фильм ${args.filmName} был нажат"
            btnClose.setOnClickListener {
                dismiss()
            }
        }
    }

}