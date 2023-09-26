package org.donnguk.jjoin.main.view

import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import org.donnguk.jjoin.base.view.BaseActivity
import org.donnguk.jjoin.R
import org.donnguk.jjoin.databinding.ActivityMainBinding
import org.donnguk.jjoin.main.viewmodel.MainViewModel
import timber.log.Timber

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by lazy {
        MainViewModel.MainViewModelFactory().create(MainViewModel::class.java)
    }
    private lateinit var navController: NavController
    val REQ_PERMISSION_PUSH = 123
    override fun initView() {
        // Timber 활성화
        Timber.plant(Timber.DebugTree())
        super.initView()

        setSupportActionBar(binding.toolbar).apply {
            supportActionBar?.setDisplayShowTitleEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }

        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onSupportNavigateUp()
            }
        })

        navController = (supportFragmentManager.findFragmentById(binding.mainFrameLayout.id) as NavHostFragment).navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    binding.toolbarTextView.visibility = android.view.View.VISIBLE
                    binding.toolbarImageView.visibility = android.view.View.VISIBLE
                    binding.bottomNaviBar.visibility = android.view.View.VISIBLE
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    binding.toolbarTextView.text = "홈"
                }
                R.id.profileFragment -> {
                    binding.toolbarTextView.visibility = android.view.View.VISIBLE
                    binding.toolbarImageView.visibility = android.view.View.VISIBLE
                    binding.bottomNaviBar.visibility = android.view.View.VISIBLE
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    binding.toolbarTextView.text = "마이 페이지"
                }
                R.id.notificationFragment, R.id.profileEditFragment -> {
                    binding.toolbarTextView.visibility = android.view.View.GONE
                    binding.toolbarImageView.visibility = android.view.View.GONE
                    binding.bottomNaviBar.visibility = android.view.View.GONE
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
            }
        }

        NavigationUI.setupActionBarWithNavController(this, navController)
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

        binding.toolbarImageView.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_notificationFragment)
        }
    }

    override fun afterOnCreate() {
        super.afterOnCreate()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun onLogBackStack() {
        val backStackEntryCount = supportFragmentManager.backStackEntryCount
        Timber.d("backStackEntryCount: $backStackEntryCount")
    }
}