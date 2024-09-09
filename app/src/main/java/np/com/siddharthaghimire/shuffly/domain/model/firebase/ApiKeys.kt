package np.com.siddharthaghimire.shuffly.domain.model.firebase

data class ApiKeys(
    val instagram: List<KeysItem> = listOf(),
    val tiktok: List<KeysItem> = listOf(),
    val youtube: List<KeysItem> = listOf()
)