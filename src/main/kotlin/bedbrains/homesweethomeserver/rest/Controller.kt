package bedbrains.homesweethomeserver.rest

import bedbrains.homesweethomeserver.DataRepository
import bedbrains.shared.datatypes.devices.Device
import bedbrains.shared.datatypes.rules.Rule
import bedbrains.shared.datatypes.rules.RuleValue
import bedbrains.shared.datatypes.update
import bedbrains.shared.datatypes.upsert
import org.springframework.web.bind.annotation.*

@RestController
class Controller {
    @GetMapping("/v1/devices")
    fun devices() = DataRepository.devices

    @GetMapping("/v1/devices/{uid}")
    fun device(@PathVariable(name = "uid") uid: String) = DataRepository.devices.find { it.uid == uid }

    @PutMapping("/v1/devices/device")
    fun putDevice(@RequestBody device: Device) = DataRepository.devices.update(device) { it.uid == device.uid }

    @PutMapping("/v1/devices")
    fun putDevices(@RequestBody devices: List<Device>) {
        for (d in devices) {
            DataRepository.devices.update(d) { it.uid == d.uid }
        }
    }


    @GetMapping("/v1/rules")
    fun rules() = DataRepository.rules

    @GetMapping("/v1/rules/{uid}")
    fun rule(@PathVariable(name = "uid") uid: String) = DataRepository.rules.find { it.uid == uid }

    @PutMapping("/v1/rules/rule")
    fun putRule(@RequestBody rule: Rule): Boolean {
        return DataRepository.rules.update(rule) { it.uid == rule.uid }
    }

    @PutMapping("/v1/rules")
    fun putRules(@RequestBody rules: List<Rule>) {
        for (r in rules) {
            DataRepository.rules.update(r) { it.uid == r.uid }
        }
    }

    @PostMapping("/v1/rules/rule")
    fun postRule(@RequestBody rule: Rule): Boolean {
        return DataRepository.rules.upsert(rule) { it.uid == rule.uid }
    }

    @DeleteMapping("/v1/rules/{uid}")
    fun deleteRule(@PathVariable(name = "uid") uid: String): Boolean {
        return DataRepository.rules.removeIf { it.uid == uid }
    }

    @DeleteMapping("/v1/rules")
    fun deleteRules(@RequestBody uids: List<String>) {
        DataRepository.rules.removeAll { it.uid in uids }
    }

    @GetMapping("/v1/values")
    fun values() = DataRepository.values

    @GetMapping("/v1/values/{uid}")
    fun value(@PathVariable(name = "uid") uid: String) = DataRepository.values.find { it.uid == uid }

    @PutMapping("/v1/values/value")
    fun putValue(@RequestBody value: RuleValue): Boolean {
        return DataRepository.values.update(value) { it.uid == value.uid }
    }

    @PutMapping("/v1/values")
    fun putValues(@RequestBody values: List<RuleValue>) {
        for (v in values) {
            DataRepository.values.update(v) { it.uid == v.uid }
        }
    }

    @PostMapping("/v1/values/value")
    fun postValue(@RequestBody value: RuleValue): Boolean {
        return DataRepository.values.upsert(value) { it.uid == value.uid }
    }

    @DeleteMapping("/v1/values/{uid}")
    fun deleteValue(@PathVariable(name = "uid") uid: String): Boolean {
        return DataRepository.values.removeIf { it.uid == uid }
    }

    @DeleteMapping("/v1/values")
    fun deleteValues(@RequestBody uids: List<String>) {
        DataRepository.values.removeAll { it.uid in uids }
    }
}
