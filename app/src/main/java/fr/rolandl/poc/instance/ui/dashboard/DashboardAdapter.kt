package fr.rolandl.poc.instance.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import fr.rolandl.poc.instance.ui.recycler.ItemFragment

class DashboardAdapter(fragment: FragmentManager, lifecycle: Lifecycle) :
  FragmentStateAdapter(fragment, lifecycle)
{

  private var list = emptyList<Int>()

  override fun getItemCount(): Int =
    list.size

  override fun createFragment(position: Int): Fragment =
    ItemFragment()

  fun updateList(list: List<Int>) {
    this.list = list
    notifyDataSetChanged()
  }
}