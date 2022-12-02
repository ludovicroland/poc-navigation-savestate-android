package fr.rolandl.poc.instance.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import fr.rolandl.poc.instance.databinding.FragmentDashboardBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardFragment : Fragment()
{

  private var _binding: FragmentDashboardBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  private lateinit var adapter: DashboardAdapter

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View
  {
    val dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

    _binding = FragmentDashboardBinding.inflate(inflater, container, false)
    val root: View = binding.root

    adapter = DashboardAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
    _binding?.viewPager?.adapter = adapter

    _binding?.let {
      TabLayoutMediator(it.tabs, it.viewPager) { tab, position ->
        tab.text = "TAB ${(position + 1)}"
      }.attach()

      viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
        delay(2000)

        withContext(Dispatchers.Main) {
          adapter.updateList((1..5).toList())
        }
      }
    }

    return root
  }

  override fun onDestroyView()
  {
    super.onDestroyView()
    _binding = null
  }

}