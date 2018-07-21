package io.github.kjm015.kylenewer.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MessageGenerator {

    private static final Random randy = new Random();

    public static String motionVerb() {
        List<String> verbs = new ArrayList<String>() {{
            add("stroll");
            add("mosey");
            add("amble");
            add("waltz");
            add("parade");
            add("saunter");
            add("cruise");
            add("drive");
            add("skate");
            add("fly");
            add("ski");
            add("snowboard");
            add("sail");
            add("bike");
            add("roll");
            add("travel");
            add("hike");
            add("stumble");
            add("traipse");
            add("skip");
            add("gallop");
            add("drift");
            add("glide");
            add("surf");
            add("paddle");
            add("ride");
        }};
        return verbs.get(randy.nextInt(verbs.size()));
    }

    public static String derogatoryNoun() {
        List<String> nouns = new ArrayList<String>() {{
            add("Highlander: The Source");
            add("\"working\" at Channel Awesome for 10 years");
            add("putting food on your family");
            add("endorsing Microsoft Teams");
            add("exchanging energy drinks for slices of pizza");
            add("a chimney sweep shoved into a woodchipper");
            add("resolving personal conflicts by going catatonic");
            add("discovering the true meaning of \"where wings take dream\"");
            add("false rape allegations");
            add("being reincarnated, then immediately aborted");
            add("having your viral video on iCarly");
            add("early 2000s era pop punk bands");
            add("making metal music about your fantasy sci-fi novel series");
            add("$200 buckets of gruel bought from a right-wing religious institution");
            add("a Spotify playlist with nothing but \"All Star\" by Smash Mouth");
            add("post-Spiderman Toby Maguire");
            add("being abducted by a chicken mascot named Al");
            add("being banned from r/the_donald");
            add("stealing DVDs from Walmart");
            add("referring to sprinkles as \"jimmies\"");
            add("Drake Bell's bankruptcy filings");
            add("pressing 'F' to pay respects");
            add("making illegal u-turns on the way to work");
            add("masturbating in a dormitory study area");
            add("Facebook moms who believe that vaccines cause autism");
            add("racist farmers who care more about racism than farming");
            add("parents whose kids hold up drive-thru lines");
            add("shooting people who fail to use their turn signal on the highway");
            add("Indian religious nationalism");
            add("people who create social media pages for their pets and unborn children");
            add("supply-side economics");
            add("conservative talk show hosts who assault union workers");
            add("a right-wing utopia where white people work 60-hour weeks at jobs they hate and everyone else is dead");
            add("standing up for traditional marriage whilst cheating on your wife with an 18-year-old male intern");
            add("losing your job as a sleep psychologist for sleeping on the job");
            add("hoping in one hand and shitting in the other to see which one fills first");
            add("a Gaijin fanboy on r/WarThunder");
            add("poorly translated signs in China");
            add("drinking and driving");
            add("not being able to connect to the translator service");
            add("overdosing and dying");
            add("cherishing flower and grass to care about future");
            add("my RAM after using Chrome for 5 minutes");
            add("earning a daily bonus of 100 silver lions");
            add("some white guy in a polo shirt");
            add("shaving your hair into a cake and eating it");
            add("a dating app exclusively for farmers");
            add("accidentally tearing a hole in your pack of Swiss Miss");
            add("Stephen Crowder at a union protest");
            add("Ben Shapiro at a Neo-Nazi rally");
            add("Ethan Couch's release-day celebrations");
            add("Florida, but with double the crack");
            add("a Republican in San Francisco");
            add("a small town nested within another small town");
            add("making weird sounds whilst playing Heroes of the Storm");
            add("being alt-right while also dating a transgender Latino person");
            add("having a 0.357 GPA");
            add("watching hentai all day instead of going to class");
            add("watching Community all day instead of going to class");
            add("Byzantium in 1453");
            add("Poland asserting its autonomy");
            add("Unite the Right rallies");
            add("Turning Point USA");
            add("miscellaneous Glenn Beck merchandise");
            add("Dave Rubin's pile of Koch Brothers cash");
            add("a failure to yield to oncoming traffic resulting in a crash");
            add("a Trump supporter calling me a soy boy");
            add("worshipping the Confederacy");
            add("Trump's environmental protections");
            add("a Hummer H2 after the recession");
            add("Freddy Mercury's immune system");
            add("the almighty three-shoe beating");
            add("refusing to bake a cake for a gay wedding");
            add("discussing drugs in great depth because you've tried them all, but you're above them all");
            add("the ever-shrinking pool of Baby Boomers destroying the economy");
            add("a hole in a men's room stall");
            add("unfettered zoophilia");
            add("a hefty bottle of hand lotion");
            add("watching gay porn for the plot");
            add("having sex exclusively between midnight and 1:30 AM");
            add("posting \"OwO what's this\" on Reddit");
            add("Green Day before September");
            add("people who shout \"Pickle Rick\" at fast food restaurants");
            add("those stupid Facebook events about memes and The Bean");
            add("getting an associate's degree in psychology to become a doctor");
            add("abandoning a career as a YouTube star to become a musician");
            add("eating ravioli out of your shirt pocket in a public park");
            add("a Roblox group dedicated to communism founded by a 14 year old who watches Fox News");
            add("hardcore conservative Bronies");
            add("dropping out of college because you don't like math");
            add("a Catholic eating meat on Friday");
            add("being yourself in the event of a fire");
            add("novelty fire extinguishers during a fire");
            add("calling 911 as a substitute for a phone sex hotline");
            add("robbing a police station");
            add("a bot made exclusively to troll one person who doesn't log into Discord enough");
            add("stealing bottles of alcohol from Wal Mart");
            add("destroying copies of WWE 2010 because you hate John Cena");
            add("people who unironically share iFunny memes");
            add("dropping out of college to become an alcoholic waiter at Olive Garden");
            add("dropping out of college and moving to Florida to get a boating certificate");
            add("being fired from Taco Bell for being late");
            add("post-bankruptcy Toys R Us");
            add("not knowing how to order a hamburger at a restaurant");
            add("DMing for a Pathfinder session where all players are named Kevin");
            add("spending $8,000 to mine Bitcoin");
            add("getting into a drunken brawl during an internship");
            add("people who water the grass after a torrential downpour");
            add("Topper's Pizza trying to exist one last time");
            add("pretending to have a manual transmission on your car that your dad bought you");
            add("dropping out of Computer Science because it's too hard");
            add("an MMA fighter seeking validation from American tourists in China");
            add("my mixtape");
            add("a hearty dose of THC");
            add("flat-earther conventions");
            add("Despacito 2 memes");
            add("girls dropping acid in a high school bathroom");
            add("not having any books because you don't read books");
            add("playing Rust for 300 hours");
            add("guys who claim salt is worth more than gold");
            add("guys who play Rust for 16 hours a day");
            add("a 12 pack of sub-par Shock Top Belgian ale");
            add("suing over a frying pan");
            add("digging a hole for publicity");
            add("censored Christian porn");
            add("Call of Duty: Infinite Warfare");
            add("incels on 4chan");
            add("r/the_donald on inauguration day");
            add("Nate's basement razor");
            add("the sex life of a disgraced programmer who chews tobacco");
            add("being fired from Menard's for not going to meetings");
            add("my ex's hepatitis");
            add("going to anime conventions to get drunk and hit on weeaboo chicks");
            add("making fun of a programmer for going to college, then losing your job");
            add("dropping out of community college");
            add("New Orleans residents without flood insurance");
            add("people who still panic about ebola");
            add("not eating pork as an attempt to avoid swine flu");
            add("getting arrested in Scotland for telling jokes");
            add("getting kicked out of a restaurant for being a pile of garbage");
            add("using Patreon funds to buy a boat to sink migrant rafts crossing the Mediterranean");
            add("Puerto Rico's financial status");
            add("people who still play Runescape");
            add("good old-fashioned jizz");
            add("Minecraft porn creators");
            add("the rusted remains of Detroit");
            add("blocking someone for joking about your 1970's El Camino");
            add("having your life savings robbed by your second cousin");
            add("our NSFW channel");
            add("the latest post on r/trashy");
            add("a whiskey flask tucked into a young mother's fanny pack");
            add("Logan Paul's 7-year-old fans");
            add("AnthroCon's venue staff");
            add("joining a radical Islamic militant group");
            add("the Jonestown juice cleanse");
            add("an anime fan on prom night");
            add("being 16 and pregnant");
            add("having 26 kids and counting");
            add("not knowing that you're pregnant");
            add("having Gordon Ramsay shut down your restaurant");
            add("that asshat Bobby Flay");
            add("a guy named George who names all of his kids George");
            add("a girl named George");
            add("a crack dealer on a Ferris wheel");
            add("people who talk about moving south because it's too cold");
            add("neckbeard uprisings");
            add("earning a degree in Music to work at Walmart");
            add("harassing sales clerks at Sears");
            add("blaring porn on your speakers to troll your older brother");
            add("assuming someone's race based on their involvement in a shooting accident");
            add("being the most enlightened philosopher on Discord");
            add("Anarcho-Individualism");
            add("stopping a mandatory social-justice lecture to talk about libertarian Satanism");
            add("black female Nazi soldiers");
            add("Panic at the Disco themed weddings");
            add("hoarding graphics cards for profit");
            add("Battlefield: Hardline");
            add("receiving multiple VAC bans");

            add("deceased hip-hop artists from the 1990's");
            add("deeply-rooted ignorance");
            add("smoking blunts while playing Fortnite");
            add("medically inaccurate sex education");
            add("the Insane Clown Posse");
            add("fucking magnets");
            add("binders full of women");
            add("shutting the whole thing down after a legitimate rape");
            add("owning the libs");
            add("calling someone a cuck snowflake");
            add("furry porn");
            add("claiming to be Japanese after watching anime");
            add("a pirated CrunchyRoll subscription");
            add("eating fresh™");
            add("asking for sex from minors");
            add("being the mascot for a sandwich chain");
            add("concentration camps");
            add("tender-age facilities");
        }};

        return nouns.get(randy.nextInt(nouns.size()));
    }

    public static String location() {
        List<String> locations = new ArrayList<String>() {{
            add("the shattered remains of Detroit");
            add("my neighbor's lawn");
            add("my ex-girlfriends crack den");
            add("Lauren Southern's racism-raft");
            add("the local garbage dump");
            add("hell");
            add("Constantinople circa 1453");
            add("the cold floor of a county jail");
            add("a ska-themed bar mitzvah");
            add("a run-down public restroom");
            add("some white trash trailer park in Kentucky");
            add("my basement");
            add("a tender-age facility");
            add("a concentration camp");
            add("Jared Fogle's prison cell");
            add("an illegal logging site");
            add("Mogadishu");
            add("an adults-only furry convention");
            add("an unscrupulous anime convention");
            add("the drunk tank");
            add("rehab");
            add("a juvenile detention center");
            add("Neverland Ranch");
            add("Pen Island");
            add("boating school");
            add("northern Florida");
            add("a well-maintained meth lab");
            add("America");
            add("Nazi Germany");
            add("Vichy France");
            add("Imperial Japan");
            add("The British Empire");
            add("China");
            add("North Korea");
            add("Pyongyang");
            add("post-Katrina New Orleans");
            add("the Hard Rock Cafe");
            add("O'Hare airport");
            add("Chicago");
            add("San Francisco");
            add("Ferguson, Missouri");
            add("the Pacific Ocean");
            add("the slums of Bangladesh");
            add("the dumpster behind my apartment");

            add("GoDaddy.com");
            add("BlackPeopleMeet.com");
            add("FarmersOnly.com");
            add("my Patreon page");
            add("my GoFuncMe page");

            add("r/the_donald");
            add("r/incels");
        }};

        return locations.get(randy.nextInt(locations.size()));
    }

    public static String removeArticles(String string) {
        String temp = new String(string);

        temp = temp.replace("the ", "");
        temp = temp.replace("a ", "");
        temp = temp.replace("an ", "");

        return temp;
    }

    public static String switchPerspectives(String string) {
        String temp = string;

        if (temp.contains("your ") || temp.contains("you ") || temp.contains("yourself ")) {
            temp = temp.replace("your ", "my ");
            temp = temp.replace("you ", "me ");
            temp = temp.replace("yourself", "myself");
        } else {
            temp = temp.replace("I ", "you ");
            temp = temp.replace("me ", "you ");
            temp = temp.replace("my ", "your ");
            temp = temp.replace("myself", "yourself");
            temp = temp.replace("this ", "that ");
        }
        temp = temp.replace("some ", "those ");
        temp = temp.replace("these ", "those ");

        return temp;
    }

    public static String pruneAbout(String string) {
        String temp = new String(string);

        temp = temp.replace("about ", "");
        temp = temp.replace("on about ", "");

        return temp;
    }

}
