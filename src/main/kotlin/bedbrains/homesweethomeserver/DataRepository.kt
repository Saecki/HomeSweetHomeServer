package bedbrains.homesweethomeserver

import bedbrains.platform.UIDProvider
import bedbrains.shared.datatypes.devices.Device
import bedbrains.shared.datatypes.devices.Heating
import bedbrains.shared.datatypes.devices.Light
import bedbrains.shared.datatypes.rules.Rule
import bedbrains.shared.datatypes.rules.RuleValue
import bedbrains.shared.datatypes.rules.WeeklyRule
import bedbrains.shared.datatypes.temperature.celsius
import bedbrains.shared.datatypes.time.WeeklyTime
import bedbrains.shared.datatypes.time.WeeklyTimeSpan

object DataRepository {
    val devices: MutableList<Device> = mutableListOf(
        Heating(UIDProvider.newUID, "Küche", "Heizung", 22.celsius).apply {
            tags = mutableSetOf("Nice", "Yeet", "Amazing", "Cool", "But why?", "Hello there", "Maaaan")
        },
        Light(UIDProvider.newUID, "Küche", "Boden").apply {
            tags = mutableSetOf("Nice", "Yeet", "Amazing", "Cool", "But why?", "Hello there", "Maaaan")
        },
        Heating(UIDProvider.newUID, "Badezimmer", "Bodenheizung", 22.celsius).apply {
            tags = mutableSetOf("Nice", "Yeet", "Amazing", "Cool", "But why?", "Hello there", "Maaaan")
        },
        Light(UIDProvider.newUID, "Badezimmer", "Decke").apply {
            tags = mutableSetOf("Nice", "Yeet", "Amazing", "Cool", "But why?", "Hello there", "Maaaan")
        },
        Heating(UIDProvider.newUID, "Keller", "Heizung", 22.celsius).apply {
            tags = mutableSetOf("Nice", "Yeet", "Amazing", "Cool", "But why?", "Hello there", "Maaaan")
        },
        Light(UIDProvider.newUID, "Wohnzimmer", "Decke").apply {
            tags = mutableSetOf("Nice", "Yeet", "Amazing", "Cool", "But why?", "Hello there", "Maaaan")
        },
        Light(UIDProvider.newUID, "Wohnzimmer", "Ecke").apply {
            tags = mutableSetOf("Nice", "Yeet", "Amazing", "Cool", "But why?", "Hello there", "Maaaan")
        },
        Light(UIDProvider.newUID, "Wohnzimmer", "Tisch").apply {
            tags = mutableSetOf("Nice", "Yeet", "Amazing", "Cool", "But why?", "Hello there", "Maaaan")
        },
        Light(UIDProvider.newUID, "Keller", "Wand").apply {
            tags = mutableSetOf("Nice", "Yeet", "Amazing", "Cool", "But why?", "Hello there", "Maaaan")
        }
    )
    val rules: MutableList<Rule> = mutableListOf(
        WeeklyRule(UIDProvider.newUID, "Normal").apply { timeSpans.add(WeeklyTimeSpan(WeeklyTime.now, WeeklyTime.MAX)) },
        WeeklyRule(UIDProvider.newUID, "Ferien")
    )
    val values: MutableList<RuleValue> = mutableListOf(
        RuleValue(UIDProvider.newUID, "Default", 22.celsius, true),
        RuleValue(UIDProvider.newUID, "Winter", 23.celsius, true)
    )

    init {
        (devices[0] as Heating).apply {
            targetTemp = 24.celsius
            rule = rules[0]
        }
    }
}