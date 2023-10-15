package com.turtleteam.impl.navigation

import androidx.navigation.NavController
import com.turtleteam.api.FeatureThreeNavigation
import com.turtleteam.api.FeatureTwoNavigation

class FeatureTwoNavigator(
    private val featureThreeNavigation: FeatureThreeNavigation,
    private val featureTwoNavigation: FeatureTwoNavigation,
    private val navController: NavController
) {
    fun navigateToFeatureThree(string: String){
        navController.navigate(featureThreeNavigation.baseRoute + "/$string")
    }
}