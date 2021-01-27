package org.tasks.caldav

import dagger.hilt.android.lifecycle.HiltViewModel
import org.tasks.data.CaldavAccount
import org.tasks.data.CaldavCalendar
import org.tasks.ui.CompletableViewModel
import javax.inject.Inject

@HiltViewModel
class UpdateCalendarViewModel @Inject constructor(
        private val provider: CaldavClientProvider
) : CompletableViewModel<String?>() {
    suspend fun updateCalendar(account: CaldavAccount, calendar: CaldavCalendar, name: String, color: Int) {
        run {
            calendar.url?.let { provider.forAccount(account, it).updateCollection(name, color) }
        }
    }
}