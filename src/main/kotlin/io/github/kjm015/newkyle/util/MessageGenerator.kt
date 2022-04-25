package io.github.kjm015.newkyle.util

import net.dv8tion.jda.api.entities.User
import org.springframework.stereotype.Service
import java.util.*

/**
 * This class generates all of the random shit that Kyle will say.
 * It also does formatting of messages that need to be processed in a specific way,
 * such as removing articles or changing the perspective of certain pronouns.
 *
 * @author kjm015
 * @since 7/26/2018
 */
@Service
class MessageGenerator {

    /**
     * Returns a random String from a list of dumb motion verbs
     *
     * @return a randomly selected motion verb String
     */
    fun motionVerb(): String {
        val verbs = object : ArrayList<String>() {
            init {
                add("stroll")
                add("mosey")
                add("amble")
                add("waltz")
                add("parade")
                add("saunter")
                add("cruise")
                add("drive")
                add("skate")
                add("fly")
                add("ski")
                add("snowboard")
                add("sail")
                add("bike")
                add("roll")
                add("travel")
                add("hike")
                add("stumble")
                add("traipse")
                add("skip")
                add("gallop")
                add("drift")
                add("glide")
                add("surf")
                add("paddle")
                add("ride")
            }
        }
        return verbs.random()
    }

    /**
     * Returns a random String from a list of relevant stuff that related to Kyle.
     * Feel free to add stuff to this list if you think it fits!
     *
     * @return a randomly selected noun String
     */
    fun derogatoryNoun(): String {
        val nouns = object : ArrayList<String>() {
            init {
                add("Highlander: The Source")
                add("\"working\" at Channel Awesome for 10 years")
                add("putting food on your family")
                add("endorsing Microsoft Teams")
                add("exchanging energy drinks for slices of pizza")
                add("a chimney sweep shoved into a woodchipper")
                add("resolving personal conflicts by going catatonic")
                add("discovering the true meaning of \"where wings take dream\"")
                add("false rape allegations")
                add("being reincarnated, then immediately aborted")
                add("having your viral video on iCarly")
                add("early 2000s era pop punk bands")
                add("making metal music about your fantasy sci-fi novel series")
                add("$200 buckets of gruel bought from a right-wing religious institution")
                add("a Spotify playlist with nothing but \"All Star\" by Smash Mouth")
                add("post-Spiderman Toby Maguire")
                add("being abducted by a chicken mascot named Al")
                add("being banned from r/the_donald")
                add("stealing DVDs from Walmart")
                add("referring to sprinkles as \"jimmies\"")
                add("Drake Bell's bankruptcy filings")
                add("pressing 'F' to pay respects")
                add("making illegal u-turns on the way to work")
                add("masturbating in a dormitory study area")
                add("Facebook moms who believe that vaccines cause autism")
                add("racist farmers who care more about racism than farming")
                add("parents whose kids hold up drive-thru lines")
                add("shooting people who fail to use their turn signal on the highway")
                add("Indian religious nationalism")
                add("people who create social media pages for their pets and unborn children")
                add("supply-side economics")
                add("conservative talk show hosts who assault union workers")
                add("a right-wing utopia")
                add("standing up for traditional marriage whilst cheating on your wife with an 18-year-old male intern")
                add("losing your job as a sleep psychologist for sleeping on the job")
                add("a Gaijin fanboy on r/WarThunder")
                add("poorly translated signs in China")
                add("drinking and driving")
                add("overdosing and dying")
                add("gluten-free menu options")
                add("earning a daily bonus of 100 silver lions")
                add("some white guy in a polo shirt")
                add("shaving your hair into a cake and eating it")
                add("a dating app exclusively for farmers")
                add("accidentally tearing a hole in your pack of Swiss Miss")
                add("Stephen Crowder at a union protest")
                add("Ben Shapiro at a Neo-Nazi rally")
                add("Ethan Couch's release-day celebrations")
                add("Florida, but with double the crack")
                add("a Republican in San Francisco")
                add("a small town nested within another small town")
                add("making weird sounds whilst playing Heroes of the Storm")
                add("being alt-right while also dating a transgender Latino person")
                add("having a 0.357 GPA")
                add("watching hentai all day instead of going to class")
                add("watching Community all day instead of going to class")
                add("Byzantium in 1453")
                add("Poland asserting its autonomy")
                add("Unite the Right rallies")
                add("Turning Point USA")
                add("miscellaneous Glenn Beck merchandise")
                add("Dave Rubin's pile of Koch Brothers cash")
                add("a failure to yield to oncoming traffic resulting in a crash")
                add("a Trump supporter calling me a soy boy")
                add("worshipping the Confederacy")
                add("Trump's environmental protections")
                add("a Hummer H2 after the recession")
                add("Freddy Mercury's immune system")
                add("the almighty three-shoe beating")
                add("refusing to bake a cake for a gay wedding")
                add("discussing drugs in great depth because you've tried them all, but you're above them all")
                add("the ever-shrinking pool of Baby Boomers destroying the economy")
                add("a hole in a men's room stall")
                add("unfettered zoophilia")
                add("a hefty bottle of hand lotion")
                add("watching gay porn for the plot")
                add("having sex exclusively between midnight and 1:30 AM")
                add("posting \"OwO what's this\" on Reddit")
                add("Green Day before September")
                add("people who shout \"Pickle Rick\" at fast food restaurants")
                add("those stupid Facebook events about memes and The Bean")
                add("getting an associate's degree in psychology to become a doctor")
                add("abandoning a career as a YouTube star to become a musician")
                add("eating ravioli out of your shirt pocket in a public park")
                add("a Roblox group dedicated to communism founded by a 14 year old who watches Fox News")
                add("hardcore conservative Bronies")
                add("dropping out of college because you don't like math")
                add("a Catholic eating meat on Friday")
                add("being yourself in the event of a fire")
                add("novelty fire extinguishers during a fire")
                add("calling 911 as a substitute for a phone sex hotline")
                add("robbing a police station")
                add("a bot made exclusively to troll one person who doesn't log into Discord enough")
                add("stealing bottles of alcohol from Wal Mart")
                add("destroying copies of WWE 2010 because you hate John Cena")
                add("people who unironically share iFunny memes")
                add("dropping out of college to become an alcoholic waiter at Olive Garden")
                add("dropping out of college and moving to Florida to get a boating certificate")
                add("being fired from Taco Bell for being late")
                add("post-bankruptcy Toys R Us")
                add("not knowing how to order a hamburger at a restaurant")
                add("DMing for a Pathfinder session where all players are named Kevin")
                add("spending $8,000 to mine Bitcoin")
                add("getting into a drunken brawl during an internship")
                add("people who water the grass after a torrential downpour")
                add("Topper's Pizza trying to exist one last time")
                add("pretending to have a manual transmission on your car that your dad bought you")
                add("dropping out of Computer Science because it's too hard")
                add("an MMA fighter seeking validation from American tourists in China")
                add("my mixtape")
                add("swearing on Roblox")
                add("Fortnite skins")
                add("a hefty sum of money from Epic Games")
                add("a hearty dose of THC")
                add("flat-earther conventions")
                add("Despacito 2 memes")
                add("girls dropping acid in a high school bathroom")
                add("not having any books because you don't read books")
                add("playing Rust for 300 hours")
                add("guys who claim salt is worth more than gold")
                add("guys who play Rust for 16 hours a day")
                add("a 12 pack of sub-par Shock Top Belgian ale")
                add("suing over a frying pan")
                add("digging a hole for publicity")
                add("censored Christian porn")
                add("Call of Duty: Infinite Warfare")
                add("incels on 4chan")
                add("r/the_donald on inauguration day")
                add("Nate's basement razor")
                add("the sex life of a disgraced programmer who chews tobacco")
                add("being fired from Menard's for not going to meetings")
                add("my ex's hepatitis")
                add("going to anime conventions to get drunk and hit on weeaboo chicks")
                add("making fun of a programmer for going to college, then losing your job")
                add("dropping out of community college")
                add("New Orleans residents without flood insurance")
                add("people who still panic about ebola")
                add("not eating pork as an attempt to avoid swine flu")
                add("getting arrested in Scotland for telling jokes")
                add("getting kicked out of a restaurant for being a pile of garbage")
                add("using Patreon funds to buy a boat to sink migrant rafts crossing the Mediterranean")
                add("Puerto Rico's financial status")
                add("people who still play Runescape")
                add("good old-fashioned jizz")
                add("Minecraft porn creators")
                add("the rusted remains of Detroit")
                add("blocking someone for joking about your 1970's El Camino")
                add("having your life savings robbed by your second cousin")
                add("our NSFW channel")
                add("the latest post on r/trashy")
                add("a whiskey flask tucked into a young mother's fanny pack")
                add("Logan Paul's 7-year-old fans")
                add("AnthroCon's venue staff")
                add("joining a radical Islamic militant group")
                add("the Jonestown juice cleanse")
                add("an anime fan on prom night")
                add("being 16 and pregnant")
                add("having 26 kids and counting")
                add("not knowing that you're pregnant")
                add("having Gordon Ramsay shut down your restaurant")
                add("that asshat Bobby Flay")
                add("a guy named George who names all of his kids George")
                add("a girl named George")
                add("praying the gay away")
                add("a crack dealer on a Ferris wheel")
                add("people who talk about moving south because it's too cold")
                add("neckbeard uprisings")
                add("earning a degree in Music to work at Walmart")
                add("harassing sales clerks at Sears")
                add("blaring porn on your speakers to troll your older brother")
                add("assuming someone's race based on their involvement in a shooting accident")
                add("being the most enlightened philosopher on Discord")
                add("Anarcho-Individualism")
                add("stopping a mandatory social-justice lecture to talk about libertarian Satanism")
                add("black female Nazi soldiers")
                add("Panic at the Disco-themed weddings")
                add("hoarding graphics cards for profit")
                add("Battlefield: Hardline")
                add("receiving multiple VAC bans")
                add("finding your original birth certificate in a pile of trash")
                add("first aid kits filled with bullets")
                add("anti-vax Facebook moms")

                add("deceased hip-hop artists from the 1990's")
                add("deeply-rooted ignorance")
                add("smoking blunts while playing Fortnite")
                add("medically inaccurate sex education")
                add("the Insane Clown Posse")
                add("fucking magnets")
                add("binders full of women")
                add("shutting the whole thing down after a legitimate rape")
                add("owning the libs")
                add("calling someone a cuck snowflake")
                add("furry porn")
                add("claiming to be Japanese after watching anime")
                add("a pirated CrunchyRoll subscription")
                add("eating fresh™")
                add("having an anime profile picture")
                add("frequenting 4chan")
                add("asking for sex from minors")
                add("being the mascot for a sandwich chain")
                add("concentration camps")
                add("donating to an alt-right Patreon account")
                add("tender-age facilities")
                add("anime body pillows")
            }
        }

        return nouns.random()
    }

    /**
     * Returns a random String from a list of stupid location names
     * Again, feel free to add to this list if you think it will work with the theme
     *
     * @return a randomly selected place String
     * @author kjm015
     * @since 7/26/2018
     */
    fun location(): String {
        val locations = object : ArrayList<String>() {
            init {
                add("the shattered remains of Detroit")
                add("my neighbor's lawn")
                add("my ex-girlfriends crack den")
                add("Lauren Southern's racism-raft")
                add("the local garbage dump")
                add("hell")
                add("Constantinople circa 1453")
                add("the cold floor of a county jail")
                add("a ska-themed bar mitzvah")
                add("a run-down public restroom")
                add("some white trash trailer park in Kentucky")
                add("my basement")
                add("a tender-age facility")
                add("a concentration camp")
                add("Jared Fogle's prison cell")
                add("an illegal logging site")
                add("Mogadishu")
                add("an adults-only furry convention")
                add("an unscrupulous anime convention")
                add("the drunk tank")
                add("rehab")
                add("a juvenile detention center")
                add("Neverland Ranch")
                add("Pen Island")
                add("boating school")
                add("northern Florida")
                add("a well-maintained meth lab")
                add("America")
                add("Nazi Germany")
                add("Vichy France")
                add("Imperial Japan")
                add("The British Empire")
                add("China")
                add("North Korea")
                add("Pyongyang")
                add("post-Katrina New Orleans")
                add("the Hard Rock Cafe")
                add("O'Hare airport")
                add("Chicago")
                add("San Francisco")
                add("Ferguson, Missouri")
                add("the Pacific Ocean")
                add("the slums of Bangladesh")
                add("the dumpster behind my apartment")
                add("a truck load of Minions merchandise.")

                add("GoDaddy.com")
                add("BlackPeopleMeet.com")
                add("FarmersOnly.com")
                add("my Patreon page")
                add("my GoFuncMe page")

                add("r/the_donald")
                add("r/incels")
            }
        }

        return locations.random()
    }

    // List of weird side messages
    fun adjuncts(): String {
        val adjuncts = object : ArrayList<String>() {
            init {
                add("Like, who fucking though this was a good idea")
                add("Seriously, where the fuck were you when that happened")
                add("How is that shit allowed to happen")
                add("I am not fucking around")
                add("No one can fucking stop me")
                add("The system is fucking rigged.")
                add("We all know it's bullshit.")
                add("I'm so done with this game's bullshit.")
                add("Like, I can't fucking stand this shit anymore.")
            }
        }
        return adjuncts.random()
    }

    // Closing statements.
    fun closer(): String {
        val closers = object : ArrayList<String>() {
            init {
                add("Not having any of this")
                add("This is so fucking stupid")
                add("You guys are fucking stupid")
                add("I don't give a flying fuck")
                add("Like what the fuck, dude")
                add("Literally the dumbest shit")
                add("I am so fucking done with this")
                add("This is why we need genocide")
                add("Like, god fucking damn it")
                add("We all know it's bullshit.")
                add("I'm so done with this game's bullshit.")
                add("Fucking nobody can be okay with this.")
                add("Like, who fucking though this was a good idea")
                add("Seriously, where the fuck were you when that happened")
                add("How is that shit allowed to happen")
                add("I am not fucking around")
                add("No one can fucking stop me")
                add("The system is fucking rigged.")
                add("We all know it's bullshit.")
                add("I'm so done with this game's bullshit.")
            }
        }
        return closers.random()
    }

    // List of entry phrases.
    fun intent(): String {
        val intents = object : ArrayList<String>() {
            init {
                add("I want to")
                add("Someone should seriously")
                add("I should totally")
                add("Just saying, I'll")
                add("I am going to")
                add("Like, I will")
                add("I'm considering calling someone to")
                add("I plan to")
                add("Gonna fucking")
                add("I should get my dad to")
                add("Seriously,")
                add("Why don't I just")
                add("Even my girlfriend says to")
                add("I know some guys that would")
            }
        }
        return intents.random()
    }

    // List of verbs
    fun openers(): String {
        val open = object : ArrayList<String>() {
            init {
                add("fuck")
                add("invade")
                add("roundhouse kick")
                add("shoot")
                add("motherfucking sue")
                add("curb stomp")
                add("choke slam")
                add("drop kick")
                add("kill")
                add("murder")
                add("dick punch")
                add("stab")
                add("hack")
                add("exterminate")
                add("gas")
                add("protest")
                add("run over")
                add("sue")
                add("vandalize")
            }
        }
        return open.random()
    }

    // List of intended targets of the action
    fun targets(): String {
        val target = object : ArrayList<String>() {
            init {
                add("Ethan Couch")
                add("Mike Pence")
                add("Trump")
                add("Nate")
                add("Gaijin")
                add("the Russians")
                add("these Chinese hackers")
                add("you fucking idiots")
                add("Richard Spencer")
                add("these kids")
                add("the alt-right")
                add("my boss")
                add("the police")
                add("that guy Seamus")
                add("the Mamluks")
                add("the Pope")
                add("Hitler")
                add("Nazis")
                add("stupid people")
            }
        }
        return target.random()
    }

    // Exclamations for Kyle to yell
    fun exclamations(): String {
        val exclamations = object : ArrayList<String>() {
            init {
                add("shit")
                add("fuck")
                add("ass")
                add("piss")
                add("dick")
                add("balls")
                add("everlasting fucksmack")
            }
        }
        return exclamations.random()
    }

    /**
     * This method formats the judgement util to be sent to a specific user. The judgement
     * is put together using pieces from MessageGenerator given these preset formats.
     *
     * @param target - The user targeted for judgement that will also be mentioned in the util
     * @return the util String to be sent
     */
    fun generateJudgement(target: User): String {
        // Make a list of String formats
        val funList = object : ArrayList<String>() {
            init {
                add("Nothing says ${target.asMention} like ${derogatoryNoun()} and ${derogatoryNoun()}.")
                add("${target.asMention} loves nothing more than ${derogatoryNoun()} on a Sunday morning in ${location()}.")
                add("There's nothing that ${target.asMention} cherishes more than ${derogatoryNoun()}.")
                add("${target.asMention} is great, but there's nothing better than ${derogatoryNoun()}.")
                add("I always knew that ${target.asMention} was really just ${derogatoryNoun()} in disguise.")
                add("${target.asMention} practically wrote the book on ${derogatoryNoun()}")
                add("The only class that ${target.asMention} didn't flunk was ${derogatoryNoun()} 101.")
                add("${target.asMention} is really just a sad combination of ${derogatoryNoun()} and ${derogatoryNoun()}.")
                add("Some say that ${target.asMention} is really just a cross between ${derogatoryNoun()} and ${derogatoryNoun()}.")
                add("It is a fact that ${target.asMention} identifies strongly with ${derogatoryNoun()}.")
                add("Some people have spirit animals. ${target.asMention} has ${derogatoryNoun()}.")
                add("If ${target.asMention} had a million dollars, it would all go towards ${derogatoryNoun()} and ${derogatoryNoun()}.")
                add("${derogatoryNoun()}, ${derogatoryNoun()}, and ${derogatoryNoun()}: the perfect Friday night for ${target.asMention}")
                add("I hear that ${target.asMention} is starring in a reality TV show about ${derogatoryNoun()}. A good fit, I say!")
                add("I heard that ${target.asMention} subsists solely on a diet of ${derogatoryNoun()}. Good for you, man.")
                add("What ruined ${target.asMention} was the rapid onset of ${derogatoryNoun()} and ${derogatoryNoun()}.")
                add("You might suck, ${target.asMention}, but at least you're an expert in ${derogatoryNoun()}.")
                add("Taking comfort in ${derogatoryNoun()} is sadly the only thing that ${target.asMention} has left.")
                add("Kids, learn from ${target.asMention}: ${derogatoryNoun()} is not a valuable career choice.")
                add("${target.asMention} is a valuable lesson in why we learn from schools, and not ${derogatoryNoun()}.")
                add("${target.asMention} is proof that ${derogatoryNoun()} and ${derogatoryNoun()} should not mix.")
                add("I'm sorry, ${target.asMention}, but nobody appreciates your fascination with ${derogatoryNoun()}.")
                add("All hail ${target.asMention}, master of ${derogatoryNoun()}!")
                add("Breakfast? No, ${target.asMention} starts the day off right with ${derogatoryNoun()} and ${derogatoryNoun()}.")
                add("We all know that ${target.asMention} couldn't live without ${derogatoryNoun()}.")
                add("I despise ${derogatoryNoun()}, but I hate ${target.asMention} even more!")
                add("The only thing worse than ${derogatoryNoun()} is ${target.asMention}'s obsession with ${derogatoryNoun()}.")
                add("Leave it to ${target.asMention} to ruin the fine American pasttimes of ${derogatoryNoun()} and ${derogatoryNoun()}.")
                add("A combination of ${derogatoryNoun()} and ${derogatoryNoun()} gives you ${target.asMention}. What a world.")
                add("I checked ${target.asMention}'s internet history, and there's a lot of weird porn about ${derogatoryNoun()} and ${derogatoryNoun()}.")
            }
        }
        // Return a random element from the list of Strings
        return funList.random()
    }

}
