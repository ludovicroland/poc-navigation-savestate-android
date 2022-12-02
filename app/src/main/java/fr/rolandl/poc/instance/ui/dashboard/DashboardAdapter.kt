package fr.rolandl.poc.instance.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import fr.rolandl.poc.instance.ui.recycler.ItemFragment

class DashboardAdapter(fragment: Fragment) :
  FragmentStateAdapter(fragment)
{

  override fun getItemCount(): Int =
    5

  override fun createFragment(position: Int): Fragment =
    ItemFragment()

}