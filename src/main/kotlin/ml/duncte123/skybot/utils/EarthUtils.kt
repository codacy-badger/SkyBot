/*
 * Skybot, a multipurpose discord bot
 *      Copyright (C) 2017  Duncan "duncte123" Sterken & Ramid "ramidzkh" Khan & Sanduhr32
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ml.duncte123.skybot.utils

import org.json.JSONArray
import org.json.JSONObject

class EarthUtils {
    companion object {
        @JvmStatic
        fun throwableToJSONObject(throwable: Throwable): JSONObject {
            var json = JSONObject().put("className", throwable::class.java.name)
                        .put("message", throwable.message)
                        .put("localiziedMessage", throwable.localizedMessage)
                        .put("cause", throwable.cause?.let { throwableToJSONObject(it) })
                        .put("supressed", throwableArrayToJSONArray(throwable.suppressed))
                        .put("stacktraces", stacktraceArrayToJSONArray(throwable.stackTrace))
            if(throwable.cause != null)
                json.put("cause", throwableToJSONObject(throwable.cause!!))
            return json
        }

        @JvmStatic
        private fun throwableArrayToJSONArray(throwables: Array<Throwable>) =
                JSONArray(throwables.map { throwableToJSONObject(it) })

        @JvmStatic
        private fun stacktraceArrayToJSONArray(stacktraces: Array<StackTraceElement>): JSONArray =
                JSONArray(stacktraces.map { stacktraceToJSONObject(it) })

        @JvmStatic
        fun stacktraceToJSONObject(stackTraceElement: StackTraceElement) =
                JSONObject().put("className", stackTraceElement.className)
                            .put("methodName", stackTraceElement.methodName)
                            .put("lineNumber", stackTraceElement.lineNumber)
                            .put("isNative", stackTraceElement.isNativeMethod)
    }
}