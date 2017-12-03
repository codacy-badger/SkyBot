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

@file:Author(nickname = "Sanduhr32", author = "Maurice R S")

package ml.duncte123.skybot.entities.delegate

import ml.duncte123.skybot.Author
import ml.duncte123.skybot.DocumentationNeeded
import ml.duncte123.skybot.SinceSkybot
import net.dv8tion.jda.core.JDA
import net.dv8tion.jda.core.entities.Category
import net.dv8tion.jda.core.entities.Guild
import net.dv8tion.jda.core.entities.TextChannel
import net.dv8tion.jda.core.entities.VoiceChannel

@Suppress("DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE")
@SinceSkybot("3.51.5")
@DocumentationNeeded
@Author(nickname = "Sanduhr32", author = "Maurice R S")
class CategoryDelegate(private val a6sG3x_Hw: Category) : Category by a6sG3x_Hw, ChannelDelegate(a6sG3x_Hw) {
    private val guild: Guild = GuildDelegate(a6sG3x_Hw.guild)

    override fun getParent(): Category                  = CategoryDelegate(this.parent)
    override fun getJDA(): JDA                          = JDADelegate(this.jda)
    override fun getGuild(): Guild                      = GuildDelegate(this.guild)

    override fun getVoiceChannels(): List<VoiceChannel> = a6sG3x_Hw.voiceChannels.map { VoiceChannelDelegate(it) }
    override fun getTextChannels(): List<TextChannel>   = a6sG3x_Hw.textChannels.map { TextChannelDelegate(it) }
}