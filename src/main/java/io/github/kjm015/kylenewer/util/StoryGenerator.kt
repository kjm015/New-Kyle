package io.github.kjm015.kylenewer.util

import java.lang.StringBuilder
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
        intros.add("So I was at the store, ")

        return intros[randy.nextInt(intros.size)]
    }

    private fun antagonism(): String {
        val ants = ArrayList<String>()
        ants.add("when this lady proceeded to tell me that vaccines weren't poison for children, ")

        return ants[randy.nextInt(ants.size)]
    }

    private fun retort(): String {
        val retorts = ArrayList<String>()
        retorts.add("and so my 5 year old son told her that she did not know she was being fooled by doctors and their lies. ")

        return retorts[randy.nextInt(retorts.size)]
    }

    private fun affirmation(): String {
        val affirm = ArrayList<String>()
        affirm.add("Everyone there started to clap, and I was given $100 by the clerks for raising such a smart son! ")

        return affirm[randy.nextInt(affirm.size)]
    }

    private fun snark(): String {
        val snarks = ArrayList<String>()
        snarks.add("I'm so glad I raised such a wonderful little angel who knows the medical industry's lies for what they are!")

        return snarks[randy.nextInt(snarks.size)]
    }

    companion object {
        // Random number generator
        private val randy = Random()
    }
}