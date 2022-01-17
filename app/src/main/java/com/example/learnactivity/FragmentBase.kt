package com.example.learnactivity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class FragmentBase(private val name: String) : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("state - fragment - " + name, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("state - fragment - " + name, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Log.e("state - fragment - " + name, "onCreateView");
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("state - fragment - " + name, "onActivityCreated");
    }

    override fun onStart() {
        super.onStart()
        Log.e("state - fragment - " + name, "onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.e("state - fragment - " + name, "onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.e("state - fragment - " + name, "onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.e("state - fragment - " + name, "onStop");
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("state - fragment - " + name, "onDestroyView");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("state - fragment - " + name, "onDestroy");
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("state - fragment - " + name, "onDetach");
    }
}