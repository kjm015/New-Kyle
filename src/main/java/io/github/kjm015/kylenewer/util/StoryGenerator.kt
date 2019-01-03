package io.github.kjm015.kylenewer.util

import java.util.*
import kotlin.collections.ArrayList

class StoryGenerator {

    fun story(): String {
        val builder = StringBuilder()

        builder.append(setup())
                .append(antagonism())
                .append(retort())
                .append(affirmation())

        if (randy.nextBoolean())
            builder.append(snark())

        return builder.toString()
    }

    private fun setup(): String {
        val intros = ArrayList<String>()

        // Add the story components here
        intros.add("So I was at the store, ")
        intros.add("It was two weeks ago, ")
        intros.add("I was at the bank with my sister, ")
        intros.add("I went to Walmart to buy a tub of cookie dough and a box of tampons, ")
        intros.add("I beat the shit out of a cop once for being an asshole, ")
        intros.add("I was at Starbucks with Aiden (who is 4 years old) today, ")
        intros.add("I was the head of a large venture capital organization, and one weekend I go away on holiday. I come back, ")
        intros.add("My sister asked me to take the dog out for a walk, ")
        intros.add("So I was at McDonald's, ")

        return intros[randy.nextInt(intros.size)]
    }

    private fun antagonism(): String {
        val ants = ArrayList<String>()

        // Add the story components here
        ants.add("and this lady proceeded to tell me that vaccines weren't poison for children. ")
        ants.add("when I corrected my chemistry teacher. ")
        ants.add("when we hear: \"EVERYONE GET DOWN!\" We all get down. ")
        ants.add("and a 17 year old boy was ringing me up. ")
        ants.add("because the cop touched me first. ")
        ants.add("and Lil Pump was playing on the radio. ")
        ants.add("and all of my employees are having a giant 100-person orgy all over the office. ")
        ants.add("when my sister looked out the window to see me dragging an empty leash around the yard. ")
        ants.add("and I had to complain how bad my Big Mac was. ")

        return ants[randy.nextInt(ants.size)]
    }

    private fun retort(): String {
        val retorts = ArrayList<String>()

        // Add the story components here
        retorts.add("So my 5 year old son proceeded to tell her that she did not know she was being fooled by doctors and their lies. ")
        retorts.add("I solved a problem he wasn't able to crack in days. ")
        retorts.add("Then, my sister says \"Stealing is wrong.\" ")
        retorts.add("He just looked at me and said \"It's going to be okay.\" ")
        retorts.add("I forgot the dog. ")
        retorts.add("He got arrested, and I got off fine. And by \"got off fine,\" I don't just mean that I didn't have to go to court. ")
        retorts.add("Aiden went and told the barista to switch to some Eminem, because \"All new music is dumb nowadays.\" ")
        retorts.add("I dropped what I was holding, and everyone goes silent. One of the employees then turned off all the lights. When they come back on, everyone is back to normal. ")
        retorts.add("I ended up creating a whole new sandwich on the spot. ")

        return retorts[randy.nextInt(retorts.size)]
    }

    private fun affirmation(): String {
        val affirm = ArrayList<String>()

        // Add the story components here
        affirm.add("Everyone there started to clap, and I was given $100 by the clerks for raising such a smart son! ")
        affirm.add("He congratulated me and told me to teach the class properly. ")
        affirm.add("The robbers bolted out and everyone stood and clapped. ")
        affirm.add("The FEMALE officers were quite pleased with my achievements :) ")
        affirm.add("All other customers started clapping and cheering when \"Rap God\" started playing, and I'd never been so proud. ")
        affirm.add("Everyone went back to work like nothing had happened. A couple commented on how odd the power outage was. ")
        affirm.add("In my defense, our dog was really fucking small.")
        affirm.add("It went down so well with a customer that the staff asked for my recipe so they could put it on the menu.")

        return affirm[randy.nextInt(affirm.size)]
    }

    private fun snark(): String {
        val snarks = ArrayList<String>()

        // Add the story components here
        snarks.add("Nothing personnel, kid.")
        snarks.add("Everyone stood and clapped, too.")
        snarks.add("I'm so glad I raised such a wonderful little angel who knows the medical industry's lies for what they are!")
        snarks.add("Today, everyone took a test on it and they all got A's because of me.")
        snarks.add("The manager gave us $1,000 for saving the day as well!")
        snarks.add("The barista even gave us free drinks for the business advice!")
        snarks.add("I know they haven't said anything about it. But they know I know.")
        snarks.add("That's what you get for challenging me!")


        return snarks[randy.nextInt(snarks.size)]
    }

    companion object {
        // Random number generator
        private val randy = Random()
    }
}