package fr.rolandl.poc.instance.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import fr.rolandl.poc.instance.ui.recycler.ItemFragment

class DashboardAdapter(fragment: FragmentManager, lifecycle: Lifecycle, val List: List<Int>) :
  FragmentStateAdapter(fragment, lifecycle)
{

  override fun getItemCount(): Int =
    List.size

  override fun createFragment(position: Int): Fragment =
    ItemFragment()

}