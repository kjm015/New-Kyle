package io.github.kjm015.kylenewer.util

import java.util.*

/**
 * This class generates from different sources. This should be expanded upon in the
 * future, as right now it only contains from Skyrim.
 *
 * @author kjm015
 * @since 01/20/2019
 */
class QuotesGenerator {

    /**
     * This function returns a Skyrim quote from a list.
     *
     * @return a Skyrim quote String
     */
    fun getSkyrimQuote(): String {
        val quotes: ArrayList<String> = ArrayList()

        with(quotes) {
            add("I'd be a lot warmer and a lot happier with a belly full of mead.")
            add("Is that... Fur? Coming out of your ears?")
            add("Don't suppose you'd enchant my sword? Dull old blade can barely cut butter.")
            add("Go cast your fancy magic someplace else.")
            add("Favor the bow, eh? I'm a sword man myself.")
            add("A guard might get nervous, if a man approaches with his weapon drawn.")
            add("No lollygagging.")
            add("I am sworn to carry your burdens.")
            add("Khajiit will follow.")
            add("You Nords and your damn Jarls.")
            add("I'm going to find whoever did this.")
            add("Oh no, by the gods, this can't be happening!")
            add("Another corpse for the pile!")
            add("Have you seen those warriors from Hammerfell? They've got curved swords. Curved. Swords.")
            add("You have committed crimes against Skyrim and her people. What say you in your defense?")
            add("I used to be an adventurer like you. Then I took an arrow in the knee.")
            add("I've heard about you and your honeyed words.")
            add("Hands to yourself, sneak-thief.")
            add("Let me guess, someone stole your sweet roll.")
            add("This better not be all the things you just can't be bothered with.")
            add("If you've got the aptitude, you should join the mage's college in Winterhold.")
            add("My ancestors are smiling at me, Imperials. Can you say the same?")
            add("I am an apprenticed wizard, not a pack mule. Oh, very well. Just make it quick.")
            add("May you walk on warm sands.")
            add("Divines smile on you, friend.")
            add("What do you want, milk drinker?")
            add("You'll be so much easier to rob when you're dead!")
            add("Never should have come here!")
            add("Shor's bones, you're going to freeze to death!")
            add("By Ysmir, you'll never leave here alive!")
            add("I've fought colds tougher than you!")
            add("No more! I yield, I yield!")
            add("Skyrim belongs to the Nords!")
            add("I hope the wilds claim you one of these days.")
            add("By the gods, did that really just happen?")
            add("Some may call this junk. Me? I call them treasures.")
            add("My cousin's out fighting dragons, and what do I get? Guard duty.")
            add("Do you get to the Cloud District very often? Oh, what am I saying? Of course you don't.")
            add("The Thalmor know what to do with Talos worshippers.")
            add("There are such few pleasures in life such as your company.")
            add("I mostly deal with petty thievery and drunken brawls. It's been too long since we've had a good bandit raid.")
            add("Spells and incantations, for those with the talent to cast them.")
            add("I catch your hand in my pocket, I'm going to cut it off.")
            add("The gods gave you two hands, and you use both for your weapon. I can respect that.")
            add("Lightly armored means light on your feet. Smart.")
            add("Psst. Hey, I know who you are. Hail Sithis!")
            add("Heard they're reforming the Dawnguard. Vampire hunters or something, in the old fort near Riften. Might consider joining up myself.")
        }

        return quotes.random()
    }

}