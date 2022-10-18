object AndroidX {

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.androidxUi}"

    // we will remove these 2 dependencies later when building the compose-only nav system
    const val navFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navComponent}"
    const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navComponent}"

    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUtil = "androidx.compose.ui:ui-util:${Versions.composeUtil}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial}"
    const val composeMaterialWindowSize =
        "androidx.compose.material3:material3-window-size-class:${Versions.composeMaterial}"
    const val composeIconsCore = "androidx.compose.material:material-icons-core:${Versions.compose}"
    const val composeIconsExtended =
        "androidx.compose.material:material-icons-extended:${Versions.compose}"

    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navCompose}"
    const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavCompose}"
    const val constraintCompose =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraint}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val datastore = "androidx.datastore:datastore-preferences:${Versions.datastore}"

    const val hiltLifecycleViewModel =
        "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltLifecycleViewModel}"

    const val paging = "androidx.paging:paging-compose:${Versions.paging}"
}