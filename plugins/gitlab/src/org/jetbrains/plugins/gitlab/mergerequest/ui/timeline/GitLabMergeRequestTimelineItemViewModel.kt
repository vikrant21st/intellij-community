// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.plugins.gitlab.mergerequest.ui.timeline

import kotlinx.coroutines.CoroutineScope
import org.jetbrains.plugins.gitlab.mergerequest.data.GitLabDiscussion

sealed interface GitLabMergeRequestTimelineItemViewModel {
  val id: String

  class Immutable(
    val item: GitLabMergeRequestTimelineItem.Immutable
  ) : GitLabMergeRequestTimelineItemViewModel {
    override val id: String = item.id
  }

  class Discussion(
    parentCs: CoroutineScope,
    discussion: GitLabDiscussion
  ) : GitLabMergeRequestTimelineItemViewModel,
      GitLabMergeRequestTimelineDiscussionViewModel
      by GitLabMergeRequestTimelineDiscussionViewModelImpl(parentCs, discussion) {
    override val id: String = discussion.id
  }
}