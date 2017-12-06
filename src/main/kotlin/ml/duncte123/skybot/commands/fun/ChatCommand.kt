/*
 * Skybot, a multipurpose discord bot
 *      Copyright (C) 2017  Duncan "duncte123" Sterken & Ramid "ramidzkh" Khan & Maurice R S "Sanduhr32"
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

package ml.duncte123.skybot.commands.`fun`

import ml.duncte123.skybot.entities.chatai.AI
import ml.duncte123.skybot.objects.command.Command
import ml.duncte123.skybot.utils.AirUtils
import ml.duncte123.skybot.utils.Settings
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent
import org.slf4j.event.Level
import java.util.function.Consumer

class ChatCommand : Command() {

    private val ai: AI

    init {
        ai = AI(AirUtils.config.getString("apis.cleverbot.user", "meme"), AirUtils.config.getString("apis.cleverbot.api", "null"))
                .setNick(Settings.defaultName + AirUtils.generateRandomString(4))
                .create(Consumer {
                   AirUtils.log(Level.INFO, "AI has been loaded, server response: $it")
                })
    }


    override fun executeCommand(invoke: String, args: Array<out String>, event: GuildMessageReceivedEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun help() = "Have a chat with dunctebot\n" +
            "Usage: `$PREFIX$name <message>`"

    override fun getName() = "chat"
}