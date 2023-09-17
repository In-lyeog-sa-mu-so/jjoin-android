package org.donnguk.jjoin.main.view

import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.viewpharm.yakal.base.BaseActivity
import org.donnguk.jjoin.R
import org.donnguk.jjoin.databinding.ActivityMainBinding
import org.donnguk.jjoin.main.viewmodel.MainViewModel
import timber.log.Timber

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by lazy {
        MainViewModel.MainViewModelFactory().create(MainViewModel::class.java)
    }
    private lateinit var navController: NavController

    override fun initView() {
        // Timber 활성화
        Timber.plant(Timber.DebugTree())
        super.initView()

        navController = (supportFragmentManager.findFragmentById(binding.mainFrameLayout.id) as NavHostFragment).navController

//        navController.addOnDestinationChangedListener { _, destination, _ ->
//        }

        binding.bottomNaviBar.setupWithNavController(navController)
    }

    override fun initViewModel() {
        super.initViewModel()

    }

    override fun initListener() {
        super.initListener()
        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onSupportNavigateUp()
            }
        })
    }

    override fun afterOnCreate() {
        super.afterOnCreate()
    }
}