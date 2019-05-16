package io.github.kjm015.kylenewer.util

import java.util.*
import kotlin.collections.ArrayList


/**
 * This class generates a story that was compiled from a list of sources.
 * Namely, top posts from the illustrious subreddit /r/thatHappened, which
 * contains a lot of hilarious "true" stories.
 *
 * @author kjm015
 * @since 01/20/2019
 */
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

    /**
     * This function generates the setup String for the story to be generated.
     * Essentially, it sets the scene for the ridiculousness that is to come.
     *
     * @return the setup String to the story
     */
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
        intros.add("I was at the doctor's today, ")
        intros.add("I just had a job interview, ")
        intros.add("Well, I downloaded Pokemon Go since I figured it gives me something to do, ")
        intros.add("I was in English class today, the teacher put my poem on the board, ")
        intros.add("Earlier today, my son was talking to his friend about getting shots from the doctor, ")
        intros.add("So I was at KFC where I work, ")
        intros.add("I was on the elevator earlier today, ")
        intros.add("I was playing a game the night before my history test, ")
        intros.add("I was on a cruise ship, ")
        intros.add("So I was shopping at Target earlier today, ")
        intros.add("I was at my job as a supervisor at McDonald's, ")
        intros.add("The other night, I was in a cab, ")
        intros.add("I was at the bar the other night with a bunch of Chads that were hitting on girls, ")
        intros.add("I was at my girlfriend's place last weekend, ")
        intros.add("I was sitting on the couch minding my own business, ")
        intros.add("I was sitting in the airport waiting for my connecting flight, ")

        return intros.random()
    }

    /**
     * This function generates the point of conflict in the story. If you read
     * some of the top posts from /r/thatHappened, you'll notice that pretty much
     * all of them have some cartoon-villain levels of shit like this.
     *
     * @return some stupid String that signifies the antagonist of the story
     */
    private fun antagonism(): String {
        val ants = ArrayList<String>()

        // Add the story components here
        ants.add("and this lady proceeded to tell me that vaccines weren't poison for children. ")
        ants.add("when I corrected my chemistry teacher. ")
        ants.add("when we hear: \"EVERYONE GET DOWN!\" We all get down. ")
        ants.add("and a 17 year old boy was ringing me up. ")
        ants.add("when I got bit by a black widow spider twice!")
        ants.add("and Lil Pump was playing on the radio. ")
        ants.add("and all of my employees are having a giant 100-person orgy all over the office. ")
        ants.add("when my sister looked out the window to see me dragging an empty leash around the yard. ")
        ants.add("and I had to complain how bad my Big Mac was. ")
        ants.add("when the nurse asks if I am getting any vaccinations for my son today. ")
        ants.add("and they showed a video of me shoplifting. ")
        ants.add("when an old man tried to shame me because I was on my phone with my headphones in. He said \"Kids today don't read.\" ")
        ants.add("when all of the kids started searching for the Pokemon I was tracking, even though it disappeared. ")
        ants.add("and they had us guess who wrote the poem was on the board. Most people guessed \"Shakespeare\". ")
        ants.add("when my son's friend said he needs to get shots in order to stay in school. ")
        ants.add("and my coworkers and I were getting furious at the butcher for slaughtering animals on premises every day. We kept quiet because they kept threatening to fire us. ")
        ants.add("and a bunch of girls I worked with just flashed me. ")
        ants.add("when I began to write down all of Gandhi's greatest achievements. I wrote that \"He nuked America.\" My teacher asked to see me after class. ")
        ants.add("and the doctor asked why we did not vaccinate our son. ")
        ants.add("when I began to sing to myself. ")
        ants.add("and I heard a girl say: \"Boys are so dumb.\" ")
        ants.add("and we completely ran out of chicken to make McNuggets. ")
        ants.add("when my professor came in 30 minutes late, hungover, shirt inside-out and backwards, with nothing on his feet but flip-flops.")
        ants.add("and the cab driver had \"My Life\" by 50 Cent and Eminem on. He asked me if I wanted him to change it to country. ")
        ants.add("when I see a Chad violently beating a drunk girl. At this point, she's on the floor, cowering and crying. ")
        ants.add("when I played my favorite song for my girlfriend. She said it sounded like \"elevator music\". ")
        ants.add("when my sister's friend brushed against my thigh to see if I'd notice. ")
        ants.add("when some blond-haired blue-eyed group of college kids came and asked a Native American where all of his land went. ")

        return ants.random()
    }

    /**
     * This function generates the storyteller's response to the made-up situation at hand.
     * This is those "DESTROYS" moment, where the person telling
     * the story thinks they've just done some triumphant form of heroism, but in reality, they
     * just made themselves sound like an idiot.
     *
     * @return some garbage String response
     */
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
        retorts.add("I tell them that after a lot of research, I have decided not to get any vaccinations. ")
        retorts.add("Just then, an old man around the corner yells out \"Team Rocket blasting off again!\" ")
        retorts.add("My teacher revealed that it was I who wrote it. ")
        retorts.add("This seems to happen from job to job, too. ")
        retorts.add("He then asked if I played Civilization V, and I said that I did. ")
        retorts.add("My son then told his friend that you do not need shots to be in school, and that they're really dangerous! ")
        retorts.add("I took action, and hid a camera inside their chicken coop. I showed the footage to all the customers while they were eating. ")
        retorts.add("I turned a bit to show him the book in my hand that I was about to read. I said \"I'm just listening to music.\" ")
        retorts.add("My son answers that we don't put poison in our bodies. ")
        retorts.add("I told her to say it louder, and she screamed \"BOYS ARE DUMB!\" ")
        retorts.add("So, I made 10 batches of vegan chicken nuggets with the ingredients that were on hand. ")
        retorts.add("I responded by rapping my favorite song word for word. ")
        retorts.add("I immediately dumped my girlfriend at that point. ")
        retorts.add("Getting up, I say \"Hey, fuck off man, you have no reason to do that!\" I decked him, and his jaw came off at the hinges, hitting a table on the way down. ")
        retorts.add("I didn't have to go to the hospital though, because my fiance is a badass! ")
        retorts.add("I then lifted up my dress to reveal the blade I had strapped on my thigh. ")
        retorts.add("He sat at his desk and banged his fist on the table, sobbing \"I hate this class so much!\"")
        retorts.add("My response to them was \"Hey, how does it feel to be descendants of thieves and murderers and rapists?\" ")

        return retorts.random()
    }

    /**
     * This function creates the part of the story where the storyteller gets some reward for their courage.
     * The infamous "and everybody clapped" comes to mind.
     *
     * @return some made up crap about being a hero String
     */
    private fun affirmation(): String {
        val affirm = ArrayList<String>()

        // Add the story components here
        affirm.add("Everyone there started to clap, and I was given $100 by the clerks for raising such a smart son! ")
        affirm.add("He congratulated me and told me to teach the class properly. ")
        affirm.add("The robbers bolted out and everyone stood and clapped. ")
        affirm.add("The FEMALE officers were quite pleased with my achievements :) ")
        affirm.add("All other customers started clapping and cheering when \"Rap God\" started playing, and I'd never been so proud. ")
        affirm.add("Everyone went back to work like nothing had happened. A couple commented on how odd the power outage was. ")
        affirm.add("It went down so well with a customer that the staff asked for my recipe so they could put it on the menu. ")
        affirm.add("The nurse then tells me that she won't argue with that, and gives me the thumbs up. The doctor prescribes some great vitamin supplements instead. ")
        affirm.add("All the kids groaned and I laughed. He got it right under our noses. ")
        affirm.add("I then received an applause. ")
        affirm.add("Horrified, my son's friend then asked if his parents and doctor knew. My son told him that the doctor gets paid to lie. ")
        affirm.add("People got so mad that they starting throwing their food at the manager. The police showed up and arrested him, and everyone applauded. ")
        affirm.add("Then, he said \"Music today is garbage.\" I showed him my phone. I was listening to hymns. ")
        affirm.add("We spent 4 hours playing Civ V together in the computer room, and I got an A on the test. ")
        affirm.add("The entire waiting room and 3 of the nurses laughed and clapped. ")
        affirm.add("The whole cruise ship clapped for me, and the captain thought it was so good, that he shook my hand. ")
        affirm.add("Other customers replied with a slow clap. ")
        affirm.add("None of the customers realized, and I even heard that they liked it more than usual. ")
        affirm.add("Hopefully that teaches them not to disrespect women. ")
        affirm.add("She sucked out all of the spider venom and used herbs as an anti-venom, saving my life! ")
        affirm.add("I responded \"Same.\" out of habit.")

        return affirm.random()
    }

    /**
     * This function generates an optional closing statement from the storyteller. It's often the cherry atop
     * the sundae for the story at hand. It's an extra bit of snark that just kind of cements the narcissism
     * of whomever decided that telling this story was a great idea.
     *
     * @return snark String
     */
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
        snarks.add("*Strolls out of there feeling like a million bucks*")
        snarks.add("Evil is real, ladies and gentlemen.")
        snarks.add("I'm so proud of my son.")
        snarks.add("Anyway, I have to get to bed soon. I'm now the new head manager!")
        snarks.add("Baby boomers, gosh...")
        snarks.add("I must just be lucky I guess, lol")
        snarks.add("10/10, will play again with my teacher")
        snarks.add("My son is six. Six! And he knows more than doctors already!")
        snarks.add("#blessed")
        snarks.add("Best Target experience yet!")
        snarks.add("In my defense, our dog was really fucking small. ")
        snarks.add("Another reason to grow your own medicine and food!")
        snarks.add("That man? Albert Einstein.")

        return snarks.random()
    }

    companion object {
        // Random number generator
        private val randy = Random()
    }

}