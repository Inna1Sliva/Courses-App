package com.it.shka.feature_profile.domain.model

data class SupportChat(
   val conversations: List<Conversation>,
   val unreadCount: Int
)
