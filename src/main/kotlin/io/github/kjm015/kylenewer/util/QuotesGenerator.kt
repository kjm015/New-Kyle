package io.github.kjm015.kylenewer.util

import java.util.*

/**
 * This class generates quotes from different sources. This should be expanded upon in the
 * future, as right now it only contains quotes from Skyrim.
 *
 * @author kjm015
 * @since 01/20/2019
 */
class QuotesGenerator {

    private var randy = Random()

    /**
     * This function returns a Skyrim quote from a list.
     *
     * @return a Skyrim quote String
     */
    fun getSkyrimQuote(): String {
        val quotes: ArrayList<String> = ArrayList()

        quotes.add("I'd be a lot warmer and a lot happier with a belly full of mead.")
        quotes.add("Is that... Fur? Coming out of your ears?")
        quotes.add("Don't suppose you'd enchant my sword? Dull old blade can barely cut butter.")
        quotes.add("Go cast your fancy magic someplace else.")
        quotes.add("Favor the bow, eh? I'm a sword man myself.")
        quotes.add("A guard might get nervous, if a man approaches with his weapon drawn.")
        quotes.add("No lollygagging.")
        quotes.add("I am sworn to carry your burdens.")
        quotes.add("Khajiit will follow.")
        quotes.add("You Nords and your damn Jarls.")
        quotes.add("I'm going to find whoever did this.")
        quotes.add("Oh no, by the gods, this can't be happening!")
        quotes.add("Another corpse for the pile!")
        quotes.add("Have you seen those warriors from Hammerfell? They've got curved swords. Curved. Swords.")
        quotes.add("You have committed crimes against Skyrim and her people. What say you in your defense?")
        quotes.add("I used to be an adventurer like you. Then I took an arrow in the knee.")
        quotes.add("I've heard about you and your honeyed words.")
        quotes.add("Hands to yourself, sneak-thief.")
        quotes.add("Let me guess, someone stole your sweet roll.")
        quotes.add("This better not be all the things you just can't be bothered with.")
        quotes.add("If you've got the aptitude, you should join the mage's college in Winterhold.")
        quotes.add("My ancestors are smiling at me, Imperials. Can you say the same?")
        quotes.add("I am an apprenticed wizard, not a pack mule. Oh, very well. Just make it quick.")
        quotes.add("May you walk on warm sands.")
        quotes.add("Divines smile on you, friend.")
        quotes.add("What do you want, milk drinker?")
        quotes.add("You'll be so much easier to rob when you're dead!")
        quotes.add("Never should have come here!")
        quotes.add("Shor's bones, you're going to freeze to death!")
        quotes.add("By Ysmir, you'll never leave here alive!")
        quotes.add("I've fought colds tougher than you!")
        quotes.add("No more! I yield, I yield!")
        quotes.add("Skyrim belongs to the Nords!")
        quotes.add("I hope the wilds claim you one of these days.")
        quotes.add("By the gods, did that really just happen?")
        quotes.add("Some may call this junk. Me? I call them treasures.")
        quotes.add("My cousin's out fighting dragons, and what do I get? Guard duty.")
        quotes.add("Do you get to the Cloud District very often? Oh, what am I saying? Of course you don't.")
        quotes.add("The Thalmor know what to do with Talos worshippers.")
        quotes.add("There are such few pleasures in life such as your company.")
        quotes.add("I mostly deal with petty thievery and drunken brawls. It's been too long since we've had a good bandit raid.")
        quotes.add("Spells and incantations, for those with the talent to cast them.")
        quotes.add("I catch your hand in my pocket, I'm going to cut it off.")
        quotes.add("The gods gave you two hands, and you use both for your weapon. I can respect that.")
        quotes.add("Lightly armored means light on your feet. Smart.")
        quotes.add("Psst. Hey, I know who you are. Hail Sithis!")
        quotes.add("Heard they're reforming the Dawnguard. Vampire hunters or something, in the old fort near Riften. Might consider joining up myself.")

        return quotes[randy.nextInt(quotes.size)]
    }

}